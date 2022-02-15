package com.cx.service.impl;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.fluentmybatis.entity.InformEntity;
import com.cx.fluentmybatis.mapper.InformMapper;
import com.cx.fluentmybatis.wrapper.InformQuery;
import com.cx.model.PageReq;
import com.cx.service.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformServiceImpl implements InformService {

    @Autowired
    InformMapper informMapper;

    @Override
    public List<InformEntity> getAll() {
        return informMapper.listEntity(new InformQuery().selectAll());
    }

    @Override
    public StdPagedList<InformEntity> get(PageReq pageReq) {
        InformQuery query=new InformQuery().selectAll().limit(pageReq.getPageSize()*pageReq.getPageNum(),pageReq.getPageSize());
        return informMapper.stdPagedEntity(query);
    }
}
