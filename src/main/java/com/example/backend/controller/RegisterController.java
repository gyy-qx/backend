package com.example.backend.controller;

import com.example.backend.model.Login;
import com.example.backend.model.Teacher;
import com.example.backend.service.MyAccountService;
import com.example.backend.service.LoginService;
import com.example.backend.service.TeacherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    MyAccountService myAccountService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    LoginService loginService;

    @RequestMapping(path = "/created")
    public List<String> getResearchList() {
        List<String> researchList = myAccountService.getResearchList();
        return researchList;
    }

    @RequestMapping(path = "/verifyIdentity")
    public Integer selectChairman(@RequestBody String json) {
        JacksonJsonParser jsonParser = new JacksonJsonParser();
        Map<String, Object> map = jsonParser.parseMap(json);
        String research_name = (String) map.get("researchName");
        System.out.println(research_name);
        Integer researchChairman = myAccountService.selectChairman(research_name);
        System.out.println(researchChairman);
        return researchChairman;
    }

    @RequestMapping(path = "/register")
    public String InsertTeacher(@RequestBody String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        String loginJson = jsonNode.get("Login").toString();
        String teacherJson = jsonNode.get("Teacher").toString();

        Login loginPerson = objectMapper.readValue(loginJson, Login.class);
        Teacher teacher = objectMapper.readValue(teacherJson, Teacher.class);
        System.out.println(teacher);

        int loginResult=loginService.insert(loginPerson);
        int teacherResult=teacherService.insert(teacher);

        if(loginResult>0&&teacherResult>0){
            return "注册成功";
       }else{
            return "注册失败";
        }
    }
}
