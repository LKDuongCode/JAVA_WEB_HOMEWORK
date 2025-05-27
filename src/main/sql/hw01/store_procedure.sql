use ss12;

-- insert
delimiter //
create procedure sp_insert_student (
    in p_name varchar(255),
    in p_email varchar(255),
    in p_dob date
)
begin
    insert into student (name, email, dob)
        values (p_name,p_email,p_dob);
end //
delimiter ;

-- update
delimiter //
create procedure sp_update_student (
    in p_id int,
    in p_name varchar(255),
    in p_email varchar(255),
    in p_dob date
)
begin
    update student
        set name = if(p_name is null ,name,p_name),
            email = if(p_email is null, email,p_email),
            dob = if(p_dob is null, dob,p_dob)
    where id = p_id;

end //
delimiter ;

-- delete
delimiter //
create procedure sp_delete_student (
    in p_id int
)
begin
    delete from student where id = p_id;
end //
delimiter ;

-- get all
delimiter //
create procedure sp_get_all_student ()
begin
    select id, name, email, dob from student;
end //
delimiter ;

-- find by id
delimiter //
create procedure sp_find_student_by_id (
    in p_id int
)
begin
    select id, name, email, dob from student where id = p_id;
end //
delimiter ;

-- find by email
delimiter //
create procedure sp_find_student_by_email (
    in p_email varchar(255)
)
begin
    select id, name, email, dob from student where email = p_email;
end //
delimiter ;