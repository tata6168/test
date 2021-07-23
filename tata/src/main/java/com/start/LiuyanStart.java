package com.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.start.mapper")
public class LiuyanStart {
    public static void main(String[] args) {
        SpringApplication.run(LiuyanStart.class,args);
    }
}
