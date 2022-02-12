create table note (
    id serial primary key,
    text varchar not null,
    date timestamp not null default now()
)