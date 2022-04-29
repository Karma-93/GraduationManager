package com.cx.service;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.fluentmybatis.entity.ProjectEntity;
import com.cx.fluentmybatis.mapper.ProjectMapper;
import com.cx.fluentmybatis.mapper.TeacherMapper;
import com.cx.fluentmybatis.wrapper.ProjectQuery;
import com.cx.model.PageReq;
import com.cx.model.VerifyProjectData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProjectService {


    int verifyChoose(Integer projectId);

    List<VerifyProjectData> getgetVerifyProjectList(String teacherId);

    public ProjectEntity getProjectById(Integer projectId );

    public List<ProjectEntity> getProjectListByTeacherId(String teacherId);

    public ProjectEntity getProjectByStudentId(String studentId);

    public boolean updateStudentIdByProjectId(String studentId,Integer projectId) ;

    public boolean updateNoStudent(Integer projectId);

    public int getCountProjectNum();

    public int getTeacherYesProjectNum(String teacherId);

    public boolean insertSelective(ProjectEntity project,String teacherId);

    public List<ProjectEntity> getProjectByTeacherId(String teacherId);

    public boolean updateByPrimaryKeySelective(ProjectEntity project);

    public StdPagedList<ProjectEntity> getPeojectList(PageReq pageReq);

}
