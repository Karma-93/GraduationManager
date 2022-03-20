package com.cx.controller;


import com.cx.common.utils.CurPool;
import com.cx.common.utils.JsonUtils;
import com.cx.common.utils.SpringContextUtil;
import com.cx.fluentmybatis.entity.MessageEntity;
import com.cx.fluentmybatis.entity.SessionListEntity;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.service.MessageService;
import com.cx.service.SessionListService;
import com.cx.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
@ServerEndpoint("/websocket/{userId}/{sessionId}")   //socket链接地址，通过此url建立链接
public class MessageSocketController {

    /**
     * webSocket无法直接Autowired注入对象
     */

    @Autowired
    private SessionListService sessionListService;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;
    //会话
    private Session session;

    /**
     * 当前端调用链接时，就会调用这个方法，可以拿到链接的参数和传递的参数
     *
     * @param session
     * @param userId
     * @param sessionId
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "userId") String userId, @PathParam(value = "sessionId") String sessionId) {
        this.session = session;
        CurPool.messageSockets.put(userId, this);
        List<Object> list = new ArrayList<>();
        list.add(sessionId);//sessionId
        list.add(session);
        CurPool.sessionPool.put(userId, list);
        System.out.println("【websocket消息】有新的连接，总数为:" + CurPool.messageSockets.size());
    }

    /**
     * 链接中断时调用的方法
     */
    @OnClose
    public void onClose() {
        if (userService==null){
            userService=(UserService) SpringContextUtil.getBean("userService");
        }
        //断开链接删除用户删除Session
        String userId = this.session.getRequestParameterMap().get("userId").get(0);
        CurPool.sessionPool.remove(userId);
        CurPool.messageSockets.remove(userId);
        UserEntity user = userService.getUserById(userId);
        CurPool.curUserPool.remove(user.getUserName());
        System.out.println("【websocket消息】连接断开，总数为:" + CurPool.messageSockets.size());
    }

    /**
     * 当前端向后端发送消息(this.websock.send(content))时
     *
     * @param message
     */
    @OnMessage
    public void onMessage(String message) {
        //获取sessionId
        String sessionId = this.session.getRequestParameterMap().get("sessionId").get(0);
        if (sessionId == null) {
            log.error("sessionId 错误");
        }
        if (sessionListService == null) {
            sessionListService = (SessionListService) SpringContextUtil.getBean("sessionListService");
        }
        if (messageService == null) {
            messageService = (MessageService) SpringContextUtil.getBean("messageService");
        }
        if (userService == null) {
            userService = (UserService) SpringContextUtil.getBean("userService");
        }
        SessionListEntity sessionListEntity = sessionListService.getSessionListById(Integer.parseInt(sessionId));
        UserEntity user = userService.getUserById(sessionListEntity.getUserId());
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessageBody(message);
        messageEntity.setCreateDate(new Date());
        messageEntity.setUserId(sessionListEntity.getUserId());
        messageEntity.setToUserId(sessionListEntity.getToUserId());
        messageEntity.setState(0);
        // 消息持久化
        messageService.insertMessage(messageEntity);
        // 判断用户是否存在，不存在就结束,      判断用户是否登录  所返回的list存储SessionListId以及session对象
        List<Object> list = CurPool.sessionPool.get(sessionListEntity.getToUserId());
        if (list == null || list.isEmpty()) {//若当前用户未登录
            // 用户不存在，即未登录，标记未读状态
            //  未登录也应该判断会话是否存在？
            sessionListService.addUnReadCount(sessionListEntity.getToUserId(), sessionListEntity.getUserId());
            //seesionListMapper.addUnReadCount(sessionList.getToUserId(),sessionList.getUserId());
        } else {
            // 用户存在(即用户已登录)，判断会话是否存在  判断接收者的会话是否存在？
            String id = sessionListService.getIdByUser(sessionListEntity.getToUserId(), sessionListEntity.getUserId()) + "";
            String o = list.get(0) + "";   //sessionId
            if (id.equals(o)) {
                // 会话存在直接发送消息
                sendTextMessage(sessionListEntity.getToUserId(), JsonUtils.objectToJson(messageEntity));
            } else {
                // 判断会话列表是否存在
                if (id == null || "".equals(id) || "null".equals(id)) {//当会话不存在
                    // 新增会话列表
                    SessionListEntity tmpSessionList = new SessionListEntity();
                    tmpSessionList.setUserId(sessionListEntity.getToUserId());
                    tmpSessionList.setToUserId(sessionListEntity.getUserId());
                    tmpSessionList.setListName(user.getUserName());
                    tmpSessionList.setUnReadCount(1);
                    sessionListService.insert(tmpSessionList);
                } else {
                    // 更新未读消息数量
                    sessionListService.addUnReadCount(sessionListEntity.getToUserId(), sessionListEntity.getUserId());
                }
                // 会话不存在发送列表消息
                List<SessionListEntity> sessionLists = sessionListService.getSessionListByUserId(sessionListEntity.getToUserId());
                sendTextMessage(sessionListEntity.getToUserId(), JsonUtils.objectToJson(sessionLists));
            }
        }
        System.out.println("【websocket消息】收到客户端消息:" + message);
    }


    // 此为单点消息 (发送文本)

    /**
     * 向前端发送消息
     *
     * @param userId
     * @param message
     */
    public void sendTextMessage(String userId, String message) {
        Session session = (Session) CurPool.sessionPool.get(userId).get(1);
        if (session != null) {
            try {
                session.getBasicRemote().sendText(message);//向前端发送消息
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////


}
