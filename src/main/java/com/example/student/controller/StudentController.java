package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/students/new")
	public String showStudentForm(Model model) {
		model.addAttribute("student",  new Student());
		return "student_form";
	}
	
	@PostMapping("/students/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentRepository.save(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		List<Student> students=studentRepository.findAll();
		model.addAttribute("students", students);
		return "student_list";
	}
}
