package com.sanketscode.student.service;

import java.util.List;

import com.sanketscode.student.entity.Student;
import com.sanketscode.student.model.StudentDTO;

public interface StudentService {

	String createStudent(Student student);
	StudentDTO updateStudent(int id, Student student);
	   StudentDTO getStudent(int id);
	   List<StudentDTO> getAllStudents();
	   String deleteStudentById(int id);
	    void deleteAllStudents();
	   
}
