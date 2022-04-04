package com.cx.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.common.Result;
import com.cx.common.ResultCode;
import com.cx.fluentmybatis.entity.ProjectEntity;
import com.cx.model.PageReq;
import com.cx.service.ProjectService;
import com.cx.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = "ProjectController", description = "选题管理" )
@RequestMapping("/project")
@RestController
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    StudentService studentService;


    @ApiOperation("通过教师id获取选题列表")
    @GetMapping("/getprojectlistbyteacherid")
    @SaCheckLogin
    public Result getProjectListByTeacherId(@RequestParam String teacherId){
        return  Result.success(projectService.getProjectListByTeacherId(teacherId));
    }

    @ApiOperation("根据学生ID获取单个选题")
    @GetMapping("/getprojectbystudentid")
    @SaCheckLogin
    public Result getProjectByStudentId(@RequestParam String studentId){
        return  Result.success(projectService.getProjectByStudentId(studentId));
    }

    @ApiOperation("更新项目的学生ID,即选择题目,只有学生用户可访问")
    @GetMapping("/updatestudentidbyproject")
    @SaCheckRole("student")
    public Result updateStudentIdByProjectId(@RequestParam String projectId){
        String studentId=studentService.getStudentIdByUserId((String) StpUtil.getLoginId());
        if (projectService.updateStudentIdByProjectId(studentId,projectId)){
            return Result.success();
        }else {
            return Result.failure(ResultCode.UPDATE_ERROR);
        }
    }

    @ApiOperation("更新项目未被学生选择")
    @GetMapping("/updatenostudent")
    @SaCheckLogin
    public Result updateNoStudent(@RequestParam String projectId){
        if (projectService.updateNoStudent(projectId)) return Result.success();
        else return Result.failure(ResultCode.UPDATE_ERROR);
    }

    @ApiOperation("查询还可以选择的课题数量")
    @GetMapping("/getcountproject")
    @SaCheckLogin
    public Result getCountProject(){
        return Result.success(projectService.getCountProjectNum());
    }

    @ApiOperation("插入新的选题")
    @PostMapping("/insertSelective")
    @SaCheckRole({"teacher","admin"})
    public Result insertSelective(@RequestBody ProjectEntity project){
        String teacherId=project.getTeacherId();
        if (projectService.insertSelective(project,teacherId)){
            return Result.success();
        }else {
            return Result.failure(ResultCode.INSERT_ERROR);
        }
    }

    @ApiOperation("更新选题信息,只有教师用户、管理员用户可以访问")
    @PostMapping("/updatebyprimarykey")
    @SaCheckRole({"teacher","admin"})
    public Result updateByPrimaryKey(@RequestBody ProjectEntity project){
        if (projectService.updateByPrimaryKeySelective(project)){
            return Result.success();
        }else {
            return Result.failure(ResultCode.UPDATE_ERROR);
        }
    }

    @ApiOperation("分页查询所有选题")
    @PostMapping("/getAll")
    @SaCheckLogin
    public Result<StdPagedList<ProjectEntity>> getAll(@Validated @RequestBody PageReq pageReq){
        return Result.success(projectService.getPeojectList(pageReq));
    }
}
