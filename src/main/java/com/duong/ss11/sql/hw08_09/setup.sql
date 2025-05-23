create database ss11;
use ss11;

create table category (
    id int primary key auto_increment,
    name varchar(50) unique not null ,
    status enum ('ACTIVE','INACTIVE')
);