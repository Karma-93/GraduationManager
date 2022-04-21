package com.cx.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.map.MapUtil;
import com.cx.common.Result;
import com.cx.common.ResultCode;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.model.Login;
import com.cx.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Slf4j
@Api(tags = "UserController", description = "用户管理")
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public Result Login(@Validated @RequestBody Login login) {
        UserEntity user = userService.getUserByAccount(login.getAccount());
        if (user == null) {
            return Result.failure(ResultCode.USER_NOT_EXIST);
        }
        if (!user.getUserPassword().equals(SaSecureUtil.md5(login.getPassword()))) {
            return Result.failure(ResultCode.USER_LOGIN_ERROR);
        }
        StpUtil.login(user.getUserId());
        return Result.success(MapUtil.builder()
                .put("userId", user.getUserId())
                .put("userName", user.getUserName())
                .put("userRoles", user.getUserRoles())
                .put(StpUtil.getTokenName(), StpUtil.getTokenValue())
                .map()
        );
    }


    @CrossOrigin
    @GetMapping("/logout")
    @ApiOperation("注销登陆，会根据请求头的satoken注销登录")
    @SaCheckLogin()
    public Result logout(){
        StpUtil.logout();
        return Result.success();
    }


    @ApiOperation("通过userId获取用户信息")
    @SaCheckLogin
    @GetMapping("/getUserById")
    public Result<UserEntity> getUserById(@RequestParam String userId){
        return Result.success(userService.getUserById(userId));
    }



}
