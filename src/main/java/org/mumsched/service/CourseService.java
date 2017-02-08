package org.mumsched.service;

import java.util.List;

import org.mumsched.domain.Course;


public interface CourseService {
	public void save(Course course);

	public List<Course> getAllCourse();

	public Course getCourseBycourseId(Long courseId); 

	public void delete(Long courseId);
	
	public Course findByCourseName(String name);
	
	public Course findByCourseNumber(String name);

}
