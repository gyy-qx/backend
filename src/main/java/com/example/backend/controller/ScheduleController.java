package com.example.backend.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.backend.model.ProcessScore;
import com.example.backend.model.ProcessText;
import com.example.backend.model.TargetText;
import com.example.backend.service.ScheduleService;
import com.example.backend.studentDto.StudentDto1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

//平时任务
    @RequestMapping(path="/getTargetText")
    public TargetText getTargetText(@RequestBody String json){
        String courseName = JSON.parseObject(json).get("courseName").toString();
        String courseMajor = JSON.parseObject(json).get("courseMajor").toString();
        String courseGrade = JSON.parseObject(json).get("courseGrade").toString();
        return scheduleService.getTargetText(courseName,courseMajor,courseGrade);
    }

    @RequestMapping(path="/selectOrdinary")
    public List<ProcessText> selectOrdinary(@RequestBody String json){
        return scheduleService.selectOrdinary(json);
    }

    @RequestMapping(path="/insertProcessText")
    public String insertProcessText(@RequestBody ProcessText processText){
        System.out.println(processText);
        return scheduleService.insertProcessText(processText);
    }
    @RequestMapping(path = "/deleteOrdinary")
    public String deleteOrdinary(@RequestBody String json){
        return scheduleService.deleteOrdinary(json);
    }

    @RequestMapping(path = "/getStudentByGrade")
    public List<StudentDto1> getStudentByGrade(@RequestBody String json){
        return scheduleService.getStudentByGrade(json);
    }

    @RequestMapping(path = "/insertProcessScore")
    public String insertProcessScore(@RequestBody String json){
        String processScore = JSON.parseObject(json).get("processScoreList").toString();
        List<ProcessScore> processScoreList = JSONArray.parseArray(processScore,ProcessScore.class);
        return scheduleService.insertProcessScore(processScoreList);
    }

    @RequestMapping(path="/ifHaveProcessScore")
    public List<ProcessScore> ifHaveProcessScore(@RequestBody String json){
        return scheduleService.ifHaveProcessScore(json);
    }

    @RequestMapping(path="/updateProcessScore")
    public String updateProcessScore(@RequestBody String json){
        String processScore = JSON.parseObject(json).get("processScoreList").toString();
        List<ProcessScore> processScoreList = JSONArray.parseArray(processScore,ProcessScore.class);
        return scheduleService.updateProcessScore(processScoreList);
    }
}
