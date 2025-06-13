set serveroutput on;

declare
  salary number := &salary;
  bonus  number;
  total  number;
begin
  bonus := salary * 0.05;
  total := salary + bonus;

  dbms_output.put_line('salary: ' || salary);
  dbms_output.put_line('bonus (5%): ' || bonus);
  dbms_output.put_line('total (salary + bonus): ' || total);
end;
/
