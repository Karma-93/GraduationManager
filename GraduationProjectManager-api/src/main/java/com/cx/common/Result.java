package com.cx.common;


import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private int code;
    private String message;
    private Object data;
    public Result(){}
    public Result(ResultCode resultCode,Object data){
        this.code=resultCode.code();
        this.message=resultCode.message();
        this.data=data;
    }
    public void setResultCode(ResultCode resultCode){
        this.code=resultCode.code();
        this.message=resultCode.message();
    }
    public static Result success(Object data){
        Result result=new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }
    public static Result success(){
        Result result=new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }
    public static Result failure(ResultCode resultCode){
        Result result=new Result();
        result.setResultCode(resultCode);
        return result;
    }

    public static Result failure(ResultCode resultCode,Object data){
        Result result=new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

}
