package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2019/9/3
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test")
    public String getString() {
        return "hello wolrd";
    }
}
