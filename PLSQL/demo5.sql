set serveroutput on;

declare
  uid     varchar2(30) := '&user_id';
  pwd     varchar2(30) := '&password';
  is_valid number := 0;
begin
  select count(*) into is_valid
  from users
  where user_id = uid and password = pwd;

  if is_valid = 1 then
    dbms_output.put_line('valid login');
  else
    dbms_output.put_line('invalid login');
  end if;
end;
/
