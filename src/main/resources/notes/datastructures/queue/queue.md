# Queue Notes
Queues are slightly trickier to implement compared to stack, as we have to keep track of both ends of the array. <br/>
The elements are inserted from the back and removed from the front. <br/>

## Attributes of Stack

```java
// array to store the elements
array = (T[]) new Object[capacity];

// size of the queue
maxSize = capacity;

// points to the elements at the front side
front = 0;

// points to the element at the tail of the queue
back = -1;

// currentSize refers to the current size of the queue
currentSize = 0;
```

## Check if Queue is Full?
If `currentSize` of the queue is equal to the `maxSize`

## How Queue is implemented?
We just maintain two pointer, one for the front and one for the back of the Queue. </br>
If the elements are to be inserted, we calculate the mode value and insert it to the front index. <br/>
If the elements are full, we do not insert, if the Queue is empty we do not pop the elements.
