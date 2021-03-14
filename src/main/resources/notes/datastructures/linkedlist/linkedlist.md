# LinkedList Notes

### What is LinkedList
A linked list is a linear data structure, in which the elements are not stored at contiguous memory locations. <br/>
The elements in a linked list are linked using pointers.

### Notes
#### I. `Pointer Movement`<br/>
When we create two pointers (e.g slow & fast) in the linked list.<br/>
If fast reaches the end first, there are chances that jumping off n pointer, it holds `NULL` reference in heap<br/>
When the condition check is made, make sure `fast != null` comes first<br/>
If we are seeking `.nextNode` value by `fast.nextNode != null` it will lead to `NullPointerException`

```java
while ( fast != null && fast.nextNode != null )
```

### Form a LinkedList with an Array of Integers

```java
// Create a prev Node.
ListNode prev = new ListNode();

// Save the reference of the node to a temp variable, as we will be linking with help of prev Node.
ListNode temp = prev;
        
for(int i =0; i<arr.length; i++){

    // Create a new Node with values starting from the array
    ListNode node = new ListNode();
    node.val = arr[i];
    
    // take the checkpointed node and assign the (next) to newly created Node.
    prev.next = node;
    
    // Checkpoint current Node Address so that we can assign (next) node when we create new Node.
    prev = node;   
}
return temp.next; 
```