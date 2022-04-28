package com.cx.common;

public enum ResultCode {

    //成功状态码
    SUCCESS(1,"成功"),
    //参数错误1001-1999
    PARAM_IS_INVALID(1001,"参数无效"),
    PARAM_IS_BLANK(1002,"参数为空"),
    PARAM_TYPE_BIND_ERROR(1003,"参数类型错误"),
    PARAM_NOT_COMPLETE(1004,"参数缺失"),

    //用户错误
    USER_NOT_LOGGED_IN(2001,"用户未登录，访问的路径需要验证，请登录"),
    USER_LOGIN_ERROR(2002,"账户不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(2003,"账号已被禁用"),
    USER_NOT_EXIST(2004,"用户不存在"),
    USER_HAS_EXIETED(2005,"用户已存在"),
    USER_AUTHORITY_ERROR(2006,"修改权限错误"),
    //服务器错错误
    SERVER_ERROR(3001,"服务器错误"),
    DATA_NOT_EXIST(3002,"查询失败或不存在"),
    INSERT_ERROR(3003,"插入失败"),
    UPDATE_ERROR(3004,"更新失败"),
    DELETE_ERROR(3005,"删除失败"),
    //权限角色错误
    NOT_ROLE_ERROR(4001,"用户角色权限错误");

    private Integer code;
    private String message;
    ResultCode(Integer code,String message){
        this.code=code;
        this.message=message;
    }
    public Integer code(){
        return code;
    }
    public String message(){
        return message;
    }

}
