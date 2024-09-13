
# Java Interview Questions & Answers

### 1. Finding a Loop in a LinkedList - Opentext
To detect a loop in a linked list using Floyd's Cycle-Finding Algorithm (Tortoise and Hare Algorithm):

```java
public class LinkedListLoopDetection {
    static class Node {
        int data;
        Node next;
    }

    public static boolean hasLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
```

### 2. Print the Diagonal of a Square Matrix - Opentext
To print the main diagonal elements of a square matrix:

```java
public class DiagonalMatrix {
    public static void printMainDiagonal(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][i] + " ");
        }
    }
}
```

To print the anti-diagonal:

```java
public static void printAntiDiagonal(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
        System.out.print(matrix[i][n - i - 1] + " ");
    }
}
```

### 3. Reverse a LinkedList - Impetus
To reverse a singly linked list:

```java
public class LinkedListReversal {
    static class Node {
        int data;
        Node next;
    }

    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}
```

### 4. Add a Node After in LinkedList - Ordr
To insert a node after a given node:

```java
public class LinkedListInsertion {
    static class Node {
        int data;
        Node next;
    }

    public static void insertAfter(Node prevNode, int newData) {
        if (prevNode == null) {
            System.out.println("Previous node cannot be null");
            return;
        }
        Node newNode = new Node();
        newNode.data = newData;
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }
}
```

### 5. Producer & Consumer Problem - Opentext
Using a `BlockingQueue` to solve the Producer-Consumer problem:

```java
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerExample {
    static class Producer implements Runnable {
        private BlockingQueue<Integer> queue;

        public Producer(BlockingQueue<Integer> q) {
            this.queue = q;
        }

        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    queue.put(i);
                    System.out.println("Produced " + i);
                }
                queue.put(-1); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {
        private BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue<Integer> q) {
            this.queue = q;
        }

        public void run() {
            try {
                int value;
                while ((value = queue.take()) != -1) {
                    System.out.println("Consumed " + value);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}
```

### 6. Singleton Class with Double Locking - Opentext
Implementing a thread-safe singleton using double-checked locking:

```java
public class Singleton {
    private volatile static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

### 7. Find Anagram of a Word - Subex
To check if two strings are anagrams:

```java
import java.util.Arrays;

public class AnagramChecker {
    public static boolean areAnagrams(String str1, String str2) {
        char[] arr1 = str1.replaceAll("\s", "").toLowerCase().toCharArray();
        char[] arr2 = str2.replaceAll("\s", "").toLowerCase().toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}
```

### 8. Find Palindrome in an Array - Epsilon
To find palindrome numbers in an array:

```java
public class PalindromeFinder {
    public static boolean isPalindrome(int number) {
        int original = number;
        int reverse = 0;
        while (number != 0) {
            int digit = number % 10;
            reverse = reverse * 10 + digit;
            number /= 10;
        }
        return original == reverse;
    }

