package com.example.backend.courseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class CourseClass {
    private String courseName;

    private String courseGrade;

    private String courseMajor;

    private String courseCover;
}
