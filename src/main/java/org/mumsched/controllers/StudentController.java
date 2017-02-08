package org.mumsched.controllers;

import java.util.List;

import javax.validation.Valid;

import org.mumsched.domain.Student;
import org.mumsched.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	StudentService studentservice;

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String getForm(@ModelAttribute("newStudent") Student student, Model model) {
		return "studentAddForm";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String stsave(@ModelAttribute("newStudent") @Valid Student studentObj, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "studentAddForm";
		} else {
			if (this.studentservice.findByStudentIdNumber(studentObj.getStudentIdNumber()) != null) {
				result.rejectValue("studentIdNumber", "error.student", "The Student IdNumber should be unique.");
				return "studentAddForm";
			}

			studentservice.save(studentObj);
			return "redirect:/student/add";
		}
	}

	@RequestMapping(value = "/edit/{studentId}", method = RequestMethod.GET)
	public String get(@PathVariable long studentId, Model model) {
		model.addAttribute("editStudent", studentservice.getStudentById(studentId));
		return "studentEditForm";
	}

	@RequestMapping(value = "/edit/{studentId}", method = RequestMethod.POST)
	public String update(Student student, @PathVariable long studentId,
			@ModelAttribute("editStudent") @Valid Student editStudent, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "studentEditForm";
		} else {
			student.setStudentId(studentId);
			studentservice.save(editStudent);
			return "redirect:/student/add";
		}
	}

	@RequestMapping(value = "/delete/{studentId}", method = RequestMethod.GET)
	public String delete(@PathVariable("studentId") Long studentId) {
		studentservice.delete(studentId);
		return "redirect:/student/add";
	}

	@ModelAttribute("studentlist")
	public List<Student> showList() {
		List<Student> studentList = studentservice.getAllStudent();
		return studentList;
	}
}
