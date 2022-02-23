package com.cx.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@ToString
public class Login {
    @NotBlank(message = "账户不能为空")
    private String password;
    @NotBlank(message = "密码不能为空")
    private String account;
}
