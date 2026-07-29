select name from Employee
where id IN ( select managerId from Employee
group by managerId
having count(*)>=5);