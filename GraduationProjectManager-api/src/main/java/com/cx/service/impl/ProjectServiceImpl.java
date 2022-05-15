package com.cx.service.impl;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import cn.org.atool.fluent.mybatis.segment.model.PagedOffset;
import com.cx.fluentmybatis.entity.ProjectEntity;
import com.cx.fluentmybatis.entity.StudentEntity;
import com.cx.fluentmybatis.entity.TeacherEntity;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.fluentmybatis.mapper.ProjectMapper;
import com.cx.fluentmybatis.mapper.TeacherMapper;
import com.cx.fluentmybatis.wrapper.*;
import com.cx.model.PageReq;
import com.cx.model.VerifyProjectData;
import com.cx.service.ProjectService;
import com.cx.service.StudentService;
import com.cx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;




@Service
public class ProjectServiceImpl implements ProjectService
{

    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;

    @Override
    public int getCountProject() {
        ProjectQuery query=new ProjectQuery();
        query=query.selectAll();
        return projectMapper.count(query);
    }

    @Override
    public int delete(Integer projectId) {
        ProjectQuery query=new ProjectQuery();
        query.where.projectId().eq(projectId).end();
        return projectMapper.delete(query);
    }

    @Override
    public int verifyChoose(Integer projectId) {
        ProjectUpdate update = new ProjectUpdate();
        update.where.projectId().eq(projectId).end().set.projectState().is(2).end();
        return projectMapper.updateBy(update);
    }
    @Override
    public List<VerifyProjectData> getVerifyProjectList(String teacherId) {
        List<VerifyProjectData> res=new ArrayList<>();
        ProjectQuery query = new ProjectQuery();
        query.where.teacherId().eq(teacherId).and.projectState().eq(1).or.projectState().eq(2).end();
        List<ProjectEntity> entities=projectMapper.listEntity(query);
        for (ProjectEntity entity:entities){
            VerifyProjectData data=new VerifyProjectData();
            data.setProjectId(entity.getProjectId());
            data.setProjectName(entity.getProjectName());
            data.setStudentId(entity.getStudentId());
            StudentEntity studentEntity=studentService.getStudentById(data.getStudentId());
            UserEntity userEntity=userService.getUserById(studentEntity.getUserId());
            data.setClassName(studentService.getClassName(studentEntity.getStudentId()));
            data.setUserName(userEntity.getUserName());
            data.setTel(userEntity.getUserTel());
            data.setUserId(userEntity.getUserId());
            data.setProjectState(entity.getProjectState());
            res.add(data);
        }
        return res;
    }

    @Override
    public ProjectEntity getProjectById(Integer projectId) {
        ProjectQuery query=new ProjectQuery();
        query.where.projectId().eq(projectId).end();
        return projectMapper.findOne(query);
    }

    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public List<ProjectEntity> getProjectListByTeacherId(String teacherId){
        ProjectQuery query=new ProjectQuery();
        query.where().teacherId().eq(teacherId).end();
        return projectMapper.listEntity(query);
    }
    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public ProjectEntity getProjectByStudentId(String studentId) {
        ProjectQuery query=new ProjectQuery();
        query.where().studentId().eq(studentId).end();
        return projectMapper.findOne(query);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public boolean updateStudentIdByProjectId(String studentId,Integer projectId) {
        ProjectUpdate update=new ProjectUpdate();
        update.where().projectId().eq(projectId).end().set.studentId().is(studentId).end().set.projectState().is(1).end();
        int res=projectMapper.updateBy(update);
        if (res>=1) return true;
        else return false;
    }
    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public boolean updateNoStudent(Integer projectId) {
        ProjectUpdate update=new ProjectUpdate();
        update.where().projectId().eq(projectId).end().set.studentId().is(null).end().set.projectState().is(0).end();
        int res=projectMapper.updateBy(update);
        if (res>=1) return true;
        else return false;
    }

    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public int getCountProjectNum() {
        ProjectQuery query=new ProjectQuery();
        query.where().studentId().isNull().end();
        return projectMapper.count(query);
    }

    // 根据教师id查询该教师已被选的课题数

    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public int getTeacherYesProjectNum(String teacherId) {
        ProjectQuery query=new ProjectQuery();
        query.where().teacherId().eq(teacherId).and.studentId().notNull().end();
        return projectMapper.count(query);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public boolean insertSelective(ProjectEntity project,String teacherId) {
        if(teacherId!=null){
            TeacherUpdate update=new TeacherUpdate();
            update.set.teacherProjectNum().applyFunc("teacher_project_num+1").end().where().teacherId().eq(teacherId).end();
            if(teacherMapper.updateBy(update)>0){
                if (projectMapper.insert(project)>0){
                    return true;
                }
            }
        }else {
            if (projectMapper.insert(project) > 0) {
                return true;
            }
        }
        return false;
    }

    @Transactional(propagation=Propagation.SUPPORTS)
    public List<ProjectEntity> getProjectByTeacherId(String teacherId) {
        ProjectQuery query=new ProjectQuery();
        query.where().teacherId().eq(teacherId);
        return projectMapper.listEntity(query);
    }



    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public boolean updateByPrimaryKeySelective(ProjectEntity project) {
        if (projectMapper.updateById(project)>0){
            return true;
        }
        return false;
    }

    @Override
    public StdPagedList<ProjectEntity> getProjectList(PageReq pageReq) {
        ProjectQuery query=new ProjectQuery().selectAll().limit(pageReq.getPageSize()*pageReq.getPageNum(),pageReq.getPageSize());
        return projectMapper.stdPagedEntity(query);
    }
}
