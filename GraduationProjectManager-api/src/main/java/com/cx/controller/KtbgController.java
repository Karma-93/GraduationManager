package com.cx.controller;


import com.cx.common.Result;
import com.cx.common.ResultCode;
import com.cx.fluentmybatis.entity.KtbgEntity;
import com.cx.service.KtbgService; 
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = "KtbgController", description = "开题报告接口")
@RequestMapping("/ktbg")
@RestController
public class KtbgController {
    @Autowired
    KtbgService ktbgService;

    @ApiOperation(value = "添加开题报告")
    @PostMapping("/addktbg")
    public Result addKtbg(@RequestBody KtbgEntity ktbg){
        if (ktbgService.addKtbg(ktbg)>0){
            return Result.success();
        }else {
            return Result.failure(ResultCode.INSERT_ERROR);
        }
    }

    @ApiOperation("根据id删除ktbg")
    @GetMapping("/remove")
    public Result removeKtbg(@RequestParam Integer id){
        if (ktbgService.removeKtbg(id)>0){
            return Result.success();
        }else {
            return Result.failure(ResultCode.DELETE_ERROR);
        }
    }

    @ApiOperation("更新开题报告")
    @PostMapping("/update")
    public Result updateKtbg(@RequestBody KtbgEntity ktbg){
        if (ktbgService.updateKtbg(ktbg)>0) return Result.success();
        else return Result.failure(ResultCode.UPDATE_ERROR);
    }

    @ApiOperation("通过id获取开题报告")
    @GetMapping("/getById")
    public Result<KtbgEntity> getKtbgById(@RequestParam Integer id){
        return Result.success(ktbgService.getKtbg(id));
    }


    @ApiOperation("通过studentId获取开题报告")
    @GetMapping("/getByStudentId")
    public Result<KtbgEntity> getKtbgById(@RequestParam String studentId){
        return Result.success(ktbgService.getKtbgByStudentId(studentId));
    }
}
