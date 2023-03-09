package com.sanketscode.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanketscode.student.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {

}
