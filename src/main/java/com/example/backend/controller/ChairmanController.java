package com.example.backend.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.backend.model.Course;
import com.example.backend.model.Student;
import com.example.backend.model.Teacher;
import com.example.backend.service.ChairmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChairmanController {
    @Autowired
    ChairmanService chairmanService;

//    教师管理
    @RequestMapping(path ="/getResearch")
    public String selectResearch(@RequestBody String json){
        Integer teacherNumber = Integer.parseInt(JSON.parseObject(json).get("teacherNumber").toString());
        String ResearchName = chairmanService.selectByNumber(teacherNumber);
        return ResearchName;
    }

    @RequestMapping(path="/getAllTeacher")
    public List<Teacher> selectAllTeacher(@RequestBody String json){
        System.out.println(json);
        Integer teacherNumber = Integer.parseInt(JSON.parseObject(json).get("teacherNumber").toString());
        System.out.println(chairmanService.selectAllTeacher(teacherNumber).toString());
        return chairmanService.selectAllTeacher(teacherNumber);
    }

    @RequestMapping(path="/deleteTeacher")
    public String deleteTeacher(@RequestBody String json){
        Integer teacherNumber = Integer.parseInt(JSON.parseObject(json).get("teacherNumber").toString());
        return chairmanService.deleteTeacher(teacherNumber);
    }

    @RequestMapping(path = "/updateTeacher")
    public String updateTeacher(@RequestBody Teacher teacher) {
        return chairmanService.updateTeacher(teacher);
    }


//    课程管理
@RequestMapping(path="/selectCourseByMajor")
public List<Course> selectCourseByMajor(@RequestBody String json){
    String researchName = JSON.parseObject(json).get("researchName").toString();
    return chairmanService.selectCourseByMajor(researchName);
}

    @RequestMapping(path="/getAllCourse")
    public List<Course> getAllCourse(@RequestBody String json){
        String courseGrade = JSON.parseObject(json).get("courseGrade").toString();
        String researchName = JSON.parseObject(json).get("researchName").toString();
        return chairmanService.getAllCourse(researchName,courseGrade);
    }

    @RequestMapping(path="/deleteCourse")
    public String deleteCourse(@RequestBody String json){
        String courseName = JSON.parseObject(json).get("courseName").toString();
        String courseMajor = JSON.parseObject(json).get("courseMajor").toString();
        String courseGrade = JSON.parseObject(json).get("courseGrade").toString();
        return chairmanService.deleteCourse(courseName,courseMajor,courseGrade);
    }

    @RequestMapping(path="/updateCourse")
    public String updateCourse(@RequestBody Course course){
        System.out.println(course);
        return chairmanService.updateCourse(course);
    }

    @RequestMapping(path = "/getWholeTeacher")
    public List<String> selectTeacherName(){
        return chairmanService.selectTeacherName();
    }

    @RequestMapping(path="/insertCourse")
    public String insertCourse(@RequestBody String json){
        String researchName = JSON.parseObject(json).get("researchName").toString();
        String courseTeacher = JSON.parseObject(json).get("courseTeacher").toString();
        String courseName= JSON.parseObject(json).get("courseName").toString();
        String courseGrade =JSON.parseObject(json).get("courseGrade").toString();
        String courseCover =JSON.parseObject(json).get("courseCover").toString();
        return chairmanService.insertCourse(researchName,courseTeacher,courseName,courseGrade,courseCover);
    }
    @RequestMapping(path="/getTeacherName")
    public String getTeacherName(@RequestBody String json){
        return chairmanService.getTeacherName(json);
    }
    @RequestMapping(path="/getTeacherNum")
    public Integer getTeacherNumber(@RequestBody String json){
        System.out.println(chairmanService.getTeacherNumber(json));
        return chairmanService.getTeacherNumber(json);
    }

    @RequestMapping(path="/searchTeacherOne")
    public Teacher searchTeacherOne(@RequestBody String json){
        String teacherName = JSON.parseObject(json).get("teacherName").toString();
        return chairmanService.searchTeacherOne(teacherName);
    }

//  学生管理
    @RequestMapping(path = "/insertStudent")
    public String insertStudent(@RequestBody Student student){
        return chairmanService.insertStudent(student);
    }

    @RequestMapping(path="/getGrade")
    public List<String> getGrade(){
        System.out.println(chairmanService.getGrade());
        return chairmanService.getGrade();
    }

    @RequestMapping(path="/getStudentClass")
    public List<String> selectStudentClass(@RequestBody String json){
        String researchName = JSON.parseObject(json).get("researchName").toString();
        String studentGrade = JSON.parseObject(json).get("studentGrade").toString();
        return chairmanService.selectStudentClass(researchName,studentGrade);
    }

    @RequestMapping(path="/getStudentClassALL")
    public List<String> selectStudentClassALL(@RequestBody String json){
        String researchName = JSON.parseObject(json).get("researchName").toString();
        return chairmanService.selectStudentClassALL(researchName);
    }

    @RequestMapping(path = "/getMajor")
    public String getMajor(@RequestBody String json){
        String researchName = JSON.parseObject(json).get("researchName").toString();
        return chairmanService.getMajor(researchName);
    }

    @RequestMapping(path="/insertStudentByClass")
    public String insertStudentByClass(@RequestBody String json){
        String student = JSON.parseObject(json).get("studentList").toString();
        List<Student> studentList = JSONArray.parseArray(student,Student.class);
        return chairmanService.insertStudentByClass(studentList);
    }

    @RequestMapping(path="/getStudentByClass")
    public List<Student> getStudentByClass(@RequestBody String json){
        String studentClass=JSON.parseObject(json).get("studentClass").toString();
        System.out.println(chairmanService.getStudentByClass(studentClass));
        return chairmanService.getStudentByClass(studentClass);
    }

    @RequestMapping(path="/updateStudent")
    public String updateStudent(@RequestBody Student student){
        return chairmanService.updateStudent(student);
    }

    @RequestMapping(path = "/deleteStudent")
    public  String deleteStudent(@RequestBody String json){
        Integer studentSno = Integer.parseInt(JSON.parseObject(json).get("studentSno").toString());
        return chairmanService.deleteStudent(studentSno);
    }
}
