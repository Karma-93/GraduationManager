package com.cx.config;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerUIConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()  //函数返回一个ApiSelectorBuilder实例来控制哪些接口暴露给Swagger来展现
                .apis(RequestHandlerSelectors.basePackage("com.cx.controller"))
                //为有API注解的Controller生成API注解
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //为有@APiOperation注解的方法生成API文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes());
    }
    //在页定义面上显示的标题信息
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Swagger-UI Test")
                .version("1.0")
                .description("CRUD")
                .build();
    }
    private List<ApiKey> securitySchemes(){
        //设置请求头信息
        List<ApiKey> result=new ArrayList<>();
        ApiKey apiKey=new ApiKey("satoken","satoken","header");
        result.add(apiKey);
        return result;
    }
}
