
CREATE SCHEMA IF NOT EXISTS test AUTHORIZATION slenzi;

create table test.people (
  person_id integer not null,
  fname varchar(50) not null,
  mname varchar(50),
  lname varchar(50) not null,
  email varchar(100)
);

insert into test.people (person_id,fname,mname,lname,email) values (1,'Seth','Andrew','Lenzi','slenzi@gmail.com');