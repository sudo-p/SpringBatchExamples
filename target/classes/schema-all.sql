DROP TABLE people IF EXISTS;

CREATE TABLE people  (
    person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    UNIQUE(first_name)
);

CREATE TABLE customer (
    id INT PRIMARY KEY,
    firstName VARCHAR(255) NULL,
    lastName VARCHAR(255) NULL,
    birthdate VARCHAR(255) NULL
);

CREATE TABLE new_customer (
    id INT PRIMARY KEY,
    firstName VARCHAR(255) NULL,
    lastName VARCHAR(255) NULL,
    birthdate VARCHAR(255) NULL
);