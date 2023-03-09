package com.sanketscode.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanketscode.student.entity.Student;
import com.sanketscode.student.model.StudentDTO;
import com.sanketscode.student.service.StudentService;
import com.sanketscode.student.util.Converter;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private Converter converter;
	
	@PostMapping("/createStudent")
	public String createStudent(@RequestBody StudentDTO studentDTO)
	{
		final Student student= converter.convertToEntity(studentDTO);
	return studentService.createStudent(student);
	}
	@PutMapping("/updateStudent/{identity}")
	  public StudentDTO updateStudent(@PathVariable("identity") int id, @RequestBody StudentDTO studentDTO)
	  {
		  Student student1= converter.convertToEntity(studentDTO);
		  return studentService.updateStudent(id, student1);
	  }
	    
	    @GetMapping("/getStudent/{identity}")
	    public StudentDTO getStudent(@PathVariable("identity") int id)
	    {
	    	//Student student2=converter.convertToEntity(studentDTO);
	    return studentService.getStudent(id);
	    	
	    }
	    @GetMapping("/getAllStudents")
	    public List<StudentDTO> getAllStudents()
	    {
	    	return studentService.getAllStudents();
	    }
	    @DeleteMapping("/deleteStudentById/{id}")
	    public String deleteStudentById(@PathVariable("id") int id)
	    {
	    	return studentService.deleteStudentById(id);
	    	
	    }
	    @DeleteMapping("/deleteAllStudents")
	    public void deleteAllStudents()
	    {
	    	studentService.deleteAllStudents();
	    	
	    }

}
