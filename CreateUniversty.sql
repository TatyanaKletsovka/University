create database university;
use university;
drop database university;

create table faculty (
id int primary key auto_increment not null,
name varchar(60) not null,
places smallint not null, 
passing_points smallint not null
);

drop table user;
select * from faculty;

create table subject (
id int primary key auto_increment not null,
name enum(
	'maths', 
	'native_language', 
	'foreign_language', 
	'history', 
	'physics', 
	'chemistry',
    'biology',
    'geography',
    'literature',
    'computer_science') not null
);

create table subjects_in_faculty (
id int primary key auto_increment not null,
faculty_id int not null,
subject_id int not null, 
foreign key(faculty_id) references faculty(id), 
foreign key(subject_id) references subject(id)
);

create table user (
id int primary key auto_increment not null,
login varchar(25) not null,
password varchar(25) not null,
role enum('admin', 'user') not null default 'user',
firstName varchar(25) not null,
secondName varchar(25) not null,
certificate smallint
);

create table mark (
id int primary key auto_increment not null,
user_id int not null,
subject_id int not null, 
value smallint not null, 
foreign key(user_id) references user(id), 
foreign key(subject_id) references subject(id)
);

create table application (
id int primary key auto_increment not null,
faculty_id int not null,
user_id int not null,
status enum(
	'under_consideration',
    'not_accepted',
    'accepted') default 'under_consideration',
date_of_register datetime default now(), 
foreign key(faculty_id) references faculty(id),
foreign key(user_id) references user(id) 
);



create index name_1 on student (student_id);