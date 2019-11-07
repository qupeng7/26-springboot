package com.qupeng.springboot.service.impl;

import com.qupeng.springboot.constants.Constant;
import com.qupeng.springboot.mapper.users.UsersMapper;
import com.qupeng.springboot.model.ResultObject;
import com.qupeng.springboot.model.Users;
import com.qupeng.springboot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    public ResultObject register(String phone, String password) {
        Users users = new Users();
        users.setPhone(phone);
        users.setPassword(password);
        int insert = usersMapper.insertSelective(users);
        if (insert > 0) {
            return new ResultObject(Constant.ZERO, "注册成功", users);
        } else {
            return new ResultObject(Constant.ONE, "注册失败");
        }
    }

    public ResultObject login(String phone, String password) {
        Users users = usersMapper.login(phone, password);
        if (users != null) {
            return new ResultObject(Constant.ZERO, "登录成功", users);
        } else {
            return new ResultObject(Constant.ONE, "账号或密码不匹配");
        }
    }

    public void show() {

        System.out.println("222.............");

        System.out.println("userservice show方法执行了.............");
    }
}