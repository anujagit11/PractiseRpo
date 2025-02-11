package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
 @GetMapping("/all")
    public String one()
    {
        System.out.println("in one");
        return "hello";
    }

}
