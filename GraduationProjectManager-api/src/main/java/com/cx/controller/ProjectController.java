package com.cx.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.common.Result;
import com.cx.common.ResultCode;
import com.cx.fluentmybatis.entity.ProjectEntity;
import com.cx.model.PageReq;
import com.cx.model.VerifyProjectData;
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

import java.util.List;

@Slf4j
@Api(tags = "ProjectController", description = "选题管理" )
@RequestMapping("/project")
@RestController
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    StudentService studentService;




    @ApiOperation("获取选题综述")
    @SaCheckLogin()
    @GetMapping("/getcountproject")
    public Result getCountProject(){
        return Result.success(projectService.getCountProject());
    }

    @ApiOperation("删除选题")
    @SaCheckLogin()
    @GetMapping("/delete")
    public Result delete(@RequestParam Integer projectId){
        projectService.delete(projectId);
        return Result.success();
    }

    //同意确认学生选题
    @ApiOperation("同意学生选题")
    @GetMapping("/verifychoose")
    @SaCheckRole("teacher")
    public Result verifyChoose(@RequestParam Integer projectId){
        projectService.verifyChoose(projectId);
        return Result.success();
    }


    @ApiOperation("查找待确认选题的列表")
    @GetMapping("/getverifyprojectlist")
    @SaCheckRole("teacher")
    public Result<List<VerifyProjectData>> getVerifyProjectList(@RequestParam String teacherId){
        return Result.success(projectService.getVerifyProjectList(teacherId));
    }

    @ApiOperation("通过projectid获取选题")
    @GetMapping("/getprojectbyid")
    @SaCheckLogin
    public Result<ProjectEntity> getProjectById(@RequestParam Integer projectId){
        return Result.success(projectService.getProjectById(projectId));
    }


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
    public Result updateStudentIdByProjectId(@RequestParam Integer projectId){
        String studentId=studentService.getStudentIdByUserId((String) StpUtil.getLoginId());
        ProjectEntity entity= projectService.getProjectById(projectId);;
        //如果存在选题返回错误
        if(studentService.getStudentById(studentId).getProjectId()!=null){
            return Result.failure(ResultCode.INSERT_ERROR);
        }
        projectService.updateStudentIdByProjectId(studentId,projectId);

        studentService.setProjectIdAndTeacherId(studentId,projectId,entity.getTeacherId());
        return Result.success();
    }

    @ApiOperation("更新项目未被学生选择")
    @GetMapping("/updatenostudent")
    @SaCheckLogin
    public Result updateNoStudent(@RequestParam Integer projectId){
        String studentId=projectService.getProjectById(projectId).getStudentId();
        //首先删除project的选择状态
        projectService.updateNoStudent(projectId);
        //删除学生的projectId信息
        studentService.deleteProjectIdAndTeacherId(studentId);

        return Result.success();
    }

    @ApiOperation("查询还可以选择的课题数量")
    @GetMapping("/getcountnochooseproject")
    @SaCheckLogin
    public Result getCountNoChooseProject(){
        return Result.success(projectService.getCountProjectNum());
    }

    @ApiOperation("插入新的选题")
    @PostMapping("/insert")
    @SaCheckLogin
    public Result insertSelective(@RequestBody ProjectEntity project){
        String teacherId=project.getTeacherId();
        if (projectService.insertSelective(project,teacherId)){
            return Result.success();
        }else {
            return Result.failure(ResultCode.INSERT_ERROR);
        }
    }

    @ApiOperation("更新选题信息")
    @PostMapping("/updatebyprimarykey")
    @SaCheckLogin()
    public Result updateByPrimaryKey(@RequestBody ProjectEntity project){
        if (projectService.updateByPrimaryKeySelective(project)){
            return Result.success();
        }else {
            return Result.failure(ResultCode.UPDATE_ERROR);
        }
    }

    @CrossOrigin
    @ApiOperation("分页查询所有选题")
    @PostMapping("/getAll")
    @SaCheckLogin
    public Result<StdPagedList<ProjectEntity>> getAll(@Validated @RequestBody PageReq pageReq){
        System.out.println("getAll");
        return Result.success(projectService.getProjectList(pageReq));
    }


    @ApiOperation("分页查询所有选题")
    @GetMapping("/getprojectlist")
    @SaCheckLogin
    public Result<StdPagedList<ProjectEntity>> getProjectList(@RequestParam Integer pageSize,@RequestParam Integer pageNum){
        PageReq pageReq = new PageReq();
        pageReq.setPageSize(pageSize);
        pageReq.setPageNum(pageNum);
        return Result.success(projectService.getProjectList(pageReq));
    }
}
