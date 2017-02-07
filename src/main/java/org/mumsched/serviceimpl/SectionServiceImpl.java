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
		int numberOfFpp = block.getSchedule().getEntry().getNoOfFppStudents()/25;
		int numberOfMpp = block.getSchedule().getEntry().getNoOfMppStudents()/25;
		int total = numberOfFpp + numberOfMpp;
		
		List<Course> courseList = new ArrayList<>();
		List<Faculty> facultyList = new ArrayList<>();

		switch(blockName) {
		// ALL SCI Blocks
		case "Block 1" : 
			courseList.add(courseService.getCourseBycourseName("SCI"));

			for(Course course: courseList) {
				facultyList = facultyService.getFacultyByCourse(course);
				for(Faculty faculty : facultyList) {
					this.saveSectionInBlock(course, faculty, block);
					if(total == 0) {
						break;
					}
					total--;
				}
			}
			courseList.clear();
			facultyList.clear();
			break;

		// FPP and MPP
		case "Block 2" :
			Course courseFPP = courseService.getCourseBycourseName("FPP");
			facultyList = facultyService.getFacultyByCourse(courseFPP);
			for(Faculty faculty : facultyList) {
				this.saveSectionInBlock(courseFPP, faculty, block);
				if(numberOfFpp == 0) {
					break;
				}
				numberOfFpp--;
			}
			courseList.clear();
			facultyList.clear();

			Course courseMPP = courseService.getCourseBycourseName("MPP");
			facultyList = facultyService.getFacultyByCourse(courseMPP);
			for(Faculty faculty : facultyList) {
				this.saveSectionInBlock(courseMPP, faculty, block);
				if(numberOfMpp == 0) {
					break;
				}
				numberOfMpp--;
			}
			facultyList.clear();
			break;
		// MPP and ELECTIVE
		case "Block 3" :
			courseMPP = courseService.getCourseBycourseName("MPP");
			facultyList = facultyService.getFacultyByCourse(courseMPP);
			for(Faculty faculty : facultyList) {
				this.saveSectionInBlock(courseMPP, faculty, block);
				if(numberOfFpp == 0) {
					break;
				}
				numberOfFpp--;
			}
			courseList.clear();
			facultyList.clear();
			

			courseList.addAll(courseService.getCourseBycourseLevel("400"));

			for(Course course: courseList) {
				facultyList = facultyService.getFacultyByCourse(course);
				for(Faculty faculty : facultyList) {
					this.saveSectionInBlock(course, faculty, block);
					if(numberOfMpp == 0) {
						break;
					}
					numberOfMpp--;
				}
			}
			courseList.clear();
			facultyList.clear();
			break;
			
		// Elective
		case "Block 4" :
			courseList.addAll(courseService.getCourseBycourseLevel("400"));

			for(Course course: courseList) {
				facultyList = facultyService.getFacultyByCourse(course);
				for(Faculty faculty : facultyList) {
					this.saveSectionInBlock(course, faculty, block);
					if(numberOfFpp == 0) {
						break;
					}
					numberOfFpp--;
				}
			}
			courseList.clear();
			facultyList.clear();
			courseList.addAll(courseService.getCourseBycourseLevel("500"));

			for(Course course: courseList) {
				facultyList = facultyService.getFacultyByCourse(course);
				for(Faculty faculty : facultyList) {
					this.saveSectionInBlock(course, faculty, block);
					if(numberOfMpp == 0) {
						break;
					}
					numberOfMpp--;
				}
			}
			courseList.clear();
			facultyList.clear();
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

	protected List<Faculty> removeDuplicateFaculty(List<Course> courseList) {
		// TO DO
		List<Faculty> facultyList = new ArrayList<>(); 
//		for(Course course : courseList) {
//			facultyList.get
//			facultyList.add()
//			
//		}
		return facultyList;
	}


}
