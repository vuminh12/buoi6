package com.in28minutes.springboot.service;

import com.in28minutes.springboot.model.ClassroomStudent;
import com.in28minutes.springboot.model.ClassroomStudentId;
import com.in28minutes.springboot.repository.IClassroomStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomStudentServiceImpl implements ClassroomStudentService{
   @Autowired
   private IClassroomStudentRepository iClassroomStudentRepository;

    @Override
    public ClassroomStudent saveAndFlush(ClassroomStudent classroomStudent) {
        return iClassroomStudentRepository.saveAndFlush(classroomStudent);
    }

    @Override
    public List<ClassroomStudent> getAll() {
        return iClassroomStudentRepository.findAll();
    }

    @Override
    public List<ClassroomStudent> getAllStudentByIdClassroom(String id) {
        return iClassroomStudentRepository.getAllStudentByIdClassroom(id);
    }

    @Override
    public void deleteClassroomStudent(ClassroomStudentId classroomStudentId) {
        iClassroomStudentRepository.deleteById(classroomStudentId);
    }
}
