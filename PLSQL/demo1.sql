SET SERVEROUTPUT ON;
 
DECLARE
  name VARCHAR2(20) := 'Asha Gupta';
BEGIN
  DBMS_OUTPUT.PUT_LINE('Your name is ' || name);
END;
/