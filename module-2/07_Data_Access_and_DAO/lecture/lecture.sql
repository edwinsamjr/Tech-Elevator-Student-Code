SELECT park.park_id, park.park_name, park.date_established, park.area, park.has_camping
FROM park
	JOIN park_state ON park.park_id = park_state.park_id
WHERE park_state.state_abbreviation ='NV';

INSERT INTO park (park_name, date_established, area, has_camping)
VALUES ('A', '19000101', '1', false) RETURNING park_id;

DELETE FROM park
WHERE park_name = 'Oak';

INSERT INTO park_state (park_id, state_abbreviation)
VALUES (70, 'NV');

SELECT *
FROM park;

UPDATE park 
SET park_name = 'Oak2', date_established = '19000101', area = 1, has_camping = true
WHERE park_id = 73;