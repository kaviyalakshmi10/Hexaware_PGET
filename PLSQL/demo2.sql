SET SERVEROUTPUT ON;

DECLARE 
  a NUMBER := &a;
  b NUMBER := &b;
  c NUMBER;
BEGIN
  c := a + b;
  DBMS_OUTPUT.PUT_LINE('Sum of two numbers: ' || c);
END;
/
S