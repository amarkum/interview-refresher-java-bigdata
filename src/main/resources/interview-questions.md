"""
# Big Data, Java, SQL, and OS Interview Questions

## Hadoop Interview Questions
1. **What is a Combiner?**  
   _Companies: Legato, Impetus_

2. **What is the difference between `hadoop fs`, `hadoop dfs`, and `hdfs dfs` commands?**  
   _Company: Legato_

3. **What is the difference between `put`, `copyFromLocal`, `get`, and `copyToLocal` commands?**  
   _Company: Legato_

4. **Explain the difference between AVRO, ORC, and Parquet file formats.**  
   _Companies: Fidelity, Paypal_

5. **Which scheduler is used, and what is the version of Oozie?**  
   _Company: ThoughtWorks_

6. **How does ZooKeeper assign a follower when the leader goes down?**  
   _Company: ThoughtWorks_

7. **How can we create a Hive table on HBase?**  
   _Company: Deloitte_

8. **Will Hive continue executing a query if the cluster is back after failure?**  
   _Company: Subex_

9. **Write a Kafka Producer and Consumer program.**  
   _Company: OpenText_

10. **Explain Hive bucketing and partitioning.**  
   _Company: Impetus_

11. **When should we use bucketing vs partitioning in Hive?**  
   _Company: Impetus_

12. **What are UDFs (User Defined Functions) in Hive?**  
   _Company: Deloitte_

13. **Explain the `hdfs -getmerge` command.**  
   _Company: Sear Holding_

14. **Using HBase shell, how can we retrieve data from a column family?**  
   _Company: Sear Holding_

15. **How do we bulk load data from HDFS to HBase?**  
   _Company: Rapido_

16. **Describe the architecture of HBase.**  
   _Companies: Rapido, Tavant_

17. **What is Tombstoning in HBase?**  
   _Company: Rapido_

---

## Kafka Interview Questions
1. **What are offsets in Kafka?**  
   _Company: Sianr Mas Group_

2. **What are ISR (In-Sync Replicas)?**  
   _Company: Sianr Mas Group_

3. **List commands to list topics, delete a topic, and run a producer and consumer.**  
   _Company: Sianr Mas Group_

4. **Explain the concept of consumer and consumer group in Kafka.**  
   _Company: Sianr Mas Group_

5. **Describe the architecture of Kafka.**  
   _Company: Rapido_

6. **If a producer is producing faster than the consumer can handle, how can we fix this?**  
   _Company: HappiestMinds_

---

## Hive Interview Questions
1. **What is static partitioning and dynamic partitioning in Hive?**  
   _Company: Yodlee_

2. **What are the datatypes in Hive?**  
   _Company: UST Global_

3. **How do you load a CSV with 4 columns combined into 1 column in Hive?**  
   _Company: Synechron_

---

## Spark Interview Questions
1. **Explain cache and persist in Spark.**  
   _Company: Virtusa_

2. **What are the levels of cache in Spark?**  
   _Company: Virtusa_

3. **What is a sliding window in Spark?**  
   _Company: Virtusa_

4. **How to submit a Spark job?**  
   _Company: Virtusa_

5. **Explain joining an RDD in Spark.**  
   _Company: Virtusa_

6. **What are broadcast variables and accumulators in Spark?**  
   _Company: Virtusa_

7. **Explain the difference between repartition and coalesce.**  
   _Company: Virtusa_

8. **How do you join two columns in a DataFrame?**  
   _Company: Lowe's_

9. **How can you calculate the difference by the last row in Spark?**  
   _Company: Virtusa_

10. **At which phase does Spark load data into memory?**  
   _Company: Synechron_

11. **What is the difference between map and mapPartitions?**  
   _Company: HappiestMinds_

12. **How does Spark handle files larger than main memory?**  
   _Company: Tavant_

13. **What is lineage in Spark?**  
   _Company: L&T_

14. **What is lazy evaluation in Spark?**  
   _Company: L&T_

15. **What is narrow transformation in Spark?**  
   _Company: L&T_

16. **What is speculative execution in Spark?**  
   _Company: Quantiphi_

---

## Java Interview Questions
1. **How do you detect a loop in a LinkedList?**  
   _Company: OpenText_

2. **How to print the diagonal of a square matrix in Java?**  
   _Company: OpenText_

3. **How do you reverse a LinkedList?**  
   _Company: Impetus_

4. **How do you add a node after a given node in a LinkedList?**  
   _Company: Ordr_

5. **Explain the producer-consumer problem.**  
   _Company: OpenText_

6. **What is a singleton class with double locking?**  
   _Company: OpenText_

7. **How do you find an anagram of a word?**  
   _Company: Subex_

8. **How to find palindrome numbers in an array?**  
   _Company: Epsilon_

9. **What is try-with-resources in Java (introduced in Java 1.7)?**  
   _Company: Genpact_

10. **Explain deep cloning in Java.**  
   _Company: Genpact_

11. **What are executors in Java?**  
   _Company: Sear Holding_

12. **What is a Java semaphore?**  
   _Company: Genpact_

13. **Explain the concept of a cyclic barrier in Java.**  
   _Company: Genpact_

14. **What are the key differences between Java 6 and Java 7?**  
   _Company: Genpact_

15. **How do you create a custom exception in Java?**  
   _Company: Sear Holdings_

16. **What is the difference between final, finally, and finalize in Java?**  
   _Company: Sear Holdings_

17. **What are iterators and list iterators in Java?**  
   _Company: Sear Holdings_

18. **How do you implement the Fibonacci series using recursion?**  
   _Company: Subex_

19. **Explain composition and aggregation in Java.**  
   _Company: Genpact_

20. **How do you traverse and print data from the middle to the last of a LinkedList?**  
   _Company: KPMG_

21. **How do you find the maximum and minimum values in a HashMap?**  
   _Company: KPMG_

22. **How do you reverse a string using recursion in Java?**  
   _Company: KPMG_

23. **What is the difference between List, Set, and HashMap in Java?**  
   _Company: KPMG_

24. **Can an Integer hold a null value in Java?**  
   _Company: Sianr Mas Group_

25. **What is the performance comparison between an interface and an abstract class?**  
   _Company: Sianr Mas Group_

26. **What are the Diamond Problem and SOLID principles?**  
   _Company: Sianr Mas Group_

27. **What is a String pool in Java?**  
   _Company: Sianr Mas Group_

28. **Explain block-level and method-level synchronization in Java.**  
   _Company: Sianr Mas Group_

29. **What is the difference between ArrayList and LinkedList in Java?**  
   _Company: Sianr Mas Group_

30. **Explain Comparable and Comparator in Java.**  
   _Company: Sianr Mas Group_

31. **What is the difference between Runnable and Callable in Java?**  
   _Company: Syncheron_

32. **What are executor services in Java?**  
   _Company: Syncheron_

33. **What are the different ways to implement a thread in Java?**  
   _Company: Syncheron_

34. **What is TreeMap used for in Java?**  
   _Company: Syncheron_

35. **What is the difference between an abstract class and an interface in Java?**  
   _Company: GlobalLogic_

36. **How do you implement an immutable class in Java?**  
   _Company: GlobalLogic_

37. **What is a ConcurrentHashMap in Java?**  
   _Company: Virtusa_

38. **What is the difference between HashSet and TreeSet in Java?**  
   _Company: Virtusa_

39. **Why do we use lambda expressions in Java?**  
   _Company: Virtusa_

40. **Why do we use the Stream API in Java?**  
   _Company: Virtusa_

41. **What happens if we make `public static void main()` private in Java?**  
   _Company: Virtusa_
42. **What are Executor Services in Java, and how do we initialize them?**  
   _Company: Virtusa_

   ExecutorService manages thread pools and allows asynchronous execution. It can be initialized using `Executors.newFixedThreadPool()` or similar methods.

43. **How to create a Singleton class in Java for a multi-threading environment?**  
   _Company: Virtusa_

   To ensure thread safety, you can implement the Singleton pattern using double-checked locking or using `enum` to create a Singleton class.

44. **What is try-with-resources in Java?**  
   _Company: Virtusa_

   Introduced in Java 7, try-with-resources automatically closes resources like streams or connections once they are no longer needed. It works with objects that implement `AutoCloseable`.

45. **What is fail-fast & fail-safe?**  
   _Company: DansakeIT_

   - **Fail-Fast**: Throws `ConcurrentModificationException` if a collection is modified while iterating (e.g., `ArrayList`).
   - **Fail-Safe**: Works on a clone of the collection, so it does not throw exceptions during iteration (e.g., `CopyOnWriteArrayList`).

46. **How do you implement a Concurrent HashMap?**  
   _Company: DansakeIT_

   ConcurrentHashMap allows concurrent read and write operations by dividing the map into segments. This ensures better performance in multi-threaded environments.

47. **With two threads printing odd and even numbers, how do you print the sequence of numbers?**  
   _Company: Rapido_

   You can use synchronization with `wait()` and `notify()` methods to alternate between threads, ensuring that one thread prints odd numbers while the other prints even.

48. **What is composition, isA, and hasA relationship in Java?**  
   _Company: Accolite_

   - **Composition**: Represents a strong "has-a" relationship where one object contains another object (e.g., `Car has an Engine`).
   - **isA**: Represents inheritance (e.g., `Dog is an Animal`).
   - **hasA**: Represents aggregation (e.g., `Library has Books`).

49. **What is the difference between HashMap and LinkedHashMap?**  
   _Company: Accolite_

   - **HashMap**: Does not maintain any order of entries.
   - **LinkedHashMap**: Maintains insertion order of elements.

50. **Why is the `wait()` method part of the Object class and not the Thread class?**  
   _Company: Accolite_

   `wait()` operates on the monitor of an object and is thus part of the `Object` class. It allows any thread holding the object's lock to wait for some condition to be met.

51. **What is Auto-Boxing and Unboxing in Java?**  
   _Company: ProKarma_

   - **Auto-Boxing**: Automatic conversion of primitive types to their corresponding wrapper objects (e.g., `int` to `Integer`).
   - **Unboxing**: Automatic conversion of wrapper class objects to primitive types (e.g., `Integer` to `int`).

52. **What is Deadlock & Race Condition in Java?**  
   _Company: Walmart_

   - **Deadlock**: Occurs when two or more threads are blocked, each waiting for the other to release a lock.
   - **Race Condition**: Happens when two or more threads access shared data concurrently, leading to unpredictable outcomes.

53. **Detect if a Tree is a Binary Search Tree (BST).**  
   _Company: JP Morgan & Chase Co._

   To check if a tree is a BST, ensure that for every node, the values in the left subtree are smaller, and the values in the right subtree are larger.

54. **What are the different ways to traverse a tree?**  
   _Company: JP Morgan & Chase Co._

   - **In-order Traversal**: Left, Root, Right
   - **Pre-order Traversal**: Root, Left, Right
   - **Post-order Traversal**: Left, Right, Root
   - **Level-order Traversal**: Traverses the tree level by level.

55. **Traverse a tree and link siblings of nodes at the same level.**  
   _Company: OLA Cabs_

   Use a level-order traversal to link siblings at the same level in a binary tree.

# SQL Interview Questions
```text
1.) Find nth Salary from salary table - Impetus
2.) Find the sum of spend by an ID - KPMG
3.) what is PRIMARY Key and UNIQUE key - Virtusa
4.) Can PRIMARY key have a NULL value - Virtusa
5.) Difference between INNER JOIN and OUTER JOIN - Virtusa
6.) Find the maximum salary in each department and name of the employee - HappiestMinds, Lowe's
```

# Network & OS Interview Questions
```text
1.) What happens if the directory file size is 20KB, but it occupies 90GB of data, what are iNodes in UNIX - OLA Cabs
2.) What is Context-Switching - OLA Cabs
3.) Difference between process and threads - OLA Cabs
4.) Difference between TCP/IP & UDP - OLA Cabs
```

# Miscellaneous Interview Questions
```text
1.) What is Micro-service Architecture? - Walmart
2.) Difference between Authentication and Authorization - Walmart
```
