create table products.requisites
(
    id                    bigserial    not null,
    bic                   varchar(255) not null,
    bank_name             varchar(255) not null,
    inn                   varchar(255) not null,
    kpp                   varchar(255) not null,
    recipient_account     varchar(255) not null,
    recipient             varchar(255) not null,
    correspondent_account varchar(255) not null,
    product_id            bigint,
    primary key (id)
)
