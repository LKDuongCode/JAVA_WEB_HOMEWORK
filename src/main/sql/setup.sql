
create database ss09;
use ss09;

create table customer (
  id int auto_increment primary key ,
  username varchar(100) unique ,
  phone varchar(12) unique ,
  email varchar(255) unique ,
  address varchar(255),
  gender enum('MALE','FEMALE','OTHER'),
    password varchar(100)
);

insert into customer (username, phone, email, address, gender, password)
values
    ('minhthanh', '0912345678', 'minhthanh@gmail.com', '123 Lê Lợi, Quận 1, TP.HCM', 'MALE', '123456'),
    ('hoamai99', '0987654321', 'hoamai99@yahoo.com', '456 Nguyễn Trãi, Hà Nội', 'FEMALE', 'matkhau123'),
    ('quangtruong', '0909090909', 'truongquang@outlook.com', '789 Trần Hưng Đạo, Đà Nẵng', 'MALE', 'abcxyz'),
    ('linhnguyen', '0933222111', 'linh.nguyen@example.com', '12 Phạm Văn Đồng, Huế', 'OTHER', '123qwe'),
    ('anhduong', '0955111222', 'anhduong@protonmail.com', '88 Tôn Đức Thắng, Cần Thơ', 'FEMALE', 'sunshine2024');
