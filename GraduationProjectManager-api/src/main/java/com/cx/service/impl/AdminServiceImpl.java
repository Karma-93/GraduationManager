package com.cx.service.impl;

import com.cx.fluentmybatis.entity.AdminEntity;
import com.cx.fluentmybatis.helper.AdminMapping;
import com.cx.fluentmybatis.mapper.AdminMapper;
import com.cx.fluentmybatis.wrapper.AdminQuery;
import com.cx.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public AdminEntity getAdminByUserId(String userId) {
        AdminQuery query=new AdminQuery();
        query.where.userId().eq(userId).end();
        return adminMapper.findOne(query);
    }
}
