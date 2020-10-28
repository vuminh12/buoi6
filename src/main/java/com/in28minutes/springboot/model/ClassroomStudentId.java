package com.in28minutes.springboot.model;


import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClassroomStudentId implements Serializable{
    private String studentId;
    private String classroomId;

    public ClassroomStudentId(String studentId, String classroomId) {
        this.studentId = studentId;
        this.classroomId = classroomId;
    }

    public ClassroomStudentId() {

    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(String classroomId) {
        this.classroomId = classroomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassroomStudentId)) return false;
        ClassroomStudentId that = (ClassroomStudentId) o;
        return getStudentId().equals(that.getStudentId()) &&
                getClassroomId().equals(that.getClassroomId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getClassroomId());
    }

    @Override
    public String toString() {
        return "ClassroomStudentId{" +
                "studentId='" + studentId + '\'' +
                ", classId='" + classroomId + '\'' +
                '}';
    }
}
