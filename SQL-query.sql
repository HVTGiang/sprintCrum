create database Project_Management;

USE Project_Management;
Create Table Section(
	st_id varchar(10) primary Key,
    st_name nvarchar(20) not null,
    lead_id varchar(10)
);

create table Class(
	c_id varchar(10) Primary Key,
    c_name nvarchar(50) not null,
    c_number int
);

create table Teacher(
	t_id varchar(10) Primary Key,
    t_name nvarchar(50) not null,
    t_gender bit not null,
    t_birth date not null,
    t_email varchar(50) not null,
    t_phone varchar(10) not null,
    t_lead bit not null,
    t_degree nvarchar(10) not null,
    t_position nvarchar(10) not null,
	st_id varchar(10) not null,
    cc_id varchar(10) null
);

Create Table Council(
	cc_id varchar(10) Primary Key,
    lead_id varchar(10),
    cc_num int
);

create table Topic(
	tp_id varchar(10) Primary Key,
    tp_name nvarchar(100) not null,
    tp_detail nvarchar(200),
    st_id varchar(10),
    cc_id varchar(10)
);

create table Student(
	s_id varchar(10) Primary Key,
    s_name nvarchar(50) not null,
    s_gender bit not null,
    s_birth date not null,
    s_phone varchar(10) not null,
    s_email varchar(50) not null,
    s_specialization nvarchar(20) not null,
    lead_id varchar(10),
    c_id varchar(10),
    tp_id varchar(10)
);

Create Table Critic(
	tp_id varchar(10) not null,
    t_id varchar(10) not null
);

Create Table Detail(
	tp_id varchar(10) not null,
    tp_num varchar(10),
    tp_specialization nvarchar(20) not null,
    tp_status bit default 0 not null,
    s_id varchar(10),
    tp_point float
);

Alter Table Section
add constraint fk_leadSection foreign key (lead_id) references Section(st_id);

ALTER Table Teacher
ADD Constraint fk_sectionTeacher Foreign Key (st_id) References Section(st_id),
ADD Constraint fk_councilTeacher Foreign Key(cc_id)references Council(cc_id);

ALTER Table Council
ADD constraint fk_leadCouncil foreign key(lead_id) references Teacher(t_id);

alter table Topic
ADD constraint fk_sectionTopic foreign key(st_id)references Section(st_id),
ADD constraint fk_councilTopic foreign key(cc_id) references Council(cc_id);

alter table Student
add constraint fk_leadStudent foreign key (lead_id)references Student(s_id),
add constraint fk_classStudent foreign key (c_id)references Class(c_id),
add constraint fk_topicStudent foreign key(tp_id) references Topic(tp_id);

Alter Table Critic
add constraint fk_topic foreign key(tp_id) references Topic(tp_id),
add constraint fk_teacher foreign key(t_id) references Teacher(t_id);


Alter Table Detail
add constraint fk_topicDetail foreign key(tp_id) references Topic(tp_id),
add constraint fk_studentDetail foreign key(s_id) references Student(s_id);
