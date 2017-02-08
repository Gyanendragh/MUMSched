package org.mumsched.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Block {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long blockId;
	
	@Column(unique = true)
	@NotEmpty(message="no empty field accpted")

	private String blockName;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="schedule_id")
	private Schedule schedule;

	@OneToMany(mappedBy="block", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Section> sectionList = new HashSet<>();

	public Long getBlockId() {
		return blockId;
	}

	public void setBlockId(Long blockId) {
		this.blockId = blockId;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Set<Section> getSectionList() {
		return sectionList;
	}

	public void setSectionList(Set<Section> sectionList) {
		this.sectionList = sectionList;
	}
	
}
