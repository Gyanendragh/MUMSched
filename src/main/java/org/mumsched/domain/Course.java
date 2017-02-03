package org.mumsched.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	private Long id;
	
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
	private List<Faculty> facultyList = new ArrayList<>();
	
	@OneToMany(mappedBy="course")
	private List<Section> sectionList = new ArrayList<>();
	
	public String getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
