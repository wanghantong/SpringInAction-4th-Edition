drop table if exists spittle;
drop table if exists spitter;

create table spitter (
  id AUTO_INCREMENT,
  username varchar(25) not null,
  password varchar(25) not null,
  fullName varchar(100) not null,
  email varchar(50) not null,
  updateByEmail boolean not null
);

create table spittle (
  id integer identity primary key,
  spitter integer not null,
  message varchar(2000) not null,
  postedTime datetime not null,
  foreign key (spitter) references spitter(id)
);
create table spitter (
  `id` int(11) NOT NULL AUTO_INCREMENT,  
  `username` varchar(25) not null,
  `password` varchar(25) not null,
  `fullName` varchar(100) not null,
  `email` varchar(50) not null,
  `updateByEmail` boolean not null, 
  PRIMARY KEY (`id`)
  );