package org.mumsched.controllers;


import java.util.List;

import javax.validation.Valid;

import org.mumsched.domain.Entry;
import org.mumsched.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/entry")
public class EntryController {
	@Autowired
	EntryService entryservice;
	
	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String getForm(@ModelAttribute("newEntry") Entry entry,Model model){
		return "entryAddForm";
	}
	
	@RequestMapping(value={"/add"},method=RequestMethod.POST) 
	public String stsave(@ModelAttribute("newEntry") @Valid Entry entryObj, BindingResult result,Model model){
		if(result.hasErrors()){
			return "entryAddForm";
		}else{
			entryservice.save(entryObj);
		return "redirect:/entry/add";
		}
	}
	
	@RequestMapping(value="/edit/{entryId}", method=RequestMethod.GET)
	public String get(@PathVariable long entryId, Model model) {
		model.addAttribute("editEntry", entryservice.getEntryById(entryId));
		return "entryEditForm";
	}
	
	@RequestMapping(value="/edit/{entryId}", method=RequestMethod.POST)
	public String update(Entry entry, @PathVariable long entryId, @ModelAttribute("editEntry") @Valid Entry editEntry, BindingResult result, Model model) {
		if(result.hasErrors()){
			return"entryEditForm";
		}else{
		entry.setEntryId(entryId);
		entryservice.save(editEntry);
		return "redirect:/entry/add";
		}
	}
	
	@RequestMapping(value="/delete/{entryId}", method=RequestMethod.GET)
	public String delete(@PathVariable("entryId") Long entryId) {
		entryservice.delete(entryId);
		return "redirect:/entry/add";
	}
	
	@ModelAttribute("entrylist")
	public List<Entry> showList(){
		List<Entry> entryList=entryservice.getAllEntry();
		return entryList;
	}
}
