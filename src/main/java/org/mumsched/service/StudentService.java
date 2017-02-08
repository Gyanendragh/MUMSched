package org.mumsched.service;

import java.util.List;

import org.mumsched.domain.Student;

public interface StudentService {

	public void save(Student studentObj);

	public Object getStudentById(long id);

	public void delete(Long id);

	public List<Student> getAllStudent();

	public Student findByStudentIdNumber(String studentIdNumber);


}
