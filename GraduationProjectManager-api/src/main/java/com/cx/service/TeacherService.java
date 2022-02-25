package com.cx.service;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.fluentmybatis.entity.TeacherEntity;
import com.cx.model.PageReq;

public interface TeacherService {
    public StdPagedList<TeacherEntity> getTeacherList(PageReq pageReq);
    public TeacherEntity getTeacherById(int teacherid);
}
