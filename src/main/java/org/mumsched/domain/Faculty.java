package org.mumsched.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Faculty {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	private Long facultyId;
	@NotNull
	private String fullName;
	
	@OneToMany(mappedBy="faculty")
	private List<Section> section = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "facultyList")
	private List<Course> courseList = new ArrayList<>();

	public Long getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


}
