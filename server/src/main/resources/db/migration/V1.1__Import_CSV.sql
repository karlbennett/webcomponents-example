CREATE TABLE Addresses AS SELECT * FROM CSVREAD('classpath:Sacramentorealestatetransactions.csv');

ALTER TABLE Addresses ALTER COLUMN ID SET NOT NULL;
ALTER TABLE Addresses ADD PRIMARY KEY (ID)