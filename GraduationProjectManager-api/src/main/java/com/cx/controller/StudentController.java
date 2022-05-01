package com.cx.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.common.Result;
import com.cx.common.ResultCode;
import com.cx.fluentmybatis.dao.intf.UserDao;
import com.cx.fluentmybatis.entity.StudentEntity;
import com.cx.model.PageReq;
import com.cx.model.StudentData;
import com.cx.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@Api(tags = "StudentController", description = "学生模块")
@RequestMapping("/student")
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;





    @SaCheckLogin
    @ApiOperation("获取学生总数")
    @GetMapping("getstudentnum")
    public Result getStudentNum(){
        return  Result.success(studentService.getStudentNum());
    }


    @SaCheckLogin
    @ApiOperation("获取未选题学生总数")
    @GetMapping("getnoprojectstudentnum")
    public Result getNoProjectStudentNum(){
        return  Result.success(studentService.getNoProjectStudentNum());
    }

    @SaCheckLogin
    @ApiOperation("获取班级名")
    @GetMapping("getclassname")
    public Result<String> getClassName(@RequestParam String userId){
        return Result.success(studentService.getClassName(userId));
    }


    @SaCheckLogin
    @ApiOperation("分页查询所有学生Entity数据")
    @PostMapping("getStudentList")
    public Result<StdPagedList<StudentEntity>> getStudentList(@Validated @RequestBody PageReq pageReq){
        return Result.success(studentService.getStudentList(pageReq));
    }


    @SaCheckLogin
    @ApiOperation("通过教师id查询学生data")
    @GetMapping("/getStudentDataListByTeacherId")
    public Result<List<StudentData>> getStudentDataByTeacehrId(@RequestParam String teacherId){
        return Result.success(studentService.getStudentDataByTeacherId(teacherId));
    }


    @SaCheckLogin
    @ApiOperation(value = "通过UserId获取学生信息")
    @GetMapping("/getStudentByUserId")
    public Result<StudentEntity> getStudentByUserId(@RequestParam String userId){
//        StudentEntity student= studentService.getStudentByUserId((String) StpUtil.getLoginId());
        StudentEntity student= studentService.getStudentByUserId(userId);

        if (student==null){
            return Result.failure(ResultCode.DATA_NOT_EXIST);
        }
        return Result.success(student);
    }

    @SaCheckLogin
    @ApiOperation(value = "通过当前登录学生信息")
    @GetMapping("/getCurrentStudentData")
    public Result<StudentEntity> getCurrentStudentData(){
        StudentEntity student= studentService.getStudentByUserId((String) StpUtil.getLoginId());    
        if (student==null){
            return Result.failure(ResultCode.DATA_NOT_EXIST);
        }
        return Result.success(student);
    }


    @SaCheckLogin
    @ApiOperation("通过教师id查询学生")
    @GetMapping("/getStudentListByTeacherId")
    public Result<List<StudentEntity>> getStudentListByTeacherId(@RequestParam String teacherId){
        return Result.success(studentService.getStudentListByTeacherId(teacherId));
    }
}
