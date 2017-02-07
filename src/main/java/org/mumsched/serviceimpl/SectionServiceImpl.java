package org.mumsched.serviceimpl;

import java.util.ArrayList;
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
		int numberOfFpp = (block.getSchedule().getEntry().getNoOfFppStudents()/25)+1;
		int numberOfMpp = (block.getSchedule().getEntry().getNoOfMppStudents()/25)+1;
		int total = numberOfFpp + numberOfMpp;

		List<Faculty> facultyListFPP = new ArrayList<>();
		List<Faculty> facultyListMPP = new ArrayList<>();

		switch(blockName) {
		// ALL SCI Blocks
		case "Block 1" :
			Course sci = courseService.getCourseBycourseName("SCI");
			facultyListFPP = facultyService.getFacultyByCourse(sci);
			for(int i=0; i<(Math.min(facultyListFPP.size(), total)); i++) {
				this.saveSectionInBlock(sci, facultyListFPP.get(i), block);
			}				

			break;

			// FPP and MPP
		case "Block 2" :
			Course fpp = courseService.getCourseBycourseName("FPP");
			facultyListFPP = facultyService.getFacultyByCourse(fpp);
			for(int i=0; i<(Math.min(facultyListFPP.size(), numberOfFpp)); i++) {
				this.saveSectionInBlock(fpp, facultyListFPP.get(i), block);
			}				

			Course mpp = courseService.getCourseBycourseName("MPP");
			facultyListMPP = facultyService.getFacultyByCourse(mpp);
			
			for(Faculty facFPP : facultyListFPP) {
				for(int j=0; j<facultyListMPP.size(); j++) {
					Faculty facMPP = facultyListMPP.get(j);
					if(facFPP.getFacultyId() == facMPP.getFacultyId()) {
						facultyListMPP.remove(facMPP);
					}
				}
			}
			
			for(int i=0; i<(Math.min(facultyListMPP.size(), numberOfMpp)); i++) {
				this.saveSectionInBlock(mpp, facultyListMPP.get(i), block);
			}				

			break;
			// MPP and ELECTIVE
		case "Block 3" :
			mpp = courseService.getCourseBycourseName("MPP");
			facultyListFPP = facultyService.getFacultyByCourse(mpp);
			for(int i=0; i<(Math.min(facultyListFPP.size(), numberOfFpp)); i++) {
				this.saveSectionInBlock(mpp, facultyListFPP.get(i), block);
			}

			this.saveSectionByLevel(block, "400", numberOfMpp);

			break;
			// Elective
		case "Block 4" :
			this.saveSectionByLevel(block, "400", numberOfFpp);
			this.saveSectionByLevel(block, "500", numberOfMpp);
			break;

		case "Block 5" :
			this.saveSectionByLevel(block, "400", numberOfFpp);
			this.saveSectionByLevel(block, "500", numberOfMpp);
			break;

		case "Block 6" :
			this.saveSectionByLevel(block, "400", numberOfFpp);
			this.saveSectionByLevel(block, "500", numberOfMpp);
			break;

		case "Block 7" :
			this.saveSectionByLevel(block, "500", numberOfFpp);
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

	protected void saveSectionInBlock(Section section, Block block) {
		this.save(section);
		block.getSectionList().add(section);
	}

	protected void saveSectionByLevel(Block block, String level, int count) {
		List<Course> electiveList = new ArrayList<>();
		List<Faculty> facultyList = new ArrayList<>();
		List<Section> sectionList = new ArrayList<>();
		electiveList = courseService.getCourseBycourseLevel(level);

		for(Course course : electiveList) {
			facultyList = facultyService.getFacultyByCourse(course);
			for(Faculty faculty : facultyList) {

				Section section = new Section();
				section.setSectionName(course.getCourseName() + "( " + faculty.getFullName() + " )");
				section.setBlock(block);
				section.setCourse(course);
				section.setFaculty(faculty);

				sectionList.add(section);

			}
		}

		for(int i=0; i<(Math.min(sectionList.size(), count)); i++) {
			this.saveSectionInBlock(sectionList.get(i), block);
		}
	}

}
