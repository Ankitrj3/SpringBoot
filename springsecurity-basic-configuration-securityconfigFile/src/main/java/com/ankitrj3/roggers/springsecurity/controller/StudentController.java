package com.ankitrj3.roggers.springsecurity.controller;

import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ankitrj3.roggers.springsecurity.entity.Student;

@RestController
public class StudentController {
    

    @GetMapping("/student")
    public List<Student> getStudent() {
        return getStudent();
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(CsrfToken token) {
        return token;
    }

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student) {
        return saveStudent(student);
    }
}
