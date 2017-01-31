package org.mumsched.serviceimpl;

import java.util.List;

import org.mumsched.domain.Schedule;
import org.mumsched.repositories.ScheduleRepository;
import org.mumsched.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {
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

}