use ss11;

create table movie
(
    id          int auto_increment primary key,
    title       varchar(100) not null,
    director    varchar(50)  not null,
    releaseDate date,
    genre       varchar(30)  not null,
    poster      text
);


delimiter //
create procedure sp_add_movie(
    in p_title varchar(100),
    in p_director varchar(50),
    in p_releaseDate date,
    in p_genre varchar(30),
    in p_poster text
)
begin
    insert into movie(title, director, releaseDate, genre, poster)
    values (p_title, p_director, p_releaseDate, p_genre, p_poster);
end //
delimiter ;



delimiter //
create procedure sp_update_movie(
    in p_id int,
    in p_title varchar(100),
    in p_director varchar(50),
    in p_releaseDate date,
    in p_genre varchar(30),
    in p_poster text
)
begin
    update movie
    set title = p_title,
        director = p_director,
        releaseDate = p_releaseDate,
        genre = p_genre,
        poster = p_poster
    where id = p_id;
end //
delimiter ;



delimiter //
create procedure sp_delete_movie(in p_id int)
begin
    delete from movie where id = p_id;
end //
delimiter ;

delimiter //
create procedure sp_get_all_movies()
begin
    select * from movie order by id desc;
end //
delimiter ;


delimiter //
create procedure sp_get_movie_by_id(in p_id int)
begin
    select * from movie where id = p_id;
end //
delimiter ;
