use ss06;

create table users
(
    id       int primary key auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    email    varchar(255) not null unique,
    phone    varchar(255)
);


delimiter //

create procedure find_user_by_id (
    in in_id int
)
begin
    select * from users where id = in_id;
end //

delimiter ;

delimiter //

create procedure find_user_by_email (
    in in_email varchar(255)
)
begin
    select * from users where email = in_email;
end //

delimiter ;


delimiter //

create procedure register_new_account (
    in p_username varchar(100),
    in p_password varchar(100),
    in p_email varchar(100),
    in p_phone varchar(20)
)
begin
    -- Check if email already exists
    if exists (select 1 from users where email = p_email) then
        signal sqlstate '45000'
            set message_text = 'Email đã được sử dụng';
    else
        insert into users (username, email, phone, password)
        values (p_username, p_email, p_phone, p_password);
    end if;
end //

delimiter ;

