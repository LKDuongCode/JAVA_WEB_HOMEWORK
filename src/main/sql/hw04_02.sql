use ss16;

create table bus_trip
(
    id              int primary key auto_increment,
    departure_point varchar(255) not null,
    destination     varchar(255) not null,
    departure_time  datetime     not null,
    arrival_time    datetime     not null,
    bus_id          int          not null,
    seats_available int          not null,
    image           text         not null,

    foreign key (bus_id) references bus (id)
);


delimiter //

create procedure sp_get_all_bus_trip()
begin
    select id, departure_point, destination, departure_time, arrival_time, bus_id, seats_available, image
    from bus_trip;
end //

delimiter ;


delimiter //

create procedure sp_insert_bus_trip(
    in p_departure_point varchar(255),
    in p_destination varchar(255),
    in p_departure_time datetime,
    in p_arrival_time datetime,
    in p_bus_id int,
    in p_seats_available int,
    in p_image text
)
begin
    insert into bus_trip (departure_point, destination, departure_time, arrival_time, bus_id, seats_available, image)
    values (p_departure_point, p_destination, p_departure_time, p_arrival_time, p_bus_id, p_seats_available, p_image);
end //

delimiter ;



delimiter //

create procedure sp_update_bus_trip(
    in p_id int,
    in p_departure_point varchar(255),
    in p_destination varchar(255),
    in p_departure_time datetime,
    in p_arrival_time datetime,
    in p_bus_id int,
    in p_seats_available int,
    in p_image text
)
begin
    update bus_trip
    set departure_point  = ifnull(p_departure_point, departure_point),
        destination      = ifnull(p_destination, destination),
        departure_time   = ifnull(p_departure_time, departure_time),
        arrival_time     = ifnull(p_arrival_time, arrival_time),
        bus_id           = ifnull(p_bus_id, bus_id),
        seats_available  = ifnull(p_seats_available, seats_available),
        image            = ifnull(p_image, image)
    where id = p_id;
end //

delimiter ;


delimiter //

create procedure sp_delete_bus_trip(
    in p_id int
)
begin
    delete from bus_trip where id = p_id;
end //

delimiter ;


delimiter //

create procedure sp_get_bus_trip_by_id(
    in p_id int
)
begin
    select id, departure_point, destination, departure_time, arrival_time, bus_id, seats_available, image
    from bus_trip
    where id = p_id;
end //

delimiter ;
