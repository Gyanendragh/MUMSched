package org.mumsched.service;

import java.util.List;

import org.mumsched.domain.Section;


public interface SectionService {
	public void save(Section section);

	public List<Section> getAllSections();

	public Section getSectionBysectionId(Long sectionId); 

	public void delete(Long sectionId);

}
