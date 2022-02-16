-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT *
FROM state
ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region. 
-- The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT state.state_name, state.census_region
FROM state
ORDER BY state.census_region DESC, state_name ASC;



-- The biggest park by area
SELECT park_name
FROM park
ORDER BY area DESC;



-- LIMITING RESULTS

SELECT park_name
FROM park
ORDER BY area DESC
LIMIT 1;

-- OFFSET / FETCH

SELECT park_name
FROM park
ORDER BY area DESC
FETCH NEXT 1 ROWS ONLY;

SELECT park_name
FROM park
ORDER BY area DESC
FETCH FIRST 10 ROWS ONLY;

SELECT park_name
FROM park
ORDER BY area DESC
OFFSET 4
FETCH NEXT 5 ROWS ONLY;


-- The 10 largest cities by populations


-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
--SELECT CURRENT_DATE;

SELECT CURRENT_DATE - date_established AS age_in_days, park_name
FROM park
ORDER BY age_in_days DESC, park_name ASC
--LIMIT 20;
FETCH FIRST 20 ROWS ONLY;








-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
-- city (abv)
SELECT city_name || ' (' || state_abbreviation || ')'
FROM city;

-- The all parks by name and date established.
SELECT park_name || ' ' || date_es
FROM park


SELECT *
FROM city
WHERE lower(city.state_abbreviation) = lower('CA');


-- The census region and state name of all states in the West & Midwest sorted in ascending order.



-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population)
FROM state;



-- Total population in the West and South census regions
SELECT SUM(population) AS total_population
FROM state
WHERE census_region IN ('West', 'South');



-- The number of cities with populations greater than 1 million
SELECT COUNT(population)
FROM city
WHERE population > 1000000;

SELECT COUNT(*) AS rows, COUNT(census_region) AS values
FROM state;
--WHERE census_region IS NULL;

-- The number of state nicknames.


-- The area of the smallest and largest parks.
SELECT MIN(area), MAX(area)
FROM park;

SELECT *
FROM park
WHERE area IS NULL;




-- GROUP BY

SELECT *
FROM city;


-- Count the number of cities in each state, ordered from most cities to least.
SELECT state_abbreviation, COUNT(*) AS total_cities
FROM city
GROUP BY state_abbreviation
ORDER BY total_cities DESC;

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, AVG(area) AS avg_area
FROM park
GROUP BY has_camping;

-- SELECT AVG(price) AS avg_price
-- FROM products
-- GROUP BY department, category, subcategory;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, SUM(population) AS total_population
FROM city
GROUP BY state_abbreviation
HAVING SUM(population) > 4000000
ORDER BY total_population DESC;






-- The smallest city population in each state ordered by city population.



-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)



-- SUBQUERIES (optional)

-- WHERE IN ('CA', 'ME')
-- WHERE IN (query)

/*
 outer query
*/

SELECT * 
FROM city
WHERE city.state_abbreviation IN (
	-- subquery / inner query
	-- one column, multiple rows
	SELECT state_abbreviation
	FROM state
	WHERE census_region = 'West'
);

SELECT (1+1);

-- outer query
SELECT (
	-- inner query / subquery
	-- one column, one row
	SELECT SUM(area) AS total_area FROM park
) AS total_area_outer;


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


SELECT *
FROM state;



-- Include state name rather than the state abbreviation while counting the number of cities in each state,


-- Include the names of the smallest and largest parks


-- List the capital cities for the states in the Northeast census region.

