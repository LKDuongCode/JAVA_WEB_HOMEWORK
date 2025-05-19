use ss10;

delimiter //
create procedure sp_insert_file_info (
    in p_url text,
    in p_des text
)
begin
    insert into file_uploaded (url, des)
        values (p_url,p_des);
end //
delimiter //;