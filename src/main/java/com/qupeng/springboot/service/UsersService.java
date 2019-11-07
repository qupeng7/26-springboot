package com.qupeng.springboot.service;

import com.qupeng.springboot.model.ResultObject;

public interface UsersService {

    public ResultObject register(String phone, String password);

    public ResultObject login(String phone, String password);

    public void show();
}