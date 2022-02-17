
-- outer query
SELECT city.city_name
	, city.state_abbreviation
	, (
		-- inner query / correlated subquery
		-- one column, one row
		SELECT state.state_name
		FROM state
		WHERE state.state_abbreviation = city.state_abbreviation
	  ) AS state_name
FROM city;

SELECT * FROM state;
SELECT * FROM city ORDER BY state_abbreviation;

-- INNER JOIN

-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database
SELECT city_name, state_abbreviation
FROM city
WHERE city_name = 'Columbus';

-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).
SELECT city_name, city.state_abbreviation, state_name
FROM city
	JOIN state ON state.state_abbreviation = city.state_abbreviation
WHERE city_name = 'Columbus';

-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)
SELECT park_name, state_abbreviation
FROM park
	JOIN park_state ON park.park_id = park_state.park_id
ORDER BY park_name

-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
SELECT park_name, state_name
FROM park
	JOIN park_state ON park.park_id = park_state.park_id
	JOIN state ON state.state_abbreviation = park_state.state_abbreviation
ORDER BY park_name

-- Modify the previous query to include the name of the state's capital city.
SELECT park_name, state_name, city.city_name
FROM park
	JOIN park_state ON park.park_id = park_state.park_id
	JOIN state ON state.state_abbreviation = park_state.state_abbreviation
	JOIN city ON city.city_id = state.capital
ORDER BY park_name

-- Modify the previous query to include the area of each park.
SELECT * --park_name, state_name, city.city_name, park.area
FROM park
	JOIN park_state ON park.park_id = park_state.park_id
	JOIN state ON state.state_abbreviation = park_state.state_abbreviation
	JOIN city ON city.city_id = state.capital
ORDER BY park_name

-- Write a query to retrieve the names and populations of all the cities in the Midwest census region.
SELECT * --city.city_name, city.population
FROM city
INNER JOIN state ON state.state_abbreviation = city.state_abbreviation
WHERE state.census_region = 'Midwest'
ORDER BY state_name;

-- Write a query to retrieve the *number* of cities in the city 
-- table for each state in the Midwest census region.
SELECT state_name, COUNT(city.city_name) AS num_cities
FROM city
	JOIN state ON state.state_abbreviation = city.state_abbreviation
WHERE state.census_region = 'Midwest'
GROUP by state_name

-- Modify the previous query to sort the results by the number of cities in descending order.
SELECT state_name, COUNT(city.city_name) AS num_cities
FROM city
	JOIN state ON state.state_abbreviation = city.state_abbreviation
WHERE state.census_region = 'Midwest'
GROUP by state_name
ORDER BY num_cities DESC

-- LEFT JOIN

-- Write a query to retrieve the *state name* and the *earliest 
-- date a park was established in that state* (or territory) 
-- for every record in the state table that has park records associated with it.
SELECT state.state_name, MIN(park.date_established) AS first_park_date
FROM state
JOIN park_state ON park_state.state_abbreviation = state.state_abbreviation
JOIN park ON park.park_id = park_state.park_id
GROUP BY state.state_abbreviation;

SELECT COUNT(*) FROM state;

-- Modify the previous query so the results include entries 
-- for all the records in the state table, even if they have no park records associated with them.
SELECT state.state_name, MIN(park.date_established) AS first_park_date
FROM state 
	LEFT JOIN park_state ON park_state.state_abbreviation = state.state_abbreviation
	LEFT OUTER JOIN park ON park.park_id = park_state.park_id
GROUP BY state.state_abbreviation;

SELECT COUNT(*) FROM state;


-- UNION
SELECT 'A' AS col1
UNION
SELECT 'B' as col1;

-- union removes dups
SELECT 'A' AS col1
UNION
SELECT 'A' AS col1;

-- union ALL keeps dups
SELECT 'A' AS col1
UNION ALL
SELECT 'A' AS col1;

-- Write a query to retrieve all the place names in the city 
-- and state tables that begin with "W" sorted alphabetically. 
-- (Washington is the name of a city and a state--how many times does it appear in the results?)
SELECT city_name AS place_name
FROM city
WHERE city_name LIKE 'W%'
UNION
SELECT state_name
FROM state
WHERE state_name LIKE 'W%'
ORDER BY place_name;


-- Modify the previous query to include a column that indicates whether the place is a city or state.
SELECT city_name AS place_name, 'city' AS city_or_state
FROM city
WHERE city_name LIKE 'W%'
UNION
SELECT state_name, 'state'
FROM state
WHERE state_name LIKE 'W%'
ORDER BY place_name;

-- MovieDB
-- After creating the MovieDB database and running the setup script, make sure it is selected in DbVisualizer and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres


-- The titles of all the Comedy movies

