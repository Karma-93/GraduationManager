package com.cx.service;

import com.cx.fluentmybatis.entity.MessageEntity;

import java.util.List;

public interface MessageService{
    //1、把该接收用户与发送用户间的接收消息设为已读
    public int updateMessageState();
    //2、发送消息
    public int insertMessage(MessageEntity messageEntity);
    public int saveBatch(List<MessageEntity> messageEntityList);
    public List<MessageEntity> getMessageList(String toUserId,String userId);
    public void messageRead(String toUserId,String userId);
}
