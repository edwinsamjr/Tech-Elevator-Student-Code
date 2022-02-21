DROP TABLE IF EXISTS group_member;
DROP TABLE IF EXISTS member_event;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS interest_group;
DROP TABLE IF EXISTS member;


CREATE TABLE interest_group (
	group_id SERIAL NOT NULL PRIMARY KEY,
	group_name VARCHAR(64) NOT NULL
);

CREATE TABLE member (
	member_id SERIAL NOT NULL PRIMARY KEY,
	last_name VARCHAR(64) NOT NULL,
	first_name VARCHAR(64) NOT NULL,
	email_address VARCHAR(64) NOT NULL,
	phone_number VARCHAR(64),
	date_of_birth DATE NOT NULL,
	wants_reminder_emails BOOLEAN NOT NULL
);

CREATE TABLE event (
	event_id SERIAL NOT NULL PRIMARY KEY,
	event_name VARCHAR(64) NOT NULL,
	description VARCHAR(64) NOT NULL,
	start_date_time TIMESTAMP NOT NULL,
	mins_duration INT NOT NULL,
	group_id INT NOT NULL CONSTRAINT fk_group REFERENCES interest_group(group_id)
);

CREATE TABLE group_member (
	group_id INT NOT NULL CONSTRAINT fk_group REFERENCES interest_group(group_id),
	member_id INT NOT NULL CONSTRAINT fk_member REFERENCES member(member_id),
	
	CONSTRAINT pk_group_member PRIMARY KEY (group_id, member_id)
);

CREATE TABLE member_event (
	event_id INT NOT NULL CONSTRAINT fk_event REFERENCES event(event_id),
	member_id INT NOT NULL CONSTRAINT fk_member REFERENCES member(member_id),
	
	CONSTRAINT pk_member_event PRIMARY KEY (event_id, member_id)
);

SELECT * FROM member_event;