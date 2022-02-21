
-----CREATING DATABASE-----

DROP TABLE IF EXISTS group_member;
DROP TABLE IF EXISTS member_event;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS interest_group;
DROP TABLE IF EXISTS member;


CREATE TABLE interest_group (
	group_id SERIAL NOT NULL PRIMARY KEY,
	group_name VARCHAR(64) NOT NULL,
	
	CONSTRAINT uq_group_name UNIQUE(group_name)
	
);

CREATE TABLE member (
	member_id SERIAL NOT NULL PRIMARY KEY,
	last_name VARCHAR(64) NOT NULL,
	first_name VARCHAR(64) NOT NULL,
	email_address VARCHAR(64) NOT NULL ,
	phone_number VARCHAR(64) ,
	date_of_birth DATE NOT NULL,
	wants_reminder_emails BOOLEAN NOT NULL,
	
	CONSTRAINT uq_email_address UNIQUE(email_address),
	CONSTRAINT uq_phone_number UNIQUE(phone_number)

);

CREATE TABLE event (
	event_id SERIAL NOT NULL PRIMARY KEY,
	event_name VARCHAR(64) NOT NULL,
	description VARCHAR(64) NOT NULL,
	start_date_time TIMESTAMP NOT NULL,
	mins_duration INT NOT NULL CHECK (mins_duration>=30),
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

-----FILLING DATABASE-----

--Creating Members:
INSERT INTO member (last_name, first_name,email_address, phone_number, date_of_birth, wants_reminder_emails)
VALUES ('Beckham', 'David', 'dbeckham@england.com', '3105559483', '19750502', false)
		, ('Messi', 'Lionel', 'messil@goat.com', '2135559483', '19870624', false)
		, ('Maradona', 'Diego', 'maradona@bestplayer.org', '9875558263', '19601030', false)
		, ('Mbappe', 'Kylian', 'mbappe@hotmail.com', '2015557444', '19981220', true)
		, ('Zidane', 'Zinedine', 'zizou@outlook.com', '5135554343', '19720623', false)
		, ('Beckenbauer', 'Franz', 'beckenbecks99@aol.com', '7405559334', '19450911', false)
		, ('Cruyff', 'Johan', 'jcruyff212@gmail.com', '2205554382', '19470425', false)
		, ('Weah', 'George', 'simplythebest@yahoo.com', '9195552048', '19661001', true)
;

--Creating Groups

INSERT INTO interest_group (group_name)
VALUES ('Argentines'),
	   ('Active Players'),
	   ('Europeans');


--Creating Events:
INSERT INTO event (event_name, description, start_date_time, mins_duration, group_id)
VALUES  ('Viewing Party', 'Watch party for the World Cup Final', '20221218 10:00 AM', 120, (SELECT group_id FROM interest_group WHERE group_name = 'Europeans'))
	   ,('Ballon D''Or', 'Award ceremony for world''s best players', '20211129 2:00 PM', 150, (SELECT group_id FROM interest_group WHERE group_name = 'Europeans'))
	   ,('Empanada Cooking Class', 'Leaning to cook Argentinian empanadas', '20220228 6:00 PM', 90, (SELECT group_id FROM interest_group WHERE group_name = 'Argentines'))
	   ,('Pickup Soccer Game', 'Meeting on Short Vine to play pickup soccer', '20220226 10:00 AM', 60, (SELECT group_id FROM interest_group WHERE group_name = 'Active Players'))
;

--Adding Members to Europeans group
INSERT INTO group_member (group_id, member_id)
VALUES  ((SELECT group_id FROM interest_group WHERE group_name = 'Europeans'),(SELECT member_id FROM member WHERE last_name = 'Beckham'))
	   ,((SELECT group_id FROM interest_group WHERE group_name = 'Europeans'),(SELECT member_id FROM member WHERE last_name = 'Mbappe'))
	   ,((SELECT group_id FROM interest_group WHERE group_name = 'Europeans'),(SELECT member_id FROM member WHERE last_name = 'Zidane'))
	   ,((SELECT group_id FROM interest_group WHERE group_name = 'Europeans'),(SELECT member_id FROM member WHERE last_name = 'Beckenbauer'))
	   ,((SELECT group_id FROM interest_group WHERE group_name = 'Europeans'),(SELECT member_id FROM member WHERE last_name = 'Cruyff'));

--Adding members to Active Players group
INSERT INTO group_member (group_id, member_id)
VALUES  ((SELECT group_id FROM interest_group WHERE group_name = 'Active Players'),(SELECT member_id FROM member WHERE last_name = 'Messi'))
	   ,((SELECT group_id FROM interest_group WHERE group_name = 'Active Players'),(SELECT member_id FROM member WHERE last_name = 'Mbappe'));

--Adding members to Argentines group
INSERT INTO group_member (group_id, member_id)
VALUES  ((SELECT group_id FROM interest_group WHERE group_name = 'Argentines'),(SELECT member_id FROM member WHERE last_name = 'Messi'))
	   ,((SELECT group_id FROM interest_group WHERE group_name = 'Argentines'),(SELECT member_id FROM member WHERE last_name = 'Maradona'));

--Adding members to Viewing Party event
INSERT INTO member_event (event_id, member_id)
VALUES  ((SELECT event_id FROM event WHERE event_name = 'Viewing Party'),(SELECT member_id FROM member WHERE last_name = 'Weah'))
	   ,((SELECT event_id FROM event WHERE event_name = 'Viewing Party'),(SELECT member_id FROM member WHERE last_name = 'Beckenbauer'))
	   ,((SELECT event_id FROM event WHERE event_name = 'Viewing Party'),(SELECT member_id FROM member WHERE last_name = 'Beckham'));

--Adding members to Ballon D'Or event
INSERT INTO member_event (event_id, member_id)
VALUES  ((SELECT event_id FROM event WHERE event_name = 'Ballon D''Or'),(SELECT member_id FROM member WHERE last_name = 'Messi'))
	   ,((SELECT event_id FROM event WHERE event_name = 'Ballon D''Or'),(SELECT member_id FROM member WHERE last_name = 'Mbappe'))
	   ,((SELECT event_id FROM event WHERE event_name = 'Ballon D''Or'),(SELECT member_id FROM member WHERE last_name = 'Zidane'));

--Adding members to Empanada Cooking Class event
INSERT INTO member_event (event_id, member_id)
VALUES  ((SELECT event_id FROM event WHERE event_name = 'Empanada Cooking Class'),(SELECT member_id FROM member WHERE last_name = 'Messi'))
	   ,((SELECT event_id FROM event WHERE event_name = 'Empanada Cooking Class'),(SELECT member_id FROM member WHERE last_name = 'Maradona'))
	   ,((SELECT event_id FROM event WHERE event_name = 'Empanada Cooking Class'),(SELECT member_id FROM member WHERE last_name = 'Mbappe'));

--Adding members to Pickup Soccer Game
INSERT INTO member_event (event_id, member_id)
VALUES  ((SELECT event_id FROM event WHERE event_name = 'Pickup Soccer Game'),(SELECT member_id FROM member WHERE last_name = 'Mbappe'));
		 