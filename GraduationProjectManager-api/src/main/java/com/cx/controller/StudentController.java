package com.cx.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.common.Result;
import com.cx.common.ResultCode;
import com.cx.fluentmybatis.entity.StudentEntity;
import com.cx.model.PageReq;
import com.cx.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Slf4j
@Api(tags = "StudentController", description = "学生模块")
@RequestMapping("/student")
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @SaCheckLogin
    @ApiOperation(value = "通过UserId获取学生信息")
    @GetMapping("/getStudentByUserId")
    public Result<StudentEntity> getStudentByUserId(@Validated @NotBlank(message = "UserId不能为空") @RequestParam("userid") String userId){
        StudentEntity student= studentService.getStudentByUserId(userId);
        if (student==null){
            return Result.failure(ResultCode.DATA_NOT_EXIST);
        }
        return Result.success(student);
    }


    @SaCheckLogin
    @ApiOperation("通过教师id查询学生")
    @PostMapping("/getStudentListByTeacherId")
    public Result<StdPagedList<StudentEntity>> getStudentListByTeacherId(@Validated @RequestBody PageReq pageReq, @RequestBody int teacherId){
        return Result.success(studentService.getStudentListByTeacherId(pageReq,teacherId));
    }
}
