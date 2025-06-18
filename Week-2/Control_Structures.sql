--Scenario 1: Apply 1% discount to loan interest rates for customers above 60
BEGIN
  FOR cust IN (
    SELECT c.CustomerID, l.LoanID, l.InterestRate
    FROM Customers c
    JOIN Loans l ON c.CustomerID = l.CustomerID
    WHERE MONTHS_BETWEEN(SYSDATE, c.DOB) / 12 > 60
  ) LOOP
    UPDATE Loans
    SET InterestRate = InterestRate - 1
    WHERE LoanID = cust.LoanID;
  END LOOP;
  
  COMMIT;
END;

--Scenario 2: Promote customers with balance > $10,000 to VIP
ALTER TABLE Customers ADD IsVIP CHAR(1);
BEGIN
  FOR cust IN (
    SELECT CustomerID
    FROM Customers
    WHERE Balance > 10000
  ) LOOP
    UPDATE Customers
    SET IsVIP = 'T'
    WHERE CustomerID = cust.CustomerID;
  END LOOP;
  
  COMMIT;
END;

--Scenario 3: Send reminders for loans due in next 30 days
BEGIN
  FOR loan_rec IN (
    SELECT l.LoanID, c.Name, l.EndDate
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || loan_rec.LoanID || 
                         ' for customer ' || loan_rec.Name ||
                         ' is due on ' || TO_CHAR(loan_rec.EndDate, 'DD-Mon-YYYY'));
  END LOOP;
END;
