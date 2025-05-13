-- dùng 1 db chung cho tất cả các bài
create database ss06;
use ss06;

-- hw01
create table Book (
    id int primary key auto_increment,
    title varchar(255),
    author varchar(255),
    category varchar(255),
    quantity int check ( quantity > 0 )
);

-- data demo
insert into Book (title, author, category, quantity)
    values ('dev tutorial','duong','technology',100),
           ('how to love yourself','linh','lifestyle',20),
           ('master chef','chi','cooking',200);

delimiter //
create procedure sp_get_all_book ()
begin
    select * from Book;
end //
delimiter //;

delimiter //
create procedure sp_get_book_by_id (
    in in_id int
)
begin
    select * from Book
        where id = in_id;
end //

delimiter //;


delimiter //
create procedure sp_insert_book (
    in in_title varchar(255),
    in in_author varchar(255),
    in in_category varchar(255),
    in in_quantity int
)
begin
    insert into Book (title, author, category, quantity)
        values (in_title, in_author, in_category, in_quantity);
end //
delimiter //;


delimiter //
create procedure sp_update_book (
    in in_id int,
    in in_title varchar(255),
    in in_author varchar(255),
    in in_category varchar(255),
    in in_quantity int
)
begin
    update Book
        set
            title = ifnull(in_title,title),
            author = ifnull(in_author,author),
            category = ifnull(in_category,category),
            quantity = ifnull(in_quantity,quantity)
    where id = in_id;
end //
delimiter //;


delimiter //
create procedure sp_delete_book (
    in in_id int
)
begin
    delete from Book where id = in_id;
end //
delimiter //;


