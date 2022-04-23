package com.cx.service;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.fluentmybatis.entity.PaperlibEntity;
import com.cx.model.PageReq;

import java.util.List;

public interface PaperlibService {

    public StdPagedList<PaperlibEntity> getPaperlibList(PageReq pageReq);
    int insert(PaperlibEntity paperlibEntity);
    public List<PaperlibEntity> getAllPaperlibList();
}
