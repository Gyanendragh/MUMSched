package org.mumsched.controllers;

import java.util.List;

import org.mumsched.domain.Block;
import org.mumsched.service.BlockService;
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
@RequestMapping(value="/block")
public class BlockController {
	@Autowired
	BlockService blockservice;
	
	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String getForm(@ModelAttribute("newBlock") Block block,Model model){
		return "blockAddForm";
	}
	
	@RequestMapping(value={"/add"},method=RequestMethod.POST) 
	public String stsave(@ModelAttribute("newBlock") @Validated Block blockObj, BindingResult result,Model model){
		if(result.hasErrors()){
			return "blockAddForm";
		}else{
		blockservice.save(blockObj);
		return "redirect:/block/add";
		}
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String get(@PathVariable long id, Model model) {
		model.addAttribute("editBlock", blockservice.getBlockById(id));
		return "blockEditForm";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public String update(Block block, @PathVariable long id, @ModelAttribute("editBlock") @Validated Block editBlock, BindingResult result, Model model) {
		if(result.hasErrors()){
			return"blockEditForm";
		}else{
		block.setId(id);
		blockservice.save(editBlock);
		return "redirect:/block/add";
		}
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		blockservice.delete(id);
		return "redirect:/block/add";
	}
	
	@ModelAttribute("blocklist")
	public List<Block> showList(){
		List<Block> blockList=blockservice.getAllBlock();
		return blockList;
	}

}
