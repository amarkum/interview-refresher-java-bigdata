# OOPS

## Inheritance
Inheritance means one class can extend to another class. So that the codes can be reused from one class to another class.
Existing class is known as Super class whereas the derived class is known as a sub class.<br/>
Inheritance is applicable for public and protected members only. Private members can’t be inherited.<br/>


# Strings

## StringBuffer
 Values are stored in a stack. If the values are changed then the new value replaces the older value.
The string buffer is synchronized which is thread-safe.
Performance is slower than the String Builder.

## StringBuilder
It is same as String Buffer except for the String Builder which is not threaded safety that is not synchronized. So obviously performance is fast.

# Serialization

## What is Serialization?
Serialization  is the process which is used to convert the objects into byte stream. An object is serialized by writing it an ObjectOutputStream.

## Difference between Serializable and Externalizable
`Serializable` and `Extenalizable` is used to serialize or persist java objects but the way they do is little different. <br/>
In case of Serializable Java Virtual machine has full control for serializing object while in case of Externalizable, application gets control for persisting objects. <br/>
`writeExternal()` and `readExternal()` method provides complete control on format and content of Serialization process to application which can be leverage to increase performance and speed of serialization process. <br/>

1. In case of Serializable, default serialization process is used. while in case of Externalizable custom Serialization process is used which is implemented by application. <br/>
2. JVM gives call back to `readExternal()` and `writeExternal()` of `java.io.Externalizalbe` interface for restoring and writing objects into persistence. <br/>
3. Externalizable interface provides complete control of serialization process to application. <br/>
4. `readExternal()` and `writeExternal()` supersede any specific implementation of writeObject and readObject methods.<br/>

## What is SerialVersionUID?
Whenever an object is Serialized, the object is stamped with a version ID number for the object class. 
This ID is called the  SerialVersionUID. This is used during deserialization to verify that the sender and receiver that are compatible with the Serialization

##  What is the purpose of a transient variable?
Transient variables are not part of the serialization process.

# Exception Handling
## Difference between Checked and Unchecked Exception. 
Checked exception is checked by the compiler at compile time. <br/>
It's mandatory for a method to either handle the checked exception or declare them in their throws clause. <br/>
These are the ones which are a sub class of Exception but doesn't descend from RuntimeException. <br/>
The unchecked exception is the descendant of RuntimeException and not checked by the compiler at compile time. <br/>

On the other hand, throws is used as part of method declaration and signals which kind of exceptions are thrown by this method so that its caller can handle them. <br/>
It's mandatory to declare any unhandled checked exception in throws clause in Java.

## Difference between throw and throws.

the `throw` is used to actually throw an instance of `java.lang.Throwable class`, which means you can throw both Error and Exception using throw keyword <br/>
e.g.`throw new IllegalArgumentException("size must be multiple of 2")`

## Difference between Iterator and ListIterator
`Iterator` and `ListIterator` are defined by Collection Framework in `java.util package`.<br/>
`Iterator` can traverse the elements in the collection only in `forward` direction only, also Iterator is unable to add elements to a collection. <br/>
E.g ```Iterator iterator = c.iterator();```<br/>
The `ListIterator` can traverse the elements in a collection in both the `forward` as well as the `backwards` direction, ListIterator can traverse List objects only.<br/>
E.g ```ListIterator listIterator = l.listIterator();```
<br/>

# Java 1.7

## 1. try-with-resources statement

Older way to close resources in finally
```java
BufferedReader br = new BufferedReader(new FileReader(path));
try {
   return br.readLine();
} finally {
   br.close();
}
```
Newer way to close resources using `try-with-resource`

```java
try (BufferedReader br = new BufferedReader(new FileReader(path)) {
   return br.readLine();
}
```
You can declare more than one resource to close

```java
try (
   InputStream in = new FileInputStream(src);
   OutputStream out = new FileOutputStream(dest))
{
 // code
}
```

## 2. Underscores in numeric literals

```java
int one_million = 1_000_000;
Strings in switch
String s = ...
switch(s) {
 case "quux":
    processQuux(s);
    // fall-through

  case "foo":
  case "bar":
    processFooOrBar(s);
    break;

  case "baz":
     processBaz(s);
    // fall-through

  default:
    processDefault(s);
    break;
}
```

## 3. Binary literals

```java
int binary = 0b1001_1001;
```

## 4. Improved Type Inference for Generic Instance Creation

```java
Map<String, List<String>> anagrams = new HashMap<String, List<String>>(); 

Map<String, List<String>> anagrams = new HashMap<>(); //From Java 1.7
```

## 5. Multiple exception catching

Before Java 1.7, we had to declare multiple exception as below.

```java
} catch (FirstException ex) {
     logger.error(ex);
     throw ex;
} catch (SecondException ex) {
     logger.error(ex);
     throw ex;
}
```

After 1.7 we can declare multiple exception as below

```java
} catch (FirstException | SecondException ex) {
     logger.error(ex);
    throw ex;
}
```

## 6. SafeVarargs

```java
@SuppressWarnings({"unchecked", "varargs"})
public static void printAll(List<String>... lists){
    for(List<String> list : lists){
        System.out.println(list);
    }
}
```
With Java 1.7 onwards

```java
@SafeVarargs
public static void printAll(List<String>... lists){
    for(List<String> list : lists){
        System.out.println(list);
    }
}
```

# Java 1.8

## Features

1. Lambda expression, which allows you pass an anonymous function as object. <br/>
2. Stream API, take advantage of multiple cores of modern CPU and allows you to write succinct code. <br/>
3. Date and Time API, finally you have a solid and easy to use date and time library right into JDK <br/>
4. Extension methods, now you can have static and default method into your interface <br/>
5. Repeated annotation, allows you apply the same annotation multiple times on a type <br/>
