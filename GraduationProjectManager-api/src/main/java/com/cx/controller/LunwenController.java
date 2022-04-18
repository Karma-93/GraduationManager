package com.cx.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "LunwenController", description = "论文接口")
@RequestMapping("/lunwen")
@RestController
public class LunwenController {

}
