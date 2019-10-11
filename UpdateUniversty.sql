use university;

select * from `faculty`;
SELECT faculty.id, faculty.name, places, passing_points, subject.name FROM faculty JOIN subjects_in_faculty
 ON faculty.id = subjects_in_faculty.faculty_id JOIN subject ON subjects_in_faculty.subject_id = subject.id;

SELECT faculty.id, faculty.name, places, passing_points, subject.id, subject.name FROM faculty JOIN subjects_in_faculty
 ON faculty.id = subjects_in_faculty.faculty_id JOIN subject ON subjects_in_faculty.subject_id = subject.id;

SELECT faculty.id, faculty.name, places, passing_points, subject.name FROM faculty
JOIN subjects_in_faculty ON faculty.id = subjects_in_faculty.faculty_id
JOIN subject ON subjects_in_faculty.subject_id = subject.id WHERE faculty.id = 3;

select * from `subject`;

select * from `subjects_in_faculty`;

select * from `user`;
SELECT id, login, password, role FROM user WHERE login = 'Admin' and password = 'root';
UPDATE user SET certificate = 84 WHERE user.id = 2;

select * from `mark`;

select * from `application`;
SELECT application.id, faculty.id, faculty.name, places, passing_points,
user.id, user.login, user.firstName, user.lastName, user.certificate, subject.name, mark.value, status, date_of_register
FROM application
JOIN faculty ON application.faculty_id = faculty.id

JOIN subjects_in_faculty ON faculty.id = subjects_in_faculty.faculty_id
JOIN subject ON subjects_in_faculty.subject_id = subject.id

JOIN user ON application.user_id = user.id
JOIN mark ON mark.user_id = user.id
AND mark.subject_id = subject.id
;

SELECT application.id, faculty.name, places, passing_points, user.login, user.firstName, user.lastName,
user.certificate, subject.name, mark.value, status, date_of_register FROM application
JOIN faculty ON application.faculty_id = faculty.id
JOIN subjects_in_faculty ON faculty.id = subjects_in_faculty.faculty_id
JOIN subject ON subjects_in_faculty.subject_id = subject.id
JOIN user ON application.user_id = user.id
JOIN mark ON mark.user_id = user.id
AND mark.subject_id = subject.id;

SELECT mark.id, value, user.id, subject.id FROM mark
JOIN user ON mark.user_id = user.id
JOIN subject ON mark.subject_id = subject.id
WHERE user.id = 2 and subject.id = 2;

DELETE FROM application where id=4;

UPDATE application SET status = 'ACCEPTED' WHERE application.id = 2;