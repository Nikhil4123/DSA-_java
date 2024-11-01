package DSA;
public class solution {
    public int minAddToMakeValid(String s) {
        int close = 0;
        int open = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else {
                if (open <= 0) {
                    close++;
                } else {
                    open--;
                }
            }
        }
        
        return open + close;
    }

    public static void main(String[] args) {
        solution solution = new solution();
        String input = "()))((";
        int result = solution.minAddToMakeValid(input);
        System.out.println("Minimum additions to make the parentheses valid: " + result);
    }
}


/*
 * 
 * 
 * 
# SQL Syntax Reference Guide

## 1. Basic SQL Statements

### 1.1 SELECT Statement
```sql
SELECT column1, column2, ...
FROM table_name;
```

### 1.2 WHERE Clause
```sql
SELECT column1, column2, ...
FROM table_name
WHERE condition;
```

### 1.3 ORDER BY Clause
```sql
SELECT column1, column2, ...
FROM table_name
ORDER BY column1 [ASC|DESC];
```

### 1.4 GROUP BY Clause
```sql
SELECT column1, COUNT(*)
FROM table_name
GROUP BY column1;
```

### 1.5 HAVING Clause
```sql
SELECT column1, COUNT(*)
FROM table_name
GROUP BY column1
HAVING COUNT(*) > 1;
```

## 2. SQL Joins

### 2.1 INNER JOIN
```sql
SELECT a.column1, b.column2
FROM table1 a
INNER JOIN table2 b ON a.common_column = b.common_column;
```

### 2.2 LEFT JOIN
```sql
SELECT a.column1, b.column2
FROM table1 a
LEFT JOIN table2 b ON a.common_column = b.common_column;
```

### 2.3 RIGHT JOIN
```sql
SELECT a.column1, b.column2
FROM table1 a
RIGHT JOIN table2 b ON a.common_column = b.common_column;
```

### 2.4 FULL JOIN
```sql
SELECT a.column1, b.column2
FROM table1 a
FULL JOIN table2 b ON a.common_column = b.common_column;
```

### 2.5 CROSS JOIN
```sql
SELECT a.column1, b.column2
FROM table1 a
CROSS JOIN table2 b;
```

## 3. Subqueries

### 3.1 Basic Subquery
```sql
SELECT column1
FROM table_name
WHERE column1 IN (SELECT column1 FROM table_name2 WHERE condition);
```

### 3.2 Correlated Subquery
```sql
SELECT a.column1
FROM table1 a
WHERE a.column1 > (SELECT AVG(column1) FROM table2 WHERE table1.id = table2.id);
```

## 4. Advanced SQL Functions

### 4.1 Aggregate Functions
```sql
SELECT COUNT(column1), SUM(column2), AVG(column3)
FROM table_name;
```

### 4.2 String Functions
```sql
SELECT CONCAT(first_name, ' ', last_name) AS full_name
FROM table_name;
```

### 4.3 Date Functions
```sql
SELECT YEAR(date_column), MONTH(date_column), DAY(date_column)
FROM table_name;
```

## 5. Advanced Join Examples

### 5.1 Joining with Multiple Conditions
```sql
SELECT a.column1, b.column2
FROM table1 a
JOIN table2 b ON a.id = b.id AND a.status = b.status;
```

### 5.2 LEFT JOIN with WHERE Clause
```sql
SELECT a.name, b.amount
FROM table1 a
LEFT JOIN table2 b ON a.id = b.id
WHERE b.amount > 100;
```

## 6. Indexes and Performance Optimization

### 6.1 Creating an Index
```sql
CREATE INDEX index_name ON table_name(column_name);
```

### 6.2 Using Explain Plan
```sql
EXPLAIN SELECT column1 FROM table_name WHERE condition;
```

## 7. Views

### 7.1 Creating a View
```sql
CREATE VIEW view_name AS
SELECT column1, column2
FROM table_name
WHERE condition;
```

### 7.2 Using a View
```sql
SELECT * FROM view_name;
```

## 8. Temporary Tables

### 8.1 Creating a Temporary Table
```sql
CREATE TEMPORARY TABLE temp_table AS
SELECT column1, column2 FROM table_name WHERE condition;
```

### 8.2 Dropping a Temporary Table
```sql
DROP TEMPORARY TABLE IF EXISTS temp_table;
```

## 9. Transactions

### 9.1 BEGIN, COMMIT, and ROLLBACK
```sql
BEGIN;
-- Execute SQL statements
COMMIT;

-- To undo
ROLLBACK;
```

## 10. Stored Procedures and Functions

### 10.1 Stored Procedure
```sql
CREATE PROCEDURE procedure_name()
BEGIN
   -- SQL statements
END;
```

### 10.2 Stored Function
```sql
CREATE FUNCTION function_name()
RETURNS data_type
DETERMINISTIC
BEGIN
   -- SQL statements
END;
```

## 11. Triggers

### 11.1 Creating a Trigger
```sql
CREATE TRIGGER trigger_name
AFTER INSERT ON table_name
FOR EACH ROW
BEGIN
   -- SQL statements
END;
```

---
This document provides a structured summary of SQL syntax from basic to advanced.

 */
