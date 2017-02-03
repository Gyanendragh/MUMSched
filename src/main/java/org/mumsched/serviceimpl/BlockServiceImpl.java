package org.mumsched.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.mumsched.domain.Block;
import org.mumsched.repositories.BlockRepository;
import org.mumsched.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockServiceImpl implements BlockService{

	@Autowired
	ScheduleServiceImpl scheduleService;

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


}
