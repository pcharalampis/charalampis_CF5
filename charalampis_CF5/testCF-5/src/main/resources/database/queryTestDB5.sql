-- | CREATION |

-- Creating and using testdb5.
-- -----------------------------
CREATE DATABASE testdb5;
USE testdb5;
-- -----------------------------

-- | TABLES |

-- Tables created by Hibernate
-- -----------------------------
-- |							|
-- |							|
-- |							|
-- -----------------------------

-- | CHECKING TABLES OK |

-- Test commands to ensure tables created correctly.
SELECT * FROM users;
SELECT * FROM roles;
SELECT * FROM students;
SELECT * FROM teachers;
SELECT * FROM courses;
SELECT * FROM students_courses;
SELECT * FROM teachers_courses;
SELECT * FROM users_roles;
-- More test commands
SELECT * FROM users WHERE id IN (1, 2, 3);
SELECT * FROM roles WHERE id IN (1, 2, 3);

SELECT * FROM students WHERE id IN (31, 32, 33, 34, 35);
SELECT * FROM courses WHERE id IN (1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

-- Just checking tables here
SHOW CREATE TABLE users_roles;
SHOW CREATE TABLE students_courses;

DESCRIBE students_courses;
-- More test commands
-- because sometimes I had to drop table and recreate it.
DROP TABLE users;
DROP TABLE users_roles;
DROP TABLE roles;

-- More test commands
-- because sometiimes I had to delete data from a table and insert it again.
DELETE FROM users;
DELETE FROM roles;
DELETE FROM students;
DELETE FROM courses;
DELETE FROM users_roles;
-- -----------------------------

-- | ALTERATIONS |

-- Dropping redundant foreign keys (if any).
-- because I faced this situation and I had to manually remove 2 extra FKs from each table
ALTER TABLE students_courses
DROP FOREIGN KEY FKcc42107lsifo5rjyjlhdu6i6u,
DROP FOREIGN KEY FKr16q8s9m6kr7xupi4fw9iqpgl;

ALTER TABLE users_roles 
DROP FOREIGN KEY FK2o0jvgh89lemvvo17cbqvdxaa,
DROP FOREIGN KEY FKj6m8fwv7oqv74fcehir1a9ffy;

ALTER TABLE students_courses DROP FOREIGN KEY student_id;
ALTER TABLE students_courses DROP FOREIGN KEY course_id;

ALTER TABLE students_courses
ADD CONSTRAINT fk_students_courses_student_id FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT fk_students_courses_course_id FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE ON UPDATE CASCADE;


-- Ensuring correct foreign keys:
-- 1. for the "students_courses" I just need these:
ALTER TABLE students_courses
ADD CONSTRAINT FK_student FOREIGN KEY (student_id) REFERENCES students(id),
ADD CONSTRAINT FK_course FOREIGN KEY (course_id) REFERENCES courses(id);
-- 2. for the "users_roles" I need to ensure that its FKs reference the correct fields in the correct tables.
ALTER TABLE users_roles
ADD CONSTRAINT FK_users_roles_user_id
FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE users_roles
ADD CONSTRAINT FK_users_roles_role_id
FOREIGN KEY (role_id) REFERENCES roles(id);
-- -----------------------------

-- | TEST DATA |

-- Adding 3 test users
INSERT INTO users (email, first_name, last_name, password, username) VALUES
('ani@starmail.com', 'anakin', 'skywalker', 123 , 'anakin'),
('obi@starmail.com', 'obi wan', 'kenobi', 1234, 'obiwan'),
('palpi@starmail.com', 'sheev', 'palpatine', 12345, 'palpatine');
-- *** in the login form, these users can connect, but not because they exist in the database.
-- *** the same users with the same credentials are created in the SecurityConfig class.

-- Adding 3 roles
INSERT INTO roles (role_name) VALUES
('STUDENT'),
('TEACHER'),
('ADMIN');

-- Assigning roles to test users
INSERT INTO users_roles (user_id, role_id) VALUES 
(1, 1),
(2, 2),
(3, 3);
-- *** anakin is student, obiwan is teacher, palpatine is admin

-- Adding 10 random courses
INSERT INTO courses (attend_hrs_max, attend_hrs_min, description, name) VALUES 
(30, 20, 'Introduction to programming with Python. Covers basics of algorithms and data structures.', 'Python - Intro'),
(40, 30, 'Study of fundamental data structures and their algorithms, including lists, stacks, queues, trees, and graphs.', 'Data Structures and Algorithms'),
(25, 15, 'An introductory course on databases, focusing on SQL and relational database design.', 'Database Systems'),
(35, 25, 'Understanding the principles of computer networks, including the internet, LANs, and protocols.', 'Computer Networks'),
(45, 35, 'Basics of operating system principles, including processes, memory management, and file systems.', 'Operating Systems'),
(20, 15, 'Introduction to computer hardware and assembly language programming.', 'Computer Organization'),
(50, 40, 'Comprehensive course on software engineering principles, including project management and software development life cycles.', 'Software Engineering'),
(25, 20, 'Basic concepts of artificial intelligence and machine learning.', 'Artificial Intelligence'),
(30, 25, 'Study of security principles, cryptography, and network security protocols.', 'Cybersecurity Fundamentals'),
(20, 15, 'An introduction to web development using HTML, CSS, and JavaScript.', 'Web Development Basics');
-- *** courses related to Computer Science

-- Adding 10 random students
INSERT INTO students (birth_date, email, first_name, last_name) VALUES
('1990-01-15', 'john.doe@example.com', 'John', 'Doe'),
('1992-03-22', 'jane.smith@example.com', 'Jane', 'Smith'),
('1988-07-09', 'michael.johnson@example.com', 'Michael', 'Johnson'),
('1995-11-30', 'emily.davis@example.com', 'Emily', 'Davis'),
('1991-05-16', 'daniel.brown@example.com', 'Daniel', 'Brown'),
('1993-08-25', 'linda.wilson@example.com', 'Linda', 'Wilson'),
('1989-12-12', 'william.taylor@example.com', 'William', 'Taylor'),
('1994-06-03', 'sarah.moore@example.com', 'Sarah', 'Moore'),
('1990-09-18', 'james.martin@example.com', 'James', 'Martin'),
('1996-02-20', 'mary.jackson@example.com', 'Mary', 'Jackson');
-- *** however, this isn't the correct approach, see comments below.

-- Assigning courses to students together with hours attended.
INSERT INTO students_courses (attend_hrs, course_id, student_id) VALUES
(10, 1, 41),
(15, 2, 41),
(8, 3, 41),
(12, 4, 41),
(20, 2, 42),
(18, 3, 42),
(22, 5, 42),
(25, 6, 42),
(14, 1, 43),
(17, 4, 43),
(19, 5, 43),
(11, 7, 43),
(13, 8, 43),
(9, 2, 44),
(10, 3, 44),
(15, 6, 44),
(12, 9, 44),
(16, 10, 43),
(20, 1, 45),
(18, 3, 45),
(14, 7, 45),
(19, 8, 45),
(21, 9, 45);

-- Adding 10 teachers
INSERT INTO teachers (email, first_name, last_name) VALUES
('alice.johnson@example.com', 'Alice', 'Johnson'),
('bob.brown@example.com', 'Bob', 'Brown'),
('charlie.davis@example.com', 'Charlie', 'Davis'),
('david.wilson@example.com', 'David', 'Wilson'),
('emily.moore@example.com', 'Emily', 'Moore'),
('frank.taylor@example.com', 'Frank', 'Taylor'),
('grace.anderson@example.com', 'Grace', 'Anderson'),
('henry.thomas@example.com', 'Henry', 'Thomas'),
('ivy.jackson@example.com', 'Ivy', 'Jackson'),
('jack.white@example.com', 'Jack', 'White');

-- Assigning courses to teachers together with hours teached and number of students.
INSERT INTO teachers_courses (num_of_studs, teach_hrs, course_id, teacher_id) VALUES 
(60, 22, 2, 2),
(45, 28, 3, 3),
(50, 27, 4, 4),
(40, 24, 5, 5),
(65, 21, 6, 6),
(55, 29, 7, 7),
(70, 23, 8, 8);
-- -----------------------------

-- | COMMENTS |

-- 1. Tables are created by Hibernate.
-- 2. Using "SELECTs ..." to ensure that the correct structure has been created.
-- 3. Using "ALTERs ..." to fix some mistakes that occured along the way.
-- 4. Using "INSERTs ..." to fill in some test data in the tables.
-- 5. Database does not have the correct structure, because no time :-(
-- 6. Student IS A User and Teacher IS A User, or they should be.
-- 7. Intended functionality has not been achieved.





