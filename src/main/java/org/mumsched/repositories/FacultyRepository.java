package org.mumsched.repositories;

import org.mumsched.domain.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Long>{
	Faculty findByFacultyIdNumber(String number);
}