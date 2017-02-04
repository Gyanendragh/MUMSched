INSERT INTO users(id,userid,username,password,enabled) VALUES (1,1,'student','student', TRUE);
INSERT INTO users(id,userid,username,password,enabled) VALUES (2,2,'admin','admin', TRUE);
INSERT INTO users(id,userid,username,password,enabled) VALUES (3,3,'faculty','faculty', TRUE);
INSERT INTO users(id,userid,username,password,enabled) VALUES (4,3,'fac1','fac1', TRUE);


INSERT INTO user_roles (id,userid, authority) VALUES (1,1, 'ROLE_STUDENT');
INSERT INTO user_roles (id,userid, authority) VALUES (2,2, 'ROLE_ADMIN');
INSERT INTO user_roles (id,userid, authority) VALUES (3,3, 'ROLE_FACULTY');


INSERT INTO entry (id, ename, eyear, noOfFppStudents, noOfMppStudents, noOfUsResident) VALUES (1, "January", 2017, 25, 25, 25);
INSERT INTO entry (id, ename, eyear, noOfFppStudents, noOfMppStudents, noOfUsResident) VALUES (2, "April", 2017, 35, 35, 35);
INSERT INTO entry (id, ename, eyear, noOfFppStudents, noOfMppStudents, noOfUsResident) VALUES (3, "August", 2017, 45, 45, 45);
INSERT INTO entry (id, ename, eyear, noOfFppStudents, noOfMppStudents, noOfUsResident) VALUES (4, "October", 2017, 55, 55, 55);


INSERT INTO faculty(facultyId, fullName) VALUES (1, "Lerman");
INSERT INTO faculty(facultyId, fullName) VALUES (2, "Renuka");
INSERT INTO faculty(facultyId, fullName) VALUES (3, "Pormila");
INSERT INTO faculty(facultyId, fullName) VALUES (4, "Bruen");
INSERT INTO faculty(facultyId, fullName) VALUES (5, "Crish");
INSERT INTO faculty(facultyId, fullName) VALUES (6, "James");
INSERT INTO faculty(facultyId, fullName) VALUES (7, "Salek");
INSERT INTO faculty(facultyId, fullName) VALUES (8, "Saad");
INSERT INTO faculty(facultyId, fullName) VALUES (9, "Levi");
INSERT INTO faculty(facultyId, fullName) VALUES (10, "Xing");
INSERT INTO faculty(facultyId, fullName) VALUES (11, "Arrocha");
INSERT INTO faculty(facultyId, fullName) VALUES (12, "Ruby");
INSERT INTO faculty(facultyId, fullName) VALUES (13, "Corozza");
INSERT INTO faculty(facultyId, fullName) VALUES (14, "Rakesh");
INSERT INTO faculty(facultyId, fullName) VALUES (15, "Nolle");
INSERT INTO faculty(facultyId, fullName) VALUES (16, "Maile");
INSERT INTO faculty(facultyId, fullName) VALUES (17, "Frank");
INSERT INTO faculty(facultyId, fullName) VALUES (18, "Khan");
INSERT INTO faculty(facultyId, fullName) VALUES (19, "Guthrie");
INSERT INTO faculty(facultyId, fullName) VALUES (20, "Mukadam");


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
