create table cities (
  uid serial primary key,
  city varchar(200)
);


create table streets (
  uid serial primary key,
  street varchar(200),
  city_id int REFERENCES cities(uid)
);

insert INTO cities (city) VALUES ('Vladivostok');
insert INTO cities (city) VALUES ('Moscow');


insert into streets(street, city_id) values('Russkay', (select uid from cities where city = 'Vladivostok'));
insert into streets(street, city_id) values('Kutuzova', (select uid from cities where city = 'Vladivostok'));

insert into streets(street, city_id) values('kirova', (select uid from cities where city = 'Moscow'));
insert into streets(street, city_id) values('zaslonova', (select uid from cities where city = 'Moscow'));

create table clients (
  uid serial primary key,
  lastname varchar(200),
  firstname VARCHAR(200),
  middlename VARCHAR(200),
  city int REFERENCES cities(uid),
  street int REFERENCES streets(uid),
  bithday DATE,
  phonenum VARCHAR(200)
);