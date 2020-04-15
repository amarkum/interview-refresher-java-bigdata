# Concurrency & Multi-threading 

## Defintition

1. Concurrency - Machine or software application executing multiple tasks. <br/>
2. Parallelism - Running task exactly at the same time.


## Process Vs. Thread
Process 
- Represents an application or a program
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

## Scheduling and Thread Priorities
- When we have a single CPU, all the threads have to share it.<br/>
 order of thread execution is scheduling.
 
 ## Daemon Thread
- Thread by default is a non-daemon thread
- Daemon thread don't stop the JVM from ending

E.g Java Garbage collection runs on a daemon thread.<br/>
A daemon thread is created by calling `setDaemon(true)`<br/>
