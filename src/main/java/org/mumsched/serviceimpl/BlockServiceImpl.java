package org.mumsched.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.mumsched.domain.Block;
import org.mumsched.domain.Schedule;
import org.mumsched.repositories.BlockRepository;
import org.mumsched.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockServiceImpl implements BlockService{

	@Autowired
	ScheduleServiceImpl scheduleService;

	@Autowired
	SectionServiceImpl sectionService;
	
	@Autowired
	BlockRepository blockrepository;

	@Override
	public void save(Block blockObj) {
		blockrepository.save(blockObj);

	}

	@Override
	public Block getBlockById(long id) {

		return blockrepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		blockrepository.delete(id);
	}

	@Override
	public List<Block> getAllBlock() {

		return (List<Block>) blockrepository.findAll();
	}

	public Object getBlockListByScheduleId(Long scheduleId) {

		List<Block> blockList = new ArrayList<>();
		for(Block block: this.getAllBlock()) {
			if(block.getSchedule().getId() == scheduleId) {
				blockList.add(block);
			}
		}
		return blockList;
	}

	public void addBlocksToSchedule(Schedule schedule) {
		for(int i=1; i<8; i++) {
			Block block = new Block();
			block.setBlockName("Block " + i);
			block.setSchedule(schedule);
			
			// Add Sections to Block
			this.save(block);
			sectionService.addSectionsToBlock(block);
			schedule.getBlockList().add(block);
		}
	}

	@Override
	public Block findByBlockName(String name) {
		return this.blockrepository.findByBlockName(name);
	}

}
