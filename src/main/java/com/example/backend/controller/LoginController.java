package com.example.backend.controller;

import com.example.backend.model.Login;
import com.example.backend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired

    LoginService loginService;
    @RequestMapping(path = "/login")
    public String login(@RequestBody Login login_person) {
        Integer user=login_person.getUser();
        Login result = loginService.selectByPrimaryKey(user);
        System.out.println(result);
        if(result.password.equals(login_person.getPassword())&&result.id.equals(login_person.getId()))
            return "login success";
        else if(!result.password.equals(login_person.getPassword())&&result.id.equals(login_person.getId()))
            return "ERROR Incorrect username or password";
        else
            return "ERROR identity";
    }
}
