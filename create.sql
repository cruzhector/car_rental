CREATE TABLE users (
    id int auto_increment unique,
    name varchar(255),
    email varchar(255) unique primary key,
	phonenum varchar(255) unique ,
    dob varchar(255),
    gender varchar(255),
    pass varchar(255) unique,
    license varchar(255) unique,
	aadhar varchar(255) unique
    
);

use carrental;
select * from users;
select * from booking;

create table booking(
	bookingid bigint auto_increment unique primary key,
    email varchar(255) ,
    carname varchar(255) not null,
    city varchar(255) not null,
    fromdate varchar(255) not null,
    todate varchar(255) not null
);
DROP table booking;
	
create table carstable(
carid bigint auto_increment unique primary key,
carname varchar(255) not null,
cartype varchar(255) not null,
transmission varchar(255) not null,
seats varchar(255) not null,
cost int not null,
image varchar(255)

);

SELECT * FROM carstable;

SELECT * FROM booking;
DELETE FROM booking;

SELECT * FROM carstable
