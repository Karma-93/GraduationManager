package com.cx.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.cx.fluentmybatis.entity.MessageEntity;
import com.cx.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@ServerEndpoint("/websocket/{userId}")   //socket链接地址，通过此url建立链接
@Controller
@Component
public class MessageController {
    /**
     * 在线人数
     */
    public static int onlineNumber = 0;
    /**
     * 以用户的userId为key，WebSocket为对象保存起来
     */
    private static Map<String, MessageController> clients = new ConcurrentHashMap<String, MessageController>();
    private static MessageService messageService;
    /**
     * 会话
     */
    private Session session;
    /**
     * 用户userId
     */
    private String userId;
    /**
     * 新建list集合存储数据
     */
    private static ArrayList<MessageEntity> MessageList = new ArrayList<>();
    /**
     * 设置一次性存储数据的list的长度为固定值，每当list的长度达到固定值时，向数据库存储一次
     */
    private static final Integer LIST_SIZE = 3;


    public static synchronized int getOnlineCount() {
        return onlineNumber;
    }

    @Autowired
    public void setOgLocationService(MessageService messageService) {
        MessageController.messageService = messageService;
    }

    /**
     * 进入聊天室 --> 项目中读取用户信息获取用户名
     * @param model
     * @return
     */
    @SaCheckLogin
    @RequestMapping("websocket")
    public String webSocket(Model model){
        String userId= (String)StpUtil.getLoginId();
        //websock链接地址+游客名-->  项目中请定义在配置文件 -->或直接读取服务器，ip 端口
        String path = "ws://127.0.0.1:8082/websocket/";
        model.addAttribute("path", path);
        model.addAttribute("userId",userId);
        return "socket";
    }

    /**
     * 监听链接(有用户链接，立马执行这个方法)
     * @param userId
     * @param session
     */

    @OnOpen
    public void onOpen(@PathParam("userId") String userId,Session session){
        //每打开一个新的窗口，在线人数onlineNumber++
        onlineNumber++;
        //把用户名赋值给变量
        this.userId=userId;
        //把新用户的 session 信息赋给变量
        this.session = session;
        //输出 websocket 信息
        log.info("现在来连接的客户id：" + session.getId() + "用户名：" + userId);
        log.info("有新连接加入！ 当前在线人数" + onlineNumber);
        try {
            //把自己的信息加入到map当中去，this=当前类（把当前类作为对象保存起来）
            clients.put(userId, this);
            //获得所有的用户lists
            Set<String> lists = clients.keySet();

            // 发送全体信息（新用户上线信息）

            //messageType 1代表上线 2代表下线 3代表在线名单 4代表普通消息
            Map<String, Object> map1 = new HashMap(100);
            //  把所有用户列表
            map1.put("onlineUsers", lists);
            //  返回上线状态
            map1.put("messageType", 1);
            //  返回用户名
            map1.put("userId", userId);
            //  返回在线人数
            map1.put("number", onlineNumber);

            //  发送全体信息（用户上线信息）
            sendMessageAll(JSON.toJSONString(map1), userId);

            // 给自己发一条消息：告诉自己现在都有谁在线
            Map<String, Object> map2 = new HashMap(100);
            //messageType 1代表上线 2代表下线 3代表在线名单 4代表普通消息
            map2.put("messageType", 3);
            //把所有用户放入map2
            map2.put("onlineUsers", lists);
            //返回在线人数
            map2.put("number", onlineNumber);

            // 消息发送指定人（所有的在线用户信息）
            sendMessageTo(JSON.toJSONString(map2), userId);
        } catch (IOException e) {
            log.info(userId + "上线的时候通知所有人发生了错误");
        }
    }

    /**
     * 监听连接断开（有用户退出，会立马到来执行这个方法）
     */
    @OnClose
    public void onClose() {
        //每关闭一个新的窗口，在线人数onlineNumber--
        onlineNumber--;
        //从所有在线用户的map中去除下线用户
        clients.remove(userId);
        try {
            //messageType 1代表上线 2代表下线 3代表在线名单  4代表普通消息
            Map<String, Object> map1 = new HashMap(100);
            map1.put("messageType", 2);
            //所有在线用户
            map1.put("onlineUsers", clients.keySet());
            //下线用户的用户名
            map1.put("userId", userId);
            //返回在线人数
            map1.put("number", onlineNumber);
            //发送信息，所有人，通知谁下线了
            sendMessageAll(JSON.toJSONString(map1), userId);
            //关闭连接前，判断list集合是否有数据，如果有，批量保存到数据库
            if (MessageList.size() < LIST_SIZE) {
                messageService.saveBatch(MessageList);
            }
        } catch (IOException e) {
            log.info(userId + "下线的时候通知所有人发生了错误");
        }
        log.info("有连接关闭！ 当前在线人数" + onlineNumber);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.info("服务端发生了错误" + error.getMessage());
        //error.printStackTrace();
    }

    /**
     * 监听消息（收到客户端的消息立即执行）
     *
     * @param message 消息
     * @param session 会话
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        try {
            log.info("来自客户端消息：" + message + "客户端的id是：" + session.getId());
            //用户发送的信息
            com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(message);
            //发送的内容
            String textMessage = jsonObject.getString("message");
            //发送人
            String fromuserId = jsonObject.getString("userId");
            //接收人  to=all 发送消息给所有人 || to= !all   to == 用户名
            String touserId = jsonObject.getString("to");

            //新建message对象
            MessageEntity message1 = new MessageEntity();

            //设置发送者的userId
            message1.setUserId(fromuserId);
            //设置发送的信息
            message1.setMessageBody(textMessage);
            //设置发送时间
            message1.setCreateDate(new Date());
            //判断接收者
            if (touserId.equals("All")) {
                message1.setToUserId("All");
            } else {
                message1.setToUserId(touserId);
            }
            //批量保存信息
            //将每条记录添加到list集合中
            MessageList.add(message1);
            //判断list集合长度
            if (MessageList.size() == LIST_SIZE) {
                messageService.saveBatch(MessageList);
                //清空集合
                MessageList.clear();
            }


            //发送消息  -- messageType 1代表上线 2代表下线 3代表在线名单  4代表消息
            Map<String, Object> map1 = new HashMap(100);
            map1.put("messageType", 4);
            map1.put("textMessage", textMessage);
            map1.put("fromuserId", fromuserId);
            if (touserId.equals("All")) {
                //消息发送所有人（同步）
                map1.put("touserId", "所有人");
                sendMessageAll(JSON.toJSONString(map1), fromuserId);
            } else {
                //消息发送指定人（同步）
                map1.put("touserId", touserId);
                sendMessageTo(JSON.toJSONString(map1), touserId);
            }
        } catch (Exception e) {
            log.info("发生了错误了");
        }
    }

    /**
     * 消息发送指定人
     */
    public void sendMessageTo(String message, String touserId) throws IOException {
        //遍历所有用户
        for (MessageController item : clients.values()) {
            if (item.userId.equals(touserId)) {
                //消息发送指定人（同步）
                item.session.getBasicRemote().sendText(message);
                break;
            }
        }
    }
    /**
     * 消息发送所有人
     */
    public void sendMessageAll(String message, String fromuserId) throws IOException {
        for (MessageController item : clients.values()) {
            //消息发送所有人（同步）getAsyncRemote
            item.session.getBasicRemote().sendText(message);
        }
    }


}
