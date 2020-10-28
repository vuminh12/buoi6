package com.in28minutes.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Course {
    @Id
    @Column(name = "course_id")
    private String courseId;

    @Column(name = "course_name", nullable = false)
    private String name;

    @Column(name = "course_description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Classroom> classrooms = new ArrayList<>();

    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public Course() {
    }

    public Course(String courseId, String name, String description) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;

    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String id) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
