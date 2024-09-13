
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

... (continue for the other questions)

