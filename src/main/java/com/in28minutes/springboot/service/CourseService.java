package com.in28minutes.springboot.service;

import com.in28minutes.springboot.model.Course;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {
    Iterable<Course> getAll();
}
