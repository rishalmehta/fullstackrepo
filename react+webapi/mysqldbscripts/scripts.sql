drop database if exists userinfo;

create database userinfo;

use userinfo;

create table users(
    userid int primary key auto_increment,
    username varchar(20),
    course varchar(20),
    purchasedate date
);

insert into users(username,course,purchasedate) values("ram","adv java","2023-01-15"),
("shikha","python","2022-10-14"),
("sujit","rust","2022-12-09"),
("mohak","dotnet","2022-11-12");



