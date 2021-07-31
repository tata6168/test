package com.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.start.mapper")
@EnableCaching //开启基于注解的缓存
public class LiuyanStart {
    public static void main(String[] args) {
        SpringApplication.run(LiuyanStart.class,args);
    }
}
