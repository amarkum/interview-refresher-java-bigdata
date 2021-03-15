# Stack Notes
You can think of the Stack as a container, in which we can add items and remove them. </br>
Only the top of this container is open, so the item we put in first will be taken out last, and the items we put in last will be taken out first. </br>
This is called the last in first out (LIFO) ordering. </br>

## Attributes of Stack

```java
// top is used to maintain the index for top of the stack
int top;

// maxSizs is used to define the size of the stack, we define the size using constructor
int maxSize;

// stack is implemented using a array
V array[];
```

## Check if Stack is Full?
If `top` of the stack points to `maxSize` of the Stack, all elements has been occupied in the array, hence full.