package com.example.backend.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.backend.courseDto.CourseClass;
import com.example.backend.model.*;
import com.example.backend.service.scoreService;
import com.example.backend.studentDto.StudentDto1;
import com.example.backend.targetDto.targetDto1;
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

//    存储目标成绩

    @RequestMapping(path="/getCourseInformation")
    public Course getCourseInformation(@RequestBody String json){
        return scoreService.getCourseInformation(json);
    }

    @RequestMapping(path="/getCourseCharacter")
    public TargetText getCourseCharacter(@RequestBody String json){
        return scoreService.getCourseCharacter(json);
    }

    @RequestMapping(path="/getCourseTarget")
    public Target getCourseTarget(@RequestBody String json){
        return scoreService.getCourseTarget(json);
    }

    @RequestMapping(path="/scoreCreated")
    public List<CourseClass> select(@RequestBody String json){
//        fastjson
        Integer teacherNum = Integer.parseInt(JSON.parseObject(json).get("teacherNum").toString());
        System.out.println(teacherNum);
        List<CourseClass> courseList = scoreService.select(teacherNum);
        return courseList;
    }

    @RequestMapping(path="/majorCreated")
    public List<String> getAllMajor(){
        return scoreService.getAllMajor();
    }

    @RequestMapping(path="/scoreRatio")
    public String insertRatio(@RequestBody String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String courseObject=JSON.parseObject(json).get("course").toString();
        Course course = objectMapper.readValue(courseObject, Course.class);
        String targetObject=JSON.parseObject(json).get("target").toString();
        Target target = objectMapper.readValue(targetObject, Target.class);
        String TargetTextObject=JSON.parseObject(json).get("character").toString();
        TargetText targetText=objectMapper.readValue(TargetTextObject, TargetText.class);
//        TargetText targetText=JSON.parseObject(JSON.parseObject(json).get("character").toString(),Character.class);
        System.out.println(targetText);
        String result=scoreService.insertRatio(course,targetText,target);
        System.out.println(result);
        return result;
    }


//    学生原始成绩写入


    @RequestMapping(path="/getAllCourseByTeacher")
    public List<CourseClass> getAllCourseByTeacher(@RequestBody String json){
        Integer courseTeacher = Integer.parseInt(JSON.parseObject(json).get("courseTeacher").toString());
        return scoreService.getAllCourseByTeacher(courseTeacher);
    }

    @RequestMapping(path = "/getClassByGrade")
    public List<String> getClassByCourse(@RequestBody CourseClass courseClass){
        return scoreService.getClassByCourse(courseClass);
    }

    @RequestMapping(path="/selectStudentByClass")
    public List<StudentDto1> selectStudentByClass(@RequestBody String json){
        String studentClass = JSON.parseObject(json).get("studentClass").toString();
        return scoreService.getStudentByClass(studentClass);
    }

    @RequestMapping(path="/insertScoreResult")
    public String getScoreResult(@RequestBody String json){
        String result = JSON.parseObject(json).get("resultList").toString();
        List<Result> resultList = JSONArray.parseArray(result, Result.class);
        return scoreService.getScoreResult(resultList);
    }

    @RequestMapping(path="/getTargetScore")
    public List<targetDto1> getTargetScore(@RequestBody String json){
        String courseName = JSON.parseObject(json).get("courseName").toString();
        String courseMajor = JSON.parseObject(json).get("courseMajor").toString();
        String courseGrade = JSON.parseObject(json).get("courseGrade").toString();
        return scoreService.getTargetScore(courseName,courseMajor,courseGrade);
    }

    //学生生成结果数据
    @RequestMapping(path="/getResultScore")
    public List<Result> getResultScore(@RequestBody String json){
        String studentClass = JSON.parseObject(json).get("studentClass").toString();
        String courseName = JSON.parseObject(json).get("courseName").toString();
        return scoreService.getResultScore(studentClass,courseName);
    }

    @RequestMapping(path="/updateAchievementDegree")
    public void updateAchievementDegree(@RequestBody String json) throws JsonProcessingException{
        List<Result> resultList = JSONArray.parseArray(JSON.parseObject(json).get("resultList").toString(),Result.class);
        ObjectMapper objectMapper = new ObjectMapper();
        String classResultObject=JSON.parseObject(json).get("classResult").toString();
        ClassResult classResult = objectMapper.readValue(classResultObject, ClassResult.class);
        scoreService.updateAchievementDegree(resultList,classResult);
    }



    @RequestMapping(path="/getTeacherByNum")
    public Teacher getTeacherByNum(@RequestBody String json){
        Integer teacherNumber =Integer.parseInt(JSON.parseObject(json).get("teacherNumber").toString());
        return scoreService.getTeacherByNum(teacherNumber);
    }

    @RequestMapping(path="/getCourseOne")
    public Course getCourseOne(@RequestBody String json){
        String courseName = JSON.parseObject(json).get("courseName").toString();
        String courseMajor = JSON.parseObject(json).get("courseMajor").toString();
        String courseGrade = JSON.parseObject(json).get("courseGrade").toString();
        return scoreService.getCourseOne(courseName,courseMajor,courseGrade);
    }

    @RequestMapping(path="/getClassResult")
    public ClassResult getClassResult(@RequestBody String json){
        String courseName = JSON.parseObject(json).get("courseName").toString();
        String className = JSON.parseObject(json).get("className").toString();
        return scoreService.getClassResult(courseName,className);
    }

    @RequestMapping(path="/ifHaveScoreResult")
    public List<Result> ifHaveScoreResult(@RequestBody String json){
        return scoreService.ifHaveScoreResult(json);
    }

    @RequestMapping(path="/updateScoreResult")
    public String updateScoreResult(@RequestBody String json){
        String result = JSON.parseObject(json).get("resultList").toString();
        List<Result> resultList = JSONArray.parseArray(result,Result.class);
        return scoreService.updateScoreResult(resultList);
    }

    //计算学生总成绩（通过过程成绩）
    @RequestMapping(path="/getProcessScore")
    public List<ProcessScore> getProcessScore(@RequestBody String json){
        return scoreService.getProcessScore(json);
    }

    @RequestMapping(path="/getProcessTextIf")
    public List<ProcessText> getProcessTextIf(@RequestBody String json){
        return scoreService.getProcessTextIf(json);
    }
}
