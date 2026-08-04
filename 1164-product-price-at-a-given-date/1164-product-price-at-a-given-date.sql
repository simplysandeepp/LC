# Write your MySQL query statement below
select d.product_id,
ifnull(pr.new_price,10) as price
from (
    SELECT DISTINCT product_id
FROM Products
) as d left join 
(select 
product_id,
max(change_date) as date 
from products 
WHERE change_date <= '2019-08-16'
GROUP BY product_id) as p on d.product_id=p.product_id
left join
products pr 
on pr.product_id=p.product_id and pr.change_date=p.date;