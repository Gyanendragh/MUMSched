package org.mumsched.controllers;

import java.util.List;

import javax.validation.Valid;

import org.mumsched.domain.Course;
import org.mumsched.service.FacultyService;
import org.mumsched.serviceimpl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/course")
public class CourseController {
	@Autowired
	FacultyService facultyservice;

	CourseServiceImpl courseservice;

	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String getForm(@ModelAttribute("newCourse") Course course,Model model){
		model.addAttribute("courseLists", courseservice.getAllCourse());
		return "courseAddForm";
	}

	@RequestMapping(value={"/add"},method=RequestMethod.POST) 
	public String stsave(@ModelAttribute("newCourse") @Valid Course courseObj, BindingResult result,Model model){
		if(result.hasErrors()){
			return "courseAddForm";
		}else{
			if (this.courseservice.findByCourseName(courseObj.getCourseName()) != null) {
				result.rejectValue("courseName", "error.course", "The course name should be unique.");
				return "courseAddForm";
			}
			else if (this.courseservice.findByCourseNumber(courseObj.getCourseNumber()) != null) {
				result.rejectValue("courseNumber", "error.course", "The course number should be unique.");
				return "courseAddForm";
			}
			courseservice.save(courseObj);
			return "redirect:/course/add";
		}
	}

	@RequestMapping(value="/edit/{courseId}", method=RequestMethod.GET)
	public String get(@PathVariable long courseId, Model model) {
		model.addAttribute("editCourse", courseservice.getCourseBycourseId(courseId));
		return "courseEditForm";
	}

	@RequestMapping(value="/edit/{courseId}", method=RequestMethod.POST)
	public String update(Course course, @PathVariable long courseId, @ModelAttribute("editCourse") @Valid Course editCourse, BindingResult result, Model model) {
		if(result.hasErrors()){
			return"courseEditForm";
		}else{
			course.getCourseId();
			courseservice.save(editCourse);
			return "redirect:/course/add";
		}
	}

	@RequestMapping(value="/delete/{courseId}", method=RequestMethod.GET)
	public String delete(@PathVariable("courseId") Long courseId) {
		courseservice.delete(courseId);
		return "redirect:/course/add";
	}

	@ModelAttribute("courselist")
	public List<Course> showList(){
		List<Course> courseList=courseservice.getAllCourse();
		return courseList;
	}

}
