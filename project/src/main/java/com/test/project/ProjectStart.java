package com.test.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan("com.test.project.mapper")
@EnableConfigurationProperties
public class ProjectStart {
    public static void main(String[] args) {
        SpringApplication.run(ProjectStart.class,args);
    }
}
