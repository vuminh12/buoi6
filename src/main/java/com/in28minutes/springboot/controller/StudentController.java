package com.in28minutes.springboot.controller;

import java.util.List;
import java.util.Optional;

import com.in28minutes.springboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.in28minutes.springboot.service.StudentService;

@RestController
@RequestMapping(path = "/" , produces = "application/json")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // lay tat ca sinh vien ra
    @GetMapping("students")
    public Iterable<Student> getAllStudent(){
        return studentService.getAll();
    }

    // tim kiem sinh vien theo id
    @GetMapping("students/{student_id}")
    public Optional<Student>  findById(@PathVariable("student_id")String student_id) {
        return studentService.findId(student_id);
    }
}
