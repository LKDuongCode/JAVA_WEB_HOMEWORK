use ss12;

create procedure sp_get_seat_by_bus_id(in p_bus_id int)
begin
    select id, name_seat, price, bus_id, status from seat where bus_id = p_bus_id;
end;


create procedure sp_delete_seat_by_bus_id(in p_bus_id int)
begin
    delete from seat where bus_id = p_bus_id;
end;

delimiter //
create procedure sp_insert_seat(
    in p_name_seat varchar(10),
    in p_price int,
    in p_bus_id int,
    in p_status enum('AVAILABLE', 'BOOKED')
)
begin
    insert into seat(name_seat, price, bus_id, status)
    values (p_name_seat, p_price, p_bus_id, p_status);
end //
delimiter ;

delimiter //
create procedure sp_update_seat(
    in p_id int,
    in p_name_seat varchar(10),
    in p_price int,
    in p_status enum('AVAILABLE', 'BOOKED')
)
begin
    update seat
    set name_seat = if(p_name_seat is null, name_seat, p_name_seat),
        price = if(p_price is null, price, p_price),
        status = if(p_status is null, status, p_status)
    where id = p_id;
end //
delimiter ;

delimiter //
create procedure sp_delete_seat_by_id(
    in p_id int
)
begin
    delete from seat where id = p_id;
end //
delimiter ;



