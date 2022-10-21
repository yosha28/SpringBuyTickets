set
search_path = box;

alter table customer
    add constraint email_unique UNIQUE (email);
