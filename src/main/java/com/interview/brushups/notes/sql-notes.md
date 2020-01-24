
# SQL NOTES

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

### Difference Between  `IN` and `BETWEEN`

IN
```sql
SELECT * FROM Students
WHERE ROLL_NO IN (20,21,23);
```

BETWEEN
```sql
SELECT * FROM Students
WHERE ROLL_NO BETWEEN 20 AND 30;
```

NESTED QUERY
```sql
SELECT NAME, TOTAL FROM
(SELECT NAME, SALARY * MONTHS AS TOTAL FROM EMPLOYEE WHERE SALARY > 2000 AND MONTHS<10 ORDER BY SALARY) 
WHERE ROWNUM<=5;
```

ROW LIMIT IN ORACLE - ROWNUM
```sql
SELECT ID, NAME,  FROM
(SELECT NAME, SALARY FROM EMPLOYEE ORDER BY SALARY ASC)
WHERE ROWNUM<=5;
```

FETCH NEXT {N} ROWS ONLY //FROM Oracle 12c
```sql
SELECT * FROM EMPLOYEE FETCH NEXT 5 ROWS ONLY;
```
