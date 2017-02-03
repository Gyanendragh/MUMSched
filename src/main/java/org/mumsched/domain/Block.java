package org.mumsched.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Block {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String bName;

	private Date bStartDate;
	private Date bEndDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="entry_id")
	private Entry entry;

	@OneToMany(mappedBy="block")
	private List<Section> sectionList = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public Date getbStartDate() {
		return bStartDate;
	}

	public void setbStartDate(Date bStartDate) {
		this.bStartDate = bStartDate;
	}

	public Date getbEndDate() {
		return bEndDate;
	}

	public void setbEndDate(Date bEndDate) {
		this.bEndDate = bEndDate;
	}

}
