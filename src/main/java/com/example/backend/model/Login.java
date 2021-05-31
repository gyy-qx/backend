package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * login
 * @author
 */
@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class Login implements Serializable {
    private Integer user;

    public String password;

    public String id;

    public String pathImg;

    private static final long serialVersionUID = 1L;
}
