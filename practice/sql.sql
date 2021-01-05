use test;

delimiter $$ 
create function getNthHighestSalary(N int) 
returns int 
begin declare n1 int;
 set n1=N-1; 
 return ( select distinct Salary from salary order by Salary desc limit n1,1 ); 
 end $$

