package org.mumsched.service;

import java.util.List;

import org.mumsched.domain.Schedule;

public interface ScheduleService {
	public void save(Schedule schedule);

	public List<Schedule> getAllSchedule();

	public Schedule getScheduleById(Long id); 

	public void delete(Long id);

}