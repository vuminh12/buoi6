package com.in28minutes.springboot.service;

import java.util.List;
import java.util.Optional;

import com.in28minutes.springboot.model.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
  public  List<Student> getAll();
   public Optional<Student> findId(String id);
}