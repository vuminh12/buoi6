package com.in28minutes.springboot.service;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private ICourseRepository iCourseRepository;
    
    @Override
    public Iterable<Course> getAll() {
        return iCourseRepository.findAll();
    }
}
