package com.cx.service;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.fluentmybatis.entity.StudentEntity;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.model.PageReq;
import com.cx.model.StudentData;
import com.cx.model.StudentProcessData;
import com.cx.model.StudentScore;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public interface StudentService {
    int insert(StudentEntity entity);
    int delete(String studentId);
    String getNameByStudentId(String studentId);
    int setStudentScore(StudentScore score);
    List<StudentProcessData> getStudentProcessListByTeacherId(String teacherId);
    int getStudentNum();
    int getNoProjectStudentNum();
    StudentEntity getStudentByUserId(String userId);
    String getStudentIdByUserId(String userId);
    List<StudentEntity> getStudentListByTeacherId(String teacherId);
    List<StudentData> getStudentDataByTeacherId(String teacherId);
    StdPagedList<StudentEntity> getStudentList(PageReq pageReq);
    int update(StudentEntity student);
    Boolean deleteProjectIdAndTeacherId(String studentId);
    Boolean setProjectIdAndTeacherId(String studentId,Integer projectId,String teacherId);
    String getClassName(String studentId);
    StudentEntity getStudentById(String studentId);
}
