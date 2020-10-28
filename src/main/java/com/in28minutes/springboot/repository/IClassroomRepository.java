package com.in28minutes.springboot.repository;

import com.in28minutes.springboot.model.Classroom;
import com.in28minutes.springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClassroomRepository extends JpaRepository<Classroom,String> {

}
