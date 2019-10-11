use university;

insert into `faculty` (`name`, `places`, `passing_points`) values
('Faculty of Biology', 15, 271),
('Faculty of Geography and Geoinformatics', 10, 214),
('Faculty of Journalism', 7, 311),
('Faculty of History', 14, 254),
('Faculty of Mechanics and Mathematics', 20, 345),
('Faculty of International Relations', 6, 324),
('Faculty of Applied Mathematics and Computer Science', 12, 365),
('Faculty of Radiophysics and Computer Technology', 7, 357),
('Faculty of Sociocultural Communications', 16, 239),
('Faculty of Philosophy and Social Sciences', 17, 251),
('Faculty of Physics', 12, 316),
('Faculty of Philology', 15, 248),
('Chemical faculty', 9, 288),
('Faculty of Economics', 19, 259),
('Faculty of Law', 18, 333)
;

insert into `subject` (`name`) values
('Maths'),
('Native language'),
('Foreign language'),
('History'),
('Physics'),
('Chemistry'),
('Biology'),
('Geography'),
('Literature'),
('Computer science')
;

insert into `subjects_in_faculty`(`faculty_id`, `subject_id`) values
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

insert into `user` (`login`, `password`, `role`) values
('Admin', 'root', 'admin')
;

insert into `user` (`login`, `password`, `firstName`, `lastName`, `certificate`) values
('Ringo', 'root', 'Tanya', 'Kletsovka', '83'),
('Lisa', 'root', 'Lisa', 'Sokolova', '91'),
('Alexander', 'root', 'Alexander', 'Pavlov', '64')
;

insert into `mark` (`user_id`, `subject_id`, `value`) values
(2, 1, 68), (2, 2, 78), (2, 5, 81),
(3, 2, 53), (3, 6, 49), (3, 7, 45),
(4, 2, 76), (4, 4, 52), (4, 9, 64)
;

insert into `application` (`faculty_id`, `user_id`) values
(11, 2), (13, 3), (9, 4), (5, 2)
;
