package com.in28minutes.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class ClassroomStudent {
    @EmbeddedId
    private ClassroomStudentId id;

    // tao n -1 voi bang hoc sinh bang khoa ngoai student_id
    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    //tao khoa ngoai voi bang lop hoc bang khoa ngoai classroom_id
   @ManyToOne
    @MapsId("classroomId")
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

   //them cot date, khi tao moi 1 doi tuong se tu dong cap nhat ngay tao
   @Column(name = "date_of_create")
   private LocalDate date;

    public ClassroomStudent(Classroom classroom,Student student,LocalDate date){
        this.classroom = classroom;
        this.student = student;
        this.id = new ClassroomStudentId(classroom.getClassroomId(),student.getStudentId());
        this.date = date;
    }

    public ClassroomStudent() {
    }

    public ClassroomStudentId getId() {
        return id;
    }

    public void setId(ClassroomStudentId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date.now();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassroomStudent that = (ClassroomStudent) o;
        return id.equals(that.id) &&
                student.equals(that.student) &&
                classroom.equals(that.classroom) &&
                date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, classroom, date);
    }

}
