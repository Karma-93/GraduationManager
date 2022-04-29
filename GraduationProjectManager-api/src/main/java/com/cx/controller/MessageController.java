package com.cx.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.cx.common.Result;
import com.cx.fluentmybatis.entity.MessageEntity;
import com.cx.fluentmybatis.entity.SessionListEntity;
import com.cx.service.MessageService;
import com.cx.service.SessionListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "MessageInfoController",description = "聊天记录")
@RestController
@Slf4j
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private SessionListService sessionListService;

    @ApiOperation(value = "消息列表")
    @SaCheckLogin
    @GetMapping("/messageList")
    public Result messageList(@RequestParam Integer sessionListId){
        SessionListEntity sessionListEntity=sessionListService.getSessionListById(sessionListId);
        if (sessionListEntity==null){
            return Result.success();
        }
        String userId=sessionListEntity.getUserId();
        String toUserId=sessionListEntity.getToUserId();
        List<MessageEntity> messageList=messageService.getMessageList(toUserId,userId);
        //更新消息已读
        messageService.messageRead(toUserId,userId);
        //更新会话里面的未读消息
        sessionListService.delUnReadCount(toUserId,userId);
        return  Result.success(messageList);
    }

}
