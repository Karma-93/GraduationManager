package com.cx.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.common.Result;
import com.cx.common.ResultCode;
import com.cx.fluentmybatis.entity.TeacherEntity;
import com.cx.model.PageReq;
import com.cx.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = "TeacherController",description = "教师接口")
@RequestMapping("/teacher")
@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping("/getTeacherList")
    @SaCheckLogin()
    @ApiOperation(value = "分页获取教师列表")
    public Result<StdPagedList<TeacherEntity>> getTeacherList(PageReq pageReq){
        return Result.success(teacherService.getTeacherList(pageReq));
    }

    @GetMapping("/getTeacherById")
    @ApiOperation(value = "通过teacherId获取教师信息")
    @SaCheckLogin()
    public Result<TeacherEntity> getTeahcerById(@RequestParam int teacherId){
        TeacherEntity teacherEntity=teacherService.getTeacherById(teacherId);
        if (teacherEntity!=null){
            return Result.success(teacherEntity);
        }else{
            return Result.failure(ResultCode.DATA_NOT_EXIST);
        }
    }


    @ApiOperation(value = "通过userId获取教师信息")
    @SaCheckLogin()
    @GetMapping(value = "/getTeacherByUserId")
    public Result<TeacherEntity> getTeacherByUserId(){
        return Result.success(teacherService.getTeacherByUserId((String)StpUtil.getLoginId()));
    }
}