    public static void findPalindromes(int[] array) {
        for (int num : array) {
            if (isPalindrome(num)) {
                System.out.println(num + " is a palindrome");
            }
        }
    }
}
```

### 9. What is Try-With-Resources in Java 1.7 - Genpact
Try-with-resources is a statement that declares one or more resources that are automatically closed at the end of the statement:

```java
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    String line;
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### 10. What is Deep Cloning? - Genpact
Deep cloning creates a new object and recursively clones its fields:

```java
public class DeepCloneExample implements Cloneable {
    private int id;
    private String name;
    private Address address; // Assume Address implements Cloneable

    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepCloneExample cloned = (DeepCloneExample) super.clone();
        cloned.address = (Address) address.clone();
        return cloned;
    }
}
```

### 11. Executors - Sear Holding
An ExecutorService manages a pool of threads and executes tasks asynchronously:

```java
ExecutorService executor = Executors.newFixedThreadPool(5);

for (int i = 0; i < 10; i++) {
    Runnable worker = new MyRunnable("" + i);
    executor.execute(worker);
}
executor.shutdown();
```

### 12. Java Semaphore - Genpact
Using Semaphore to control access to a resource:

```java
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    private static Semaphore semaphore = new Semaphore(3); // 3 permits

    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " acquired permit.");
                Thread.sleep(2000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " releasing permit.");
                semaphore.release();
            }
        };

        for (int i = 0; i < 6; i++) {
            new Thread(r).start();
        }
    }
}
```

### 13. CyclicBarrier - Genpact
Using CyclicBarrier to synchronize threads:

```java
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    private static CyclicBarrier barrier = new CyclicBarrier(3, () -> {
        System.out.println("All parties have arrived, proceeding...");
    });

    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(r).start();
        }
    }
}
```

### 14. Difference Between Java 6 & 7 - Genpact
Key differences between Java 6 and 7:

- **Try-with-resources**: Automatic resource management.
- **Diamond Operator**: Type inference for generics.
- **Strings in Switch**: Using String in switch statements.
- **Fork/Join Framework**: For parallel processing.
- **NIO.2**: Enhanced file I/O capabilities.

### 15. How to Create a Custom Exception - Sear Holdings
Creating a custom exception by extending the `Exception` class:

```java
public class MyCustomException extends Exception {

    public MyCustomException() {
        super();
    }

    public MyCustomException(String message) {
        super(message);
    }
}
```


### 16. Difference between final, finally, and finalize - Sear Holdings
- **final**: Used to define constants or to prevent inheritance and method overriding.
- **finally**: Block in exception handling that always executes regardless of whether an exception occurs.
- **finalize**: Method called by the garbage collector before an object is reclaimed.

### 17. Iterator and ListIterator - Sear Holdings
- **Iterator**: Traverses collections in a forward direction, does not allow modifying the collection during iteration.
- **ListIterator**: Traverses lists in both directions, allows modifying elements, can get indexes of elements.

### 18. Fibonacci Series Using Recursion - Subex
To implement Fibonacci series using recursion:

```java
public class FibonacciRecursion {

    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
```

### 19. What is Composition and Aggregation? - Genpact
- **Composition**: A strong relationship where the part cannot exist without the whole.
- **Aggregation**: A weak relationship where the part can exist independently of the whole.

### 20. Traverse and Print from Middle to Last of the LinkedList - KPMG
To traverse and print the elements from the middle to the end of the linked list:

```java
public class LinkedListMiddleToEnd {
    static class Node {
        int data;
        Node next;
    }

    public static void printFromMiddle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node current = slow;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
```

### 21. Find Maximum and Minimum Value in a HashMap - KPMG
To find the maximum and minimum values in a HashMap:

```java
import java.util.Collections;
import java.util.HashMap;

public class HashMapMinMax {
    public static void findMinMax(HashMap<String, Integer> map) {
        int maxValue = Collections.max(map.values());
        int minValue = Collections.min(map.values());

        System.out.println("Maximum Value: " + maxValue);
        System.out.println("Minimum Value: " + minValue);
    }
}
```

### 22. Reverse a String Using Recursion - KPMG
To reverse a string using recursion:

```java
public class StringReverseRecursion {

    public static String reverse(String str) {
        if (str.isEmpty())
            return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }
}
```

### 23. Difference Between List, Set, and HashMap - KPMG
- **List**: Ordered collection, allows duplicates, accessed by index.
- **Set**: Unordered collection, no duplicates allowed.
- **HashMap**: Key-value pairs, unique keys, allows duplicate values.

### 24. Does Integer Allow a Null Value? - Sianr Mas Group
Yes, the Integer wrapper class allows null values because it's an object reference, unlike the primitive int.

### 25. Performance Comparison of Interface and Abstract Class - Sianr Mas Group
There is no significant performance difference between an interface and an abstract class. The choice depends on the design; interfaces are for defining behavior, while abstract classes are for shared code and behavior.

### 26. Diamond Principle and SOLID Principles - Sianr Mas Group
- **Diamond Problem**: Issue in multiple inheritance when a class inherits from two classes with the same method. Java resolves this by not supporting multiple inheritance of classes.
- **SOLID Principles**: Guidelines for object-oriented design:
  1. **Single Responsibility Principle**: A class should have one reason to change.
  2. **Open/Closed Principle**: Classes should be open for extension, but closed for modification.
  3. **Liskov Substitution Principle**: Objects should be replaceable by instances of their subclasses.
  4. **Interface Segregation Principle**: Clients should not be forced to depend on interfaces they do not use.
  5. **Dependency Inversion Principle**: Depend on abstractions, not on concretions.

### 27. String Pool in Java - Sianr Mas Group
The string pool is a special memory region where Java stores string literals to save memory and improve performance. Strings in the pool are shared, meaning identical literals point to the same memory location.

### 28. Block Synchronization vs. Method-Level Synchronization - Sianr Mas Group
- **Method-Level Synchronization**: The entire method is synchronized, meaning only one thread can access it at a time.
- **Block-Level Synchronization**: Only a specific block of code is synchronized, allowing better concurrency control than method-level synchronization.

### 29. Difference Between ArrayList and LinkedList - Sianr Mas Group
- **ArrayList**: Uses a dynamic array, faster random access, but slower insertions/deletions as elements need to be shifted.
- **LinkedList**: Uses a doubly-linked list, slower access but faster insertions/deletions since no shifting is required.

### 30. Comparable and Comparator - Sianr Mas Group
- **Comparable**: Interface that allows natural ordering by implementing the `compareTo()` method.
- **Comparator**: Interface that allows custom ordering by implementing the `compare()` method.

### 31. What is Runnable and Callable - Syncheron
- **Runnable**: Represents a task to be executed by a thread but does not return a result.
- **Callable**: Represents a task that returns a result and can throw exceptions.

### 32. What are Executor Services - Syncheron
`ExecutorService` manages a pool of threads and allows asynchronous execution of tasks. Example:

```java
ExecutorService executor = Executors.newFixedThreadPool(5);
executor.execute(new RunnableTask());
executor.shutdown();
```

### 33. Ways to Implement a Thread - Syncheron
- Extending the `Thread` class and overriding the `run()` method.
- Implementing the `Runnable` interface and passing it to a `Thread` object.
- Implementing the `Callable` interface and using `FutureTask` to handle results.

### 34. What is TreeMap Used For? - Syncheron
`TreeMap` stores key-value pairs in sorted order based on the keys. It implements the `NavigableMap` interface and maintains a binary search tree.

### 35. Difference Between Abstract Class and Interface - GlobalLogic
- **Abstract Class**: Can have method implementations and instance variables, supports single inheritance.
- **Interface**: Cannot have instance variables (except constants), supports multiple inheritance (from Java 8, interfaces can have default and static methods).