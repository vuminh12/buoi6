package com.in28minutes.springboot.controller;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/", consumes = "application/json")
public class CourseController {
    @Autowired
    private CourseService courseService;

    // lay tat ca danh sach khoa hoc ra
    @GetMapping("getAll_Course")
    public Iterable<Course> getAllCourse(){
        return courseService.getAll();
    }
}
