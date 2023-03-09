package com.sanketscode.student.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanketscode.student.entity.Student;
import com.sanketscode.student.model.StudentDTO;
import com.sanketscode.student.repository.StudentRepository;
import com.sanketscode.student.service.StudentService;
import com.sanketscode.student.util.Converter;

@Service
public class StudentServiceImpl  implements StudentService{
	
	@Autowired
	private StudentRepository  studentRepository;
	
	@Autowired
	private Converter converter;

	@Override
	public String createStudent(Student student) {
		String message = null;
		studentRepository.save(student);
		if(student!=null)
		{
			message= "Student details saved successfully";
		}
		return message;
	}
	@Override
	public StudentDTO updateStudent(int id, Student student) {
		Student existingStudent= studentRepository.findById(id).get();
		existingStudent.setStu_name(student.getStu_name());
		existingStudent.setStu_phone(student.getStu_phone());
		existingStudent.setStu_email(student.getStu_email());
		
		studentRepository.save(existingStudent);
		return converter.convertToStudentDTO(existingStudent);
	}
@Override
  public StudentDTO getStudent(int id)
  {
	  Student getStudent= studentRepository.findById(id).get();
	  
	  //studentRepository.save(getStudent);
	  return converter.convertToStudentDTO(getStudent);
  }
@Override
 public List<StudentDTO> getAllStudents()
 {
	 List<Student> students=studentRepository.findAll();
	 List<StudentDTO> sDTO = new ArrayList<>();
	 for(Student s:students)
	 {
		 sDTO.add(converter.convertToStudentDTO(s));
	 }
	 return sDTO;
 }
  @Override
     public  String deleteStudentById(int id)
     {
    	 String message= null;
    	 Optional<Student> student=studentRepository.findById(id);
    	 if(student.isPresent())
    	 {
    		 studentRepository.deleteById(id);
    		 message="student details delete successfully";
    	 }
    	 else
    	 {
    		 message="Student details not found";
    	 }
    	 return message;
     }
  
      @Override
     public void deleteAllStudents()
     {
    	 studentRepository.deleteAll();
     }
}

	
	

