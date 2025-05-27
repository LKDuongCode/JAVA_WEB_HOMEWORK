use ss12;

delimiter //
create procedure sp_get_all_bus()
begin
    select id, license_plate, bus_type, row_seat, col_seat, total_seat, image from bus;
end //
delimiter ;


delimiter //
create procedure sp_insert_bus(
    in p_license_plate varchar(20),
    in p_bus_type enum('NORMAL', 'VIP', 'LUXURY'),
    in p_row_seat int,
    in p_col_seat int,
    in p_image text
)
begin
    insert into bus (license_plate, bus_type, row_seat, col_seat, image)
    values (p_license_plate, p_bus_type, p_row_seat, p_col_seat, p_image);
end //
delimiter ;


delimiter //
create procedure sp_update_bus(
    in p_id int,
    in p_license_plate varchar(20),
    in p_bus_type enum('NORMAL', 'VIP', 'LUXURY'),
    in p_row_seat int,
    in p_col_seat int,
    in p_image text
)
begin
    update bus
    set license_plate = if(p_license_plate is null, license_plate, p_license_plate),
        bus_type = if(p_bus_type is null, bus_type, p_bus_type),
        row_seat = if(p_row_seat is null, row_seat, p_row_seat),
        col_seat = if(p_col_seat is null, col_seat, p_col_seat),
        image = if(p_image is null, image, p_image)
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
create procedure sp_find_bus_by_id(
    in p_id int
)
begin
    select id, license_plate, bus_type, row_seat, col_seat, total_seat, image
    from bus
    where id = p_id;
end //
delimiter ;

delimiter //
create procedure sp_find_bus_by_license_plate(
    in p_license_plate varchar(20)
)
begin
    select id, license_plate, bus_type, row_seat, col_seat, total_seat, image
    from bus
    where license_plate = p_license_plate;
end //
delimiter ;
