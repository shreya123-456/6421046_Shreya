--Scenario 1: Apply 1% interest to all Savings Accounts (AccountType = 'Savings').
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  UPDATE Accounts
  SET Balance = Balance + (Balance * 0.01),
      LastModified = SYSDATE
  WHERE AccountType = 'Savings';
  
  COMMIT;
END;
/
 --Execution:
BEGIN
  ProcessMonthlyInterest;
END;
/

--Scenario 2: UpdateEmployeeBonus 
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
dept_name IN VARCHAR2,
bonus_percent IN NUMBER
) IS
BEGIN
UPDATE Employees
SET Salary = Salary + (Salary * bonus_percent / 100)
WHERE Department = dept_name;
COMMIT;
END;
/
--Execution:
BEGIN
  UpdateEmployeeBonus('IT', 10);
END;
/

--Scenario 3: Transfer Funds Between Accounts
CREATE SEQUENCE Transactions_seq START WITH 1011 INCREMENT BY 1;
CREATE OR REPLACE PROCEDURE TransferFunds (
fromAccount IN NUMBER,
toAccount IN NUMBER,
amount IN NUMBER
) IS
fromBalance NUMBER;
BEGIN
-- get source balance
SELECT Balance INTO fromBalance
FROM Accounts
WHERE AccountID = fromAccount
FOR UPDATE;
IF fromBalance < amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
END IF;

-- Deduct from source account
UPDATE Accounts
SET Balance = Balance - amount,
    LastModified = SYSDATE
WHERE AccountID = fromAccount;

-- Transfer to destination account
UPDATE Accounts
SET Balance = Balance + amount,
    LastModified = SYSDATE
WHERE AccountID = toAccount;

-- Log transactions
INSERT INTO Transactions VALUES (
    Transactions_seq.NEXTVAL,
    fromAccount,
    SYSDATE,
    amount,
    'DEBIT'
);

INSERT INTO Transactions VALUES (
    Transactions_seq.NEXTVAL,
    toAccount,
    SYSDATE,
    amount,
    'CREDIT'
);

COMMIT;
EXCEPTION
WHEN NO_DATA_FOUND THEN
RAISE_APPLICATION_ERROR(-20002, 'One or both accounts not found.');
END;
/
