package com.cx.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.map.MapUtil;
import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.cx.common.Result;
import com.cx.common.ResultCode;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.model.Login;
import com.cx.model.PageReq;
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
                .put("userTel", user.getUserTel())
                .put(StpUtil.getTokenName(), StpUtil.getTokenValue())
                .map()
        );
    }

    @CrossOrigin
    @GetMapping("/logout")
    @ApiOperation("注销登陆，会根据请求头的satoken注销登录")
    @SaCheckLogin()
    public Result logout() {
        StpUtil.logout();
        return Result.success();
    }

    @CrossOrigin
    @ApiOperation("通过userId获取用户信息")
    @SaCheckLogin
    @GetMapping("/getUserById")
    public Result<UserEntity> getUserById(@RequestParam String userId) {
        return Result.success(userService.getUserById(userId));
    }

    @CrossOrigin
    @ApiOperation("分页查询用户列表")
    @SaCheckLogin
    @PostMapping("/getUserList")
    public Result<StdPagedList<UserEntity>> getUserList(@Validated @RequestBody PageReq pageReq) {
        return Result.success(userService.getUserList(pageReq));
    }

    @CrossOrigin
    @ApiOperation("更新用户信息")
    @SaCheckLogin
    @PostMapping("/update")
    public Result updateUserById(@RequestBody UserEntity userEntity) {
        if (userService.update(userEntity) > 0) return Result.success();
        else return Result.failure(ResultCode.UPDATE_ERROR);
    }

    @CrossOrigin
    @ApiOperation("新增用户")
    @SaCheckLogin
    @PostMapping("/add")
    public Result addUser(@RequestBody UserEntity userEntity) {
        if (userService.insert(userEntity) > 0) return Result.success();
        else return Result.failure(ResultCode.INSERT_ERROR);
    }

    @ApiOperation("删除用户")
    @SaCheckRole("admin")
    @GetMapping("/remove")
    public Result deleteUser(@RequestParam String userId){
        if (userService.delete(userId)>0) return Result.success();
        else return Result.failure(ResultCode.DELETE_ERROR);
    }
}
