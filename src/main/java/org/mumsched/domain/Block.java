package org.mumsched.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
	private Long blockId;

	private String blockName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="schedule_id")
	private Schedule schedule;

	@OneToMany(mappedBy="block", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Section> sectionList = new HashSet<>();
//	private List<Section> sectionList = new ArrayList<>();

	public Long getBlockId() {
		return blockId;
	}

	public Set<Section> getSectionList() {
		return sectionList;
	}

	public void setSectionList(Set<Section> sectionList) {
		this.sectionList = sectionList;
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

	

}
