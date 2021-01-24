'''
Table: Employees

+-------------+----------+
| Column Name | Type     |
+-------------+----------+
| employee_id | int      |
| name        | varchar  |
| reports_to  | int      |
| age         | int      |
+-------------+----------+
employee_id is the primary key for this table.
This table contains information about the employees and the id of the manager they report to. Some employees do not report to anyone (reports_to is null). 
 

Write an SQL query to report the ids and the names of the people that other employees reported to (excluding null values), the number of employees who report to them, and the average age of those members rounded to the nearest integer.

Return the result table ordered by employee_id.
'''
# Write your MySQL query statement below
select e1.employee_id as employee_id,
e1.name as name,
Count(e2.reports_to) as reports_count,
Round(Avg(e2.age), 0) as average_age
from employees as e1 inner join employees as e2 on e1.employee_id = e2.reports_to
group by 1
order by 1 ASC