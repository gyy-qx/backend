package com.example.backend.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.backend.model.Email;
import com.example.backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmailController {
    @Autowired
    EmailService emailService;

    @RequestMapping(path="/emailToTeacher")
    public String emailToTeacher(@RequestBody Email email){
        return emailService.emailToTeacher(email);
    }

    @RequestMapping(path = "/getEmailByTeacher")
    public List<Email> getEmailByTeacher(@RequestBody String json){
        return emailService.getEmailByTeacher(json);
    }

    @RequestMapping(path="/updateEmailState")
    public void updateEmailState(@RequestBody Email email){
        emailService.updateEmailState(email);
    }

    @RequestMapping(path="/deleteEmail")
    public String deleteEmail(@RequestBody Email email){
        System.out.println(email);
        return emailService.deleteEmail(email);
    }

    @RequestMapping(path="/getEmailPersonName")
    public String getEmailPersonName(@RequestBody String json){
        return emailService.getEmailPersonName(json);
    }

    @RequestMapping(path="updateEmailStateAll")
    public String updateEmailStateAll(@RequestBody String json){
        List<Email> emailList = JSONArray.parseArray(JSON.parseObject(json).get("emailList").toString(),Email.class);
        return emailService.updateEmailStateAll(emailList);
    }
}
