SELECT "Low Salary" AS Category,
SUM(income<20000) AS accounts_count
FROM Accounts
UNION
SELECT  "Average Salary" Category,
SUM(income BETWEEN 20000 AND 50000) AS accounts_count
FROM Accounts
UNION
SELECT "High Salary" category,
SUM(income>50000) AS accounts_count
FROM Accounts ;