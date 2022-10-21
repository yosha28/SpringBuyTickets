set
search_path = box;

create sequence place_generator;

create table "customer"
(
    id    integer not null primary key,
    name  text,
    email text,
    phone text
);

create sequence customer_generator;

create table "ticket"
(
    id     integer not null primary key,
    cost   bigint,
    number bigint,
    status text

);


create sequence ticket_generator;

create table "event"
(
    id       integer not null primary key,
    name     text,
    date     date,
    place_id bigint
);

create sequence event_generator;


alter table ticket
    add column customer_id integer references "customer" (id);
alter table ticket
    add column event_id integer references "event" (id);
