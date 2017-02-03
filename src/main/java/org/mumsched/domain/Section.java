package org.mumsched.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Section {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	private Long sectionId;
	@NotNull
	private String sectionName;
	@NotNull
	private Long studentLimit;
	
	@ManyToOne
	@JoinColumn(name="block_id")
	private Block block;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name="faculty_id")
	private Faculty faculty;
	
	public Long getId() {
		return sectionId;
	}

	public void setId(Long id) {
		this.sectionId = id;
	}

	public Long getStudentLimit() {
		return studentLimit;
	}

	public void setStudentLimit(Long studentLimit) {
		this.studentLimit = studentLimit;
	}
	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	
}
