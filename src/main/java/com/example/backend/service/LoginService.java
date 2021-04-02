package com.example.backend.service;

import com.example.backend.mapper.LoginDao;
import com.example.backend.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginDao loginDao;//报红，在mapper文件上加@Repository注解，这是从spring2.0新增的一个注解，用于简化 Spring 的开发，实现数据访问
    public Login selectByPrimaryKey(Integer user){
        return loginDao.selectByPrimaryKey(user);
    }

    public int insert(Login record){
        return loginDao.insert(record);
    }

}
