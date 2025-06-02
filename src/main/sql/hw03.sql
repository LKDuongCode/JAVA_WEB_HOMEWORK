use ss16;

create table bus
(
    id            int primary key auto_increment,
    license_plate varchar(255)                   not null unique,
    type          enum ('VIP','NORMAL','LUXURY') not null,
    row_seat      int                            not null,
    col_seat      int                            not null,
    image         text                           not null
);


insert into bus (license_plate, type, row_seat, col_seat, image) values
('51B-12345', 'NORMAL', 10, 2, 'https://image.made-in-china.com/155f0j00ybTrfwWBEUom/Used-Coach-Old-Car-Normal-Function-City-and-Rural-Passenger-Transport-Bus.webp'),

('72C-67890', 'VIP', 7, 1, 'http://chothuexecuoihanoi.com/wp-content/uploads/2016/05/TownCarB_Exterior-1024x768.jpg'),

('29D-34567', 'LUXURY', 3, 2, 'https://image.made-in-china.com/155f0j00NeyRDIhlZLkp/13-7m-Luxury-Bus-Coach-430HP-Rear-Engine-Recreational-Tourist-Bus-with-screen-Pads-VIP-Seats.webp');


create table seat
(
    id     int primary key auto_increment,
    name   varchar(255)                not null unique,
    price  decimal(10, 2)              not null,
    status enum ('BOOKED','AVAILABLE') not null,
    bus_id int                         not null,
    foreign key (bus_id) references bus (id)
);


delimiter //
create procedure sp_insert_bus(
    in p_license_plate varchar(255),
    in p_type enum ('VIP','NORMAL','LUXURY'),
    in p_row_seat int,
    in p_col_seat int,
    in p_image text
)
begin
    insert into bus (license_plate, type, row_seat, col_seat, image)
    values (p_license_plate, p_type, p_row_seat, p_col_seat, p_image);
end //
delimiter ;

delimiter //
create procedure sp_update_bus(
    in p_id int,
    in p_license_plate varchar(255),
    in p_type enum ('VIP','NORMAL','LUXURY'),
    in p_row_seat int,
    in p_col_seat int,
    in p_image text
)
begin
    update bus
    set license_plate = ifnull(p_license_plate, license_plate),
        type          = ifnull(p_type, type),
        row_seat      = ifnull(p_row_seat, row_seat),
        col_seat      = ifnull(p_col_seat, col_seat),
        image         = ifnull(p_image, image)
    where id = p_id;
end //
delimiter ;


delimiter //
create procedure sp_delete_bus(
    in p_id int
)
begin
    delete from bus where id = p_id;
end //
delimiter ;


delimiter //
create procedure sp_get_all_bus ()
begin
select id, license_plate, type, row_seat, col_seat, image from bus;
end //
delimiter ;


delimiter //

create procedure sp_get_bus_by_id(
    in p_id int
)
begin
    select id, license_plate, type, row_seat, col_seat, image
    from bus
    where id = p_id;
end //

delimiter ;



-- seat ---------------------------------

delimiter //
create procedure sp_insert_seat(
    in p_name varchar(255),
    in p_price decimal(10, 2),
    in p_status enum ('BOOKED','AVAILABLE'),
    in p_bus_id int
)
begin
    insert into seat
        values (p_name,p_price,p_status,p_status,p_bus_id);
end //
delimiter ;

delimiter //
create procedure sp_delete_seat_by_bus_id (
    in p_bus_id int
)
begin
delete from seat where bus_id = p_bus_id;
end //
delimiter ;

delimiter //
create procedure sp_get_last_bus ()
begin
    select id, license_plate, type, row_seat, col_seat, image from bus
    order by id desc
    limit 1;
end //
delimiter ;