create database ss10;
use ss10;

create table account (
    id int primary key auto_increment,
    username varchar(100) unique ,
    password varchar(100),
    email varchar(255) unique
);


-- hw06
create table file_uploaded (
    id int primary key auto_increment,
    url text,
    des text
);