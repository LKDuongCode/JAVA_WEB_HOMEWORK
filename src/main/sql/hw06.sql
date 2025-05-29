use ss14;

create table users
(
    id       int primary key auto_increment,
    username varchar(100) not null,
    password varchar(100) not null,
    email    varchar(255) not null
);

