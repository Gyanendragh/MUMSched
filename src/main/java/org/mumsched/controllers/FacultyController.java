package org.mumsched.controllers;

import java.util.List;

import org.mumsched.domain.Faculty;
import org.mumsched.service.FacultyService;
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
@RequestMapping(value="/faculty")
public class FacultyController {
	@Autowired
	FacultyService facultyservice;
	
	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String getForm(@ModelAttribute("newFaculty") Faculty faculty,Model model){
		return "facultyAddForm";
	}
	
	@RequestMapping(value={"/add"},method=RequestMethod.POST) 
	public String stsave(@ModelAttribute("newFaculty") @Validated Faculty facultyObj, BindingResult result,Model model){
		if(result.hasErrors()){
			return "facultyAddForm";
		}else{
		facultyservice.save(facultyObj);
		return "redirect:/faculty/add";
		}
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String get(@PathVariable long id, Model model) {
		model.addAttribute("editFaculty", facultyservice.getFacultyById(id));
		return "facultyEditForm";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public String update(Faculty faculty, @PathVariable long id, @ModelAttribute("editFaculty") @Validated Faculty editFaculty, BindingResult result, Model model) {
		if(result.hasErrors()){
			return"facultyEditForm";
		}else{
		faculty.setFacultyId(id);
		facultyservice.save(editFaculty);
		return "redirect:/faculty/add";
		}
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		facultyservice.delete(id);
		return "redirect:/faculty/add";
	}
	
	@ModelAttribute("facultylist")
	public List<Faculty> showList(){
		List<Faculty> facultyList=facultyservice.getAllFaculty();
		return facultyList;
	}

}
