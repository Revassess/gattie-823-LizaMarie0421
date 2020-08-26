--CREATE DATABASE quizzard;
--DROP TABLE category cascade;
CREATE TABLE category(
	category_id SERIAL PRIMARY KEY,
	name VARCHAR UNIQUE NOT NULL
);
--DROP TABLE flashcard cascade;

CREATE TABLE flashcard(
	flashcard_id SERIAL PRIMARY KEY,
	question VARCHAR UNIQUE NOT NULL,
	answer VARCHAR NOT NULL,
	category_id INTEGER REFERENCES category(category_id)
);
--DROP TABLE user_role cascade;
--DROP TABLE IF EXISTS app_user;
CREATE TABLE user_role(
	role_id SERIAL PRIMARY KEY,
	name VARCHAR UNIQUE NOT NULL
);

--DROP TABLE app_user cascade;
CREATE TABLE app_user(
	user_id SERIAL PRIMARY KEY,
	username VARCHAR UNIQUE NOT NULL,
	password VARCHAR NOT NULL,
	first_name SERIAL NOT NULL,
	last_name VARCHAR NOT NULL,
	role_id INTEGER REFERENCES user_role(role_id)
);

--DROP TABLE study_set cascade;
--DROP TABLE IF EXISTS study_set;
CREATE TABLE study_set(
study_set_id INTEGER PRIMARY KEY,
name VARCHAR UNIQUE NOT NULL,
owner_id INTEGER REFERENCES app_user(user_id)
);

--DROP TABLE study_set_card cascade;
CREATE TABLE study_set_card(
study_set_id INTEGER REFERENCES study_set(study_set_id),
flashcard_id INTEGER REFERENCES flashcard(flashcard_id),
PRIMARY KEY (study_set_id , flashcard_id)
);

CREATE SEQUENCE sequence_one START WITH 6 INCREMENT BY 3;

--/*CREATE OR REPLACE procedure prc_sequence()
--	AS $$
--	BEGIN
--		CREATE SEQUENCE sequence_one START WITH 6 INCREMENT BY 3;
--	END;
--	$$ LANGUAGE plpgsql; */


