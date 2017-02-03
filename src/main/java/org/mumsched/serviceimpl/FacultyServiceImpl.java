package org.mumsched.serviceimpl;

import java.util.List;

import org.mumsched.domain.Faculty;
import org.mumsched.repositories.FacultyRepository;
import org.mumsched.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class FacultyServiceImpl implements FacultyService {
	@Autowired
	FacultyRepository facultyrepository;

	@Override
	public void save(Faculty faculty) {
		facultyrepository.save(faculty);
	}

	@Override
	public List<Faculty> getAllFaculty() {

		return (List<Faculty>) facultyrepository.findAll();
	}

	@Override
	public Faculty getFacultyById(Long facultyId) {

		return facultyrepository.findOne(facultyId);
	}

	@Override
	public void delete(Long facultyId) {
		facultyrepository.delete(facultyId);

	}

	

}
