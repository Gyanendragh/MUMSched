INSERT INTO users(id,userid,username,password,enabled) VALUES (1,1,'student','student', TRUE);
INSERT INTO users(id,userid,username,password,enabled) VALUES (2,2,'admin','admin', TRUE);
INSERT INTO users(id,userid,username,password,enabled) VALUES (3,3,'faculty','faculty', TRUE);
INSERT INTO users(id,userid,username,password,enabled) VALUES (4,3,'fac1','fac1', TRUE);


INSERT INTO user_roles (id,userid, authority) VALUES (1,1, 'ROLE_STUDENT');
INSERT INTO user_roles (id,userid, authority) VALUES (2,2, 'ROLE_ADMIN');
INSERT INTO user_roles (id,userid, authority) VALUES (3,3, 'ROLE_FACULTY');


INSERT INTO entry (entryId, entryName, entryYear, noOfFppStudents, noOfMppStudents, noOfUsResident) VALUES (1, "January", 2017, 75, 35, 25);
INSERT INTO entry (entryId, entryName, entryYear, noOfFppStudents, noOfMppStudents, noOfUsResident) VALUES (2, "April", 2017, 35, 35, 35);
INSERT INTO entry (entryId, entryName, entryYear, noOfFppStudents, noOfMppStudents, noOfUsResident) VALUES (3, "August", 2017, 45, 45, 45);
INSERT INTO entry (entryId, entryName, entryYear, noOfFppStudents, noOfMppStudents, noOfUsResident) VALUES (4, "October", 2017, 55, 55, 55);


INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (1,2000, "Lerman");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (2,2001, "Renuka");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (3,2002, "Pormila");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (4,2003, "Bruen");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (5,2004, "Crish");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (6,2005, "James");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (7,2006, "Salek");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (8,2042, "Saad");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (9,2008, "Levi");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (10,2009, "Xing");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (11,2010, "Arrocha");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (12,2011, "Ruby");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (13,2012, "Corozza");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (14,2013, "Rakesh");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (15,2014, "Nolle");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (16,2015, "Maile");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (17,2016, "Frank");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (18,2017, "Khan");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (19,2018, "Guthrie");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (20,2019,"Mukadam");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (21,2020, "SCI_Faculty1");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (22,2021, "SCI_Faculty2");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (23,2022, "SCI_Faculty3");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (24,2023, "SCI_Faculty4");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (25,2024, "SCI_Faculty5");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (26,2025, "SCI_Faculty6");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (27,2026, "FPP_Faculty1");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (28,2027, "FPP_Faculty2");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (30,2028, "FPP_Faculty4");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (31,2029, "FPP_Faculty5");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (32,2030, "MPP_Faculty1");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (33,2031, "MPP_Faculty2");
INSERT INTO faculty(facultyId,facultyIdNumber, fullName) VALUES (34,2032, "MPP_Faculty3");


INSERT INTO course (courseId,courseName,courseNumber,courseLevel,prerequisite_id) VALUES (1,"FPP","CS380",'400',NULL);
INSERT INTO course (courseId,courseName,courseNumber,courseLevel,prerequisite_id) VALUES (2,"MPP","CS400",'400',NULL);
INSERT INTO course (courseId,courseName,courseNumber,courseLevel,prerequisite_id) VALUES (3,"SWE","CS425",'400',NULL);
INSERT INTO course (courseId,courseName,courseNumber,courseLevel,prerequisite_id) VALUES (4,"Algorithm","CS435",'400',NULL);
INSERT INTO course (courseId,courseName,courseNumber,courseLevel,prerequisite_id) VALUES (5,"WAP","CS440",'400',NULL);
INSERT INTO course (courseId,courseName,courseNumber,courseLevel,prerequisite_id) VALUES (6,"EA","CS545",'500',NULL);
INSERT INTO course (courseId,courseName,courseNumber,courseLevel,prerequisite_id) VALUES (7,"WAA","CS450",'500',5);
INSERT INTO course (courseId,courseName,courseNumber,courseLevel,prerequisite_id) VALUES (8,"ASD","CS550",'500',3);
INSERT INTO course (courseId,courseName,courseNumber,courseLevel,prerequisite_id) VALUES (9,"BD","CS525",'500',NULL);
INSERT INTO course (courseId,courseName,courseNumber,courseLevel,prerequisite_id) VALUES (10,"BDA","CS520",'500',NULL);
INSERT INTO course (courseId,courseName,courseNumber,courseLevel,prerequisite_id) VALUES (11,"MWA","CS522",'500',5);
INSERT INTO course (courseId,courseName,courseNumber,courseLevel,prerequisite_id) VALUES (12,"SCI","CS500",'500',NULL);
INSERT INTO course (courseId,courseName,courseNumber,courseLevel,prerequisite_id) VALUES (14,"Course1","CS430",'400',NULL);
INSERT INTO course (courseId,courseName,courseNumber,courseLevel,prerequisite_id) VALUES (15,"DBMS","CS406",'400',NULL);



INSERT INTO course_faculty(course_id, faculty_id) VALUES(12, 21);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(12, 22);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(12, 23);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(12, 24);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(12, 25);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(12, 26);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(12, 5);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(12, 6);

INSERT INTO course_faculty(course_id, faculty_id) VALUES(1, 1);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(1, 2);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(1, 3);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(1, 27);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(1, 28);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(1, 29);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(1, 30);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(1, 31);

INSERT INTO course_faculty(course_id, faculty_id) VALUES(2, 1);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(2, 2);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(2, 3);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(2, 32);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(2, 33);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(2, 34);

INSERT INTO course_faculty(course_id, faculty_id) VALUES(3, 15);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(4, 18);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(5, 9);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(6, 4);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(6, 7);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(6, 11);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(7, 4);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(7, 10);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(7, 11);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(8, 19);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(9, 20);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(10, 20);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(11, 8);

INSERT INTO course_faculty(course_id, faculty_id) VALUES(13, 7);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(13, 9);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(14, 8);
INSERT INTO course_faculty(course_id, faculty_id) VALUES(15, 8);











