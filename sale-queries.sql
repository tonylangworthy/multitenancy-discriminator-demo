CREATE SCHEMA IF NOT EXISTS sales;

CREATE TABLE IF NOT EXISTS sales.sale (
id bigserial not null,
soldDate timestamp(6),
vehicle varchar(255),
customer varchar(255),
primary key (id)
);

-- demo_account_1
-- INSERT INTO sales.sale (soldDate, vehicle, customer) VALUES ('2023-12-02 8:23:54', '2002 Buick Lucerne', 'Cornhole');

select * from sales.sale;






