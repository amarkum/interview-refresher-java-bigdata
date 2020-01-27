# Hive Notes
### show databases

```sql
show databases;
```

### create database

```sql
create database bixi;
```

### use database
```sql
use bixi;
```


### create internal table
```sql
create table bixidata(startdate STRING, startstationcode INT, enddata STRING, endstationcode INT, durationsec INT, ismember INT) 
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ',' 
STORED AS TEXTFILE;
```

### show tables;
```
show tables;
```

### describe table;
```sql
describe tableName;
```

```sql
describe formatted tableName;
```


### load data
```sql
LOAD DATA [LOCAL] INPATH [PATH] INTO TABLE [TABLENAME];
```

If the Input is from local path, we can mention local
sql
```
LOAD DATA INPATH '/user/cloudera/BixiMontrealRentals2019' INTO TABLE bixidata;
```

Output

```bash
hive> LOAD DATA INPATH '/user/cloudera/BixiMontrealRentals2019' INTO TABLE bixidata;
Loading data to table bixi.bixidata
Table bixi.bixidata stats: [numFiles=7, totalSize=320686072]
OK
Time taken: 0.65 seconds
```


### create Hive tables from AVRO records 

```sql
CREATE EXTERNAL TABLE person_avro
STORED AS AVRO
LOCATION '/user/cloudera/avro-collection'
TBLPROPERTIES ('avro.schema.url'='hdfs:///user/cloudera/userdata.avsc');
```
 
### update the SCHEMA

```sql
ALTER TABLE person_avro SET TBLPROPERTIES ('avro.schema.url'='hdfs:///user/cloudera/userdata.avsc')
ALTER TABLE person_avro SET TBLPROPERTIES('transactional'='true');
```

### create a managed table from value from AVRO table

```sql
CREATE TABLE AVRO_INTERNAL_TABLE
STORED AS AVRO
TBLPROPERTIES ('avro.schema.url'='hdfs:///user/cloudera/userdata.avsc')
INSERT OVERWRITE TABLE AVRO_INTERNAL_TABLE SELECT * FROM person_avro;
```


### Insert, Update & Delete Table

```sql
INSERT INTO TABLE tablename [PARTITION (partcol1[=val1], partcol2[=val2] ...)] VALUES values_row [, values_row ...]
UPDATE tablename SET column = value [, column = value ...] [WHERE expression]
DELETE FROM tablename [WHERE expression]
```

### To Update, Delete the table in Hive, it must be stored in ORC format.
```sql
CREATE TABLE ORC_PERSON_TABLE
STORED AS ORC
INSERT OVERWRITE TABLE ORC_PERSON_TABLE SELECT * FROM person_avro;
```

### enable update
```bash
set hive.auto.convert.join.noconditionaltask.size = 10000000; 
set hive.support.concurrency = true; 
set hive.enforce.bucketing = true; 
set hive.exec.dynamic.partition.mode = nonstrict; 
set hive.txn.manager = org.apache.hadoop.hive.ql.lockmgr.DbTxnManager; 
set hive.compactor.initiator.on = true; 
set hive.compactor.worker.threads = 1; 
```

### enable delete
```bash
set hive.auto.convert.join.noconditionaltask.size = 10000000; 
set hive.support.concurrency = true; 
set hive.enforce.bucketing = true; 
set hive.exec.dynamic.partition.mode = nonstrict; 
set hive.txn.manager = org.apache.hadoop.hive.ql.lockmgr.DbTxnManager;
set hive.compactor.initiator.on = true;
set hive.compactor.worker.threads = 1; 
```

### Create ORC Table
```sql
create table testTableNew(id int ,name string ) clustered by (id) into 2 buckets stored as orc TBLPROPERTIES('transactional'='true');
```


### UDF in Hive
There are 3 `UDF` in Hive


1. Regular UDF <br/>
2. User Defined Aggregate Function (UDAF) <br/>
3. User Defined Tabular Function (UDTF) <br/>

How to add a Custom User Defined function in  Hive

```text
> hive
hive> ADD JAR /path/to/interview-brushups-1.0-SNAPSHOT-jar-with-dependencies.jar;
hive> CREATE TEMPORARY FUNCTION HELLO AS 'com.interview.brushups.hive.HelloUDF';
hive> SELECT HELLO(FIRSTNAME) FROM POPULATION LIMIT 10;
```

## Functions in HIVE

