-- set
-- search_path = box;
--
-- create table "role"
-- (
--     role_id    integer not null primary key,
--     role_name  text
--
-- );
--
-- create table "user_role"
-- (
--     id     integer not null primary key,
--     customer_id integer references "customer" (id),
--     role_id integer references "role" (role_id)
-- );