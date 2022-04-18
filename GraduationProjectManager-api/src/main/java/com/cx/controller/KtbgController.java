package com.cx.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "KtbgController", description = "开题报告接口")
@RequestMapping("/ktbg")
@RestController
public class KtbgController {
}
