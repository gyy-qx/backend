package com.example.backend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class Hello {

    @ResponseBody
    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String hello() {
        log.info("调用了/hello");
        return "hello";
    }
}
