package org.mumsched.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long studentId;
	
	@Column(unique  = true)
	@NotEmpty(message="no empty field accepted")
	private String studentIdNumber;
	
	
	@NotEmpty(message="no empty field accepted")
	private String fullName;
	
	@NotEmpty(message="no empty field accepted")
	private String studentEntry;

	public String getStudentIdNumber() {
		return studentIdNumber;
	}

	public void setStudentIdNumber(String studentIdNumber) {
		this.studentIdNumber = studentIdNumber;
	}

	public String getStudentEntry() {
		return studentEntry;
	}

	public void setStudentEntry(String studentEntry) {
		this.studentEntry = studentEntry;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
}
