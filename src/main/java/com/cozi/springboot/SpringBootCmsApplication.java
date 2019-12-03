package com.cozi.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cozi.springboot.mapper")
@SpringBootApplication
public class SpringBootCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCmsApplication.class, args);
    }

}
