# Spark Notes

# Spark - Introduction
## What is Apache Spark?
Apache Spark is an open-source distributed general-purpose cluster-computing framework.<br/>
Spark provides an interface for programming entire clusters with implicit data parallelism and fault tolerance. 

- Spark can access any Hadoop data source, also can run on Hadoop clusters
- Spark is independent of Hadoop since it has its own cluster management system.<br/>
  Basically, it uses Hadoop for storage purpose only.

## Spark is a one-stop solution for
- Apache Hadoop / MapReduce - To perform batch processing.
- Apache Storm -  Stream processing
- Apache Impala / Apache Tez - for interactive processing.
- Neo4j / Apache Giraph  - to perform graph processing.

## Components of Spark
- Spark SQL
- Spark Streaming
- Spark MLib
- Spark GraphX
- Spark R

all of which are executed on top of `Spark Core`

### Resilient Distributed Dataset – RDD
The abstraction of Spark is RDD. It is fundamental unit of spark which is immutable in nature.<br/>
It is a distributed collection of elements across cluster nodes.

#### What are different ways to Create an RDD?
1. Parallelizing a Collection
2. External Dataset 
3. RDD Transformation

### Anatomy of Spark Job
a Spark application doesn’t “do anything” until the driver program calls an action. <br/>
With each action, the Spark scheduler builds an execution graph and launches a Spark job. <br/>
Each job consists of stages, which are steps in the transformation of the data needed to materialize the final RDD. <br/>
Each stage consists of a collection of tasks that represent each parallel computation and are performed on the executors.

### Running Spark
Spark can run on YARN, Mesos or Standalone <br/>
Drawback in running spark on standalone mode is that, it has to be installed on every machine.

### Memory Management
Spark offers three options for memory management:  <br/>
in-memory as deserialized data,  <br/>
in-memory as serialized data, and on disk.

### SparkContext
The SparkCon text represents the connection between a Spark cluster and one running Spark application. <br/>
The SparkContext can be used to create an RDD from a local Scala object <br/>
(using the makeRDD or parallelize methods) or by reading from stable storage (text files, binary files, a Hadoop Context, or a Hadoop file). <br/>
DataFrames and Data sets can be read using the Spark SQL equivalent to a SparkContext, the SparkSession.

#### What are different operation that RDD Supports?
1. `Transformation` - It results into a new RDD.<br/>
2. `Action` - Action is the endpoint for the transformation where the final result is returned to driver program.

## Spark Stages
A stage is nothing but a step in a physical execution plan. It is a physical unit of the execution plan.<br/>
It is a set of parallel tasks i.e. one task per partition

There are two types of stages<br/>

1. `ShuffleMapStage` in Spark - (similar as Map in MapReduce )
    It can only work on the partitions of a single RDD<br/>  
2. `ResultStage` in Spark - (similar as Reduce in MapReduce)
    ResultStage implies as a final stage in a job that applies a function on one or many partitions of the target RDD in Spark. 

# Spark SQL

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