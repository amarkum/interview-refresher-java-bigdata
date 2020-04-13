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

## Scheduling and Thread Priorities
- When we have a single CPU, all the threads have to share it.<br/>
 order of thread execution is scheduling.