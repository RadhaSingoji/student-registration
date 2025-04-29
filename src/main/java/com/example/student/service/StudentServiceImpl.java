package com.example.student.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;

@Service
public class StudentServiceImpl  implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
		
	}

	@Override
	public List<Student> getAllStudents() {
        return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);

	}

	@Override
	public void deleteStudentById(Long id) {
	    studentRepository.deleteById(id);
		
	}

}
