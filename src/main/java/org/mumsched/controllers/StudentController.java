package org.mumsched.controllers;

import java.util.List;

import org.mumsched.domain.Student;
import org.mumsched.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	@Autowired
	StudentService studentservice;
	
	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String getForm(@ModelAttribute("newStudent") Student student,Model model){
		return "studentAddForm";
	}
	
	@RequestMapping(value={"/add"},method=RequestMethod.POST) 
	public String stsave(@ModelAttribute("newStudent") @Validated Student studentObj, BindingResult result,Model model){
		if(result.hasErrors()){
			return "studentAddForm";
		}else{
		studentservice.save(studentObj);
		return "redirect:/student/add";
		}
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String get(@PathVariable long id, Model model) {
		model.addAttribute("editStudent", studentservice.getStudentById(id));
		return "studentEditForm";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public String update(Student student, @PathVariable long id, @ModelAttribute("editStudent") @Validated Student editStudent, BindingResult result, Model model) {
		if(result.hasErrors()){
			return"studentEditForm";
		}else{
		student.setStudentId(id);
		studentservice.save(editStudent);
		return "redirect:/student/add";
		}
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		studentservice.delete(id);
		return "redirect:/student/add";
	}
	
	@ModelAttribute("studentlist")
	public List<Student> showList(){
		List<Student> studentList=studentservice.getAllStudent();
		return studentList;
	}
}
