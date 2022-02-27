package com.cx.controller;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.common.Result;
import com.cx.fluentmybatis.entity.DownEntity;
import com.cx.model.PageReq;
import com.cx.service.DownService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "DownController",description = "文件下载接口")
@RequestMapping("/down")
@RestController
public class DownController {

    @Autowired
    DownService downService;

    @ApiOperation(value = "分页查询数据列表")
    @PostMapping("/selectAllPage")
    public Result<StdPagedList<DownEntity>> selectAllPage(@Validated @RequestBody PageReq pageReq){
        return Result.success(downService.get(pageReq));
    }
}
