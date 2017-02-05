package org.mumsched.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.mumsched.domain.Course;
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

	public List<Faculty> getFacultyByCourse(Course course) {
		// TO DO Generate Random Faculty
		List<Faculty> facultyList = this.getAllFaculty();
		List<Faculty> facultyListResult = new ArrayList<>();
		
		for(Faculty faculty : facultyList) {
			for(Course preferedCourse : faculty.getPreferCourse()) {
				if(preferedCourse.getCourseId() == course.getCourseId()) {
					facultyListResult.add(faculty);
				}
				
			}
		}
		
		return facultyListResult;
	}

	

}
