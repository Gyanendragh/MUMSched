package org.mumsched.controllers;

import java.util.ArrayList;
import java.util.List;

import org.mumsched.domain.Schedule;
import org.mumsched.serviceimpl.ScheduleServiceImpl;
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
@RequestMapping(value="/schedule")
public class ScheduleController {
	@Autowired
	ScheduleServiceImpl scheduleService;

	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String getForm(@ModelAttribute("newSchedule")Schedule schedule, Model model) {
		ArrayList<String> entryList = new ArrayList<>();
		entryList.add("January");
		entryList.add("April");
		entryList.add("August");
		entryList.add("October");
		model.addAttribute("entryList", entryList);
		List<Schedule> scheduleList = scheduleService.getAllSchedule();
		model.addAttribute("scheduleList", scheduleList);
		return "scheduleAddForm";
	}
	
	@RequestMapping(value={"/add"}, method=RequestMethod.POST)
	public String save(@ModelAttribute("newSchedule") @Validated Schedule scheduleObj, BindingResult result, Model model ) {
		if(result.hasErrors()) {
			return "scheduleAddForm";
		} else {
			scheduleService.save(scheduleObj);
			System.out.println("Saved");
			return "redirect:/schedule/add";
		}
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		scheduleService.delete(id);
		return "redirect:/schedule/add";
	}

}