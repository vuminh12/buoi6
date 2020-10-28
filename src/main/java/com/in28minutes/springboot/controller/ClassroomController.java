package com.in28minutes.springboot.controller;

import com.in28minutes.springboot.model.Classroom;
import com.in28minutes.springboot.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/", produces = "application/json")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    // lay tat ca danh sach lop hoc ra
    @GetMapping("/classrooms")
    public Iterable<Classroom> getAll(){
        return classroomService.getAllClassroom();
    }

}
