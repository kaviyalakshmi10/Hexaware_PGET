create or replace function factorial(n number)
return number
as
    result number := 1;
    i number;
begin
    if n < 0 then
        return null; 
    end if;

    for i in 1..n loop
        result := result * i;
    end loop;

    return result;
end;
/
