package com.cx.service;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.fluentmybatis.entity.TeacherEntity;
import com.cx.model.PageReq;
import com.cx.model.TeacherData;

import java.util.List;

public interface TeacherService{
    int insert(TeacherEntity entity);
    int update(TeacherEntity entity);
    int delete(String teacherId);
    String getNameByTeacherId(String teacherId);
    public StdPagedList<TeacherEntity> getTeacherList(PageReq pageReq);
    public StdPagedList<TeacherData> getTeacherData(PageReq pageReq);
    public TeacherEntity getTeacherById(String teacherId);
    public TeacherEntity getTeacherByUserId(String userId);
    public List<TeacherEntity> getAllTeacherList();
    public List<TeacherData> getAllTeacherData();
}
