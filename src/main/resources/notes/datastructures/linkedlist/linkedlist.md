# LinkedList Notes

### What is LinkedList
A linked list is a linear data structure, in which the elements are not stored at contiguous memory locations. 

### Notes
#### I. `Pointer Movement`<br/>
When we create two pointers (e.g slow & fast) in the linked list.<br/>
If fast reaches the end first, there are chances that jumping off n pointer, it holds `NULL` reference in heap<br/>
When the condition check is made, make sure `fast != null` comes first<br/>
If we are seeking `.nextNode` value by `fast.nextNode != null` it will lead to `NullPointerException`

```java
while ( fast != null && fast.nextNode != null )
```