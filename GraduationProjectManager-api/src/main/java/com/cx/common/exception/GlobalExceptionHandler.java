package com.cx.common.exception;


import cn.dev33.satoken.exception.NotLoginException;

import cn.dev33.satoken.exception.NotRoleException;
import com.cx.common.Result;
import com.cx.common.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

/**
 * 处理全局异常，避免出错是返回tomcat或者nginx页面
 */
@Slf4j
@RestControllerAdvice//表示定义全局控制器异常处理
public class GlobalExceptionHandler {

   /*
    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public Result handle401(ShiroException e) {
        return Result.fail(401, e.getMessage(), null);
    }
    */
    /**
     * 处理Assert的异常,使用断言判断信息，删除
     */

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)//表示针对性异常处理
    public Result handler(IllegalArgumentException e) throws IOException {
        log.error("Assert异常:-------------->{}",e.getMessage());
        return Result.failure(ResultCode.USER_NOT_EXIST,e.getMessage());
    }
    /**
     * @Validated 校验错误异常处理
     * 使用Validated校验方式，如果实体不符合要求，会抛出如下异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handler(MethodArgumentNotValidException e) throws IOException {
        log.error("运行时异常:Validated验证异常:-------------->",e);
        BindingResult bindingResult = e.getBindingResult();
        ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();
        //在这里返回错误
        return Result.failure(ResultCode.PARAM_IS_INVALID,objectError.getDefaultMessage());
    }

    /**
     * 当请求未使用json格式或请求参数为空
     * @param e
     * @return
     * @throws IOException
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public Result handler(HttpMessageNotReadableException e) throws IOException {
        log.error("运行时异常：-------------------->",e);
        return Result.failure(ResultCode.PARAM_IS_INVALID,"请将请求数据使用json序列换"+'\n'+e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public Result handler(RuntimeException e) throws IOException {
        log.error("运行时异常:-------------->",e);
        return Result.failure(ResultCode.SERVER_ERROR,e.getMessage());
    }

    /**
     * 处理SaToken的无token异常
     * @param e
     * @return
     * @throws IOException
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = NotLoginException.class)
    public Result handler(NotLoginException e) throws IOException{
        log.error("运行时异常-未登录:-------------->",e);
        return Result.failure(ResultCode.USER_NOT_LOGGED_IN);
    }

    /**
     * 处理角色权限错误的异常
     * @param e
     * @return
     * @throws IOException
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = NotRoleException.class)
    public Result handler(NotRoleException e) throws IOException{
        log.error("运行时异常-角色权限错误:-------------->",e);
        return Result.failure(ResultCode.NOT_ROLE_ERROR);
    }




}
