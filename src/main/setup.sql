create database ss19;
use ss19;

#account
insert into account (id, username, email, phone, password, status)
values (1, 'nguyenvana', 'nguyenvana@gmail.com', '0912345678', '123456', 'ACTIVE'),
       (2, 'tranthib', 'tranthib@gmail.com', '0387654321', '123456', 'ACTIVE'),
       (3, 'leminhc', 'leminhc@gmail.com', '0701234567', '123456', 'INACTIVE'),
       (4, 'phamthid', 'phamthid@gmail.com', '0855567890', '123456', 'ACTIVE'),
       (5, 'doanquange', 'doanquange@gmail.com', '0961122334', '123456', 'INACTIVE'),
       (6, 'buiducf', 'buiducf@gmail.com', '0398877665', '123456', 'ACTIVE'),
       (7, 'hoangthig', 'hoangthig@gmail.com', '0345123987', '123456', 'ACTIVE'),
       (8, 'truongvanh', 'truongvanh@gmail.com', '0589988776', '123456', 'INACTIVE'),
       (9, 'ngothii', 'ngothii@gmail.com', '0371239876', '123456', 'ACTIVE'),
       (10, 'vutuanj', 'vutuanj@gmail.com', '0909123456', '123456', 'ACTIVE');

#movies
insert into movie (title, director, releaseYear, genre, duration, language, poster, status)
values ('Avengers: Endgame', 'Anthony Russo, Joe Russo', 2019, 'Superhero, Action', 181, 'English',
        'https://brandsketer.com/upload/category/chien-dich-marketing-khung-cua-avengers-endgame-va-cac-thuong-hieu-lien-ket-1563158033.jpg',
        true),
       ('Inception', 'Christopher Nolan', 2010, 'Sci-Fi, Thriller', 148, 'English',
        'https://brandsketer.com/upload/category/chien-dich-marketing-khung-cua-avengers-endgame-va-cac-thuong-hieu-lien-ket-1563158033.jpg',
        true),
       ('Parasite', 'Bong Joon-ho', 2019, 'Drama, Thriller', 132, 'Korean',
        'https://brandsketer.com/upload/category/chien-dich-marketing-khung-cua-avengers-endgame-va-cac-thuong-hieu-lien-ket-1563158033.jpg',
        true),
       ('Interstellar', 'Christopher Nolan', 2014, 'Sci-Fi, Drama', 169, 'English',
        'https://brandsketer.com/upload/category/chien-dich-marketing-khung-cua-avengers-endgame-va-cac-thuong-hieu-lien-ket-1563158033.jpg',
        true),
       ('The Dark Knight', 'Christopher Nolan', 2008, 'Action, Crime', 152, 'English',
        'https://brandsketer.com/upload/category/chien-dich-marketing-khung-cua-avengers-endgame-va-cac-thuong-hieu-lien-ket-1563158033.jpg',
        true),
       ('Your Name', 'Makoto Shinkai', 2016, 'Romance, Fantasy', 106, 'Japanese',
        'https://brandsketer.com/upload/category/chien-dich-marketing-khung-cua-avengers-endgame-va-cac-thuong-hieu-lien-ket-1563158033.jpg',
        true),
       ('Coco', 'Lee Unkrich', 2017, 'Animation, Adventure', 105, 'English',
        'https://brandsketer.com/upload/category/chien-dich-marketing-khung-cua-avengers-endgame-va-cac-thuong-hieu-lien-ket-1563158033.jpg',
        true),
       ('The Matrix', 'The Wachowskis', 1999, 'Action, Sci-Fi', 136, 'English',
        'https://brandsketer.com/upload/category/chien-dich-marketing-khung-cua-avengers-endgame-va-cac-thuong-hieu-lien-ket-1563158033.jpg',
        true),
       ('Spirited Away', 'Hayao Miyazaki', 2001, 'Animation, Fantasy', 125, 'Japanese',
        'https://brandsketer.com/upload/category/chien-dich-marketing-khung-cua-avengers-endgame-va-cac-thuong-hieu-lien-ket-1563158033.jpg',
        true),
       ('Fight Club', 'David Fincher', 1999, 'Drama, Psychological', 139, 'English',
        'https://brandsketer.com/upload/category/chien-dich-marketing-khung-cua-avengers-endgame-va-cac-thuong-hieu-lien-ket-1563158033.jpg',
        true);


#theater
insert into theater (theaterName, address, numberScreenRoom, status)
values ('CGV Aeon Mall Tân Phú', '30 Bờ Bao Tân Thắng, Tân Phú, TP.HCM', 7, true),
       ('BHD Star Bitexco', 'L3 Bitexco Tower, Quận 1, TP.HCM', 6, true),
       ('Lotte Cinema Gò Vấp', '242 Nguyễn Văn Lượng, Gò Vấp, TP.HCM', 5, true),
       ('Galaxy Nguyễn Du', '116 Nguyễn Du, Quận 1, TP.HCM', 4, true),
       ('Mega GS Cao Thắng', '19 Cao Thắng, Quận 3, TP.HCM', 6, true),
       ('CGV Vincom Thủ Đức', '216 Võ Văn Ngân, Thủ Đức, TP.HCM', 8, true),
       ('Cinestar Quốc Thanh', '271 Nguyễn Trãi, Quận 1, TP.HCM', 3, true),
       ('Lotte Cinema Nam Sài Gòn', '469 Nguyễn Hữu Thọ, Quận 7, TP.HCM', 6, true),
       ('BHD Star Thảo Điền', 'Vincom Mega Mall, Quận 2, TP.HCM', 5, true),
       ('CGV Hùng Vương Plaza', '126 Hùng Vương, Quận 5, TP.HCM', 7, true);

#screenroom

insert into screen_room (roomName, capacity, screenType, status, theater_id)
values ('Phòng 1 - CGV Tân Phú', 25, '2D', true, 1),
       ('Phòng 2 - CGV Tân Phú', 30, '3D', true, 1),
       ('Phòng 1 - BHD Bitexco', 20, '2D', true, 2),
       ('Phòng 2 - BHD Bitexco', 24, 'IMAX', true, 2),
       ('Phòng 1 - Lotte Gò Vấp', 28, '2D', true, 3),
       ('Phòng 2 - Lotte Gò Vấp', 30, '3D', true, 3),
       ('Phòng 1 - Galaxy ND', 22, '2D', true, 4),
       ('Phòng 1 - Mega GS', 27, '3D', true, 5),
       ('Phòng 2 - Mega GS', 30, 'IMAX', true, 5),
       ('Phòng 3 - Mega GS', 20, '2D', true, 5);

-- Ghế cho Phòng id = 1, capacity = 25
insert into seat (seatName, status, screen_room_id)
values ('A1', true, 1),
       ('A2', true, 1),
       ('A3', true, 1),
       ('A4', true, 1),
       ('A5', true, 1),
       ('B1', true, 1),
       ('B2', true, 1),
       ('B3', true, 1),
       ('B4', true, 1),
       ('B5', true, 1),
       ('C1', true, 1),
       ('C2', true, 1),
       ('C3', true, 1),
       ('C4', true, 1),
       ('C5', true, 1),
       ('D1', true, 1),
       ('D2', true, 1),
       ('D3', true, 1),
       ('D4', true, 1),
       ('D5', true, 1),
       ('E1', true, 1),
       ('E2', true, 1),
       ('E3', true, 1),
       ('E4', true, 1),
       ('E5', true, 1);
