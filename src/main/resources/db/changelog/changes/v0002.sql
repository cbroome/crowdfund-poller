
create table campaign_image (
    id bigserial not null,
    campaign_id bigint not null references campaign(id),
    url varchar(2000) not null,
    is_primary boolean not null
);