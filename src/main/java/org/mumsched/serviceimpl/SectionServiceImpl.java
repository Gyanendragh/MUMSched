package org.mumsched.serviceimpl;

import java.util.List;

import org.mumsched.domain.Block;
import org.mumsched.domain.Course;
import org.mumsched.domain.Faculty;
import org.mumsched.domain.Section;
import org.mumsched.repositories.SectionRepository;
import org.mumsched.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SectionServiceImpl implements SectionService {

	@Autowired
	CourseServiceImpl courseService;

	@Autowired
	FacultyServiceImpl facultyService;

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

		String blockName = block.getBlockName();
		int noFPP = block.getSchedule().getEntry().getNoOfFppStudents();
		int noMpp = block.getSchedule().getEntry().getNoOfMppStudents();

		switch(blockName) {
		// ALL SCI Blocks
		case "Block 1" : 
			int n = (noFPP + noMpp) / 25;
			Course course = courseService.getCourseBycourseName("SCI");
			List<Faculty> facultyList = facultyService.getFacultyByCourse(course);
		
			for(int i=0; i<=n; i++) {
				this.saveSectionInBlock(course, facultyList.get(i), block);
			}
			break;

		}
	}

	protected void saveSectionInBlock(Course course, Faculty faculty, Block block) {
		Section section = new Section();
		section.setSectionName(course.getCourseName() + "( " + faculty.getFullName() + " )");
		section.setBlock(block);
		section.setCourse(course);
		section.setFaculty(faculty);
		this.save(section);
		block.getSectionList().add(section);
	}

	//	public void addSectionsToBlock(Block block) {
	//		for(int i=1; i<8; i++) {
	//			Section section = new Section();
	//			section.setSectionName("FPP");
	//			section.setStudentLimit((long) 25);
	//			section.setBlock(block);
	//			
	//			this.save(section);
	//			block.getSectionList().add(section);
	//		}
	//		
	//	}

}
