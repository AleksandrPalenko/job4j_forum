create table if not exists posts (
    id serial primary key,
    name varchar(2000),
    description text,
    created timestamp without time zone not null default now()
);

CREATE TABLE if not exists authorities (
    id serial primary key,
    authority VARCHAR(50) NOT NULL unique
);

CREATE TABLE if not exists users (
     id serial primary key,
     username VARCHAR(50) NOT NULL unique,
     password VARCHAR(100) NOT NULL,
     enabled boolean default true,
     authority_id int not null references authorities(id)
);

insert into posts (name) values ('О чем этот форум?');
insert into posts (name) values ('Правила форума.');

insert into authorities (authority) values ('ROLE_USER');
insert into authorities (authority) values ('ROLE_ADMIN');

insert into users (username, password, authority_id)
values ('root', '$2a$10$4tgxeA6t3/mzum63x.11BODzpRTYbiN5Fg8fEzRNbrXSk56nN4ClS',
        (select id from authorities where authority = 'ROLE_ADMIN'));