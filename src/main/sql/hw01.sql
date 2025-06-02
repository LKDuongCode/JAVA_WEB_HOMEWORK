use ss16;
create table user
(
    id       int primary key auto_increment,
    username varchar(255) not null,
    email    varchar(255) not null unique,
    password varchar(100) not null,
    role     enum ('USER','ADMIN')      default 'USER',
    status   enum ('ACTIVE','INACTIVE') default 'ACTIVE'
);


delimiter //
create procedure sp_insert_user(
    in p_username varchar(255),
    in p_email varchar(255),
    in p_password varchar(100)
)
begin
    insert into user (username, password, email)
    values (p_username, p_password, p_email);
end //

create procedure sp_find_user_by_email(
    in p_email varchar(255)
)
begin
    select id, username, password, email, role, status from user where email = p_email;
end //

create procedure sp_find_user_by_email_password(
    in p_email varchar(255),
    in p_password varchar(100)
)
begin
    select id, username, password, email, role, status from user where email = p_email and password = p_password;
end //

delimiter ;

