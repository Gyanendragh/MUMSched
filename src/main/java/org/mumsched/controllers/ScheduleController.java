package org.mumsched.controllers;

import java.util.ArrayList;
import java.util.List;

import org.mumsched.domain.Entry;
import org.mumsched.domain.Schedule;
import org.mumsched.serviceimpl.EntryServiceImpl;
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

	@Autowired
	EntryServiceImpl entryService;

	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String getForm(@ModelAttribute("newSchedule")Schedule schedule, Model model) {
		model.addAttribute("entryList", this.getEntryName());
		return "scheduleAddForm";
	}

	@RequestMapping(value={"/add"}, method=RequestMethod.POST)
	public String save(@ModelAttribute("newSchedule") @Validated Schedule scheduleObj, BindingResult result, Model model ) {
		if(result.hasErrors()) {
			return "scheduleAddForm";
		} else {
			scheduleService.save(scheduleObj);
//			System.out.println("Schedule Name" + scheduleObj.getName());
//			System.out.println("Schedule Id" + scheduleObj.getId());
//			System.out.println("Entry ID" + scheduleObj);
//			System.out.println("Saved");
			return "redirect:/schedule/add";
		}
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		scheduleService.delete(id);
		return "redirect:/schedule/add";
	}

	@RequestMapping(value="/view/{id}", method=RequestMethod.GET)
	public String view(@PathVariable("id") Long id) {
		return "viewSchedule";
	}

	@ModelAttribute("scheduleList")
	public List<Schedule> showList(){
		List<Schedule> scheduleList=scheduleService.getAllSchedule();
		return scheduleList;
	}


	protected List<String> getEntryName() {
		List<String> entryNameList = new ArrayList<>();
		for(Entry e : entryService.getAllEntry()) {
			entryNameList.add(e.getEname());
		}

		return entryNameList;
	}

}