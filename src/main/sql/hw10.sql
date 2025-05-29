use ss14;

create table categories_vi
(
    id           int auto_increment primary key,
    categoryName varchar(255),
    description  text
);

create table categories_en
(
    id           int auto_increment primary key,
    categoryName varchar(255),
    description  text
);


delimiter $$

create procedure sp_insert_category_vi(
    in p_name varchar(255),
    in p_description text
)
begin
    insert into categories_vi (categoryName, description)
    values (p_name, p_description);
end$$

create procedure sp_insert_category_en(
    in p_name varchar(255),
    in p_description text
)
begin
    insert into categories_en (categoryName, description)
    values (p_name, p_description);
end$$

delimiter ;

delimiter $$

create procedure sp_get_all_categories_vi()
begin
    select * from categories_vi;
end$$

create procedure sp_get_all_categories_en()
begin
    select * from categories_en;
end$$

delimiter ;

