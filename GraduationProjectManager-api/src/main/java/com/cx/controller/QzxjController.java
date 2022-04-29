package com.cx.controller;

import com.cx.common.Result;
import com.cx.common.ResultCode;
import com.cx.fluentmybatis.entity.QzxjEntity;
import com.cx.service.QzxjService; 
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = "QzxjController", description = "其中小结接口")
@RequestMapping("/qzxj")
@RestController
public class QzxjController {

    @Autowired
    QzxjService qzxjService;

    @PostMapping("/add")
    @ApiOperation("新增期中小结")
    public Result add(@RequestBody QzxjEntity qzxj){
        if (qzxjService.addQzxj(qzxj)>0) return Result.success();
        else return Result.failure(ResultCode.INSERT_ERROR);
    }

    @ApiOperation("更新期中小结")
    @PostMapping("/update")
    public Result update(@RequestBody QzxjEntity qzxj){
        if(qzxjService.updateQzxj(qzxj)>0) return Result.success();
        else return Result.failure(ResultCode.UPDATE_ERROR);
    }

    @ApiOperation("删除")
    @GetMapping("/remove")
    public Result remove(@RequestParam Integer id){
        if (qzxjService.removeQzxj(id)>0) return Result.success();
        else  return Result.failure(ResultCode.DELETE_ERROR);
    }

    @GetMapping("/getbyid")
    @ApiOperation("根据id查询")
    public Result<QzxjEntity> getById(@RequestParam Integer id){
        return Result.success(qzxjService.getQzxj(id));
    }

    @GetMapping("/getbystudentid")
    @ApiOperation("根据studentid查询")
    public Result<QzxjEntity> getByStudentId(String studentId){
        return Result.success(qzxjService.getQzxjByStudentId(studentId));
    }

}


