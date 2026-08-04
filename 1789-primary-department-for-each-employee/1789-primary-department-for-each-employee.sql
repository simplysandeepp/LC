SELECT
    e1.employee_id,
    IFNULL(e2.department_id, e1.department_id) AS department_id
FROM Employee e1
LEFT JOIN Employee e2
    ON e1.employee_id = e2.employee_id
   AND e2.primary_flag = 'Y'
GROUP BY e1.employee_id;