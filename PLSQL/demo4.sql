set serveroutput on;
 
 
declare
 
salary number:=&salary;

bonus number;

tsal number;

begin
 
if salary<=5000 then

    bonus:=salary*5/100;

else

bonus:=salary*10/100;
 
end if;
 
tsal:=salary+bonus;

DBMS_OUTPUT.PUT_LINE('ur salary is ' ||salary  );

DBMS_OUTPUT.PUT_LINE('ur bonus  is ' ||bonus  );
 
DBMS_OUTPUT.PUT_LINE('ur salary total sal ' || tsal  );
 
end;

/

 