create table products.products
(
    id           bigserial    not null,
    agreement_id varchar(255) not null,
    external_id  varchar(255) not null,
    name         varchar(255) not null,
    type         int4         not null,
    user_id      bigint       not null,
    primary key (id)
)
