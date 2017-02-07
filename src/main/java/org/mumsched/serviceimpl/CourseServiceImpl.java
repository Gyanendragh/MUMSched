package org.mumsched.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.mumsched.domain.Course;
import org.mumsched.repositories.CourseRepository;
import org.mumsched.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseRepository courserepository;

	@Override
	public void save(Course course) {
		courserepository.save(course);
	}

	@Override
	public List<Course> getAllCourse() {

		return (List<Course>) courserepository.findAll();
	}

	@Override
	public Course getCourseBycourseId(Long courseId) {

		return courserepository.findOne(courseId);
	}

	@Override
	public void delete(Long courseId) {
		courserepository.delete(courseId);

	}
	
	public Course getCourseBycourseName(String courseName) {
		for(Course course: this.getAllCourse()) {
			if(course.getCourseName().equals(courseName)) {
				return course;
			}
		}
		return null;
	}

	public List<Course> getCourseBycourseLevel(String level) {
		List<Course> courseList = new ArrayList<>();
		for(Course course: this.getAllCourse()) {
			if(course.getCourseLevel().equals(level)) {
				courseList.add(course);
			}
		}
		return courseList;
	}

	public void saveCourse(Course courseObj) {
		// TODO Auto-generated method stub
		
	}

}
