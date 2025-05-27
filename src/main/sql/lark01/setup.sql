use ss12;

create table student_lark
(
    id     char(5) primary key,
    name   varchar(200) not null,
    email  varchar(255) not null unique,
    phone  varchar(15) unique,
    sex    enum ('MALE', 'FEMALE', 'OTHER'),
    bod    datetime,
    avatar text,
    status enum ('ACTIVE', 'INACTIVE')
);

