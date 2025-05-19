use ss10;

delimiter //
create procedure sp_insert_user (
    in p_username varchar(100),
    in p_email varchar(255),
    in p_password varchar(100)
)
begin
    insert into account (username, password, email)
        values (p_username,p_password,p_email);
end //
delimiter //;