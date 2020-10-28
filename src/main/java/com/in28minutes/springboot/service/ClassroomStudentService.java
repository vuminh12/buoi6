package com.in28minutes.springboot.service;

import com.in28minutes.springboot.model.ClassroomStudent;

import com.in28minutes.springboot.model.ClassroomStudentId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassroomStudentService {
    public ClassroomStudent saveAndFlush(ClassroomStudent classroomStudent);
    public List<ClassroomStudent> getAll();
    public List<ClassroomStudent> getAllStudentByIdClassroom(String id);
    public void deleteClassroomStudent(ClassroomStudentId classroomStudentId);
}
