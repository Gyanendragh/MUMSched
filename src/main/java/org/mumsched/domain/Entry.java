package org.mumsched.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Entry {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
    @Size(min=2, max=10)
	@NotEmpty(message="no empty field accepted")
	private String ename;
    
	@NotNull @Min(2017) @Max(2020)
	private String eyear;
    
	@NotNull @Min(25) @Max(200)
	private int noOfFppStudents;
	
	@NotNull @Min(25) @Max(200)
	private int noOfMppStudents;
	
	@NotNull @Max(200)
	private int noOfUsResident;
	
//	@OneToMany(mappedBy="entry", fetch = FetchType.EAGER)
//	List<Block> blockList = new ArrayList<>();
	
	public int getNoOfFppStudents() {
		return noOfFppStudents;
	}
	public void setNoOfFppStudents(int noOfFppStudents) {
		this.noOfFppStudents = noOfFppStudents;
	}
	public int getNoOfMppStudents() {
		return noOfMppStudents;
	}
	public void setNoOfMppStudents(int noOfMppStudents) {
		this.noOfMppStudents = noOfMppStudents;
	}
	public int getNoOfUsResident() {
		return noOfUsResident;
	}
	public void setNoOfUsResident(int noOfUsResident) {
		this.noOfUsResident = noOfUsResident;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public String getEyear() {
		return eyear;
	}
	public void setEyear(String eyear) {
		this.eyear = eyear;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
//	public List<Block> getBlockList() {
//		return blockList;
//	}
//	public void setBlockList(List<Block> blockList) {
//		this.blockList = blockList;
//	}
	
}
