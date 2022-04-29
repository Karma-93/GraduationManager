package com.cx.service.impl;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.fluentmybatis.entity.StudentEntity;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.fluentmybatis.mapper.ClassiMapper;
import com.cx.fluentmybatis.mapper.StudentMapper;
import com.cx.fluentmybatis.wrapper.ClassiQuery;
import com.cx.fluentmybatis.wrapper.StudentQuery;
import com.cx.fluentmybatis.wrapper.StudentUpdate;
import com.cx.model.PageReq;
import com.cx.model.StudentData;
import com.cx.service.StudentService;
import com.cx.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    UserService userService;
    @Autowired
    ClassiMapper classiMapper;


    @Override
    public StudentEntity getStudentByUserId(String userId) {
        StudentQuery query=new StudentQuery();
        query.where.userId().eq(userId);
        return studentMapper.findOne(query);
    }

    @Override
    public String getStudentIdByUserId(String userId) {
        return this.getStudentByUserId(userId).getStudentId();
    }

    @Override
    public List<StudentEntity> getStudentListByTeacherId( String teacherId) {
        StudentQuery query=new StudentQuery().where().teacherId().eq(teacherId).end();
        return studentMapper.listEntity(query);
    }

    @Override
    public List<StudentData> getStudentDataByTeacherId(String teacherId) {
        StudentQuery query=new StudentQuery();
        query.where.teacherId().eq(teacherId).end();
        List<StudentEntity> entities=studentMapper.listEntity(query);
        List<StudentData> res=new ArrayList<>();
        for (StudentEntity entity:entities){
            StudentData data=new StudentData();
            BeanUtils.copyProperties(data,entity);
            UserEntity userEntity=userService.getUserById(entity.getUserId());
            data.setUserName(userEntity.getUserName());
            data.setUserName(userEntity.getUserName());
            res.add(data);
        }
        return res;
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

    @Override
    public Boolean deleteProjectId(String studentId) {
        StudentUpdate update = StudentUpdate.updater().where.studentId().eq(studentId).end().set.projectId().is(null).end().set.projectNum().is(0).end();
        int tag=studentMapper.updateBy(update);
        if (tag>0) return true;
        else return false;
    }

    @Override
    public Boolean setProjectId(String studentId, Integer projectId) {
        StudentUpdate update=new StudentUpdate();
        update.where.studentId().eq(studentId).end().set.projectId().is(projectId).end().set.projectNum().is(1).end();
        if (studentMapper.updateBy(update)>0) return true;
        else return false;
    }

    @Override
    public String getClassName(String studentId) {
        StudentQuery studentQuery = new StudentQuery();
        studentQuery.where.studentId().eq(studentId).end();
        Integer classid=studentMapper.findOne(studentQuery).getClassId();
        ClassiQuery classQuery=new ClassiQuery();
        classQuery.where.classId().eq(classid).end();
        return classiMapper.findOne(classQuery).getClassName();
    }

    @Override
    public StudentEntity getStudentById(String studentId) {
        StudentQuery studentQuery=new StudentQuery();
        studentQuery.where.studentId().eq(studentId).end();
        return studentMapper.findOne(studentQuery);
    }
}
