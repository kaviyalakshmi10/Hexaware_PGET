create or replace procedure get_salary(
    dept in varchar2,
    salary out number
)
as
begin
    if dept = 'sales' then
        salary := 20000;
    elsif dept = 'admin' then
        salary := 30000;
    elsif dept = 'it' then
        salary := 50000;
    else
        salary := 0;
    end if;
end;
/
