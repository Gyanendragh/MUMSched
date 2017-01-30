package org.mumsched.service;

import java.util.List;

import org.mumsched.domain.Course;


public interface CourseService {
	public void save(Course course);

	public List<Course> getAllCourse();

	public Course getCourseById(Long id); 

	public void delete(Long id);

}
