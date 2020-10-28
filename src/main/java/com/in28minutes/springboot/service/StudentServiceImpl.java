package com.in28minutes.springboot.service;

import com.in28minutes.springboot.model.Student;
import com.in28minutes.springboot.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private IStudentRepository iStudentRepository;

    // get all Student
    @Override
    public List<Student> getAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public Optional<Student> findId(String id) {
        return iStudentRepository.findById(id);
    }


}
