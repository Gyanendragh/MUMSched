package org.mumsched.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long courseId;
	
	@Column(unique = true)
    @Size(min=2, max=30)
	@NotEmpty(message="no empty field accepted")
	private String cname; //  imp note path at the jsp file must equivalent to this cname
	
	@Column(unique = true)
	@NotEmpty(message="no empty field accepted")
	private String cnumber;
	
	@NotEmpty(message="no empty field accepted")
	private String prerequisites;
	
	@NotEmpty(message="no empty field accepted")
	
	@ManyToMany
	@JoinTable(name="course_faculty",
		joinColumns = @JoinColumn(name = "facultyList_facultyId" ), 
		inverseJoinColumns = @JoinColumn(name = "courseList_courseId"))
	private Set<Faculty> facultyList = new HashSet<>();
	
	@OneToMany(mappedBy="course")
	private List<Section> sectionList = new ArrayList<>();
	
	public String getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}
	
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public Set<Faculty> getFacultyList() {
		return facultyList;
	}
	public void setFacultyList(Set<Faculty> facultyList) {
		this.facultyList = facultyList;
	}
	public List<Section> getSectionList() {
		return sectionList;
	}
	public void setSectionList(List<Section> sectionList) {
		this.sectionList = sectionList;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCnumber() {
		return cnumber;
	}
	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}
	
}
