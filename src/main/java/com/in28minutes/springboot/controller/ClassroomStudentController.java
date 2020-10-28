package com.in28minutes.springboot.controller;

import com.in28minutes.springboot.model.Classroom;
import com.in28minutes.springboot.model.ClassroomStudent;
import com.in28minutes.springboot.model.ClassroomStudentId;

import com.in28minutes.springboot.model.Student;
import com.in28minutes.springboot.service.ClassroomStudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/", produces = "application/json")
public class ClassroomStudentController {
    @Autowired
    private ClassroomStudentService classroomStudentService;
    private RestTemplate rest = new RestTemplate();

    // tao 1 doi tuong lop hoc
    @PostMapping(value = "create_classroomStudent",consumes = "application/json")
    // viet ham lay ve 1 CourseStudentId gom: course_id va student_id
    public ClassroomStudent saveAndFlushClassroomStudent(@RequestBody ClassroomStudentId classroomStudentIdGet){
        // kiem tra xem post da co course_id va student_id ?
        System.out.println(classroomStudentIdGet);

        // create doi tuong courseStudent va add id cua courseStudent
        ClassroomStudent classroomStudent = new ClassroomStudent();
        ClassroomStudentId classroomStudentIdPost = new ClassroomStudentId();
        classroomStudentIdPost.setClassroomId(classroomStudentIdGet.getClassroomId());
        classroomStudentIdPost.setStudentId(classroomStudentIdGet.getStudentId());
        classroomStudent.setId(classroomStudentIdPost);

        // add student, course vao courseStudent
        Classroom classroom = new Classroom(classroomStudentIdGet.getClassroomId());
        Student student = new Student(classroomStudentIdGet.getStudentId());
        classroomStudent.setClassroom(classroom);
        classroomStudent.setStudent(student);
        classroomStudent.setDate(LocalDate.now());
        // kiem tra man hinh consle da tao doi tuong courseStudent ?
        System.out.println(classroomStudent);

        // luu doi tuong courStudent vao database
        return classroomStudentService.saveAndFlush(classroomStudent);
    }
    // lay tat ca doi tuong courStudent
    @GetMapping(value = "getAll_classroomStudents")
    public List<ClassroomStudent> getAll(){
        return classroomStudentService.getAll();
    }

    // tim danh sach sinh vien theo id lop hoc
    @GetMapping(value = "findStudent_classroomStudents/{id}")
    public List<ClassroomStudent> getAllStudentByIdClassroom(@PathVariable("id") String id){
        List<ClassroomStudent> classroomStudents = classroomStudentService.getAllStudentByIdClassroom(id);
        return classroomStudentService.getAllStudentByIdClassroom(id);
    }

    // xoa 1 classroomStudent bang id hoc sinh va id lop hoc
    @GetMapping(value = "deleteStudent_classroomStudents/{classroom_id}/{student_id}")
    public void deleteClassStudent(@PathVariable(value = "classroom_id") String classroom_id,@PathVariable(value = "student_id") String student_id) {
        ClassroomStudentId classroomStudentId = new ClassroomStudentId(student_id,classroom_id);
        classroomStudentService.deleteClassroomStudent(classroomStudentId);
    }
}
