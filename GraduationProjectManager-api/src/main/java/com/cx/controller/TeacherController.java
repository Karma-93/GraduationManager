package com.cx.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.common.Result;
import com.cx.common.ResultCode;
import com.cx.fluentmybatis.entity.TeacherEntity;
import com.cx.model.PageReq;
import com.cx.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Api(tags = "TeacherController",description = "教师接口")
@RequestMapping("/teacher")
@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping("/getteacherlist")
    @SaCheckLogin()
    @ApiOperation(value = "分页获取教师列表")
    public Result<StdPagedList<TeacherEntity>> getTeacherList(PageReq pageReq){
        return Result.success(teacherService.getTeacherList(pageReq));
    }

    @PostMapping("/getteacherbyid")
    @ApiOperation(value = "通过teacherId获取教师信息")
    @SaCheckLogin()
    public Result<TeacherEntity> getTeahcer(int teacherId){
        TeacherEntity teacherEntity=teacherService.getTeacherById(teacherId);
        if (teacherEntity!=null){
            return Result.success(teacherEntity);
        }else{
            return Result.failure(ResultCode.DATA_NOT_EXIST);
        }
    }
}
