package org.mumsched.serviceimpl;

import java.util.List;

import org.mumsched.domain.Entry;
import org.mumsched.domain.Schedule;
import org.mumsched.repositories.ScheduleRepository;
import org.mumsched.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	EntryServiceImpl entryService;

	@Autowired
	BlockServiceImpl blockService;

	@Autowired
	ScheduleRepository schedulerepository;

	@Override
	public void save(Schedule schedule) {
		schedulerepository.save(schedule);
	}

	@Override
	public List<Schedule> getAllSchedule() {
		return (List<Schedule>) schedulerepository.findAll();
	}

	@Override
	public Schedule getScheduleById(Long id) {
		return schedulerepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		schedulerepository.delete(id);
	}

	public void createSchedule(Schedule scheduleObj) {
		long id = Long.parseLong(scheduleObj.getName());
		Entry entry = entryService.getEntryById(id);
		Schedule schedule = new Schedule();

		schedule.setEntry(entry);
		schedule.setName("Schedule for " + entry.getEname());
		this.save(schedule);
		
		//Add Blocks to Schedule
		blockService.addBlocksToSchedule(schedule);

	}

}