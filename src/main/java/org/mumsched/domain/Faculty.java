package org.mumsched.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Faculty {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long facultyId;
	
	private String fullName;
	
	@OneToMany(mappedBy="faculty")
	private List<Section> section = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="course_faculty",
		joinColumns = @JoinColumn(name = "faculty_id"), 
		inverseJoinColumns = @JoinColumn(name = "course_id" ))
	private List<Course> preferCourse = new ArrayList<>();

	public Long getFacultyId() {
		return facultyId;
	}

	public List<Course> getPreferCourse() {
		return preferCourse;
	}

	public void setPreferCourse(List<Course> preferCourse) {
		this.preferCourse = preferCourse;
	}

	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}

	public List<Section> getSection() {
		return section;
	}

	public void setSection(List<Section> section) {
		this.section = section;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


}
