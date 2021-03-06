package com.qupeng.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@MapperScan(basePackages={"com.qupeng.springboot.mapper"})//扫描包之后,mapper注解可以去掉
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        //启动spring容器+启动一个内嵌的tomcat
        SpringApplication.run(Application.class, args);
    }

    /**
     * springboot 打war包tomcat下可以执行,需要继承SpringBootServletInitializer类,覆盖configure改方法
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }


}
