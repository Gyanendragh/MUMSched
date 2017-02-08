package org.mumsched.controllers;

import java.util.List;

import org.mumsched.domain.Block;
import org.mumsched.domain.Entry;
import org.mumsched.domain.Schedule;
import org.mumsched.serviceimpl.BlockServiceImpl;
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
	@Autowired
	BlockServiceImpl blockService;

	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String getForm(@ModelAttribute("newSchedule")Schedule schedule, Model model) {
		model.addAttribute("entryList", entryService.getAllEntry());
		return "scheduleAddForm";
	}

	@RequestMapping(value={"/add"}, method=RequestMethod.POST)
	public String generateSchedule(@ModelAttribute("newSchedule") @Validated Schedule scheduleObj, BindingResult result, Model model ) {
		if(result.hasErrors()) {
			return "scheduleAddForm";
		} else {
			this.saveSchedule(scheduleObj);
			return "redirect:/schedule/add";
		}
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		scheduleService.delete(id);
		return "redirect:/schedule/add";
	}

	@RequestMapping(value="/view/{id}", method=RequestMethod.GET)
	public String viewSchedule(@PathVariable("id") Long id, Model model) {
		model.addAttribute("schedule", scheduleService.getScheduleById(id));
		return "viewSchedule";
	}

	@ModelAttribute("scheduleList")
	public List<Schedule> showList(){
		List<Schedule> scheduleList=scheduleService.getAllSchedule();
		return scheduleList;
	}

	protected void saveSchedule(Schedule scheduleObj) {
		long id = Long.parseLong(scheduleObj.getName());
		Entry entry = entryService.getEntryById(id);
		Schedule schedule = new Schedule();

		schedule.setEntry(entry);
		schedule.setName("Schedule for " + entry.getEname());

		for(int i=1; i<8; i++) {
			Block block = new Block();
			block.setbName("block"+i);

			blockService.save(block);
			entry.getBlockList().add(block);

		}
		entryService.save(entry);
		scheduleService.save(schedule);
	}
}