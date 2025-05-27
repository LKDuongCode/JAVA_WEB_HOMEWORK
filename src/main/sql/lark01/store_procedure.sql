use ss12;

delimiter //
create procedure sp_insert_student_lark(
    in p_id char(5),
    in p_name varchar(200),
    in p_email varchar(255),
    in p_phone varchar(15),
    in p_sex enum('MALE', 'FEMALE', 'OTHER'),
    in p_bod datetime,
    in p_avatar text,
    in p_status enum('ACTIVE', 'INACTIVE')
)
begin
    insert into student_lark(id, name, email, phone, sex, bod, avatar, status)
    values (p_id, p_name, p_email, p_phone, p_sex, p_bod, p_avatar, p_status);
end //
delimiter ;


delimiter //
create procedure sp_update_student_lark(
    in p_id char(5),
    in p_name varchar(200),
    in p_email varchar(255),
    in p_phone varchar(15),
    in p_sex enum('MALE', 'FEMALE', 'OTHER'),
    in p_bod datetime,
    in p_avatar text,
    in p_status enum('ACTIVE', 'INACTIVE')
)
begin
    update student_lark
    set name   = if(p_name is null, name, p_name),
        email  = if(p_email is null, email, p_email),
        phone  = if(p_phone is null, phone, p_phone),
        sex    = if(p_sex is null, sex, p_sex),
        bod    = if(p_bod is null, bod, p_bod),
        avatar = if(p_avatar is null, avatar, p_avatar),
        status = if(p_status is null, status, p_status)
    where id = p_id;
end //
delimiter ;


delimiter //
create procedure sp_delete_student_lark(
    in p_id char(5)
)
begin
    delete from student_lark where id = p_id;
end //
delimiter ;


delimiter //
create procedure sp_get_all_student_lark()
begin
    select id, name, email, phone, sex, bod, avatar, status from student_lark;
end //
delimiter ;


delimiter //
create procedure sp_find_student_lark_by_id(
    in p_id char(5)
)
begin
    select id, name, email, phone, sex, bod, avatar, status from student_lark where id = p_id;
end //
delimiter ;

delimiter //
create procedure sp_find_student_lark_by_email(
    in p_email varchar(255)
)
begin
    select id, name, email, phone, sex, bod, avatar, status from student_lark where email = p_email;
end //
delimiter ;


delimiter //
create procedure sp_find_student_lark_by_phone(
    in p_phone varchar(15)
)
begin
    select id, name, email, phone, sex, bod, avatar, status from student_lark where phone = p_phone;
end //
delimiter ;


delimiter //
create procedure sp_find_student_lark_by_name_like(
    in p_keyword varchar(200)
)
begin
    select id, name, email, phone, sex, bod, avatar, status from student_lark
    where name like concat('%', p_keyword, '%');
end //
delimiter ;
