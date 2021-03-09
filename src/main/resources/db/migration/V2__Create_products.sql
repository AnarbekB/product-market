create table products.products
(
    id           bigserial        not null,
    agreement_id varchar(255)     not null,
    external_id  varchar(255)     not null,
    name         varchar(255)     not null,
    type         int4             not null,
    user_id      bigint           not null,
    currency     varchar(5)       not null,
    amount       double precision not null,
    active       bit(1)           not null,
    hide         bit(1)           not null,
    image        varchar(255),
    primary key (id)
)
