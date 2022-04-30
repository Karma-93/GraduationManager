package com.cx.controller;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.common.Result;
import com.cx.fluentmybatis.entity.InformEntity;
import com.cx.model.PageReq;
import com.cx.service.InformService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "InformController",description = "通知公告模块")
@RequestMapping("/inform")
@RestController
public class InformController {
    @Autowired
    InformService informService;


    @ApiOperation(value = "分页查询所有")
    @PostMapping("/selectAllPage")
    public Result<StdPagedList<InformEntity>> selectAllPage(@Validated @RequestBody PageReq pageReq){
        return Result.success(informService.get(pageReq));
    }
}
