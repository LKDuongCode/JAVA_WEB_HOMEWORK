use ss09;

create table screen_room
(
    id               bigint auto_increment primary key,
    screen_room_name varchar(100),
    total_seat       int
);


create table schedule
(
    id              bigint auto_increment primary key,
    movie_id        bigint,
    show_time       datetime,
    screen_room_id  bigint,
    available_seats int,
    format          enum ('TWO_D', 'THREE_D'),

    foreign key (movie_id) references movie(id),
    foreign key (screen_room_id) references screen_room(id)
);


insert into screen_room (screen_room_name, total_seat)
values
    ('Phòng Chiếu 1', 60),
    ('Phòng Chiếu 2', 50),
    ('Phòng Chiếu 3', 80),
    ('Phòng Chiếu 4', 40),
    ('Phòng VIP', 30);


insert into schedule (movie_id, show_time, screen_room_id, available_seats, format)
values

(1, '2025-05-20 18:30:00', 1, 58, 'TWO_D'),
(1, '2025-05-20 21:00:00', 2, 45, 'THREE_D'),


(2, '2025-05-21 19:00:00', 3, 75, 'TWO_D'),


(3, '2025-05-21 16:15:00', 4, 39, 'TWO_D'),


(4, '2025-05-22 20:00:00', 1, 59, 'TWO_D'),


(5, '2025-05-22 17:45:00', 5, 28, 'THREE_D'),
(5, '2025-05-23 14:00:00', 5, 25, 'TWO_D');

-- sp---------------------------------------------------
delimiter //

create procedure sp_find_schedules_by_movie(in p_movie_id bigint)
begin
    select * from schedule where movie_id = p_movie_id;
end //

delimiter ;

delimiter //

create procedure sp_find_all_screen_rooms()
begin
    select * from screen_room;
end //

create procedure sp_find_screen_room_by_id(in p_id bigint)
begin
    select * from screen_room where id = p_id;
end //

delimiter ;


delimiter //

create procedure sp_find_schedule_by_id(in p_id bigint)
begin
    select * from schedule where id = p_id;
end //

delimiter ;



