

create table "campaign" (
    id bigserial not null,
    summary varchar(256) not null,
    description varchar(2000),
    url varchar(2000),
    primary key (id)
);