package org.mumsched.controllers;

import java.util.List;

import javax.validation.Valid;

import org.mumsched.domain.Faculty;
import org.mumsched.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String stsave(@ModelAttribute("newFaculty") @Valid Faculty facultyObj, BindingResult result,Model model){
		if(result.hasErrors()){
			return "facultyAddForm";
		}else{
			if (this.facultyservice.findByFacultyIdNumber(facultyObj.getFacultyIdNumber()) != null) {
				result.rejectValue("facultyIdNumber", "error.faculty", "The faculty IdNumber should be unique.");
				return "facultyAddForm";
			}
		facultyservice.save(facultyObj);
		return "redirect:/faculty/add";
		}
	}
	
	@RequestMapping(value="/edit/{facultyId}", method=RequestMethod.GET)
	public String get(@PathVariable long facultyId, Model model) {
		model.addAttribute("editFaculty", facultyservice.getFacultyById(facultyId));
		return "facultyEditForm";
	}
	
	@RequestMapping(value="/edit/{facultyId}", method=RequestMethod.POST)
	public String update(Faculty faculty, @PathVariable long facultyId, @ModelAttribute("editFaculty") @Valid Faculty editFaculty, BindingResult result, Model model) {
		if(result.hasErrors()){
			return"facultyEditForm";
		}else{
		faculty.setFacultyId(facultyId);
		facultyservice.save(editFaculty);
		return "redirect:/faculty/add";
		}
	}
	
	@RequestMapping(value="/delete/{facultyId}", method=RequestMethod.GET)
	public String delete(@PathVariable("facultyId") Long facultyId) {
		facultyservice.delete(facultyId);
		return "redirect:/faculty/add";
	}
	
	@ModelAttribute("facultylist")
	public List<Faculty> showList(){
		List<Faculty> facultyList=facultyservice.getAllFaculty();
		return facultyList;
	}

}
