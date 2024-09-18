CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    declare sal int;
    set N = N - 1;
    select distinct salary into sal 
        from employee 
        order by salary desc 
        limit N, 1; 
    return sal;
END