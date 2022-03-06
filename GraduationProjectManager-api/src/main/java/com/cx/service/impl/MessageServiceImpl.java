package com.cx.service.impl;

import com.cx.fluentmybatis.entity.MessageEntity;
import com.cx.fluentmybatis.helper.MessageMapping;
import com.cx.fluentmybatis.mapper.MessageMapper;
import com.cx.fluentmybatis.wrapper.MessageQuery;
import com.cx.fluentmybatis.wrapper.MessageUpdate;
import com.cx.service.MessageService;
import com.cx.service.SessionListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Override
    public int updateMessageState() {
        return -1;
    }

    @Override
    public int insertMessage(MessageEntity messageEntity) {
        messageEntity.setMessageId(null);
        return messageMapper.insert(messageEntity);
    }

    @Override
    public int saveBatch(List<MessageEntity> messageEntityList) {
        return messageMapper.insertBatch(messageEntityList);
    }

    @Override
    public List<MessageEntity> getMessageList(String toUserId, String userId) {
        List<MessageEntity> res=new ArrayList<>();
        MessageQuery query=new MessageQuery();
        query.where.userId().eq(userId).and.toUserId().eq(toUserId).end();
        res.addAll(messageMapper.listEntity(query));
        query=new MessageQuery();
        query.where.userId().eq(toUserId).and.toUserId().eq(userId).end();
        res.addAll(messageMapper.listEntity(query));
        return res;
    }

    /**
     * 修改聊天记录为已读状态
     * @param toUserId
     * @param userId
     */
    @Override
    public void messageRead(String toUserId, String userId) {
        MessageUpdate update=new MessageUpdate();
        update.update.state().is(1).end()
                .where.toUserId().eq(toUserId).and.userId().eq(userId).end();
        messageMapper.updateBy(update);
        return;
    }
}
