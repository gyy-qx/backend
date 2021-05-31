package com.example.backend.studentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class StudentDto1 {
    private Integer studentSno;

    private String studentName;
    private String studentClass;
}
