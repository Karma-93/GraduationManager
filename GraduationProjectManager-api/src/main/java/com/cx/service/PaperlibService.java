package com.cx.service;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.fluentmybatis.entity.PaperlibEntity;
import com.cx.model.PageReq;

public interface PaperlibService {

    public StdPagedList<PaperlibEntity> getPaperlibList(PageReq pageReq);
    int insert(PaperlibEntity paperlibEntity);
}
