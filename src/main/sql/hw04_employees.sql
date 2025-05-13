use ss06;

create table employees
(
    id       int primary key auto_increment,
    name     varchar(100) not null,
    birthday date,
    phone    varchar(20),
    email    varchar(100),
    salary   decimal(15, 2),
    position varchar(50)
);

delimiter //

create procedure sp_get_employees(in search_term varchar(100))
begin
    if search_term is null or search_term = '' then
        select * from employees;
    else
        select * from employees
        where name like concat('%', search_term, '%') or id = search_term;
    end if;
end //

create procedure sp_add_employee(
    in p_name varchar(100),
    in p_birthday date,
    in p_phone varchar(20),
    in p_email varchar(100),
    in p_salary decimal(15,2),
    in p_position varchar(50)
)
begin
    insert into employees (name, birthday, phone, email, salary, position)
    values (p_name, p_birthday, p_phone, p_email, p_salary, p_position);
end //

create procedure sp_update_employee(
    in p_id int,
    in p_name varchar(100),
    in p_birthday date,
    in p_phone varchar(20),
    in p_email varchar(100),
    in p_salary decimal(15,2),
    in p_position varchar(50)
)
begin
    update employees
    set name = p_name,
        birthday = p_birthday,
        phone = p_phone,
        email = p_email,
        salary = p_salary,
        position = p_position
    where id = p_id;
end //

create procedure sp_delete_employee(in p_id int)
begin
    delete from employees where id = p_id;
end //

delimiter ;


delimiter //
CREATE PROCEDURE sp_get_employee_by_id(IN p_id INT)
BEGIN
    SELECT * FROM employees WHERE id = p_id;
END;

delimiter //;