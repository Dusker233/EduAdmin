use ddl;

create table user (
    user_id varchar(20) primary key,
    user_name nvarchar(10) not null,
    user_password varchar(20) not null,
    user_type nvarchar(10) not null
);

create table course (
    course_id varchar(20) primary key,
    course_name nvarchar(20) not null,
    course_teacher_id varchar(20) not null
);

create table classroom (
    classroom_id varchar(20),
    classroom_name nvarchar(20) not null,
    free_time varchar(20),
    free_now int default 1,
    primary key (classroom_id, free_time)
);

create table final_course (
    course_id varchar(20) primary key,
    course_name nvarchar(20) not null,
    course_teacher_id varchar(20) not null,
    classroom_id varchar(20) not null,
    classroom_name nvarchar(20) not null,
    free_time varchar(20) not null
);