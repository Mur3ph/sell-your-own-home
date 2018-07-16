-- Database: sell_your_own_home_db


-- DROP DATABASE sellyourownhomedb;

CREATE DATABASE sellyourownhomedb
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'English_Ireland.1252'
       LC_CTYPE = 'English_Ireland.1252'
       CONNECTION LIMIT = -1;
       
-- Table: person

-- DROP TABLE person;

CREATE TABLE person
(
  person_id 						SERIAL NOT NULL,
  first_name 						CHARACTER VARYING(150) NOT NULL,
  last_name 						CHARACTER VARYING(150) NOT NULL,
  username 							CHARACTER VARYING(150) NOT NULL,
  password 							CHARACTER VARYING(150) NOT NULL,
  CONSTRAINT pk_person 				PRIMARY KEY (person_id),
  CONSTRAINT uk_person_username 	UNIQUE (username)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE person
OWNER TO postgres;