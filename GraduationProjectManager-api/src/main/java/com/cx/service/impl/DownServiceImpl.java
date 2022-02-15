package com.cx.service.impl;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.fluentmybatis.dao.intf.DownDao;
import com.cx.fluentmybatis.entity.DownEntity;
import com.cx.fluentmybatis.mapper.DownMapper;
import com.cx.fluentmybatis.wrapper.DownQuery;
import com.cx.model.PageReq;
import com.cx.service.DownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DownServiceImpl implements DownService {

    @Autowired
    DownMapper downMapper;

    @Override
    public List<DownEntity> getAll() {
        List<DownEntity> res;
        DownQuery downQuery=new DownQuery().selectAll();
        res=downMapper.listEntity(downQuery);
        return res;
    }

    @Override
    public StdPagedList<DownEntity> get(PageReq pageReq) {
        StdPagedList<DownEntity> res;
        DownQuery downQuery=new DownQuery().selectAll().limit(pageReq.getPageNum()*pageReq.getPageSize(),pageReq.getPageSize());
        res=downMapper.stdPagedEntity(downQuery);
        return res;
    }
}
