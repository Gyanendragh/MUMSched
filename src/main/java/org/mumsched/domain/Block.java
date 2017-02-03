package org.mumsched.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Block {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	private Long blockId;
	@NotNull
	private String blockName;
	@NotNull
	private LocalDate blockStartDate;
	@NotNull
	private LocalDate blockEndDate;

	@ManyToOne
	@JoinColumn(name="entry_id")
	private Entry entry;
	
	@OneToMany(mappedBy="block")
	private List<Section> sectionList = new ArrayList<>();
	
	public Long getId() {
		return blockId;
	}

	public void setId(Long id) {
		this.blockId = id;
	}

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	public List<Section> getSectionList() {
		return sectionList;
	}

	public void setSectionList(List<Section> sectionList) {
		this.sectionList = sectionList;
	}

	public String getbName() {
		return blockName;
	}

	public void setbName(String bName) {
		this.blockName = bName;
	}

	public LocalDate getbStartDate() {
		return blockStartDate;
	}

	public void setbStartDate(LocalDate bStartDate) {
		this.blockStartDate = bStartDate;
	}

	public LocalDate getbEndDate() {
		return blockEndDate;
	}

	public void setbEndDate(LocalDate bEndDate) {
		this.blockEndDate = bEndDate;
	}
	
}
