package com.cx.service.impl;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.fluentmybatis.entity.PaperlibEntity;
import com.cx.fluentmybatis.mapper.PaperlibMapper;
import com.cx.fluentmybatis.wrapper.PaperlibQuery;
import com.cx.fluentmybatis.wrapper.StudentQuery;
import com.cx.model.PageReq;
import com.cx.service.PaperlibService;
import com.sun.org.glassfish.gmbal.ManagedAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperlibServiceImpl implements PaperlibService {

    @Autowired
    PaperlibMapper paperlibMapper;

    @Override
    public StdPagedList<PaperlibEntity> getPaperlibList(PageReq pageReq) {
        PaperlibQuery query=new PaperlibQuery().selectAll().limit(pageReq.getPageSize()*pageReq.getPageNum(),pageReq.getPageSize());
        return paperlibMapper.stdPagedEntity(query);
    }

    @Override
    public int insert(PaperlibEntity paperlibEntity) {

        return paperlibMapper.insert(paperlibEntity);
    }
}
