create database ss12;
use ss12;

create table student
(
    id    int primary key auto_increment,
    name  varchar(255) not null,
    email varchar(255) not null,
    dob   date
);

