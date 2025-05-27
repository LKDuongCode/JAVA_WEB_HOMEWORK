use ss12;

create table bus
(
    id            int auto_increment primary key,
    license_plate varchar(20) unique                      not null,
    bus_type      enum ('NORMAL', 'VIP', 'LUXURY') not null,
    row_seat      int                              not null,
    col_seat      int                              not null,
    total_seat    int as (row_seat * col_seat) stored,
    image         text
);

create table seat
(
    id        int auto_increment primary key,
    name_seat varchar(10) not null,
    price     int         not null,
    bus_id    int         not null,
    status    enum ('AVAILABLE', 'BOOKED') default 'AVAILABLE',
    foreign key (bus_id) references bus (id)
);

