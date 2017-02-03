package org.mumsched.service;

import java.util.List;

import org.mumsched.domain.Faculty;

public interface FacultyService {

	public List<Faculty> getAllFaculty();

	public Faculty getFacultyById(long id);

	public void save(Faculty facultyObj);

	public void delete(Long id);

}
