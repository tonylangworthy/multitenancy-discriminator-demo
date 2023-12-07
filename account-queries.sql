CREATE SCHEMA IF NOT EXISTS dms;

CREATE TABLE IF NOT EXISTS dms.dealership (
id bigserial not null,
name varchar(255),
address varchar(255),
primary key (id)
);
CREATE TABLE IF NOT EXISTS dms.employee (
id bigserial not null,
firstName varchar(255),
lastName varchar(255),
position varchar(255),
primary key (id)
);

-- INSERT INTO dms.dealership (name, address) VALUES ('Big Joe''s Awesome Rides', '700 West Main, Grand Rapids, MI');
-- INSERT INTO dms.dealership (name, address) VALUES ('WebbDealer Whips', '550 Sunnyville Road, Palm Beach, FL');
-- INSERT INTO dms.dealership (name, address) VALUES ('Parts N Stuff', '123 Blacktop Lane, Eldon, MO');

select * from dms.dealership;
