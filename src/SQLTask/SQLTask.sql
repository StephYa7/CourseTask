DROP DATABASE IF EXISTS Друзья_человека;
CREATE DATABASE Друзья_человека;

USE Друзья_человека;


CREATE TABLE ParentClass
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    NameClass VARCHAR(20) NOT NULL
);

CREATE TABLE Pack_animals
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    ParentID INT,
    SpeciesName VARCHAR(20) NOT NULL,
    FOREIGN KEY (ParentID)  REFERENCES ParentClass (Id)
);

CREATE TABLE Pets
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    ParentID INT,
    SpeciesName VARCHAR(20) NOT NULL,
    FOREIGN KEY (ParentID)  REFERENCES ParentClass (Id)
);

CREATE TABLE Dogs
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    SpeciesID INT,
    Name VARCHAR(20) NOT NULL,
    Сommands VARCHAR(50) NOT NULL,
    DateOfBirth DATE NOT NULL,
    FOREIGN KEY (SpeciesID)  REFERENCES Pets (Id)
);
CREATE TABLE Cats
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    SpeciesID INT,
    Name VARCHAR(20) NOT NULL,
    Сommands VARCHAR(50) NOT NULL,
    DateOfBirth DATE NOT NULL,
    FOREIGN KEY (SpeciesID)  REFERENCES Pets (Id)
);
CREATE TABLE Hamsters
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    SpeciesID INT,
    Name VARCHAR(20) NOT NULL,
    Сommands VARCHAR(50) NOT NULL,
    DateOfBirth DATE NOT NULL,
    FOREIGN KEY (SpeciesID)  REFERENCES Pets (Id)
);
CREATE TABLE Horses
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    SpeciesID INT,
    Name VARCHAR(20) NOT NULL,
    Сommands VARCHAR(50) NOT NULL,
    DateOfBirth DATE NOT NULL,
    FOREIGN KEY (SpeciesID)  REFERENCES Pack_animals (Id)
);
CREATE TABLE Camels
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    SpeciesID INT,
    Name VARCHAR(20) NOT NULL,
    Сommands VARCHAR(50) NOT NULL,
    DateOfBirth DATE NOT NULL,
    FOREIGN KEY (SpeciesID)  REFERENCES Pack_animals (Id)
);

CREATE TABLE Donkeys
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    SpeciesID INT,
    Name VARCHAR(20) NOT NULL,
    Сommands VARCHAR(50) NOT NULL,
    DateOfBirth DATE NOT NULL,
    FOREIGN KEY (SpeciesID)  REFERENCES Pack_animals (Id)
);

INSERT ParentClass(NameClass) 
VALUES
('Домашние животные'),
('Вьючные животные');

-- SELECT * FROM ParentClass;

INSERT Pack_animals(ParentID,SpeciesName) 
VALUES
('2','Ослы'),
('2','Кони'),
('2','Верблюды');

-- SELECT * FROM Pack_animals;

INSERT Pets(ParentID,SpeciesName) 
VALUES
('1','Собаки'),
('1','Коты'),
('1','Хомяки');

-- SELECT * FROM Pets;


INSERT Dogs(SpeciesID,Name, Сommands, DateOfBirth) 
VALUES
('1','Собака 1', 'есть, спать, лаять', '2018-01-02'),
('1','Собака 2', 'есть, спать, лаять', '2021-01-02'),
('1','Собака 3', 'есть, спать, лаять', '2023-01-02');

INSERT Cats(SpeciesID,Name, Сommands, DateOfBirth) 
VALUES
('2','Кошка 1', 'есть, спать, мяукать', '2022-02-03'),
('2','Кошка 2', 'есть, спать, мяукать', '2021-11-05'),
('2','Кошка 3', 'есть, спать, мяукать', '2017-01-02');

