create database software;
use software;

-- The cloud database's name is "ddl". --

create table user (
    user_id varchar(20) primary key,
    user_name nvarchar(10) not null,
    user_password varchar(20) not null,
    user_type nvarchar(10) not null
);

create table course (
    course_id varchar(20) primary key,
    course_name nvarchar(20) not null,
    course_teacher_name nvarchar(10) not null
);

create table classroom (
    classroom_id varchar(20),
    classroom_name nvarchar(20) not null,
    empty_time varchar(20),
    primary key (classroom_id, empty_time)
);