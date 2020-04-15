# LinkedList Notes

1. When we create 2 pointers (e.g slow & fast) in the linked list.<br/>
The fast is expected to reach the end fast, and there could be chances that jumping off the next pointer
It encounter, next to next element causing `NullPointerException` <br/>
When the condition check is made, make sure `fast != null` comes first as seeking value from `fast.nextNode != null` will lead to `NullPointerException`

```java
while ( fast != null && fast.nextNode != null )
```