package com.cx.service.impl;

import com.cx.fluentmybatis.entity.MessageEntity;
import com.cx.fluentmybatis.helper.MessageMapping;
import com.cx.fluentmybatis.mapper.MessageMapper;
import com.cx.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    @Override
    public int updateMessageState() {
        return 0;
    }

    @Override
    public int insertMessage(MessageEntity messageEntity) {
        return 0;
    }

    @Override
    public int saveBatch(List<MessageEntity> messageEntityList) {
        return 0;
    }
}
