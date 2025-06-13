CREATE OR REPLACE PROCEDURE totsal(
    salary IN NUMBER,
    bonus OUT NUMBER,
    total OUT NUMBER
)
AS
BEGIN
    bonus := salary * 0.05;
    total := bonus + salary;
END;
/
