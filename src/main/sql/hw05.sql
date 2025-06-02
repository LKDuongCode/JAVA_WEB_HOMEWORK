use ss16;

create table ticket
(
    id             int primary key auto_increment,
    user_id        int            not null,
    trip_bus_id    int            not null,
    list_seat      varchar(255)   not null,
    total_money    decimal(10, 2) not null,
    departure_date date           not null
);


delimiter //

create procedure sp_insert_ticket(
    in p_user_id int,
    in p_trip_bus_id int,
    in p_list_seat varchar(255),
    in p_total_money decimal(10,2),
    in p_departure_date date
)
begin
    insert into ticket(user_id, trip_bus_id, list_seat, total_money, departure_date)
    values (p_user_id, p_trip_bus_id, p_list_seat, p_total_money, p_departure_date);
end //

delimiter ;
