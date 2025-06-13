set serveroutput on;
 
 
declare
 
n number:=&enterANo;
i number;
begin
 
for i in 1..n Loop
 
DBMS_OUTPUT.PUT_LINE( i );
end loop;
 
end;
/