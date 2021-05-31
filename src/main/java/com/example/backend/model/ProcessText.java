package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * process_text
 * @author
 */
@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class ProcessText implements Serializable {
    private Integer number;

    private String courseName;

    private String courseMajor;

    private String courseGrade;

    private String processClassification;

    private Integer processNumber;

    private String processContent;

    private String ifCourseOne;

    private String ifCourseTwo;

    private String ifCourseThree;

    private String ifCourseFour;

    private String ifCourseFive;

    private static final long serialVersionUID = 1L;
}
