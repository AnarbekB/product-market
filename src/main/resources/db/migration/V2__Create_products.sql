create table products.products
(
    id           bigserial not null,
    agreement_id varchar(255),
    external_id  varchar(255),
    name         varchar(255),
    type         int4,
    user_id      int4      not null,
    primary key (id)
)
