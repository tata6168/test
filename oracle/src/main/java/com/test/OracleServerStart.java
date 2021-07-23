package com.test;

import com.test.demo.User;
import com.test.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.test.mapper")
public class OracleServerStart {

    public static void main(String[] args) {
        SpringApplication.run(OracleServerStart.class,args);

    }
}
