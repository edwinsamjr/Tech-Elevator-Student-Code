-- 03-Joins quiz question #8

-- option 1
SELECT *
FROM timecard
WHERE employee_id = (SELECT * FROM employee WHERE department='Sales');

-- option 2
SELECT *
FROM timecard
WHERE employee_id = (SELECT employee_id FROM employee WHERE department='Sales');

-- option 3
SELECT *
FROM timecard
WHERE employee_id IN (SELECT employee_id FROM employee WHERE department='Sales');

-- option 4
SELECT *
FROM employee AS emp
JOIN timecard AS tc ON emp.department = 'Sales';

-- option 5
SELECT *
FROM employee AS emp
JOIN timecard AS tc ON tc.employee_id = emp.employee_id
WHERE emp.department = 'Sales';





