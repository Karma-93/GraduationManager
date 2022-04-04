package com.cx.service;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.fluentmybatis.entity.StudentEntity;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.model.PageReq;

import java.util.List;

public interface StudentService {
    StudentEntity getStudentByUserId(String userId);
    String getStudentIdByUserId(String userId);
    StdPagedList<StudentEntity> getStudentListByTeacherId(PageReq pageReq,int teacherId);
    StdPagedList<StudentEntity> getStudentList(PageReq pageReq);
    int update(StudentEntity student);
}
