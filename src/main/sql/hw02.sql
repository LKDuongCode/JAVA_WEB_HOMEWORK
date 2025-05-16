use ss09;

create table movie
(
    id          bigint auto_increment primary key,
    title       varchar(255),
    director    varchar(100),
    genre       varchar(50),
    description text,
    duration    int,
    language    varchar(50)
);

insert into movie (title, director, genre, description, duration, language)
values
    ('Inception', 'Christopher Nolan', 'Sci-Fi', 'A mind-bending thriller about dreams within dreams.', 148, 'English'),
    ('Parasite', 'Bong Joon-ho', 'Drama', 'A poor family schemes to work for a wealthy one.', 132, 'Korean'),
    ('Spirited Away', 'Hayao Miyazaki', 'Animation', 'A girl enters the world of spirits to save her parents.', 125, 'Japanese'),
    ('The Godfather', 'Francis Ford Coppola', 'Crime', 'The aging patriarch of an organized crime dynasty transfers control to his reluctant son.', 175, 'English'),
    ('Your Name', 'Makoto Shinkai', 'Romance', 'Two teenagers share a mysterious connection.', 106, 'Japanese');


delimiter //

create procedure sp_get_all_movies()
begin
    select * from movie;
end //

delimiter ;


delimiter //

create procedure sp_find_movie_by_id(in p_id bigint)
begin
    select * from movie where id = p_id;
end //

delimiter ;
