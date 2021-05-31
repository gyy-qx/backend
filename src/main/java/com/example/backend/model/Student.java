package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * student
 * @author
 */
@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class Student implements Serializable {
    private Integer studentSno;

    private String studentName;

    private String studentMajor;

    private String studentGrade;

    private String studentClass;

    private String studentSex;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date studentData;

    private static final long serialVersionUID = 1L;
}
