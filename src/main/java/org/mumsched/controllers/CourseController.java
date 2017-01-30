package org.mumsched.controllers;

import java.util.List;

import org.mumsched.domain.Course;
import org.mumsched.service.CourseService;
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
@RequestMapping(value="/course")
public class CourseController {
	@Autowired
	CourseService courseservice;
	
	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String getForm(@ModelAttribute("newCourse") Course course,Model model){
		return "courseAddForm";
	}
	
	@RequestMapping(value={"/add"},method=RequestMethod.POST) 
	public String stsave(@ModelAttribute("newCourse") @Validated Course courseObj, BindingResult result,Model model){
		if(result.hasErrors()){
			return "courseAddForm";
		}else{
		courseservice.save(courseObj);
		return "redirect:/course/add";
		}
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String get(@PathVariable long id, Model model) {
		model.addAttribute("editCourse", courseservice.getCourseById(id));
		return "courseEditForm";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public String update(Course course, @PathVariable long id, @ModelAttribute("editCourse") @Validated Course editCourse, BindingResult result, Model model) {
		if(result.hasErrors()){
			return"courseEditForm";
		}else{
		course.setId(id);
		courseservice.save(editCourse);
		return "redirect:/course/add";
		}
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		courseservice.delete(id);
		return "redirect:/course/add";
	}
	
	@ModelAttribute("courselist")
	public List<Course> showList(){
		List<Course> courseList=courseservice.getAllCourse();
		return courseList;
	}

}
