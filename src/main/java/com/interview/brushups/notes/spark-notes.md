# Spark Notes


## Spark SQL

### Without Cache

```sql
SELECT COUNT(*) FROM fireCalls
```

### Use of `CACHE`

```sql
CACHE TABLE fireCalls
```

### Use of `UNCACHE`

```sql
UNCACHE TABLE fireCalls
```


### Use of `CACHE LAZY` 

```sql
CACHE LAZY TABLE fireCalls
```

## Set the Number of Shuffle Partition

```SET spark.sql.shuffle.partition=8```