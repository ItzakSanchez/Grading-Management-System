USE grade_manager_system;
DELETE FROM TBL_COURSE;
ALTER TABLE TBL_COURSE AUTO_INCREMENT = 1;
INSERT INTO TBL_COURSE(COURSE_NAME,COURSE_DESCRIPTION) VALUES
('Introduction to Java', 'A comprehensive introduction to Java programming language, covering basic concepts and advanced topics.'),
('Database Management Systems', 'An in-depth course on database design, SQL, and the principles of relational databases.'),
('Web Development with Spring Boot', 'A practical guide to developing web applications using Spring Boot and related technologies.'),
('Machine Learning Fundamentals', 'An introductory course on machine learning concepts, algorithms, and applications.');

DELETE FROM TBL_SYSTEM_USER;
ALTER TABLE TBL_SYSTEM_USER AUTO_INCREMENT = 1;
INSERT INTO TBL_SYSTEM_USER (FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, ROLE) VALUES
('Alice', 'Johnson', 'alice.johnson@example.com', 'password123', 'STUDENT'),
('Bob', 'Smith', 'bob.smith@example.com', 'password123', 'STUDENT'),
('Charlie', 'Brown', 'charlie.brown@example.com', 'password123', 'STUDENT'),
('Diana', 'Prince', 'diana.prince@example.com', 'password123', 'STUDENT'),
('Ethan', 'Hunt', 'ethan.hunt@example.com', 'password123', 'STUDENT'),
('Fiona', 'Shrek', 'fiona.shrek@example.com', 'password123', 'STUDENT'),
('George', 'Clinton', 'george.clinton@example.com', 'password123', 'STUDENT'),
('Hannah', 'Montana', 'hannah.montana@example.com', 'password123', 'TEACHER'),
('Ian', 'Fleming', 'ian.fleming@example.com', 'password123', 'TEACHER'),
('Judy', 'Hopps', 'judy.hopps@example.com', 'password123', 'TEACHER');

DELETE FROM TBL_STUDENT;
ALTER TABLE TBL_STUDENT AUTO_INCREMENT = 1;
INSERT INTO TBL_STUDENT (ID_SYSTEM_USER) VALUES
(1),(2),(3),(4),(5),(6),(7);

DELETE FROM TBL_TEACHER;
ALTER TABLE TBL_TEACHER AUTO_INCREMENT = 1;
INSERT INTO TBL_TEACHER (ID_SYSTEM_USER) VALUES
(8),(9),(10);

DELETE FROM TBL_GROUP;
ALTER TABLE TBL_GROUP AUTO_INCREMENT = 1;
INSERT INTO TBL_GROUP (ID_COURSE, ID_TEACHER, GROUP_SEMESTER, GROUP_YEAR) VALUES
(1,1,1,2024),
(1,2,1,2024),
(2,1,1,2024),
(2,2,1,2024),
(3,2,1,2024),
(3,3,1,2024),
(3,1,1,2024),
(4,4,1,2024);

DELETE FROM TBL_INSCRIPTIONS;
ALTER TABLE TBL_INSCRIPTIONS AUTO_INCREMENT = 1;
INSERT INTO TBL_INSCRIPTIONS (ID_GROUP, ID_STUDENT, SCORE) VALUES
(1,1,0),(1,2,0),(1,3,0),(1,4,0),(1,5,0),(1,6,0),(1,7,0),
(2,1,0),(2,3,0),(2,4,0),(2,5,0),(2,6,0),(2,7,0),
(3,1,0),(3,2,0),(3,3,0),(3,4,0),(3,5,0);

