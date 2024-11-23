use bankmanagementsystem;
show tables;
select * from login;

select * from signuptwo;
SET SQL_SAFE_UPDATES=0;
delete from signup where name = "abcd";
truncate table signup;
truncate table signuptwo;

create table signuptwo(
formno varchar(20),
religion varchar(20),
income varchar(20),
education varchar(20),
occupation varchar(20),
pannumber varchar(20),
aadhar varchar(20),
extacc varchar(20)
);

create table signupthree(
fomrno varchar(20),
accounttype varchar(50),
cardnumber varchar(50),
pinnumber varchar(20),
services varchar(100)
);

select * from signupthree;
truncate table signupthree;

create table login(
formno varchar(20),
cardnumber varchar(50),
pinnumber varchar(20)
);

select * from login ;	
truncate table login;

create table bank(
pin varchar(20),
date varchar(50),
type varchar(20),
amount varchar(20)
);
select * from bank;	
drop table bank;

select cardnumber from login where pinumber = 6832;