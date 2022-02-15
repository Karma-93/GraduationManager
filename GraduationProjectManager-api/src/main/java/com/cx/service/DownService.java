package com.cx.service;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.fluentmybatis.entity.DownEntity;
import com.cx.model.PageReq;

import java.util.List;

public interface DownService {
    List<DownEntity> getAll();
    StdPagedList<DownEntity> get(PageReq pageReq);
}
