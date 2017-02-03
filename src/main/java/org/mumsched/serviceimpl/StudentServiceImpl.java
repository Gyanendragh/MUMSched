package org.mumsched.serviceimpl;

import java.util.List;

import org.mumsched.domain.Student;
import org.mumsched.repositories.StudentRepository;
import org.mumsched.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
@Autowired
StudentRepository studentrepository;

	@Override
	public void save(Student student) {
		studentrepository.save(student);
		
	}

	@Override
	public Object getStudentById(long id) {
		
		return studentrepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		studentrepository.delete(id);
		
	}

	@Override
	public List<Student> getAllStudent() {
		
		return (List<Student>)studentrepository.findAll();
	}

}
