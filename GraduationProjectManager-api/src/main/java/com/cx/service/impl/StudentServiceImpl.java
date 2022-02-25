package com.cx.service.impl;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.fluentmybatis.entity.StudentEntity;
import com.cx.fluentmybatis.helper.StudentMapping;
import com.cx.fluentmybatis.mapper.StudentMapper;
import com.cx.fluentmybatis.wrapper.PaperlibQuery;
import com.cx.fluentmybatis.wrapper.StudentQuery;
import com.cx.model.PageReq;
import com.cx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public StudentEntity getStudentByUserId(String userId) {
        StudentQuery query=new StudentQuery();
        query.where.userId().eq(userId);
        return studentMapper.findOne(query);
    }

    @Override
    public StdPagedList<StudentEntity> getStudentListByTeacherId(PageReq pageReq, int teacherId) {
        StudentQuery query=new StudentQuery().selectAll().where().teacherId().eq(teacherId).end().limit(pageReq.getPageSize()*pageReq.getPageNum(),pageReq.getPageSize());
        return studentMapper.stdPagedEntity(query);
    }


    @Override
    public StdPagedList<StudentEntity> getStudentList(PageReq pageReq) {
        StudentQuery query=new StudentQuery().selectAll().limit(pageReq.getPageSize()*pageReq.getPageNum(),pageReq.getPageSize());
        return studentMapper.stdPagedEntity(query);
    }

    @Override
    public int update(StudentEntity student) {
        return studentMapper.updateById(student);
    }
}
