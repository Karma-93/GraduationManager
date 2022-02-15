package com.cx.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PageReq {
    @NotNull(message = "参数不能为空")
    private Integer pageSize;
    @NotNull(message = "参数不能为空")
    private Integer pageNum;
}
