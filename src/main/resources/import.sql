insert into movie (id, title, year, duration, genre) values (nextval('movie_seq'), 'La grande bellezza', 2013, 141, 'Drammatico');
insert into movie (id, title, year, duration, genre) values (nextval('movie_seq'), 'Il sorpasso', 1962, 105, 'Commedia');
insert into movie (id, title, year, duration, genre) values (nextval('movie_seq'), 'Oppenheimer', 2023, 180, 'Biografico');
insert into movie (id, title, year, duration, genre) values (nextval('movie_seq'), 'Nuovo Cinema Paradiso', 1988, 155, 'Drammatico');
insert into movie (id, title, year, duration, genre) values (nextval('movie_seq'), 'Perfect Days', 2023, 123, 'Drammatico');

insert into director (id, name, surname, birth_date, nationality) values (nextval('director_seq') , 'Paolo', 'Sorrentino', '1970-05-31', 'Italiana');
insert into director (id, name, surname, birth_date, nationality) values (nextval('director_seq') , 'Dino', 'Risi', '1916-12-23', 'Italiana');
insert into director (id, name, surname, birth_date, nationality) values (nextval('director_seq') , 'Christopher', 'Nolan', '1970-07-30', 'Britannica');
insert into director (id, name, surname, birth_date, nationality) values (nextval('director_seq') , 'Giuseppe', 'Tornatore', '1956-05-27', 'Italiana');
insert into director (id, name, surname, birth_date, nationality) values (nextval('director_seq') , 'Wim', 'Wenders', '1945-08-14', 'Tedesca');