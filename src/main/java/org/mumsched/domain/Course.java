package org.mumsched.domain;

import java.util.HashSet;
import java.util.Set;

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
	private String courseName; //  imp note path at the jsp file must equivalent to this cname

	@Column(unique = true)
	@NotEmpty(message="no empty field accepted")
	private String courseNumber;

	@Column(name="prerequisite_id")
	private String prerequisite;

	
	private String courseLevel;
	
	@OneToMany(mappedBy="course")
	private Set<Section> sectionList = new HashSet<>();

	public String getLevel() {
		return courseLevel;
	}
	public void setLevel(String level) {
		this.courseLevel = level;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	
	public String getPrerequisite() {
		return prerequisite;
	}
	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}
	public String getCourseLevel() {
		return courseLevel;
	}
	public void setCourseLevel(String courseLevel) {
		this.courseLevel = courseLevel;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Set<Section> getSectionList() {
		return sectionList;
	}
	public void setSectionList(Set<Section> sectionList) {
		this.sectionList = sectionList;
	}
	public String getCname() {
		return courseName;
	}
	public void setCname(String cname) {
		this.courseName = cname;
	}
	public String getCnumber() {
		return courseNumber;
	}
	public void setCnumber(String cnumber) {
		this.courseNumber = cnumber;
	}

}
