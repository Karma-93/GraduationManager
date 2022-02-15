package com.cx.service;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.fluentmybatis.entity.DownEntity;
import com.cx.fluentmybatis.entity.InformEntity;
import com.cx.model.PageReq;

import java.util.List;

public interface InformService {
    List<InformEntity> getAll();
    StdPagedList<InformEntity> get(PageReq pageReqs);

}
