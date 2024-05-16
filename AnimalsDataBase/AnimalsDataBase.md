**В ранее подключенном MySQL создать базу данных с названием "Human Friends".**
   
create database Human_Friends;

use Human_Friends;

## Создать таблицы, соответствующие иерархии из вашей диаграммы классов

create table Animals_class
(
	Id int auto_increment primary key, 
	Name_class varchar(20)
);

insert into Animals_class (Name_class)
values ('домашние'),
('вьючные');  

create table Pets
(
	  Id int auto_increment primary key,
    Name_pets varchar (20),
    Class_id INT,
    foreign key (Class_id) references Animals_class (Id) on delete cascade on update cascade
);

insert into Pets (Name_pets, Class_id)
values ('Кошки', 1),
('Собака', 1),  
('Хомяки', 1),
('Морская свинка', 1);

create table Pack_animals
(
	  Id int auto_increment primary key,
    Name_pack_animals varchar (20),
    Class_id INT,
    foreign key (Class_id) REFERENCES Animals_class (Id) on delete cascade on update cascade
);

insert into Pack_animals (Name_pack_animals, Class_id)
values ('Лошади', 2),
('Ослы', 2),  
('Верблюды', 2); 

## Заполнить таблицы данными о животных, их командах и датами рождения

create table dogs 
(       
    Id int auto_increment primary key, 
    Name varchar(20), 
    Birthday date,
    Commands varchar(50),
    Сoat_color varchar(50),
    Type_id int,
    Foreign KEY (Type_id) references Pets (Id) on delete cascade on update cascade
);
insert into dogs (Name, Birthday, Commands, Сoat_color, Type_id)
value ('Жуля', '2022-05-05', 'сидеть, лежать, дай лапу', 'Черная с белым', 1);


create table cats 
(       
    Id int auto_increment primary key, 
    Name varchar(20), 
    Birthday date,
    Commands varchar(50),
    Сoat_color varchar(50),
    Type_id int,
    Foreign KEY (Type_id) references Pets (Id) on delete cascade on update cascade
);

insert into cats (Name, Birthday, Commands, Сoat_color, Type_id)
values ('Туся', '2022-11-23', 'дай лапу', 'Трехмастная', 2),  
('Рыжик', '2017-11-03', "Прыгает через кольцо", 'Рыжий', 2); 

create table hamsters 
(       
    Id int auto_increment primary key, 
    Name varchar(20), 
    Birthday date,
    Commands varchar(50),
    Сoat_color varchar(50),
    Type_id int,
    Foreign KEY (Type_id) references Pets (Id) on delete cascade on update cascade
);
insert into hamsters (Name, Birthday, Commands, Сoat_color, Type_id)
values ('Жужу', '2023-11-08', 'Смешно лежит', 'Коричневый', 3),
('Хома', '2023-11-08', 'Протягивает лапку за кормом', 'Рыжий', 3), 
('Мося', '2023-07-05', 'Лежать', 'Белый', 3);

create table porcellus 
(       
    Id int auto_increment primary key, 
    Name varchar(20), 
    Birthday date,
    Commands varchar(50),
    Сoat_color varchar(50),
    Type_id int,
    Foreign KEY (Type_id) references Pets (Id) on delete cascade on update cascade
);
insert into porcellus (Name, Birthday, Commands, Сoat_color, Type_id)
values ('Пушистик', '2023-04-04', 'Быть пушистым', 'Трехцветный', 4),
('Беляш', '2023-04-04', 'ничего', 'Черный', 4);

create table horses 
(       
    Id int auto_increment primary key, 
    Name varchar(20), 
    Birthday date,
    Tonnage varchar(50),
    Сoat_color varchar(50),
    Type_id int,
    Foreign KEY (Type_id) references Pack_animals (Id) on delete cascade on update cascade
);
insert into horses (Name, Birthday, Tonnage, Сoat_color, Type_id)
values ('Гавриш', '2019-04-20', '90', 'Черный в яблоко', 1),
('Галя', '2020-03-14', "70", 'Коричневый', 1),
('Томсон', '2020-05-25', "80", 'Коричневый', 1);

