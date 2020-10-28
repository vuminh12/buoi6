package com.in28minutes.springboot.repository;

import com.in28minutes.springboot.model.ClassroomStudent;
import com.in28minutes.springboot.model.ClassroomStudentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClassroomStudentRepository extends JpaRepository<ClassroomStudent, ClassroomStudentId> {
    @Query(value = "select * from classroom_student   where classroom_id = ?1",nativeQuery = true)
    public List<ClassroomStudent> getAllStudentByIdClassroom(String id);
}
