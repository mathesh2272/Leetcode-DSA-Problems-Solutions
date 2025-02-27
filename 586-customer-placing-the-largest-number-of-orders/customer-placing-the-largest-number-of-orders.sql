/* Write your T-SQL query statement below */
with sample as (
    select customer_number, count(order_number) as order_count from orders group by customer_number
)
select customer_number from sample 
    where order_count = (select max(order_count) from sample);