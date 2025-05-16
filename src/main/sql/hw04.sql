use ss09;

create table seat
(
    id             bigint auto_increment primary key,
    screen_room_id bigint not null,
    price          double default 50000,
    status         enum ('AVAILABLE', 'BOOKED', 'RESERVED'),
    foreign key (screen_room_id) references screen_room (id)
);


create table ticket
(
    id          bigint auto_increment primary key,
    schedule_id bigint not null,
    total_money double,
    created_at  datetime default current_timestamp,

    customer_id int,
    foreign key (customer_id) references customer(id),
    foreign key (schedule_id) references schedule (id)
);

delimiter //

create procedure sp_add_ticket(
    in p_customer_id bigint,
    in p_schedule_id bigint,
    in p_total_money double
)
begin
    insert into ticket (customer_id, schedule_id, total_money, created_at)
    values (p_customer_id, p_schedule_id, p_total_money, now());
end //

delimiter ;


delimiter //

create procedure sp_find_seats_by_screen_room(in p_room_id bigint)
begin
    select * from seat where screen_room_id = p_room_id;
end //

delimiter ;
