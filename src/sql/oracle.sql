/*============================================*/
/*DBMS name:    ORACLE Version 10
/*Created on:   2015-11-18
/*============================================*/

drop table users cascade constraints;
/*============================================*/
/*Table:users
/*============================================*/

creat table users(
	id                 NUMBER(3,0)           not null,
	name               VARCHAR2(20)          not null,
	password           VARCHAR2(20)          not null,
	sex                VARCHAR2(2),
	age                NUMBER(3,0),
	constraint PK_USERS primary key(id)
	);




