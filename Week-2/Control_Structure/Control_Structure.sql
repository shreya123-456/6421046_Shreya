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
