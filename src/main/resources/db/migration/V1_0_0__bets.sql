CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE juridical_entity (
  entity uuid PRIMARY KEY
);

CREATE TABLE people (
email varchar(127) unique not null,
birth_date date,
name varchar(32),
surname varchar(127),
person uuid PRIMARY KEY,
user_options json,
entity uuid
);

ALTER TABLE people ADD FOREIGN KEY(entity) REFERENCES juridical_entity (entity);