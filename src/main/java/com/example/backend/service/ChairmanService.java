package com.example.backend.service;

import com.alibaba.fastjson.JSON;
import com.example.backend.mapper.*;
import com.example.backend.model.Course;
import com.example.backend.model.Student;
import com.example.backend.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChairmanService {
    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    LoginDao loginDao;
    @Autowired
    CourseDao courseDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    TargetTextDao targetTextDao;
    @Autowired
    TargetDao targetDao;
    @Autowired
    ProcessTextDao processTextDao;
    @Autowired
    ProcessScoreDao processScoreDao;
    @Autowired
    EmailDao emailDao;
    @Autowired
    ResultDao resultDao;
    @Autowired
    ClassResultDao classResultDao;

    public String selectByNumber(Integer researChairman){
        return departmentDao.selectByNumber(researChairman);
    }

    public List<Teacher> selectAllTeacher(Integer teacherNumber){
        String teacherResearch=departmentDao.selectByNumber(teacherNumber);
        System.out.println(teacherDao.selectAllTeacher(teacherResearch));
        return teacherDao.selectAllTeacher(teacherResearch);
    }

    public String deleteTeacher(Integer teacherNumber){
        Integer teacherResult = teacherDao.deleteByPrimaryKey(teacherNumber);
        Integer loginResult = loginDao.deleteByPrimaryKey(teacherNumber);
        if(teacherResult>0&&loginResult>0){
            return "删除成功";
        }
        else {
            return "删除失败";
        }
    }

    public String updateTeacher(Teacher teacher){
        Integer result = teacherDao.updateByPrimaryKey(teacher);
        if(result>0){
            return "更新成功";
        }
        else {
            return "更新失败";
        }
    }

    public List<Course> selectCourseByMajor(String researchName){
        String major = departmentDao.getMajor(researchName);
        return courseDao.selectCourse(major);
    }

    public List<Course> getAllCourse(String researchName,String courseGrade){
        String major = departmentDao.getMajor(researchName);
        return courseDao.selectByGrade(major,courseGrade);
    }

    public String deleteCourse(String courseName,String courseMajor,String courseGrade){
        Integer courseSelectResult = (courseDao.selectByKey(courseName,courseMajor,courseGrade)).size();
        Integer targetSelectResult = (targetDao.selectKey(courseName,courseMajor,courseGrade)).size();
        Integer textSelectResult = (targetTextDao.selectByPrimaryKey(courseName,courseMajor,courseGrade)).size();
        Integer courseResult = courseDao.deleteByPrimaryKey(courseName,courseMajor,courseGrade);
        Integer targetResult = targetDao.deleteCourse(courseName,courseMajor,courseGrade);
        Integer textResult = targetTextDao.deleteCourse(courseName,courseMajor,courseGrade);
        if(courseSelectResult>0&&targetSelectResult>0&&textSelectResult>0){
            if (courseResult>0&&targetResult>0&&textResult>0)
            return "删除成功";
            else return "删除失败";
        }
        else if(courseSelectResult>0&&targetSelectResult==0&&textSelectResult==0){
            if(courseResult>0)
                return "删除成功";
            else return "删除失败";
        }
        else{
            return "删除失败";
        }
    }

    public String updateCourse(Course course){
        Integer result = courseDao.updateByPrimaryKeySelective(course);
        if(result>0){
            return "更新成功";
        }
        else{
            return "更新失败";
        }
    }

    public List<String> selectTeacherName(){
        return teacherDao.selectTeacherName();
    }

    public String insertCourse(String researchName,String courseTeacher,String courseName,String courseGrade,String courseCover){
        Course course = new Course();
        String courseMajor = departmentDao.getMajor(researchName);
        Integer teacherNumber = teacherDao.getTeacherNumber(courseTeacher);
        course.setCourseMajor(courseMajor);
        course.setCourseName(courseName);
        course.setCourseGrade(courseGrade);
        course.setCourseTeacher(teacherNumber);
        course.setCourseCover(courseCover);
        Integer resultSelect = (courseDao.selectByKey(courseName,courseMajor,courseGrade)).size();
        if(resultSelect==0) {
            Integer result = courseDao.insertSelective(course);
            if(result>0){
                return "添加成功";
            }
            else{
                return "添加失败";
            }
        }
       else  return "已经存在该科目";
    }

    public String getTeacherName(String json){
        Integer teacherNumber = Integer.parseInt(JSON.parseObject(json).get("teacherNumber").toString());
        return teacherDao.getTeacherName(teacherNumber);
    }
    public Integer getTeacherNumber(String json){
        String teacherName = JSON.parseObject(json).get("teacherName").toString();
        return teacherDao.getTeacherNumber(teacherName);
    }
    public Teacher searchTeacherOne(String teacherName){
        Integer teacherNumber = teacherDao.getTeacherNumber(teacherName);
        return teacherDao.selectByPrimaryKey(teacherNumber);
    }

    public String insertStudent(Student student){
        Integer result = studentDao.insert(student);
        if(result> 0){
            return "录入成功";
        }
        else {
            return "录入失败";
        }
    }

    public List<String> getGrade(){
        return studentDao.getGrade();
    }

    public List<String> selectStudentClass(String researchName,String studentGrade){
        String studentMajor = departmentDao.getMajor(researchName);
        return studentDao.selectMajor(studentMajor,studentGrade);
    }

    public List<String> selectStudentClassALL(String researchName){
        String studentMajor = departmentDao.getMajor(researchName);
        return studentDao.getClassByMajor(studentMajor);
    }

    public String getMajor(String researchName){
        return departmentDao.getMajor(researchName);
    }

    public String insertStudentByClass(List<Student> studentList){
        Integer result = 0;
        for(int i= 0; i<studentList.size() ;i++){
            System.out.println(studentList.get(i));
            result= result+ studentDao.insert(studentList.get(i));
        }
        if(result == studentList.size()){
            return "录入成功";
        }
        else {
            return "录入失败";
        }
    }

    public List<Student> getStudentByClass(String studentClass){
        System.out.println(studentDao.selectByClass(studentClass));
        return studentDao.selectByClass(studentClass);
    }

    public String updateStudent(Student student){
        Integer result = studentDao.updateByPrimaryKey(student);
        if(result> 0){
            return "修改成功";
        }
        else {
            return "修改失败";
        }
    }

    public String deleteStudent(Integer studentSno){
        Integer result = studentDao.deleteByPrimaryKey(studentSno);
        if(result> 0){
            return "删除成功";
        }
        else {
            return "删除失败";
        }
    }
}
