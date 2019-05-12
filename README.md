# Core Java Learning and Experimenting

1. Java 8 features

    Streams
    
    Functional interface
    
    lambda
    
    Method reference
    
    Interface default and static methods
    
2. Generics

## Java Streams :

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

## Java Lambda

reference: http://www.tothenew.com/blog/functional-programming-in-java8-using-lambda-expressions/


