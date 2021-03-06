package com.qupeng.springboot.controller;

import com.qupeng.springboot.properties.MyProperties1;
import com.qupeng.springboot.properties.MyProperties2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesController {

    @Autowired
    private MyProperties1 properties1;

    @Autowired
    private MyProperties2 properties2;

    @Value("${jgs.seven.email}")
    private String email;

    @RequestMapping("/boot/prop")
    public Object prop() {
        System.out.println(properties1.getName());
        System.out.println(properties2.getAddress());

        return email;
    }
}