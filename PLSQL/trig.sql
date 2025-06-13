CREATE OR REPLACE TRIGGER BankTr
AFTER INSERT ON transaction
FOR EACH ROW
WHEN (NEW.TRANS_TYPE = 'deposit')
BEGIN
    UPDATE customer
    SET balance = balance + :NEW.amount
    WHERE cust_id = :NEW.cust_id;
END;
/