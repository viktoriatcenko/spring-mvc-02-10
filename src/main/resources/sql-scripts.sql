create table person(
                       id int generated by default as identity primary key ,
                       name varchar not null,
                       age int check ( age > 0 ),
                       email varchar unique
);

create table "order"
(
    id int generated by default as identity primary key ,
    name varchar not null,
    person_id int references person(id)
);

select * from person left join "order" on person.id = "order".person_id

select person.name, "order".name from person left join "order"  on person.id = "order".person_id

select person.id, "order".id from person left join "order" on person.id = "order".person_id

select person.email, "order".name from person join "order" on person.id = "order".person_id

select "order".name from person join "order" on person.id = "order".person_id where person.name = 'Airat'

select "order".name from person join "order" on person.id = "order".person_id where person.age = 32

insert into "order"( name, person_id) values ('TV', 1);
insert into "order"( name, person_id) values ('Car', 2);
insert into "order"( name, person_id) values ('Iphone', 3);
insert into "order"( name, person_id) values ('Boombox', 4);
insert into "order"( name, person_id) values ('Ipod', 3);

drop table person
select * from person;

select name
from person where age = 32;

select name from person;
insert into person( name, age, email) values ('Viktor',32, 'viktor@mail.ru');
insert into person( name, age, email) values ( 'Damir', 17, 'damir@mail.ru');
insert into person( name, age, email) values ( 'Airat', 25, 'airat@mail.ru');
insert into person( name, age, email) values ( 'Maxim', 32, 'maxim@mail.ru');
insert into person( name, age, email) values ( 'Tagir', 25, 'tagir@mail.ru');
update person set name='Viktor32' where name='Viktor' and age=32;
delete from person where name='Viktor32';
drop table person;

create table person(
                       id int,
                       name varchar,
                       age int
);

select * from person where name='Damir'

insert into person(name, age) values ('Viktor', 32)

select * from person;

update person set id=5 where name='Viktor' and age=32

update person
set name = '', age = 1, email = ''
where id = 1;

update person set name = 'Viktor', age = 32, email = 'viktor@gmail.com'  where id = 5

delete from person where id = 5
delete from person where id = 5

delete from person where age = 32
insert into person(id, name, age) values (4, 'Maxim', 32);

create table book(
                     id int,
                     name varchar,
                     dateOfIssue int
)

drop table book

create table picture(
                        id int,
                        name varchar,
                        author varchar
)

insert into picture(id, name, author) values (1, '9 val', 'Aivazoskiy')

select *
from picture;

drop table picture

create table tales(
                      id int,
                      name varchar,
                      author varchar,
                      yearOfIssue int
)

insert into tales(id, name, author, yearOfIssue) VALUES (1, 'kolobok', 'narodnaya', 1913)

select *
from tales;




create sequence my_seq

select nextval('my_seq')

create table person(
                       id int generated by default as identity primary key ,
                       name varchar not null,
                       age int check ( age > 0 ),
                       email varchar unique
);


create table citizen(
    id int generated by default as identity primary key ,
    name varchar(100) not null,
    age int check(age >0)
)

create table passport(
    id int primary key references citizen(id),
    passport_number int
)


INSERT INTO Citizen(name, age) VALUES ('Bob', 12);
INSERT INTO Citizen(name, age) VALUES ('Tom', 24);
INSERT INTO Citizen(name, age) VALUES ('Katy', 39);
INSERT INTO Citizen(name, age) VALUES ('Alice', 45);

INSERT INTO Passport(id, passport_number) VALUES (1, 12345);
INSERT INTO Passport(id, passport_number) VALUES (2, 75124);
INSERT INTO Passport(id, passport_number) VALUES (3, 91245);
INSERT INTO Passport(id, passport_number) VALUES (4, 19259);

insert into passport(id, passport_number) VALUES (6, 231654)

create table actor(
    id int generated by default as identity primary key,
    name varchar(100) unique ,
    age int check ( age > 0 )
)

create table movie(
    id int generated by default as identity primary key ,
    name varchar(100) unique ,
    year_of_production int check ( year_of_production > 1900 ),
    director_id int references director(id)
)

drop table movie
drop table actor_movie
drop table director

create table actor_movie(
    --id int generated by default as identity primary key ,
    actor_id int references actor(id),
    movie_id int references movie(id),
    primary key (actor_id, movie_id)
)

INSERT INTO Actor(name, age) VALUES ('Harvey Keitel', 81);
INSERT INTO Actor(name, age) VALUES ('Robert De Niro', 77);
INSERT INTO Actor(name, age) VALUES ('Leonardo DiCaprio', 46);
INSERT INTO Actor(name, age) VALUES ('Jason Statham', 53);
INSERT INTO Actor(name, age) VALUES ('Joe Pesci', 77);
INSERT INTO Actor(name, age) VALUES ('Samuel L. Jackson', 72);

create table director(
    id int generated by default as identity primary key ,
    name varchar(100) unique,
    age int
)

INSERT INTO Director(name, age) VALUES ('Quentin Tarantino', 57);
INSERT INTO Director(name, age) VALUES ('Martin Scorsese', 78);
INSERT INTO Director(name, age) VALUES ('Guy Ritchie', 52);
INSERT INTO Director(name, age) VALUES ('Woody Allen', 85);
INSERT INTO Director(name, age) VALUES ('David Lynch', 74);
INSERT INTO Director(name, age) VALUES ('Christopher Nolan', 50);



INSERT INTO Movie(director_id, name, year_of_production) VALUES (1, 'Reservoir Dogs', 1992);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (1, 'Pulp Fiction', 1994);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (1, 'The Hateful Eight', 2015);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (1, 'Once Upon a Time in Hollywood', 2019);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (2, 'Taxi Driver', 1976);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (2, 'Goodfellas', 1990);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (2, 'The Wolf of Wall Street', 2013);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (3, 'Lock, Stock and Two Smoking Barrels', 1998);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (3, 'Snatch', 2000);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (4, 'Midnight in Paris', 2011);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (6, 'Inception', 2010);


INSERT INTO Actor_Movie VALUES(1, 1);
INSERT INTO Actor_Movie VALUES(1, 2);
INSERT INTO Actor_Movie VALUES(2, 5);
INSERT INTO Actor_Movie VALUES(2, 6);
INSERT INTO Actor_Movie VALUES(3, 4);
INSERT INTO Actor_Movie VALUES(3, 7);
INSERT INTO Actor_Movie VALUES(3, 11);
INSERT INTO Actor_Movie VALUES(4, 8);
INSERT INTO Actor_Movie VALUES(4, 9);
INSERT INTO Actor_Movie VALUES(5, 6);
INSERT INTO Actor_Movie VALUES(6, 2);
INSERT INTO Actor_Movie VALUES(6, 3);

--     table1   join  table2


select actor.name, movie.name from actor
    join actor_movie on actor.id =  actor_movie.actor_id
    join movie on actor_movie.movie_id = movie.id;

select actor.name, movie.name, director.name from actor
    join actor_movie on actor.id = actor_movie.actor_id
    join movie on actor_movie.movie_id = movie.id
    join director on director.id = movie.director_id

select director.name, director.age, movie.name from director
    join movie on director.id = movie.director_id

select movie.year_of_production, movie.name, actor.name from movie
    join actor_movie on movie.id = actor_movie.movie_id
    join actor on actor.id = actor_movie.actor_id

-- имя фильма, имя актера и возраст режиссера

select movie.name, actor.name, director.age from movie
    join actor_movie on movie.id = actor_movie.movie_id
    join actor on actor.id = actor_movie.actor_id
    join director on movie.director_id = director.id
