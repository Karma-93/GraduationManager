package com.cx.service.impl;

import com.cx.fluentmybatis.entity.StudentEntity;
import com.cx.fluentmybatis.helper.StudentMapping;
import com.cx.fluentmybatis.mapper.StudentMapper;
import com.cx.fluentmybatis.wrapper.StudentQuery;
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
    public List<StudentEntity> getStudentList(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public int update(StudentEntity student) {
        return studentMapper.updateById(student);
    }
}
