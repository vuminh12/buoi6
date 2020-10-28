package com.in28minutes.springboot.service;

import com.in28minutes.springboot.model.Classroom;
import com.in28minutes.springboot.repository.IClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    private IClassroomRepository iClassroomRepository;

    @Override
    public List<Classroom> getAllClassroom() {
        return iClassroomRepository.findAll();
    }


}
