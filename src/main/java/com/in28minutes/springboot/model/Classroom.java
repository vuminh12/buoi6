package com.in28minutes.springboot.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Classroom {
	@Id
	@Column(name = "classroom_id",length = 10)
	private String classroomId;

	@Column(name = "classroom_name",nullable = false)
	private String name;

	@Column(name = "classroom_description",nullable = false)
	private String description;

	// 1- n voi classStudent
	@OneToMany(mappedBy = "classroom",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ClassroomStudent> classStudents = new ArrayList<>();

	// them khoa ngoai course_id
	@Column(name = "course_id",nullable = false)
	private String courseId;

	// tao n -1 voi lop khoa hoc bang khoa ngoai: course_id
	@ManyToOne
	@MapsId("courseId")
	@JoinColumn(name = "course_id")
	private Course course;

	// Needed by Caused by: com.fasterxml.jackson.databind.JsonMappingException:
	// Can not construct instance of com.in28minutes.springboot.model.Course:
	// no suitable constructor found, can not deserialize from Object value
	// (missing default constructor or creator, or perhaps need to add/enable
	// type information?)


	public Classroom() {
	}

	public Classroom(String classroomId, String name, String description, List<ClassroomStudent> classStudents) {
		this.classroomId = classroomId;
		this.name = name;
		this.description = description;
		this.classStudents = classStudents;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public Course getCourse() {
		return course;
	}


	public Classroom(String classroomId) {
		this.classroomId = classroomId;
	}

	public String getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(String classroomId) {
		this.classroomId = classroomId;
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

	public List<ClassroomStudent> getClassStudents() {
		return classStudents;
	}

	public void setClassStudents(List<ClassroomStudent> classStudents) {
		this.classStudents = classStudents;
	}

		@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Classroom)) return false;
		Classroom classroom = (Classroom) o;
		return getClassroomId().equals(classroom.getClassroomId()) &&
				getName().equals(classroom.getName()) &&
				getDescription().equals(classroom.getDescription()) &&
				classStudents.equals(classroom.classStudents);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getClassroomId(), getName(), getDescription(), classStudents);
	}

	@Override
	public String toString() {
		return "Classroom{" +
				"classroomId='" + classroomId + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", classStudents=" + classStudents +
				'}';
	}



}