
# SQL NOTES

# 1. SQL Basics

## Show Column from a table

```sql
SHOW COLUMN from table_name;
```
## Get the Schema definition of the table 

```sql
DESC table_name;
```

## Sorting the result from the table
```sql
SELECT * FROM table_name ORDER BY first_column DESC, second_column ASC;
```

## Case-sensitive Order
```sql
SELECT * FROM FROM ORDER BY BINARY first_column;
```

## Sort by Casting
```sql
SELECT * FROM FROM ORDER BY CAST(first_column AS CHAR) ;
```

## Alter Table Column

```sql
ALTER TABLE table_name CHANGE first_column fcolumn varchar(120);
```
## INDEX Table

```sql
ALTER TABLE table_name ADD INDEX colOneIndex (first_column);
ALTER TABLE table_name ADD INDEX colOneIndexWith10Chars (first_column(10));
```

## Show INDEX

```sql
SHOW INDEX FROM table_name;
ANALYZE TABLE table_name;
```

## TABLE ALIAS

```sql
SELECT CONCAT(first_column,' ', seond_column) AS complete_column FROM table_name ORDER BY complete_column;
```

## DISTINCT ROWS

```sql
SELECT DISTINCT first_column from table_name;
```

```sql
SELECT DISTINCT first_column,second_column from table_name;
```

## AGGREGATED FUNCTION

```sql
SELECT COUNT(*)from table_name;
SELECT SUM(first_column)from table_name;
SELECT AVG(first_column)from table_name;
SELECT MAX(first_column), MIN(first_column) from table_name;
```

# 2. GROUP BY

GROUP BY clause must appear after the FROM and WHERE clauses and is also evaluated after them. 
<br/> However, GROUP BY is evaluated before the ORDER BY, LIMIT, and HAVING clauses.

```sql
SELECT first_column, COUNT(*) FROM table_name GROUP BY first_column;
```

```sql
SELECT first_column, AVG(quantity_column) FROM table_name GROUP BY first_column;
```

# 3. HAVING
HAVING clause can be used to filter rows to display but that is not the intended use and can make the query slower. <br/>
The HAVING clause should be used to decide what rows form each group.

```sql
SELECT first_column, AVG(quantity_column) as avgQuantity FROM table_name GROUP BY first_column HAVING avgQuantity > 100;
```

# 4. JOINS
ANSI SQL standard defines 5 types of JOINS

- Inner Join
- Left Outer Join 
- Right Outer Join
- Full Outer Join
- Self Join

### 1. INNER JOIN

#### Table with two different column name 

```sql
SELECT tab1Col1, tab1Col2, tab2Col1
FROM table_one 
INNER JOIN table_two  
ON table_one.Id = table_two.relatedId;
```

#### Table with two same column name 
```sql
SELECT tab1Col1, tab1Col2, tab2Col1
FROM table_one 
INNER JOIN table_two  
USING (Id);
```

#### Alternative

```sql
SELECT tab1Col1, tab1Col2, tab2Col1
FROM table_one,table_two 
WHERE Id = relatedId;
```

# 5. UNION

The UNION clause allows us to combine the results from several queries together. <br/>
The clause doesn't join the table but merely clubs the two results together.

```sql
SELECT tab1Col1 FROM table_one 
UNION 
SELECT tab1Col2 FROM table_one;
```

Union doesn't includes the duplicate values. In order to include duplicate values in the result we use `UNION ALL` instead.

# 6. FUNCTIONS

### `DISTINCT` & `MOD`
```sql
select distinct city from STATION where MOD(ID,2)=0;
```

### `LIKE`
```sql
SELECT * FROM movies where title LIKE '%toy%’
```

```sql
SELECT * FROM movies where director LIKE '%John%'
```

### `BETWEEN`
```sql
SELECT * FROM movies where year between 2000 and 2010;
```

### `NOT BETWEEN`
```sql
SELECT * FROM movies where year not between 2000 and 2010;
```

### DEFAULT - INNER JOIN
```sql
SELECT SUM(city.population) FROM city JOIN country ON CITY.CountryCode = COUNTRY.Code WHERE COUNTRY.CONTINENT='Asia’;
```

### `SQRT` - returns the SQUARE root of a number
```sql
SQRT(36) = 6
```

### `POWER` - returns the power of a number
```sql
POWER(3,2) = 9
```

