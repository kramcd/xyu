CREATE TABLE person (
   person_id int identity primary key,
   person_age int,
   person_name varchar(255),
   city_id int
);

CREATE TABLE city (
  city_id int identity primary key,
  city_name varchar(255)
);




INSERT INTO city (city_name) VALUES ('Moskwa');
INSERT INTO city (city_name) VALUES ('Krblm');
INSERT INTO city (city_name) VALUES ('Kiev');
INSERT INTO person (person_age, person_name, city_id) VALUES (15, 'Bruce Wayne', 0);
INSERT INTO person (person_age, person_name, city_id) VALUES (40, 'Homer Simpson', 1);
INSERT INTO person (person_age, person_name, city_id) VALUES (40, 'Peter Griffin', 2);
