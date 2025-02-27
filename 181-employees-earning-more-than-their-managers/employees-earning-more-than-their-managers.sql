/* Write your T-SQL query statement below */
select e1.name as Employee from employee e1 where 
        salary > (select e2.salary from employee e2 where e2.id = e1.managerId)