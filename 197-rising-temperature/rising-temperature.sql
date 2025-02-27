/* Write your T-SQL query statement below */
select w2.id from weather w1 join weather w2  
        on datediff(day, w1.recorddate, w2.recorddate) = 1 
        and w1.temperature < w2.temperature;
