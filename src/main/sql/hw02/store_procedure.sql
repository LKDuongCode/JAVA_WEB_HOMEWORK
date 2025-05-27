use ss12;

-- all
delimiter //
create procedure sp_get_all_product ()
begin
    select id, name, price, quantity, image from product;
end //
delimiter ;

-- insert
delimiter //
create procedure sp_insert_product (
    in p_name varchar(255),
    in p_price decimal(10,2),
    in p_quantity int,
    in p_image text
)
begin
    insert into product (name, price, quantity, image)
        values (p_name,p_price, p_quantity,p_image);
end //
delimiter ;

-- edit
delimiter //
create procedure sp_update_product (
    in p_id int,
    in p_name varchar(255),
    in p_price decimal(10,2),
    in p_quantity int,
    in p_image text
)
begin
    update product
        set name = if(p_name is null ,name,p_name),
            price = if(p_price is null,price,p_price),
            quantity = if(p_quantity is null,quantity,p_quantity),
            image = if(p_image is null,image,p_image)
    where id = p_id;
end //
delimiter ;

-- delete
delimiter //
create procedure sp_delete_product (
    in p_id int
)
begin
    delete from product where id = p_id;
end //
delimiter ;

-- find by id
delimiter //
create procedure sp_find_product_by_id (
    in p_id int
)
begin
    select id, name, price, quantity, image from product where id = p_id;
end //
delimiter ;

