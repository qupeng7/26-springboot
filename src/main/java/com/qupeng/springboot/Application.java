package com.qupeng.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages={"com.qupeng.springboot.mapper"})//扫描包之后,mapper注解可以去掉
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //启动spring容器+启动一个内嵌的tomcat
        SpringApplication.run(Application.class, args);
    }

}
