package com.ankitrj3.Myproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Myclass {
    
    @GetMapping("/ank")
    public String hello() {
        return "Hello World!";
    }
}