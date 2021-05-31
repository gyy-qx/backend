package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * process_score
 * @author
 */
@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class ProcessScore implements Serializable {
    private Integer number;

    private Integer studentSno;

    private String studentName;

    private String courseName;

    private String studentMajor;

    private String studentGrade;

    private String studentClass;

    private String processClassification;

    private String processNumber;

    private Double processScore;

    private static final long serialVersionUID = 1L;
}
