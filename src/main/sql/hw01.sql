use ss09;

delimiter //

create procedure sp_find_customer_by_username(in p_username varchar(100))
begin
    select *
    from customer
    where username = p_username;
end //

delimiter ;
