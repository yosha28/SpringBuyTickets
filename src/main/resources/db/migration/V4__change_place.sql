set
search_path = box;

drop table place;

create table place
(
    id integer not null primary key,
    address text ,
    name text,
    unique (address,name)

);

