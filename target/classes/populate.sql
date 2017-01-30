INSERT INTO users(id,userid,username,password,enabled) VALUES (1,1,'student','student', TRUE);
INSERT INTO users(id,userid,username,password,enabled) VALUES (2,2,'admin','admin', TRUE);
INSERT INTO users(id,userid,username,password,enabled) VALUES (3,3,'faculty','faculty', TRUE);
INSERT INTO users(id,userid,username,password,enabled) VALUES (4,3,'fac1','fac1', TRUE);


INSERT INTO user_roles (id,userid, authority) VALUES (1,1, 'ROLE_STUDENT');
INSERT INTO user_roles (id,userid, authority) VALUES (2,2, 'ROLE_ADMIN');
INSERT INTO user_roles (id,userid, authority) VALUES (3,3, 'ROLE_FACULTY');