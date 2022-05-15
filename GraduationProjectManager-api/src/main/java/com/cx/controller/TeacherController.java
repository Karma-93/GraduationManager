package com.cx.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.common.Result;
import com.cx.common.ResultCode;
import com.cx.fluentmybatis.entity.TeacherEntity;
import com.cx.model.PageReq;
import com.cx.model.TeacherData;
import com.cx.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "TeacherController", description = "教师接口")
@RequestMapping("/teacher")
@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;


    @SaCheckRole("admin")
    @ApiOperation("增加教师信息，管理员角色才可以调用")
    @PostMapping("/addteacher")
    public Result insert(@RequestBody TeacherEntity entity){
        if (teacherService.insert(entity)>0) return Result.success();
        else return Result.failure(ResultCode.INSERT_ERROR);
    }

    @SaCheckLogin
    @ApiOperation("更新")
    @PostMapping("/update")
    public Result update(@RequestBody TeacherEntity teacherEntity){
        if (teacherService.update(teacherEntity)>0) return Result.success();
        else return Result.failure(ResultCode.UPDATE_ERROR);
    }


    @ApiOperation("根据Id获取姓名")
    @SaCheckLogin()
    @GetMapping("/getNamebyteacherid")
    public Result getNameByTeacherId(@RequestParam String teacherId){
        return Result.success(teacherService.getNameByTeacherId(teacherId));
    }

    @PostMapping("/getTeacherList")
    @SaCheckLogin()
    @ApiOperation(value = "分页获取教师列表")
    public Result<StdPagedList<TeacherEntity>> getTeacherList(@Validated @RequestBody PageReq pageReq) {
        return Result.success(teacherService.getTeacherList(pageReq));
    }


    @PostMapping("/getTeacherData")
    @SaCheckLogin()
    @ApiOperation(value = "分页获取教师数据列表")
    public Result<StdPagedList<TeacherData>> getTeacherData(@Validated @RequestBody PageReq pageReq){
        return Result.success(teacherService.getTeacherData(pageReq));
    }

    @GetMapping("/getTeacherByTeacherId")
    @ApiOperation(value = "通过teacherId获取教师信息")
    @SaCheckLogin()
    public Result<TeacherEntity> getTeahcerById(@RequestParam String teacherId) {
        TeacherEntity teacherEntity = teacherService.getTeacherById(teacherId);
        if (teacherEntity != null) {
            return Result.success(teacherEntity);
        } else {
            return Result.failure(ResultCode.DATA_NOT_EXIST);
        }
    }


    @ApiOperation(value = "通过userId获取教师信息")
    @SaCheckLogin()
    @GetMapping(value = "/getTeacherByUserId")
    public Result<TeacherEntity> getTeacherByUserId(@RequestParam Integer userId) {
        return Result.success(teacherService.getTeacherByUserId((String) StpUtil.getLoginId()));
    }

    @ApiOperation("获取所有教师列表")
    @SaCheckLogin()
    @GetMapping("getAllTeacherList")
    public Result<List<TeacherEntity>> getAllTeacherList() {
        return Result.success(teacherService.getAllTeacherList());
    }


    @ApiOperation("获取所有教师信息")
    @SaCheckLogin()
    @GetMapping("getAllTeacherData")
    public Result<List<TeacherData>> getAllTeacherData(){
        return Result.success(teacherService.getAllTeacherData());
    }

    @ApiOperation("删除教师")
    @SaCheckLogin()
    @GetMapping("delete")
    public Result delete(String teacherId){
        if (teacherService.delete(teacherId)>0) return Result.success();
        else return Result.failure(ResultCode.DELETE_ERROR);
    }
}
