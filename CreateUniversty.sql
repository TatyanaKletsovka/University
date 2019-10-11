create database `university`;
use `university`;

drop database `university`;

create table `faculty` (
`id` int primary key auto_increment not null,
`name` varchar(60) not null,
`places` smallint not null,
`passing_points` smallint not null
);

create table `subject` (
`id` int primary key auto_increment not null,
`name` varchar(30) not null
);

create table `subjects_in_faculty` (
`id` int primary key auto_increment not null,
`faculty_id` int not null,
`subject_id` int not null,
foreign key(faculty_id) references `faculty`(id),
foreign key(subject_id) references `subject`(id)
);

create table `user` (
`id` int primary key auto_increment not null,
`login` varchar(25) not null,
`password` varchar(25) not null,
`role` enum('admin', 'user') not null default 'user',
`firstName` varchar(25),
`lastName` varchar(25),
`certificate` smallint
);

create table `mark` (
`id` int primary key auto_increment not null,
`user_id` int not null,
`subject_id` int not null,
`value` smallint not null,
foreign key(user_id) references `user`(id),
foreign key(subject_id) references `subject`(id)
);

create table `application` (
`id` int primary key auto_increment not null,
`faculty_id` int not null,
`user_id` int not null,
`status` enum(
	'under_consideration',
    'accepted',
    'rejected') default 'under_consideration',
`date_of_register` datetime default now(),
foreign key(faculty_id) references `faculty`(id),
foreign key(user_id) references `user`(id)
);

create index `name` on `faculty` (name);
create index `name` on `subject` (name);
create index `subject` on `subjects_in_faculty` (faculty_id, subject_id);
create index `login` on `user` (login);
create index `mark` on `mark` (user_id, subject_id);
create index `application` on `application` (id, faculty_id, user_id);