```text
!                         !=                        $ELEM$                    $KEY$                     
$VALUE$                   $elem$                    $key$                     $value$                   
%                         &                         (                         )                         
);                        *                         +                         ,                         
-                         .                         /                         :                         
<                         <=                        <=>                       <>                        
=                         ==                        >                         >=                        
ADD                       ALL                       ALTER                     AND                       
ARRAY                     AS                        ASC                       BIGINT                    
BINARY                    BOOLEAN                   BUCKET                    BUCKETS                   
BY                        CAST                      CLUSTER                   CLUSTERED                 
COLLECTION                COLUMNS                   COMMENT                   CREATE                    
DATA                      DATE                      DATETIME                  DEFAULT                   
DEFINED                   DELIMITED                 DESC                      DESCRIBE                  
DIRECTORY                 DISTINCT                  DISTRIBUTE                DOUBLE                    
DROP                      EXPLAIN                   EXTENDED                  EXTERNAL                  
FALSE                     FIELDS                    FLOAT                     FORMAT                    
FROM                      FULL                      FUNCTION                  GROUP                     
INPATH                    INPUTFORMAT               INSERT                    INT                       
INTO                      IS                        ITEMS                     JOIN                      
KEYS                      LEFT                      LIKE                      LIMIT                     
LINES                     LOAD                      LOCAL                     LOCATION                  
MAP                       MSCK                      NONE                      NOT                       
NULL                      OF                        ON                        OR                        
ORDER                     OUT                       OUTER                     OUTPUTFORMAT              
OVERWRITE                 PARTITION                 PARTITIONED               PARTITIONS                
PURGE                     REDUCE                    REGEXP                    RENAME                    
REPLACE                   REWRITE                   RIGHT                     RLIKE                     
ROW                       SELECT                    SEQUENCEFILE              SERDE                     
SERDEPROPERTIES           SET                       SHOW                      SMALLINT                  
SORT                      SORTED                    STORED                    STRING                    
SUBQUERY                  TABLE                     TABLES                    TABLESAMPLE               
TBLPROPERTIES             TEMPORARY                 TERMINATED                TEXTFILE                  
TIMESTAMP                 TINYINT                   TO                        TRANSFORM                 
TRUE                      UNION                     UPDATE                    USING                     
VALUES                    WHERE                     WITH                      [                         
\'                        ]                         ^                         abs(                      
acos(                     add                       add_months(               all                       
alter                     and                       and(                      array                     
array(                    array_contains(           as                        asc                       
ascii(                    asin(                     assert_true(              atan(                     
avg(                      base64                    between(                  bigint                    
bigint(                   bin(                      binary                    binary(                   
boolean                   boolean(                  bucket                    buckets                   
by                        case(                     cast                      cbrt(                     
ceil(                     ceiling(                  char(                     cluster                   
clustered                 coalesce(                 collect_list(             collect_set(              
collection                columns                   comment                   compute_stats(            
concat(                   concat_ws(                context_ngrams(           conv(                     
corr(                     cos(                      count(                    covar_pop(                
covar_samp(               crc32                     create                    create_union(             
cume_dist(                current_database(         current_date(             current_timestamp(        
current_user(             data                      date                      date(                     
date_add(                 date_format(              date_sub(                 datediff(                 
datetime                  day(                      dayofmonth(               dayofweek(                
decimal(                  decode(                   default                   defined                   
degrees(                  delimited                 dense_rank(               desc                      
describe                  directory                 distinct                  distribute                
div(                      double                    double(                   drop                      
e(                        elt(                      encode(                   ewah_bitmap(              
ewah_bitmap_and(          ewah_bitmap_empty(        ewah_bitmap_or(           exp(                      
explain                   explode(                  extended                  external                  
false                     field(                    fields                    find_in_set(              
first_value(              float                     float(                    floor(                    
format                    format_number(            from                      from_unixtime(            
from_utc_timestamp(       full                      function                  get_json_object(          
greatest(                 group                     hash(                     hex(                      
histogram_numeric(        hour(                     if(                       in(                       
in_file(                  index(                    initcap(                  inline(                   
inpath                    inputformat               insert                    instr(                    
int                       int(                      into                      is                        
isnotnull(                isnull(                   items                     java_method(              
join                      json_tuple(               keys                      lag(                      
last_day(                 last_value(               lcase(                    lead(                     
least(                    left                      length(                   levenshtein(              
like                      like(                     limit                     lines                     
ln(                       load                      local                     locate(                   
location                  log(                      log10                     log2                      
logged_in_user(           lower(                    lpad(                     ltrim(                    
map                       map(                      map_keys(                 map_values(               
matchpath(                max(                      md5                       min(                      
minute(                   month(                    months_between(           msck                      
named_struct(             negative(                 next_day(                 ngrams(                   
none                      noop(                     noopstreaming(            noopwithmap(              
noopwithmapstreaming(     not                       not(                      ntile(                    
null                      nvl(                      of                        on                        
or                        or(                       order                     out                       
outer                     outputformat              overwrite                 parse_url(                
parse_url_tuple(          partition                 partitioned               partitions                
percent_rank(             percentile(               percentile_approx(        pi(                       
pmod(                     posexplode(               positive(                 pow(                      
power(                    printf(                   purge                     radians(                  
rand(                     rank(                     reduce                    reflect(                  
reflect2                  regexp                    regexp(                   regexp_extract(           
regexp_replace(           rename                    repeat(                   replace                   
reverse(                  rewrite                   right                     rlike                     
rlike(                    round(                    row                       row_number(               
rpad(                     rtrim(                    second(                   select                    
sentences(                sequencefile              serde                     serdeproperties           
set                       sha2                      show                      sign(                     
sin(                      size(                     smallint                  smallint(                 
sort                      sort_array(               sorted                    soundex(                  
space(                    split(                    sqrt(                     stack(                    
std(                      stddev(                   stddev_pop(               stddev_samp(              
stored                    str_to_map(               string                    string(                   
struct(                   subquery                  substr(                   substring(                
sum(                      table                     tables                    tablesample               
tan(                      tblproperties             temporary                 terminated                
textfile                  timestamp                 timestamp(                tinyint                   
tinyint(                  to                        to_date(                  to_unix_timestamp(        
to_utc_timestamp(         transform                 translate(                trim(                     
true                      trunc(                    ucase(                    unbase64                  
unhex(                    union                     unix_timestamp(           update                    
upper(                    using                     uuid(                     values                    
var_pop(                  var_samp(                 varchar(                  variance(                 
version(                  weekofyear(               when(                     where                     
windowingtablefunction(   with                      xpath(                    xpath_boolean(            
xpath_double(             xpath_float(              xpath_int(                xpath_long(               
xpath_number(             xpath_short(              xpath_string(             year(                     
|                         
```

