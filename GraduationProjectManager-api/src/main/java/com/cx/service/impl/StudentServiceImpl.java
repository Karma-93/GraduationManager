package com.cx.service.impl;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.common.utils.KeyUtil;
import com.cx.fluentmybatis.entity.*;
import com.cx.fluentmybatis.mapper.ClassiMapper;
import com.cx.fluentmybatis.mapper.StudentMapper;
import com.cx.fluentmybatis.wrapper.ClassiQuery;
import com.cx.fluentmybatis.wrapper.StudentQuery;
import com.cx.fluentmybatis.wrapper.StudentUpdate;
import com.cx.model.PageReq;
import com.cx.model.StudentData;
import com.cx.model.StudentProcessData;
import com.cx.model.StudentScore;
import com.cx.service.*;
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
    @Autowired
    LunwenService lunwenService;
    @Autowired
    KtbgService ktbgService;
    @Autowired
    QzxjService qzxjService;
    @Autowired
    ProjectService projectService;


    @Override
    public int insert(StudentEntity entity) {
        entity.setStudentId(KeyUtil.getUUIDKey(""));
        return studentMapper.insertWithPk(entity);
    }

    @Override
    public int delete(String studentId) {
        String userId=getStudentById(studentId).getUserId();
        userService.delete(userId);
        return studentMapper.deleteById(studentId);
    }

    @Override
    public String getNameByStudentId(String studentId) {
        StudentQuery query=new StudentQuery();
        query.where.studentId().eq(studentId).end();
        StudentEntity studentEntity=studentMapper.findOne(query);
        if (studentEntity.getUserId()==null){
            return null;
        }
        String userId =studentMapper.findOne(query).getUserId();
        return userService.getUserById(userId).getUserName();
    }

    @Override
    public int setStudentScore(StudentScore score) {
        StudentUpdate update=new StudentUpdate();
        update.where.studentId().eq(score.getStudentId()).end().set.studentScore().is(score.getScore()).end();
        return studentMapper.updateBy(update);
    }

    @Override
    public List<StudentProcessData> getStudentProcessListByTeacherId(String teacherId) {
        List<StudentProcessData> res=new ArrayList<>();
        List<StudentEntity> entities=getStudentListByTeacherId(teacherId);
        System.out.println(entities);
        for (StudentEntity entity:entities){
            StudentProcessData temp=new StudentProcessData();
            ProjectEntity project=projectService.getProjectById(entity.getProjectId());
            if(project.getProjectState()!=2){
                continue;
            }
            UserEntity user=userService.getUserById(entity.getUserId());
            LunwenEntity lunwen=lunwenService.getLunwenByStudentId(entity.getStudentId());
            KtbgEntity ktbg=ktbgService.getKtbgByStudentId(entity.getStudentId());
            QzxjEntity qzxj=qzxjService.getQzxjByStudentId(entity.getStudentId());
            if(lunwen==null) temp.setLunwenId(null);
            else temp.setLunwenId(lunwen.getLunwenId());
            if(ktbg==null) temp.setKtbgId(null);
            else temp.setKtbgId(ktbg.getKtbgId());
            if (qzxj==null) temp.setQzxjId(null);
            else temp.setQzxjId(qzxj.getQzxjId());
            temp.setStudentId(entity.getStudentId());
            temp.setProjectId(entity.getProjectId());
            temp.setUserId(entity.getUserId());
            temp.setProjectName(project.getProjectName());
            temp.setUserName(user.getUserName());
            res.add(temp);
        }
        return res;
    }

    @Override
    public int getStudentNum() {
        StudentQuery query=new StudentQuery();
        query=query.selectAll();
        return studentMapper.count(query);
    }

    @Override
    public int getNoProjectStudentNum() {
        StudentQuery query=new StudentQuery();
        query.where.projectId().isNull().end();
        return studentMapper.count(query) ;
    }

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
        System.out.println(entities);
        List<StudentData> res=new ArrayList<>();
        for (StudentEntity entity:entities){
            StudentData data=new StudentData();
            BeanUtils.copyProperties(entity,data); 
            System.out.println(entity);
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
    public Boolean deleteProjectIdAndTeacherId(String studentId) {
        StudentUpdate update = StudentUpdate.updater().where.studentId().eq(studentId).end().set.projectId().is(null).end().set.projectNum().is(0).end().set.teacherId().isNull().end();
        int tag=studentMapper.updateBy(update);
        if (tag>0) return true;
        else return false;
    }

    @Override
    public Boolean setProjectIdAndTeacherId(String studentId, Integer projectId,String teacherId) {
        StudentUpdate update=new StudentUpdate();
        update.where.studentId().eq(studentId).end().set.projectId().is(projectId).end().set.projectNum().is(1).end().set.teacherId().is(teacherId).end();
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
