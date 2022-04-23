package com.cx.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.common.Result;
import com.cx.common.ResultCode;
import com.cx.fluentmybatis.entity.PaperlibEntity;
import com.cx.model.PageReq;
import com.cx.service.PaperlibService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "PaperlibController",description = "文库模块")
@RequestMapping("paperlib")
@RestController
public class PaperlibController {
    @Autowired
    PaperlibService paperlibService;

    @SaCheckLogin
    @ApiOperation(value = "分页查询获取文库列表")
    @PostMapping("/getpaperliblist")
    public Result<StdPagedList<PaperlibEntity>> getPaperlibList(@RequestBody @Validated PageReq pageReq){
        return Result.success(paperlibService.getPaperlibList(pageReq));
    }

    @ApiOperation(value = "插入新的论文")
    @SaCheckRole("teacher")
    @PostMapping("insertpaper")
    public Result insertPaper(@RequestBody PaperlibEntity paperlibEntity){
        int res=paperlibService.insert(paperlibEntity);
        if (res>0){
            return Result.success();
        }else {
            return Result.failure(ResultCode.INSERT_ERROR);
        }
    }


    @SaCheckLogin
    @ApiOperation(value = "查询获取所有文库列表")
    @GetMapping("/getallpaperliblist")
    public Result<List<PaperlibEntity>> getAll(){
        return Result.success(paperlibService.getAllPaperlibList());
    }

}


