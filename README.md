# Core Java Learning and Experimenting


## Java 8 Features

### Java Streams :

reference: https://www.baeldung.com/java-8-streams

To perform a sequence of operations over the elements of the data source and aggregate their results, three parts are needed – the source, intermediate operation(s) and a terminal operation.
Intermediate operations return a new modified stream. 
If more than one modification is needed, intermediate operations can be chained.

A stream by itself is worthless, the real thing a user is interested in is a result of the terminal operation, which can be a value of some type or an action applied to every element of the stream. Only one terminal operation can be used per stream.

The right and most convenient way to use streams are by a stream pipeline, which is a chain of stream source, intermediate operations, and a terminal operation.

Intermediate operations are lazy. This means that they will be invoked only if it is necessary for the terminal operation execution.

intermediate operations which reduce the size of the stream should be placed before operations which are applying to each element. So, keep such methods as skip(), filter(), distinct() at the top of your stream pipeline.

collect() method used to collect the result of stream. We can use some pre defines collectors using Collectors class.

don’t leave an instantiated streams unconsumed as that will lead to memory leaks.

### Java Lambda

reference: http://www.tothenew.com/blog/functional-programming-in-java8-using-lambda-expressions/

### Functional Interface 

Functional Interface is interface with exactly one abstract method.

It's annotated with @FunctionalInterface to avoid adding more than one abstract method, gives compile time error in that case.

Lambdas work in Java 8 because of Functional interface. It can only be applied to Functional interface.

 
### Method reference

https://www.baeldung.com/java-method-references

1. Static method reference

2. Instance method of particular object

3. Instance method reference of arbitrary object

4. Constructor reference


### Interface static and default methods


## Generics


[Ref 1](https://www.baeldung.com/java-generics)
    
[Ref 2](https://howtodoinjava.com/java/generics/complete-java-generics-tutorial/)
    
Generics are required to force type safety in java language.

Generics add stability to your code by making more of your bugs detectable at compile time.

## Java Collection Framework

[Reference](https://www.baeldung.com/java-collections)

### List

* Allows duplicates
* Ordered collection based on index or insertion order

##### ArrayList 
* Backed by Array 
* Array size increases/decreases dynamically with adding/deleting elements
* Methods are not **synchronized**
* Random access time complexity is O(1)
* Insertion/Deletion  time complexity is O(n)
* Adding element amortised time complexity is O(1)
* Searching an element in unordered list time complexity is O(n), Sorted list takes O(log n)
* Best option if we access list more than modification, or no insertion/deletion between list
* It's iterator is Fail fast, meaning it throws *ConcurrentModificationException* while iterate with iterator and list is modified outside iterator.

##### LinkedList
* backed by doubly linked list data structure
* Adding new element is just adding another node to the existing list
* Random access takes time
* Insertion/Deletion time complexity O(n) [ actually finding position takes time but adding deletion takes O(1) only]
* Adding element time complexity is O(1)
* Searching an element takes O(n) for unordered list
* Best option when modification between list is more than random access

##### Vector
* Same as ArrayList except few differences
* All methods are **synchronized**
* Part of legacy java collection

##### CopyOnWriteArrayList
* Same as ArrayList except few differences listed below
* It's thread safe
* Creates new copy of the ArrayList when list is modified
* It's iterator is fail safe, meaning doesn't throw *ConcurrentModificationException* when list is modified while iterating
* Useful in multi-threaded environment where modification to list is less than access.
* Iterator basically represents the snapshot of list at the time it was created.
 
##### Immutable ArrayList
* ArrayList which can't be modified once created.
* Can be created in different ways
* Using Java Collections class

```java
List<String> list = Arrays.asList("ab", "cd", "ef");
List<String> immutableList = Collections.unmodifiableList(list);
```
* Using Google Guava library
```java
List<String> list = Arrays.asList("ab", "cd", "ef");
List<String> immutableList = ImmutableList.copyOf(list);
```

* Using Apache Collection Commons
```java
List<String> list = Arrays.asList("ab", "cd", "ef");
List<String> immutableList = ListUtils.unmodifiableList(list);
```
### Set
* doesn't allow duplicate elements
 
##### HashSet
* Unordered set backed by hashtable
* Fast and less memory foot print compared to other set counterparts
* The class of the element which need to be inserted into Set need to follow Equals and HashCode contract
* 
 

##### LinkedHashSet
* Ordered set which **maintains the order in which elements are inserted**
* Takes some memory as it stored next and previous links

##### TreeSet
* Ordered set where the **elements are sorted**
* The elements which need to be inserted should implement Comparable interface (natural ordering) or Comparator need to be supplied while creating TreeSet
* The TreeSet uses a self-balancing binary search tree, more specifically a Red-Black tree.The TreeSet uses a self-balancing binary search tree, more specifically a Red-Black tree.
* It’s not thread-safe
* Operations like add, remove and search take O(log n) time while operations like printing n elements in sorted order require O(n) time.
 


### Map
* Collection of Key-Value pair
##### HashMap
* Un-ordered collection of Key-Value pairs
* Backed by HashMap.
* Methods are not **synchronized** and not thread safe.
* Fast and less memory foot print
* Fail fast 

##### LinkedHashMap
* Ordered collection of Key-Value pairs
* Maintains the order of insertion
* Takes more memory as compared to HashMap

##### TreeMap
* Ordered collection of Key-Value pairs.
* Keys are sorted based on the natural order or based on the Comparator provided at the time of creation.

##### ConcurrentHashMap
* Thread safe HashMap
* Doesn't throw *ConcurrentModificationException*


#### Queue





