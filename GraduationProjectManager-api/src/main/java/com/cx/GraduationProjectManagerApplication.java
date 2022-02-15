package com.cx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan("com.cx.fluentmybatis.mapper")
public class GraduationProjectManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GraduationProjectManagerApplication.class, args);
    }
}
