CREATE TABLE addresses AS SELECT * FROM CSVREAD('classpath:Sacramentorealestatetransactions.csv');

ALTER TABLE addresses ALTER COLUMN ID SET NOT NULL;
ALTER TABLE addresses ADD PRIMARY KEY (ID)