package com.demo.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = {"com.demo.dao"}, sqlSessionTemplateRef = "sqlSessionTemplate")
public class ServiceImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceImplApplication.class, args);
    }

}
