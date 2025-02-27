/* Write your T-SQL query statement below */
with smp as(
    select email, count(email) as count from person group by email
)
select email from smp where count > 1;