CREATE database test_db WITH OWNER POSTGRES;
CREATE TABLE exercise (
	id bigint PRIMARY KEY NOT NULL,
	message VARCHAR ( 255 )
);