INSERT Hamsters(SpeciesID,Name, Сommands, DateOfBirth) 
VALUES
('3','Хомяк 1', 'есть, спать, пищать', '2023-09-22'),
('3','Хомяк 2', 'есть, спать, пищать', '2023-03-21'),
('3','Хомяк 3', 'есть, спать, пищать', '2023-04-12');

INSERT Donkeys(SpeciesID,Name, Сommands, DateOfBirth) 
VALUES
('1','Осел 1', 'есть, спать, иркать', '2015-01-02'),
('1','Осел 2', 'есть, спать, иркать', '2016-01-02'),
('1','Осел 3', 'есть, спать, иркать', '2017-01-02');

INSERT Horses(SpeciesID,Name, Сommands, DateOfBirth) 
VALUES
('2','Конь 1', 'есть, спать, ржать', '2015-01-02'),
('2','Конь 2', 'есть, спать, ржать', '2023-07-02'),
('2','Конь 3', 'есть, спать, ржать', '2017-01-02');

INSERT Camels(SpeciesID,Name, Сommands, DateOfBirth) 
VALUES
('3','Верблюд 1', 'есть, спать, грохотать', '2015-01-02'),
('3','Верблюд 2', 'есть, спать, грохотать', '2016-01-02'),
('3','Верблюд 3', 'есть, спать, грохотать', '2022-11-02');


DROP TABLE Camels ;

CREATE TABLE HorsesAndDonkeys AS
SELECT * FROM Horses
UNION ALL
SELECT Id + (SELECT MAX(Id) FROM Horses), SpeciesID, Name, Сommands, DateOfBirth FROM Donkeys;

-- SELECT * FROM HorsesAndDonkeys;


CREATE TABLE Young_Animals
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(20) NOT NULL,
    AgeInMonths INT
);

INSERT INTO Young_Animals (Name, AgeInMonths)
SELECT Name, DATEDIFF(CURRENT_DATE, DateOfBirth) / 30 AS AgeInMonths
FROM Dogs
WHERE DATEDIFF(CURRENT_DATE, DateOfBirth) > 365 AND DATEDIFF(CURRENT_DATE, DateOfBirth) < 1095
UNION
SELECT Name, DATEDIFF(CURRENT_DATE, DateOfBirth) / 30 AS AgeInMonths
FROM Cats
WHERE DATEDIFF(CURRENT_DATE, DateOfBirth) > 365 AND DATEDIFF(CURRENT_DATE, DateOfBirth) < 1095
UNION
SELECT Name, DATEDIFF(CURRENT_DATE, DateOfBirth) / 30 AS AgeInMonths
FROM Hamsters
WHERE DATEDIFF(CURRENT_DATE, DateOfBirth) > 365 AND DATEDIFF(CURRENT_DATE, DateOfBirth)
UNION
SELECT Name, DATEDIFF(CURRENT_DATE, DateOfBirth) / 30 AS AgeInMonths
FROM HorsesAndDonkeys
WHERE DATEDIFF(CURRENT_DATE, DateOfBirth) > 365 AND DATEDIFF(CURRENT_DATE, DateOfBirth);



SELECT * FROM Young_Animals;

CREATE TABLE AllAnimals AS
SELECT  Name, Сommands, DateOfBirth,Pets.SpeciesName
FROM Dogs
JOIN Pets ON Dogs.SpeciesID = Pets.Id
UNION ALL
SELECT  Name, Сommands, DateOfBirth,Pets.SpeciesName
FROM Cats
JOIN Pets ON Cats.SpeciesID = Pets.Id
UNION ALL
SELECT  Name,  Сommands, DateOfBirth,Pets.SpeciesName
FROM Hamsters
JOIN Pets ON Hamsters.SpeciesID = Pets.Id
UNION ALL
SELECT Name,  Сommands, DateOfBirth, P.SpeciesName
FROM HorsesAndDonkeys H
JOIN Pack_animals P ON H.SpeciesID = P.Id;


SELECT * FROM AllAnimals;






















