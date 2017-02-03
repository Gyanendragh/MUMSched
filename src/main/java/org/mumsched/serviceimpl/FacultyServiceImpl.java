package org.mumsched.serviceimpl;

import java.util.List;

import org.mumsched.domain.Faculty;
import org.mumsched.repositories.FacultyRepository;
import org.mumsched.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService{

	@Autowired
	FacultyRepository facultyrepository;
	
	@Override
	public List<Faculty> getAllFaculty() {
		return (List<Faculty>) facultyrepository.findAll();
	}

	@Override
	public Faculty getFacultyById(long id) {
		return facultyrepository.findOne(id);
	}

	@Override
	public void save(Faculty faculty) {
		facultyrepository.save(faculty);
	}

	@Override
	public void delete(Long id) {
		facultyrepository.delete(id);
	}

}
