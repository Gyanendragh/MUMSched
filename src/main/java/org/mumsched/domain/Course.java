package org.mumsched.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	private String prerequisites;

	@NotEmpty(message="no empty field accepted")
	private String faculty;

	/*@NotEmpty(message="no empty field accepted")
	@ManyToMany
	@JoinTable(name="course_faculty",
		joinColumns = @JoinColumn(name = "facultyList_facultyId" ), 
		inverseJoinColumns = @JoinColumn(name = "courseList_courseId"))
	private Set<Faculty> facultyList = new HashSet<>();*/

	@OneToMany(mappedBy="course")
	private List<Section> sectionList = new ArrayList<>();

	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
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
