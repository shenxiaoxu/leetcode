'''
Write an SQL query to calculate the total time in minutes spent by each employee on each day at the office. 
Note that within one day, an employee can enter and leave more than once.
'''
# Write your MySQL query statement below
select event_day as day,
emp_id as emp_id,
sum(out_time-in_time) as total_time
from employees
group by emp_id, event_day
order by event_day ASC