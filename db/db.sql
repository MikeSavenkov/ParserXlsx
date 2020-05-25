--create db
CREATE DATABASE structure

--drop all tables
drop table divisions, directions, services, subdivisions, consultants;

--create table divisions
create table IF NOT EXISTS divisions(id SERIAL PRIMARY KEY, name VARCHAR(50) NOT NULL);

--create table directions
CREATE TABLE IF NOT EXISTS directions (
  id        SERIAL PRIMARY KEY,
  name      VARCHAR(50) NOT NULL,
  div_id    INTEGER     NOT NULL
);

--create table services
CREATE TABLE IF NOT EXISTS services (
  id        SERIAL PRIMARY KEY,
  name      VARCHAR(50) NOT NULL,
  div_id    INTEGER     NOT NULL,
  dir_id    INTEGER     NOT NULL
);

--create table subdivisions
CREATE TABLE IF NOT EXISTS subdivisions (
  id        SERIAL PRIMARY KEY,
  name      VARCHAR(50) NOT NULL,
  div_id    INTEGER     NOT NULL,
  dir_id    INTEGER     NOT NULL,
  ser_id    INTEGER     NOT NULL
);

--create table consultants
CREATE TABLE IF NOT EXISTS consultants (
  id           SERIAL PRIMARY KEY,
  name         VARCHAR(50) NOT NULL,
  count_tasks  REAL        NOT NULL,
  div_id       INTEGER     NOT NULL,
  dir_id       INTEGER     NOT NULL,
  ser_id       INTEGER     NOT NULL,
  sub_id       INTEGER
);

--select json from db
SELECT consultants.name AS consultant, consultants.count_tasks AS tasks, services.name AS service
FROM consultants JOIN services ON ser_id = services.id;