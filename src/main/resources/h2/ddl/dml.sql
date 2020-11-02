insert into role (role_name) values('ADMIN');
insert into role (role_name) values('USER');

insert into users (username, password) values('admin', 'password');
insert into users (username, password) values('user', 'password');

insert into user_role (user_id, role_id) values(1,1);
insert into user_role (user_id, role_id) values(2,2);