create table donkeys 
(       
    Id int auto_increment primary key, 
    Name varchar(20), 
    Birthday date,
    Tonnage varchar(50),
    Сoat_color varchar(50),
    Type_id int,
    Foreign KEY (Type_id) references Pack_animals (Id) on delete cascade on update cascade
);
insert into donkeys (Name, Birthday, Tonnage, Сoat_color, Type_id)
values ('Джек', '2022-09-18', '70', 'Серый', 2),
('Джон', '2022-08-17', "75", 'Серый', 2),  
('Анжелина', '2021-04-30', '60', 'Черный', 2), 
('Муся', '2022-03-31', '55', 'Серый', 2);

create table camels 
(       
    Id int auto_increment primary key, 
    Name varchar(20), 
    Birthday date,
    Tonnage varchar(50),
    Сoat_color varchar(50),
    Type_id int,
    Foreign KEY (Type_id) references Pack_animals (Id) on delete cascade on update cascade
);
insert into camels (Name, Birthday, Tonnage, Сoat_color, Type_id)
value ('Лосяш', '2019-04-20', '150', 'Белый', 3);




## Удалить записи о верблюдах и объединить таблицы лошадей и ослов.

drop table camels;

select Name, Birthday, Tonnage, Сoat_color from horses
union select Name, Birthday, Tonnage, Сoat_color from donkeys;

   - Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.

create temporary table Animals as 
select *, 'Лошади' as Genus from horses
union select *, 'Ослы' as Genus from donkeys
union select *, 'Собаки' as Genus from dogs
union select *, 'Кошки' as Genus from cats
union select *, 'Хомяки' as Genus from hamsters
union select *, 'Морские свинки' as Genus from porcellus;

create table yang_animals as
select Name, Birthday, genus, timestampdiff(month, Birthday, curdate()) as Age_animals
from animals where Birthday between adddate(curdate(), interval -3 year) and adddate(curdate(), interval -1 year);
 
select * from yang_animals;

##  Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.

SELECT c.Name, c.Birthday, c.Commands, c.Сoat_color, ha.Name_pets, ya.Age_animals 
FROM cats c   
LEFT JOIN yang_animals ya ON ya.Name = c.Name
LEFT JOIN Pets ha ON ha.Id = c.Type_id
UNION
SELECT d.Name, d.Birthday, d.Commands, d.Сoat_color, ha.Name_pets, ya.Age_animals 
FROM dogs d
LEFT JOIN yang_animals ya ON ya.Name = d.Name
LEFT JOIN Pets ha ON ha.Id = d.Type_id
UNION
SELECT hm.Name, hm.Birthday, hm.Commands, hm.Сoat_color, ha.Name_pets, ya.Age_animals
FROM hamsters hm
LEFT JOIN yang_animals ya ON ya.Name = hm.Name
LEFT JOIN Pets ha ON ha.Id = hm.Type_id
UNION
SELECT por.Name, por.Birthday, por.Commands, por.Сoat_color, ha.Name_pets, ya.Age_animals
FROM porcellus por
LEFT JOIN yang_animals ya ON ya.Name = por.Name
LEFT JOIN Pets ha ON ha.Id = por.Type_id
UNION
SELECT h.Name, h.Birthday, h.Tonnage, h.Сoat_color, pa.Name_pack_animals, ya.Age_animals 
FROM horses h 
LEFT JOIN yang_animals ya ON ya.Name = h.Name
LEFT JOIN Pack_animals pa ON pa.Id = h.Type_id
UNION 
SELECT d.Name, d.Birthday, d.Tonnage, d.Сoat_color, pa.Name_pack_animals, ya.Age_animals 
FROM donkeys d 
LEFT JOIN yang_animals ya ON ya.Name = d.Name
LEFT JOIN Pack_animals pa ON pa.Id = d.Type_id;
