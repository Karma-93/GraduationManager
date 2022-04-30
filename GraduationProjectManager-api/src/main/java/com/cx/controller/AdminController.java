package com.cx.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.cx.common.Result;
import com.cx.fluentmybatis.entity.AdminEntity;
import com.cx.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = "AdminController",description = "管理员用户")
@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @SaCheckLogin
    @ApiOperation(value = "获取管理员信息")
    @GetMapping("/getadminbyuserid")
    public Result<AdminEntity> getAdmin(@RequestParam String userId){
        return Result.success(adminService.getAdminByUserId(userId));
    }
}
