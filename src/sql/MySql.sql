/*============================================*/
/*DBMS name:    MySql 5.0
/*Created on:   2015-11-18
/*============================================*/

drop table if exists users;

/*============================================*/
/*Table:users
/*============================================*/

create table users
(
	id                  numeric(3,0)  not null,
	name                varchar(20)   not null,
	password            varchar(20)   not null,
	sex                 varchar(2),
	age                 numeric(3,0),
	primary             key(id)
	);
	




