package org.mumsched.repositories;

import org.mumsched.domain.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

	Course findByCourseName(String name);

	Course findByCourseNumber(String name);
	
}
