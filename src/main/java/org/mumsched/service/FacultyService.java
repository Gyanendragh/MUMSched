package org.mumsched.service;

import java.util.List;

import org.mumsched.domain.Faculty;



public interface FacultyService {
	public void save(Faculty faculty);

	public List<Faculty> getAllFaculty();

	public Faculty getFacultyById(Long facultyId); 

	public void delete(Long facultyId);

}

