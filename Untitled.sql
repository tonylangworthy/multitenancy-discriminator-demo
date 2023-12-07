CREATE SCHEMA IF NOT EXISTS dms;

CREATE TABLE IF NOT EXISTS dealership (
id bigserial not null,
name varchar(255),
address varchar(255),
primary key (id)
);
CREATE TABLE IF NOT EXISTS employee (
id bigserial not null,
firstName varchar(255),
lastName varchar(255),
position varchar(255),
primary key (id)
);

CREATE TABLE IF NOT EXISTS sale.sale (
id bigserial not null,
soldDate timestamp(6) ,
customer varchar(255),
primary key (id)
);
