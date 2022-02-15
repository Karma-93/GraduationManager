package com.cx.service;

import com.cx.fluentmybatis.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentEntity getStudentByUserId(String userId);
    List<StudentEntity> getStudentList(Integer pageNum,Integer pageSize);
    int update(StudentEntity student);
}
