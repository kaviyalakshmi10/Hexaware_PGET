create or replace procedure totsal(salary in number) as
declare
bonus number;

total number;

begin

bonus:=salary*0.05;

total=bonus+salary;

dbms_output.put_line('Total salary'||total);

end;

/
 