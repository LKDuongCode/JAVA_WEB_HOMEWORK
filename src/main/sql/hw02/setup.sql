use ss12;

create table product (
  id int primary key auto_increment,
  name varchar(255) not null ,
  price decimal(10,2),
  quantity int,
  image text
);


