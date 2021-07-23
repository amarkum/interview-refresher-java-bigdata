# Concurrency & Multi-threading 

## Definition

1. Concurrency - Machine or software application executing multiple tasks. <br/>
2. Parallelism - Running task exactly at the same time.

## Process Vs. Thread
Process 
- Represents an application, or a program
- Self contained execution environment
- Adding new process is a costly business.
- Switch between process (IPC)

Thread
- Lightweight instance within a process
- E.g MS Word - Spell Check, Edit
- Creating new thread requires fewer resource
- Can be used via Multithreading API
- every java program has default main thread
- many threads can run concurrently in java program
- threads can be used to perform time-intensive tasks

## Concurrency
A system capable of running several distinct programs<br/>
or more than one independent unit of the same program in overlapping time intervals is called a concurrent system

## Parallelism
A parallel system is one which necessarily has the ability to execute multiple programs at the same time. 

## Scheduling and Thread Priorities
When we have a single CPU, all the threads have to share it,order of thread execution is scheduling.
 
## `synchronized` - keyword
Synchronized is used to restrict access to critical sections one thread at a time

## `volatile` - keyword
If a variable is declared volatile then whenever a thread writes or reads to the volatile variable, <br/>
the read and write always happen in the main memory. As a further guarantee, <br/>
all the variables that are visible to the writing thread also get written-out to the main memory alongside the volatile variabl

## Thread methods
`start()` - starts the execution of the thread.JVM calls the run() <br/>
`join()` - complete the current thread execution until done, other thread waits for the thread to die<br/>
`sleep()` - sleep is used to sleep a thread for the specified amount of time

## Thread scheduler 
Thread scheduler in java is the part of the JVM that decides which thread should run.<br/>
There is no guarantee that which runnable thread will be chosen to run by the thread scheduler.<br/>
Only one thread at a time can run in a single process.<br/>
The thread scheduler mainly uses `preemptive` or `time slicing` scheduling to schedule the threads.<br/>
 
# Java Thread pool 
It represents a group of worker threads that are waiting for the job and reuse many times.<br/> 
In thread pool, a group of fixed size threads are created.<br/>
A thread from the thread pool is pulled out and assigned a job by the service provider. <br/>
After completion of the job, thread is contained in the thread pool again

We can create a Thread Pool, using Executor Services
```java 
ExecutorService executorService = Executors.newFixedThreadPool(5);
```

Submit the thread to `executorService.execute(thread)` for execution.<br/>
The execution of task will be done by 5 threads in the ThreadPool

Note: Staring a thread twice, will lead to `java.lang.IllegalThreadStateException`

## Daemon Thread
- Thread by default is a non-daemon thread
- Daemon thread don't stop the JVM from ending

E.g. Java Garbage collection runs on a daemon thread.<br/>
A daemon thread is created by calling `setDaemon(true)`<br/>
