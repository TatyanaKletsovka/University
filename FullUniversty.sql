use university;

insert into faculty (name, places, subjects_for_admission, passingPoints) values
('Faculty of Biology', 15, 1, 271), 
('Faculty of Geography and Geoinformatics', 10, 2, 214),
('Faculty of Journalism', 7, 3, 311),
('Faculty of History', 14, 4, 254),
('Faculty of Mechanics and Mathematics', 20, 5, 345),
('Faculty of International Relations', 6, 6, 324),
('Faculty of Applied Mathematics and Computer Science', 12, 7, 365),
('Faculty of Radiophysics and Computer Technology', 7, 8, 357),
('Faculty of Sociocultural Communications', 16, 9, 239),
('Faculty of Philosophy and Social Sciences', 17, 10, 251),
('Faculty of Physics', 12, 11, 316),
('Faculty of Philology', 15, 12, 248),
('Chemical faculty', 9, 13, 288),
('Faculty of Economics', 19, 14, 259),
('Faculty of Law', 18, 15, 333)
;
select * from faculty;

insert into subject (name) values
('maths'), 
('native_language'), 
('foreign_language'), 
('history'), 
('physics'), 
('chemistry'),
('biology'),
('geography'),
('literature'),
('computer_science') 
;
select * from subject;

insert into subjects_in_faculty(faculty_id, subject_id) values 
(1, 7), (1, 2), (1, 1),
(2, 8), (2, 9), (2, 2),
(3, 2), (3, 3), (3, 9),
(4, 4), (4, 2), (4, 9),
(5, 1), (5, 2), (5, 5),
(6, 1), (6, 2), (6, 3),
(7, 1), (7, 2), (7, 10),
(8, 2), (8, 5), (8, 10),
(9, 2), (9, 4), (9, 9),
(10, 2), (10, 4), (10, 9),
(11, 1), (11, 2), (11, 5),
(12, 2), (12, 4), (12, 9),
(13, 6), (13, 7), (13, 2),
(14, 1), (14, 2), (14, 3),
(15, 1), (15, 2), (15, 4)
;
select * from subjects_in_faculty;
select faculty_id as fac_id, subject_id as sub_id from subjects_in_faculty as sab_fac 
join faculty as fac on sab_fac.fac_id=fac.id;

select faculty.name, subject.name from faculty 
LEFT OUTER JOIN subjects_in_faculty
  ON faculty.ID = subjects_in_faculty.faculty_id
LEFT OUTER JOIN groups
  ON subject.ID = subjects_in_faculty.faculty_id
;


insert into register (faculty_id, student_id) values (1, 1);
select * from register;

select * from student;
select * from mark;

