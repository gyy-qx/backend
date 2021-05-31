package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * email
 * @author
 */
@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class Email implements Serializable {
    private Integer num;

    private String courseName;

    private String courseMajor;

    private String courseGrade;

    private Integer courseTeacher;

    private String emailTitle;

    private String emailTeacher;

    private String emailContent;

    private String emailState;

    private String emailTime;

    private static final long serialVersionUID = 1L;
}
