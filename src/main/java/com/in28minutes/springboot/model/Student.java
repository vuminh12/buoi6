package com.in28minutes.springboot.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Student {
	@Id
	@Column(name ="student_id",length = 10)
	private String studentId;

	@Column(name = "student_name", nullable = false)
	private String name;

	@Column(name = "student_description", nullable = false)
	private String description;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ClassroomStudent> classroomStudents = new ArrayList<>();

	public Student() {}

	public Student(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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

	public List<ClassroomStudent> getClassroomStudents() {
		return classroomStudents;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Student)) return false;
		Student student = (Student) o;
		return getStudentId().equals(student.getStudentId()) &&
				getName().equals(student.getName()) &&
				getDescription().equals(student.getDescription()) &&
				getClassroomStudents().equals(student.getClassroomStudents());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getStudentId(), getName(), getDescription(), getClassroomStudents());
	}

	@Override
	public String toString() {
		return "Student{" +
				"studentId='" + studentId + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", classroomStudents=" + classroomStudents +
				'}';
	}
}