package org.mumsched.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private Set<Section> section = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="course_faculty",
		joinColumns = @JoinColumn(name = "faculty_id"), 
		inverseJoinColumns = @JoinColumn(name = "course_id" ))
	private Set<Course> preferCourse = new HashSet<>();

	public Long getFacultyId() {
		return facultyId;
	}

	public Set<Course> getPreferCourse() {
		return preferCourse;
	}


	public void setPreferCourse(Set<Course> preferCourse) {
		this.preferCourse = preferCourse;
	}


	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}

	public Set<Section> getSection() {
		return section;
	}

	public void setSection(Set<Section> section) {
		this.section = section;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


}
