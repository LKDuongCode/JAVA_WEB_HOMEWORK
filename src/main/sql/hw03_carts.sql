use ss06;

create table products
(
    id        int primary key auto_increment,
    name      varchar(255)   not null,
    price     decimal(10, 2) not null,
    image_url varchar(255)
);

create table product_carts
(
    id         int primary key auto_increment,
    user_id    int not null,
    product_id int not null,
    quantity   int not null
);


insert into products (name, price, image_url)
values ('iPhone 15', 24999.00, 'https://smartviets.com/upload/iPHONE15/iPHONE15PR-PRM/15PRM-black_titanium.jpg'),
       ('Macbook Air', 32999.00,
        'https://maconline.vn/uploads/macbook/macbook-air/macbook-air-2020/air-2020-silver-5.jpg'),
       ('AirPods Pro', 5999.00,
        'https://cdn2.fptshop.com.vn/unsafe/564x0/filters:quality(80)/Uploads/images/2015/Tin-Tuc/AnhNQ/02/Mo-ta-san-pham-tai-nghe-khong-day-apple-airpods-pro-1.JPG');

delimiter //

create procedure sp_get_all_products()
begin
    select * from products;
end //

delimiter ;


delimiter //

create procedure sp_get_cart_by_user(
    in p_user_id int
)
begin
    select * from product_carts where user_id = p_user_id;
end //

delimiter ;


delimiter //

create procedure add_to_cart (
    in p_user_id int,
    in p_product_id int,
    in p_quantity int
)
begin
    insert into product_carts (user_id, product_id, quantity)
    values (p_user_id, p_product_id, p_quantity);
end //

delimiter ;

delimiter //

create procedure remove_from_cart (
    in p_cart_id int
)
begin
    delete from product_carts where id = p_cart_id;
end //

delimiter ;

