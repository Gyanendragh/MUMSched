package org.mumsched.controllers;

import java.util.List;

import javax.validation.Valid;

import org.mumsched.domain.Block;
import org.mumsched.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/block")
public class BlockController {
	@Autowired
	BlockService blockservice;

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String getForm(@ModelAttribute("newBlock") Block block, Model model) {
		return "blockAddForm";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String stsave(@ModelAttribute("newBlock") @Valid Block blockObj, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "blockAddForm";
		} else {
			if (this.blockservice.findByBlockName(blockObj.getBlockName()) != null) {
				result.rejectValue("blockName", "error.block", "The block name should be unique.");
				return "blockAddForm";
			}
			blockservice.save(blockObj);
			return "redirect:/block/add";
		}
	}

	@RequestMapping(value = "/edit/{blockId}", method = RequestMethod.GET)
	public String get(@PathVariable long blockId, Model model) {
		model.addAttribute("editBlock", blockservice.getBlockById(blockId));
		return "blockEditForm";
	}

	@RequestMapping(value = "/edit/{blockId}", method = RequestMethod.POST)
	public String update(Block block, @PathVariable long blockId,
			@ModelAttribute("editBlock") @Valid Block editBlock, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "blockEditForm";
		} else {
			if (this.blockservice.findByBlockName(editBlock.getBlockName()) != null) {
				result.rejectValue("blockName", "error.block", "The block name should be unique.");
				return "blockAddForm";
			}
			block.setBlockId(blockId);
			blockservice.save(editBlock);
			return "redirect:/block/add";
		}
	}

	@RequestMapping(value = "/delete/{blockId}", method = RequestMethod.GET)
	public String delete(@PathVariable("blockId") Long blockId) {
		blockservice.delete(blockId);
		return "redirect:/block/add";
	}

	@ModelAttribute("blocklist")
	public List<Block> showList() {
		List<Block> blockList = blockservice.getAllBlock();
		return blockList;
	}

}
