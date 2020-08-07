insert into inv_user values('aswathi@gmail.com','aswathik','aswathi','1234');
select * from inv_user;

drop table brands;
drop table categories;
SELECT * FROM ORDERSUSER;
INSERT INTO ORDERSUSER VALUES('1','45',34,'2'); 

delete from  productsinStore where pid = 105;
CREATE SEQUENCE ORD_SEQ MINVALUE  1 START WITH 1 INCREMENT BY 1;
INSERT INTO orderuserss(id,NAME,PNAME,ADRESS,PRICE,QUANTITY) VALUES(ORD_SEQ.NEXTVAL ,'ASWATHI KRISHNAN','CHOCOLATE','PAYYANNUR KERALA','35',1);
SELECT * FROM ORDERUSERSS;
create table orderuserss(
id varchar(10),
name varchar(20),
pname varchar(20),
adress varchar(30),
price varchar(10),
quantity varchar(10)
);
ALTER TABLE orderuserss ADD PRIMARY KEY(ID);

create table productsinStore(
pid number(10) primary key,
pname varchar(20),
category varchar(30),
brand varchar(30),
quantity number(20),
price number(20)
);

create table admin(
name varchar(20),
pass varchar(20)
);
insert into admin values('admin','admin@123');
select * from admin;
select * from productsinstore;

insert into productsinstore values('100','Samsung A10','Electronics','Samsung','10','75000'); 
insert into productsinstore values('101','Phillips Hair Dryer','Electronics','Phillips','15','95000'); 

drop table ordersuser;

drop table custorders;
desc productsinstore;
select * from productsinstore;
commit;

drop table productsinstore;