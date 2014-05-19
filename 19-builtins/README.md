## HW19 - Java Builtins

#### 1. What is the difference between the HashMap and HashSet from a use point of view?

HashMap implements Map, while HashSet implements Set.
Consequently, the HashMap maps keys to values (it's a dictionary / associative array) while the HashSet
is like a mathematical set. 
HashMap can store duplicates, while the HashSet cannot (in the spirit of the mathematical set). 

#### 2. Internally, how is a HashMap implemented?

A HashMap is implemented as an array of linked lists. 
There's a main array, whose indices correspond to hash values. 
When entries have the same hash value, they pile on top of each other 
in that index's linked list. 

#### 3. Internally, how is a HashSet implemented? 

HashSet is implemented using HashMap.

#### 4. Speed Comparison Results

HashMap was much more efficient than TreeMap in adding/removing data.

#### 5. Java's Built-in Heap

Java's built-in heap is the PriorityQueue.