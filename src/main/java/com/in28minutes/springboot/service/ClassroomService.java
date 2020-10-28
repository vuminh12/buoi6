package com.in28minutes.springboot.service;

import com.in28minutes.springboot.model.Classroom;

import com.in28minutes.springboot.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClassroomService {
    public List<Classroom> getAllClassroom();
}
