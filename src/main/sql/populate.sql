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