### `ABS` - gets the Absolute Value [Positive Value]
```sql
ABS(b-d)
```

### `ROUND` - rounds the number to n decimal number
```sql
ROUND(sum(long_w),2)
```

### `CEIL` - removes the decimal and gives the exact value
```sql
CEIL(AVG(REPLACE(SALARY,'0’,’ ‘)))
```

### `REPLACE` - replaces the character with something
```sql
REPLACE(SALARY,'0’,' ')
```

### `LENGTH` - returns the LENGTH of the string
```sql
Select MAX(city), LENGTH(MAX(city)) from station;
Select MIN(city), LENGTH(MIN(city)) from station;
```

### Difference of Value
```sql
SELECT MAX(POPULATION) - MIN(POPULATION) FROM CITY;
```

### Write an SQL query to find names of employee start with 'A'?
```sql
SELECT * FROM Employees WHERE EmpName like 'A%' ;
```

### Difference Between `IN` and `BETWEEN`

I. `IN`
```sql
SELECT * FROM Students
WHERE ROLL_NO IN (20,21,23);
```

II. `BETWEEN`
```sql
SELECT * FROM Students
WHERE ROLL_NO BETWEEN 20 AND 30;
```

### Difference Between `DROP` , `TRUNCATE` and `DELETE`

#### I. `DROP` - Removes entire TABLE<br/>
The DROP command removes a table from the database.All the tables'rows, indexes and privileges will also be removed.<br/>
No DML triggers will be fired. The operation cannot be rolled back.

#### II. `TRUNCATE` - Removes ALL Rows<br/>
TRUNCATE removes all rows from a table.<br/>
The operation cannot be rolled back and no triggers will be fired.<br/>
As such,TRUNCATE is faster and doesn't use as much undo space as a DELETE.Table level lock will be added when Truncating.

#### III. `DELETE` - Removes Row with WHERE CLAUSE<br/>
The DELETE command is used to remove rows from a table. <br/>
A WHERE clause can be used to only remove some rows. If no WHERE condition is specified, all rows will be removed.<br/>
After DELETE operation you need to COMMIT or ROLLBACK the transaction to make changes permanent or to undo it.<br/> 
Note that this operation will cause all DELETE triggers on the table to fire. Row level lock will be added when deleting.

### `PRIMARY KEY`
A primary key is used to ensure data in the specific column is unique. It is a column cannot have NULL values.<br/>
It is either a column or a column that is specifically generated by the database according to a defined sequence.

### `FOREIGN KEY`
Foreign key is a column or group of columns in a RDBMS table that provides a link between data in two tables.<br/>
It is a column (or columns) that references a column (most often the primary key) of another table.

### Differences Between Primary key and Unique key
- Primary key will not accept NULL values whereas Unique key can accept one NULL value.
- A table can have only primary key whereas there can be multiple unique key on a table.
- Clustered index is automatically created when primary key is defined whereas Unique key generates non-clustered index.

### NESTED QUERY
```sql
SELECT NAME, TOTAL FROM
(SELECT NAME, SALARY * MONTHS AS TOTAL FROM EMPLOYEE WHERE SALARY > 2000 AND MONTHS<10 ORDER BY SALARY) 
WHERE ROWNUM<=5;
```

### ROW LIMIT IN ORACLE - `ROWNUM`
```sql
SELECT ID, NAME,  FROM
(SELECT NAME, SALARY FROM EMPLOYEE ORDER BY SALARY ASC)
WHERE ROWNUM<=5;
```

### `FETCH NEXT {N} ROWS ONLY` - FROM Oracle 12c
```sql
SELECT * FROM EMPLOYEE FETCH NEXT 5 ROWS ONLY;
```

## TRIANGLE PROBLEM
```sql
SELECT CASE WHEN a+b>c AND b+c>a AND a+c>b THEN
            CASE
                WHEN a=b AND b=c AND c=a THEN 'Equilateral'
            ELSE
                CASE WHEN a=b or b=c or c=a THEN 'Isosceles'
                ELSE 'Scalene'
                END
            END
        ELSE 'Not A Triangle'
        END
FROM triangles;
```

## Example of CASE Statement in Oracle

```sql
CASE STATEMENT
SELECT
CASE
           WHEN 1=1 THEN 'YES'
           ELSE 'NO'
END
FROM ‘TABLE_NAME’
```
