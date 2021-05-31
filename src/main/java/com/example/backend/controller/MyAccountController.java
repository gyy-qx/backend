package com.example.backend.controller;

import com.alibaba.fastjson.JSON;
import com.example.backend.model.Login;
import com.example.backend.model.Teacher;
import com.example.backend.service.LoginService;
import com.example.backend.service.MyAccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyAccountController {
    @Autowired
    LoginService loginService;
    @Autowired
    MyAccountService myAccountService;

    @RequestMapping(path="/myAccountLogin")
    public Login myAccountLogin(@RequestBody String json){
        Integer teacherNumber = Integer.parseInt(JSON.parseObject(json).getString("teacherNumber").toString());
        return myAccountService.myAccountLogin(teacherNumber);
    }

    @RequestMapping(path = "/myAccountTeacher")
    public Teacher myAccountTeacher(@RequestBody String json){
        Integer teacherNumber = Integer.parseInt(JSON.parseObject(json).getString("teacherNumber").toString());
        return myAccountService.myAccountTeacher(teacherNumber);
    }

    @RequestMapping(path="/myAccountSubmit")
    public String myAccountSubmit(@RequestBody String json)throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String LoginObject=JSON.parseObject(json).get("Login").toString();
        Login login = objectMapper.readValue(LoginObject, Login.class);
        String TeacherObject=JSON.parseObject(json).get("Teacher").toString();
        Teacher teacher = objectMapper.readValue(TeacherObject, Teacher.class);
        return myAccountService.myAccountSubmit(teacher,login);
    }

}
