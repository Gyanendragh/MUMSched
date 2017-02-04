package org.mumsched.serviceimpl;

import java.util.List;

import org.mumsched.domain.Block;
import org.mumsched.domain.Section;
import org.mumsched.repositories.SectionRepository;
import org.mumsched.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SectionServiceImpl implements SectionService {
	@Autowired
	SectionRepository sectionrepository;

	@Override
	public void save(Section section) {
		sectionrepository.save(section);
	}

	@Override
	public List<Section> getAllSections() {

		return (List<Section>) sectionrepository.findAll();
	}

	@Override
	public Section getSectionBysectionId(Long sectionId) {

		return sectionrepository.findOne(sectionId);
	}

	@Override
	public void delete(Long sectionId) {
		sectionrepository.delete(sectionId);

	}

	public void addSectionsToBlock(Block block) {
		for(int i=1; i<8; i++) {
			Section section = new Section();
			section.setSectionName("FPP");
			section.setStudentLimit((long) 25);
			
			this.save(section);
			block.getSectionList().add(section);
		}
		
	}

}
