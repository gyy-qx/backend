package com.example.backend.controller;

import com.alibaba.fastjson.JSON;
import com.example.backend.model.Course;
import com.example.backend.model.Target;
import com.example.backend.service.scoreService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class scoreController {
    @Autowired
    scoreService scoreService;

    @RequestMapping(path="/scoreCreated")
    public List<String> select(@RequestBody String json){
        System.out.println(json);
//        fastjson
        Integer teacherNum = Integer.parseInt(JSON.parseObject(json).get("teacherNum").toString());
        System.out.println(teacherNum);
        List<String> courseList = scoreService.select(teacherNum);
        for(String course:courseList){
            System.out.println(course);
        }
        return courseList;
    }

    @RequestMapping(path="/scoreRatio")
    public void insertRatio(@RequestBody String json) throws JsonProcessingException {
        System.out.println(json);
        String courseObject=JSON.parseObject(json).get("course").toString();
        String characterObject=JSON.parseObject(json).get("character").toString();
        String targetObject=JSON.parseObject(json).get("target").toString();
        System.out.println(courseObject);
        System.out.println(characterObject);
        System.out.println(targetObject);


        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.readTree(json);
//        String courseJson = jsonNode.get("course").toString();
//        String characterJson = jsonNode.get("character").toString();
//        String targetJson = jsonNode.get("target").toString();
//
        Course course = objectMapper.readValue(courseObject, Course.class);
        Character character = objectMapper.readValue(characterObject, Character.class);
        Target target = objectMapper.readValue(targetObject, Target.class);
        System.out.println(course);
        System.out.println(character);
        System.out.println(target);
//        scoreService.insertRatio(course,character,target);
    }
}
