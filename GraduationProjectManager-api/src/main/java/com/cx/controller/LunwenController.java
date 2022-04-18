package com.cx.controller;

import com.cx.common.Result;
import com.cx.common.ResultCode;
import com.cx.fluentmybatis.entity.LunwenEntity;
import com.cx.service.LunwenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = "LunwenController", description = "论文接口")
@RequestMapping("/lunwen")
@RestController
public class LunwenController {

    @Autowired
    LunwenService lunwenService;

    @ApiOperation("新增论文")
    @PostMapping("/add")
    public Result addLunwen(@RequestBody LunwenEntity lunwen) {
        if (lunwenService.addLunwen(lunwen) > 0) return Result.success();
        else return Result.failure(ResultCode.INSERT_ERROR);
    }

    @ApiOperation("删除论文")
    @GetMapping("/remove")
    public Result removeLunwen(@RequestParam Integer id) {
        if (lunwenService.removeLunwen(id) > 0) return Result.success();
        else return Result.failure(ResultCode.DELETE_ERROR);
    }

    @ApiOperation("更新论文")
    @PostMapping("/update")
    public Result updateLunwen(@RequestBody LunwenEntity lunwen){
        if (lunwenService.updateLunwen(lunwen)>0) return Result.success();
        else return Result.failure(ResultCode.UPDATE_ERROR);
    }

    @ApiOperation("通过id获取论文")
    @GetMapping("/getById")
    public Result<LunwenEntity> getLunwenById(@RequestParam Integer id) {
        return Result.success(lunwenService.getLunwen(id));
    }

    @ApiOperation("通过studentid获取论文")
    @GetMapping("/getByStudentId")
    public Result<LunwenEntity> getLunwenById(@RequestParam String studentId) {
        return Result.success(lunwenService.getLunwenByStudentId(studentId));
    }
}
