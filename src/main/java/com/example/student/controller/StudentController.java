package com.example.student.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.student.model.Student;
import com.example.student.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService; 
	
	@GetMapping("/students/new")
	public String showStudentForm(Model model) {
		model.addAttribute("student",  new Student());
		return "student_form";
	}
	
	@PostMapping("/students/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		List<Student> students=studentService.getAllStudents();
		model.addAttribute("students", students);
		return "student_list";
	}
	@GetMapping("/students/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
	    Student student = studentService.getStudentById(id);
	    model.addAttribute("student", student);
	    return "student_form";  
	}

	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
	    studentService.deleteStudentById(id);
	    return "redirect:/students";
	}

}