# Partitioning and Bucketing

## I. Partitioning

### why Derby is not used  for metastore?
Because, we can't run multiple instances of HIVE if we are using Derby.

### show the current database being use
```bash
set hive.cli.print.current.db = true;
```

### Partition Type
1. Static Partition

Create a table.
```sql
create table bixidata(startdate STRING, startstationcode INT, enddata STRING, endstationcode INT, durationsec INT) partitioned by (ismember INT);
```

Load the data into the table.
```sql
LOAD DATA INPATH '/user/cloudera/BixiMontrealRentals2019/ismember1.txt' INTO TABLE bixidata
partiion(ismember="1");
```

2. Dynamic Partition

By default, dynamic partition will be disabled, we should enable it by

```bash
SET hive.exec.dynamic.partition = true;
SET hive.exec.dynamic.partition.mode = nonstrict;
```

Create a partitioned table

```sql
create table biximontreal(startdate STRING, startstationcode INT, enddata STRING, endstationcode INT, durationsec INT) partitioned by (ismember INT);
```

load data into partitioned Table. The partitioned column must be at the last.

```sql
INSERT OVERWRITE TABLE biximontreal PARTITION(ismember)
SELECT startdate, startstationcode, enddata, endstationcode, durationsec, ismember from bixidata;
```


## II. bucketing
In order to enable bucketing, we need to set as below
```bash
SET hive.enforce.bucketing=true;
```

Partitioning with Bucketing
```sql
create table biximontreal(startdate STRING, startstationcode INT, enddata STRING, endstationcode INT, durationsec INT) partitioned by (ismember INT) clustered by(durationsec) into 4 buckets
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ',' 
STORED AS TEXTFILE;
```

Data  Sampling

```sql
select * from bixidata;
TABLESAMPLE(BUCKET 2 OUT OF 5 ON ISMEMBER)
```

### Map Side Join
Performed at Map Phase without involvement of Reduce Phase. </br>
Perform Join by importing small table into memory and therefore speeding execution.
