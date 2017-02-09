package org.mumsched.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Entry {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long entryId;
	
    @Size(min=2, max=10)
	@NotEmpty(message="no empty field accepted")
	private String entryName;
    
	@NotNull @Min(2017) @Max(2020)
	private String entryYear;
    
	@NotNull @Min(1) @Max(200)
	private int noOfFppStudents;
	
	@NotNull @Min(1) @Max(200)
	private int noOfMppStudents;
	
	@NotNull @Min(1) @Max(200)
	private int noOfUsResident;
	
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
	public Long getEntryId() {
		return entryId;
	}
	public void setEntryId(Long entryId) {
		this.entryId = entryId;
	}
	public String getEntryName() {
		return entryName;
	}
	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}
	public String getEntryYear() {
		return entryYear;
	}
	public void setEntryYear(String entryYear) {
		this.entryYear = entryYear;
	}
	
	
}
