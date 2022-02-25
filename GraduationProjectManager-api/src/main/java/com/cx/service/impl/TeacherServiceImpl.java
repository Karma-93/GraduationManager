package com.cx.service.impl;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.fluentmybatis.entity.TeacherEntity;
import com.cx.fluentmybatis.mapper.TeacherMapper;
import com.cx.fluentmybatis.wrapper.TeacherQuery;
import com.cx.model.PageReq;
import com.cx.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;
    @Override
    public StdPagedList<TeacherEntity> getTeacherList(PageReq pageReq) {
        TeacherQuery query=new TeacherQuery().selectAll().limit(pageReq.getPageSize()*pageReq.getPageNum(),pageReq.getPageSize());
        return teacherMapper.stdPagedEntity(query);
    }

    @Override
    public TeacherEntity getTeacherById(int teacherid) {
        TeacherQuery query=new TeacherQuery().where().teacherId().eq(teacherid).end();
        return teacherMapper.findOne(query);
    }
}
