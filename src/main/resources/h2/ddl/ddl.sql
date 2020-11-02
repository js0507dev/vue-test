drop table users_role;
drop table role;
drop table users;

create table users(
user_id int primary key AUTO_INCREMENT,
username varchar(50) unique not null,
password varchar(50) not null,
disabled boolean default false,
account_expired boolean default false,
account_locked boolean default false,
credentials_expired boolean default false
);

create table role (
role_id integer primary key AUTO_INCREMENT,
role_name varchar(50)
);

create table user_role (
user_role_id integer primary key AUTO_INCREMENT,
user_id integer references users(user_id),
role_id integer references role(role_id)
);