package com.cx.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.cx.common.Result;
import com.cx.fluentmybatis.entity.SessionListEntity;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.service.SessionListService;
import com.cx.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.Session;
import java.util.List;


@Api(tags = "SessionController",description = "聊天会话管理")
@RestController
@Slf4j
@RequestMapping("/session")
public class MessageSessionListController {
    @Autowired
    private UserService userService;
    @Autowired
    private SessionListService sessionListService;

    @SaCheckLogin
    @ApiOperation(value = "根据用户ID查询已经建立会话的列表")
    @GetMapping("/sessionListsAlready")
    public Result sessionListAlready(){
        String userId=(String)StpUtil.getLoginId();
        List<SessionListEntity> sessionListEntityList=sessionListService.getSessionListByUserId(userId);
        return Result.success(sessionListEntityList);
    }


    @SaCheckLogin
    @ApiOperation(value = "根据用户ID查询未建立(可以建立)会话的列表")
    @GetMapping("/sessionListsNot")
    public Result sessionListNot(){
        String userId=(String)StpUtil.getLoginId();
        List<String> list=sessionListService.getUserIdByUserId(userId);
        list.add(userId);
        List<UserEntity> excludeList=userService.getExcludeList(list);
        return Result.success(excludeList);
    }

    @ApiOperation(value = "创建一个会话记录列表")
    // 创建会话
    @SaCheckLogin
    @GetMapping("/createSessionList")
    public Result createSession(@RequestParam String toUserId,@RequestParam String toUserName){
        //互相建立session
        SessionListEntity sessionListEntity=new SessionListEntity();
        String userId=(String)StpUtil.getLoginId();
        Integer temp1=sessionListService.getIdByUser(userId,toUserId);
        if (temp1==null||temp1<=0) {
            sessionListEntity.setUserId(userId);
            sessionListEntity.setToUserId(toUserId);
            sessionListEntity.setUnReadCount(0);
            sessionListEntity.setListName(toUserName);
            sessionListService.insert(sessionListEntity);
        }
        // 判断对方和我建立会话没有？ 没有也要建立
        Integer temp=sessionListService.getIdByUser(toUserId,userId);
        //如果没有建立会话
        if (temp == null || temp <= 0){
            UserEntity user = userService.getUserById(userId);
            sessionListEntity.setUserId(toUserId);
            sessionListEntity.setToUserId(userId);
            sessionListEntity.setListName(user.getUserName());
            sessionListService.insert(sessionListEntity);
        }
        temp=sessionListService.getIdByUser(userId,toUserId);
        sessionListService.getSessionListById(temp);
        return Result.success(sessionListService.getSessionListById(temp));
    }

    @ApiOperation(value = "删除一个聊天会话记录")
    @SaCheckLogin
    // 删除会话
    @GetMapping("/delSessionList")
    public Result delSession(@RequestParam Integer sessionListId){
        sessionListService.deleteById(sessionListId);
        return Result.success();
    }


}



