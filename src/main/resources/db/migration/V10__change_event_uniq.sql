set
search_path = box;

alter table event
    drop constraint one_place_for_date;

alter table event
    add constraint one_place_for_date UNIQUE (date,place_id);

