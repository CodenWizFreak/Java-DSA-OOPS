# ☕ Java Collections Framework — Complete Reference

> A complete, production-ready reference covering every interface, class, method, and time complexity in the Java Collections Framework. From ArrayList to TreeMap, Generics to PriorityQueue.

**Package:** `java.util` &nbsp;|&nbsp; **Java 8+ compatible** &nbsp;|&nbsp; **30+ topics** &nbsp;|&nbsp; **Big-O complexity included**

---

## 📋 Table of Contents

| # | Topic |
|---|-------|
| 01 | [Need for a Framework](#01-need-for-a-framework) |
| 02 | [What is Collections Framework?](#02-what-is-the-collections-framework) |
| 03 | [Module vs Framework vs Library vs Package](#03-module-vs-framework-vs-library-vs-package) |
| 04 | [How to Import](#04-how-to-import) |
| 05 | [Hierarchy of Collections Framework](#05-hierarchy-of-collections-framework) |
| 06 | [Collection Interface Functions](#06-functions-in-the-collection-interface) |
| 07 | [Generics & AutoBoxing](#07-java-generics--autoboxing) |
| 08 | [List Interface](#08-list-interface) |
| 09 | [ArrayList & Functions](#09-arraylist--its-functions) |
| 10 | [Iterator](#10-iterating-a-list-using-iterator) |
| 11 | [Internal Working of ArrayList](#11-internal-working-of-arraylist) |
| 12 | [Sorting with Comparator](#12-sorting-using-comparator) |
| 13 | [ListIterator](#13-listiterator) |
| 14 | [ArrayList Time Complexity](#14-time-complexity-of-arraylist) |
| 15 | [LinkedList & Functions](#15-linkedlist--its-functions) |
| 16 | [ArrayList vs LinkedList](#16-arraylist-vs-linkedlist) |
| 17 | [Vector](#17-vector) |
| 18 | [Stack & Functions](#18-stack--its-functions) |
| 19 | [Queue Interface](#19-queue-interface--its-functions) |
| 20 | [Queue via LinkedList](#20-queue-using-linkedlist) |
| 21 | [Queue via ArrayDeque](#21-queue-using-arraydeque) |
| 22 | [Deque Interface](#22-deque-interface-using-arraydeque--linkedlist) |
| 23 | [PriorityQueue](#23-priorityqueue) |
| 24 | [Map Interface](#24-map-interface) |
| 25 | [Hashing Concept](#25-hashing-concept) |
| 26 | [How Map Uses Hashing](#26-how-map-uses-hashing) |
| 27 | [HashMap & Functions](#27-hashmap--its-functions) |
| 28 | [Map.Entry Interface](#28-traversing-a-map-using-mapentry) |
| 29 | [LinkedHashMap](#29-linkedhashmap) |
| 30 | [BST, Red-Black Tree & TreeMap](#30-bst-red-black-tree--treemap) |
| 31 | [Set Interface](#31-set-interface) |
| 32 | [HashSet](#32-hashset) |
| 33 | [LinkedHashSet](#33-linkedhashset) |
| 34 | [TreeSet](#34-treeset) |
| ★ | [Quick Reference Cheatsheet](#-quick-reference-cheatsheet) |

---

## 01. Need for a Framework

Before the Java Collections Framework (JCF) was introduced in **Java 1.2**, developers had to manage data structures manually or use inconsistent, proprietary classes.

| Problem | Without JCF | With JCF |
|---------|-------------|----------|
| Dynamic arrays | Manual array resizing | `ArrayList` / `LinkedList` |
| No common API | `Vector`, `Hashtable` (inconsistent) | Unified `Collection`/`Map` interfaces |
| Type safety | Stored `Object`, required casts | Generics — compile-time checking |
| Algorithms | Write sort/search manually | `Collections.sort()`, `binarySearch()` |
| Interoperability | No way to swap implementations | Code to interface, swap class easily |

> **Key Principle:** The JCF provides a unified architecture to store, retrieve, and manipulate groups of objects — reducing programming effort, improving performance, and enabling interoperability.

---

## 02. What is the Collections Framework?

The **Java Collections Framework** is a unified architecture for representing and manipulating collections. It has three parts:

- **Interfaces** — Abstract data types (List, Set, Map, Queue, Deque)
- **Implementations (Classes)** — Concrete classes (ArrayList, HashMap, TreeSet, etc.)
- **Algorithms** — Static utility methods in the `Collections` class (sort, shuffle, binarySearch, etc.)

All classes reside in the `java.util` package. The framework supports:
- Ordered sequences (`List`)
- Unique element sets (`Set`)
- Key-value pair mappings (`Map`)
- FIFO queues and priority-based ordering (`Queue`)
- Double-ended queues (`Deque`)

---

## 03. Module vs Framework vs Library vs Package

| Term | Definition | Example | Controls Flow? |
|------|-----------|---------|---------------|
| **Package** | A namespace grouping related classes/interfaces together | `java.util`, `java.io` | No |
| **Module** | A self-contained unit of code with explicit dependencies (Java 9+) | `java.base` module | No |
| **Library** | A collection of pre-written utility functions/classes you call | Apache Commons, Guava | No — *you* call it |
| **Framework** | An architecture that calls YOUR code via inversion of control | Spring, JUnit, JCF | Yes — *it* calls you |

> **Inversion of Control:** In a framework, the framework defines the skeleton of the algorithm and calls your implementations. For example, you implement `Comparator` so `Collections.sort()` can call your comparison logic.

---

## 04. How to Import

```java
// Import everything from java.util (fine for learning)
import java.util.*;

// OR import specific classes (recommended for production)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Collections;  // For utility algorithms
import java.util.Arrays;       // For array utilities
import java.util.Comparator;   // For custom sorting
import java.util.Iterator;     // For iteration
```

> **Tip:** Modern IDEs (IntelliJ, Eclipse) auto-import. Use `java.util.*` during prototyping, then narrow imports before code review.

---

## 05. Hierarchy of Collections Framework

```
«interface» Iterable<E>
    └── «interface» Collection<E>
            ├── «interface» List<E>
            │        ├── ArrayList<E>
            │        ├── LinkedList<E>    (also implements Deque)
            │        ├── Vector<E>        (legacy, synchronized)
            │        └── Stack<E>         (extends Vector)
            │
            ├── «interface» Queue<E>
            │        ├── LinkedList<E>
            │        ├── PriorityQueue<E>
            │        └── «interface» Deque<E>
            │                   ├── ArrayDeque<E>
            │                   └── LinkedList<E>
            │
            └── «interface» Set<E>
                     ├── HashSet<E>
                     ├── LinkedHashSet<E>
                     └── «interface» SortedSet<E>
                                  └── «interface» NavigableSet<E>
                                               └── TreeSet<E>

── Separate Map Hierarchy ──────────────────────────────────

«interface» Map<K,V>
    ├── HashMap<K,V>
    │        └── LinkedHashMap<K,V>
    ├── Hashtable<K,V>         (legacy)
    └── «interface» SortedMap<K,V>
              └── «interface» NavigableMap<K,V>
                           └── TreeMap<K,V>
```

> **Important:** `Map` does **NOT** extend `Collection`. It is a separate hierarchy because maps deal with key-value pairs, not single elements.

---

## 06. Functions in the Collection Interface

Every class in the Collection hierarchy inherits these core methods:

| Method | Return Type | Description |
|--------|-------------|-------------|
| `add(E e)` | `boolean` | Adds element. Returns `true` if collection changed. |
| `addAll(Collection<? extends E> c)` | `boolean` | Adds all elements from another collection. |
| `remove(Object o)` | `boolean` | Removes a single instance of the specified element. |
| `removeAll(Collection<?> c)` | `boolean` | Removes all elements contained in `c`. |
| `retainAll(Collection<?> c)` | `boolean` | Keeps only elements in common with `c` (intersection). |
| `contains(Object o)` | `boolean` | Returns `true` if element exists. |
| `containsAll(Collection<?> c)` | `boolean` | Returns `true` if all elements of `c` are present. |
| `size()` | `int` | Returns number of elements. |
| `isEmpty()` | `boolean` | Returns `true` if `size() == 0`. |
| `clear()` | `void` | Removes all elements. |
| `iterator()` | `Iterator<E>` | Returns an iterator to traverse elements. |
| `toArray()` | `Object[]` | Returns an array of all elements. |
| `stream()` | `Stream<E>` | Returns a sequential Stream (Java 8+). |
| `forEach(Consumer action)` | `void` | Performs action for each element (Java 8+). |

---

## 07. Java Generics & AutoBoxing

### Generics

Generics provide **compile-time type safety** by parameterizing classes/methods with types. Introduced in Java 5.

```java
// WITHOUT Generics (pre-Java 5) — unsafe, requires casting
ArrayList list = new ArrayList();
list.add("Hello");
list.add(42);  // No compile error — dangerous!
String s = (String) list.get(1);  // ClassCastException at RUNTIME!

// WITH Generics — type-safe, no casting needed
ArrayList<String> list = new ArrayList<>();
list.add("Hello");
// list.add(42);  → COMPILE ERROR — caught at compile time!
String s = list.get(0);  // No cast needed

// Generic class definition
class Box<T> {
    private T value;
    public Box(T value) { this.value = value; }
    public T get() { return value; }
}

Box<Integer> intBox = new Box<>(42);
Box<String>  strBox = new Box<>("Hello");
```

### Type Bounds (Wildcards)

```java
// Upper bounded wildcard — accepts Number or any subclass (Integer, Double, etc.)
public static double sum(List<? extends Number> list) {
    return list.stream().mapToDouble(Number::doubleValue).sum();
}
sum(new ArrayList<Integer>());  // OK
sum(new ArrayList<Double>());   // OK

// Lower bounded wildcard — accepts Integer or any superclass (Number, Object)
public static void addNumbers(List<? super Integer> list) {
    list.add(1);
    list.add(2);
}
```

### AutoBoxing & Unboxing

Collections cannot store primitives (`int`, `double`, etc.) — they require wrapper objects. Java automatically converts between them.

| Primitive | Wrapper Class |
|-----------|--------------|
| `int` | `Integer` |
| `double` | `Double` |
| `boolean` | `Boolean` |
| `char` | `Character` |
| `long` | `Long` |
| `float` | `Float` |
| `byte` | `Byte` |
| `short` | `Short` |

```java
List<Integer> nums = new ArrayList<>();

// AutoBoxing: int → Integer automatically
nums.add(5);     // compiler converts to: nums.add(Integer.valueOf(5))
nums.add(10);

// Unboxing: Integer → int automatically
int val = nums.get(0);  // compiler converts to: nums.get(0).intValue()
System.out.println(val);  // Output: 5

// AutoBoxing in arithmetic
Integer a = 3, b = 4;
int sum = a + b;  // Unboxed, added, result is int 7
```

> ⚠️ **Warning:** Autoboxing can cause `NullPointerException`! If an `Integer` is `null` and you unbox it to `int`, you get NPE. Always null-check when unboxing.

---

## 08. List Interface

The `List` interface extends `Collection` and represents an **ordered, index-based, duplicate-allowing** sequence of elements.

**Characteristics:** Ordered ✅ | Allows Duplicates ✅ | Index-based Access ✅ | Null Allowed ✅

Additional methods List adds beyond Collection:

| Method | Return Type | Description |
|--------|-------------|-------------|
| `get(int index)` | `E` | Returns element at the given index. |
| `set(int index, E element)` | `E` | Replaces element at index; returns old value. |
| `add(int index, E element)` | `void` | Inserts element at index; shifts existing right. |
| `remove(int index)` | `E` | Removes element at index; returns it. |
| `indexOf(Object o)` | `int` | Returns index of first occurrence, or `-1`. |
| `lastIndexOf(Object o)` | `int` | Returns index of last occurrence, or `-1`. |
| `subList(int from, int to)` | `List<E>` | View of list from `[from, to)`. Changes reflect in original. |
| `listIterator()` | `ListIterator<E>` | Returns a bidirectional iterator. |
| `sort(Comparator<? super E> c)` | `void` | Sorts using provided comparator (Java 8+). |

---

## 09. ArrayList & its Functions

`ArrayList` is a resizable-array implementation of `List`. The most commonly used collection in Java.

**Characteristics:** Backed by `Object[]` | Random Access `O(1)` | Not Thread-Safe | Default capacity: 10

### Creation

```java
// Default constructor — initial capacity 10
ArrayList<String> list1 = new ArrayList<>();

// With initial capacity (avoids resizing for large data)
ArrayList<Integer> list2 = new ArrayList<>(100);

// From existing collection
List<String> source = Arrays.asList("A", "B", "C");
ArrayList<String> list3 = new ArrayList<>(source);
```

### Core Operations — Full Reference

```java
ArrayList<String> fruits = new ArrayList<>();

// ── ADD ──────────────────────────────────────────────────
fruits.add("Apple");           // ["Apple"]
fruits.add("Banana");          // ["Apple","Banana"]
fruits.add("Cherry");          // ["Apple","Banana","Cherry"]
fruits.add(1, "Avocado");      // insert at index 1
                               // → ["Apple","Avocado","Banana","Cherry"]
fruits.addAll(Arrays.asList("Date", "Elderberry"));
// → ["Apple","Avocado","Banana","Cherry","Date","Elderberry"]

// ── ACCESS ───────────────────────────────────────────────
String first = fruits.get(0);   // "Apple"
int size = fruits.size();        // 6

// ── SEARCH ───────────────────────────────────────────────
boolean has = fruits.contains("Banana");  // true
int idx  = fruits.indexOf("Cherry");      // 3
int last = fruits.lastIndexOf("Apple");   // 0

// ── UPDATE ───────────────────────────────────────────────
fruits.set(0, "Apricot");  // replaces "Apple" with "Apricot"

// ── REMOVE ───────────────────────────────────────────────
fruits.remove("Avocado");  // removes by value (first occurrence)
fruits.remove(0);          // removes by index
fruits.removeAll(Arrays.asList("Date", "Elderberry"));  // bulk remove

// ── SUBLIST ──────────────────────────────────────────────
List<String> sub = fruits.subList(0, 2);  // indices 0 and 1 (exclusive end)

// ── SORT ─────────────────────────────────────────────────
Collections.sort(fruits);              // natural order (alphabetical)
fruits.sort(Comparator.reverseOrder()); // reverse alphabetical

// ── CONVERT ──────────────────────────────────────────────
Object[] arr1 = fruits.toArray();
String[] arr2 = fruits.toArray(new String[0]);

// ── ITERATE (for-each) ───────────────────────────────────
for (String fruit : fruits) {
    System.out.println(fruit);
}

// ── ITERATE (Java 8 forEach + lambda) ────────────────────
fruits.forEach(f -> System.out.println(f));
fruits.forEach(System.out::println);  // method reference

// ── STREAM operations ────────────────────────────────────
List<String> filtered = fruits.stream()
    .filter(f -> f.startsWith("A"))
    .sorted()
    .collect(Collectors.toList());

// ── CLEAR / EMPTY CHECK ──────────────────────────────────
fruits.isEmpty();  // false (if not empty)
fruits.clear();    // removes all elements → []
```

### Useful `Collections` Utility Methods

```java
ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(3,1,4,1,5,9,2));

Collections.sort(nums);                    // [1,1,2,3,4,5,9]
Collections.reverse(nums);                 // [9,5,4,3,2,1,1]
Collections.shuffle(nums);                 // random order
Collections.min(nums);                     // 1
Collections.max(nums);                     // 9
Collections.frequency(nums, 1);            // 2 (count of 1s)
Collections.fill(nums, 0);                 // fills all elements with 0
Collections.nCopies(5, "Hi");              // ["Hi","Hi","Hi","Hi","Hi"]
Collections.binarySearch(sortedList, 4);   // list MUST be sorted first!
Collections.swap(nums, 0, 1);              // swaps elements at index 0 and 1
Collections.unmodifiableList(nums);        // returns read-only view
```

---

## 10. Iterating a List using Iterator

The `Iterator` interface provides a way to traverse a collection **forward-only**, with safe removal during iteration.

### Iterator Interface Methods

| Method | Return | Description |
|--------|--------|-------------|
| `hasNext()` | `boolean` | Returns `true` if more elements exist. |
| `next()` | `E` | Returns next element and advances cursor. Throws `NoSuchElementException` if none. |
| `remove()` | `void` | Removes the element returned by last `next()`. Call only once per `next()`. |
| `forEachRemaining(Consumer)` | `void` | Performs action on all remaining elements (Java 8+). |

```java
ArrayList<String> cities = new ArrayList<>(
    Arrays.asList("Delhi", "Mumbai", "Chennai", "Kolkata")
);

Iterator<String> it = cities.iterator();

while (it.hasNext()) {            // hasNext() → true if more elements
    String city = it.next();      // next() → returns current, advances pointer
    System.out.println(city);
    if (city.equals("Mumbai")) {
        it.remove();              // SAFE removal — no ConcurrentModificationException
    }
}
// Output: Delhi, Mumbai, Chennai, Kolkata
// After:  ["Delhi", "Chennai", "Kolkata"]

// ⚠ WRONG — removing directly during for-each:
for (String c : cities) {
    if (c.equals("Delhi")) cities.remove(c);  // → ConcurrentModificationException!
}
```

---

## 11. Internal Working of ArrayList

`ArrayList` is internally backed by a plain `Object[]` array:

```java
// Simplified internal structure of ArrayList
class ArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;  // The actual backing array
    private int size;               // Number of elements stored (NOT array length)
}
```

| Event | Behavior |
|-------|----------|
| `new ArrayList()` | Creates `Object[]` of capacity 10 (lazy in Java 8: empty array, grows on first add) |
| `add(e)` when not full | `elementData[size] = e; size++;` |
| `add(e)` when **full** | `newCapacity = oldCapacity * 1.5` — then `Arrays.copyOf()` creates new array |
| `remove(index)` | `System.arraycopy()` shifts elements left — O(n) |
| `get(index)` | Direct array access: `elementData[index]` — O(1) |
| `trimToSize()` | Trims backing array to current size — frees unused memory |
| `ensureCapacity(n)` | Pre-grow array to at least `n` — avoids repeated resizing |

> **Growth Formula:** `newCapacity = oldCapacity + (oldCapacity >> 1)` which is approximately **1.5×**
> So: 10 → 15 → 22 → 33 → 49 → 73 → ...

---

## 12. Sorting using Comparator

### Natural Ordering (Comparable)

```java
List<Integer> nums = Arrays.asList(5, 2, 8, 1, 9);
Collections.sort(nums);   // Uses Comparable → [1, 2, 5, 8, 9]
nums.sort(null);           // Also natural order
```

### Custom Comparator — Anonymous Class

```java
List<String> words = Arrays.asList("banana", "apple", "cherry", "fig");

// Sort by LENGTH (ascending)
words.sort(new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return a.length() - b.length();  // negative → a before b
    }
});
// Output: ["fig", "apple", "banana", "cherry"]
```

### Lambda Comparator (Java 8+)

```java
// Sort by length ascending
words.sort((a, b) -> a.length() - b.length());

// Sort by length descending
words.sort((a, b) -> b.length() - a.length());

// Sort alphabetically descending
words.sort((a, b) -> b.compareTo(a));

// Using Comparator builder methods (most readable)
words.sort(Comparator.comparingInt(String::length));            // asc by length
words.sort(Comparator.comparingInt(String::length).reversed()); // desc by length
words.sort(Comparator.naturalOrder());                          // alphabetical
words.sort(Comparator.reverseOrder());                          // reverse alpha
```

### Sorting Custom Objects

```java
class Student {
    String name;
    int age, marks;
    public Student(String name, int age, int marks) {
        this.name = name; this.age = age; this.marks = marks;
    }
    @Override public String toString() { return name + "(" + marks + ")"; }
}

List<Student> students = Arrays.asList(
    new Student("Alice", 20, 85),
    new Student("Bob",   22, 92),
    new Student("Carol", 19, 78)
);

// Sort by marks descending
students.sort((s1, s2) -> s2.marks - s1.marks);
// [Bob(92), Alice(85), Carol(78)]

// Sort by name ascending
students.sort(Comparator.comparing(s -> s.name));
// [Alice(85), Bob(92), Carol(78)]

// Chain: sort by marks desc, then by name asc (tiebreaker)
students.sort(
    Comparator.<Student, Integer>comparing(s -> s.marks)
              .reversed()
              .thenComparing(s -> s.name)
);
```

### Comparator Return Value Rules

| Return Value | Meaning |
|-------------|---------|
| `negative (< 0)` | First argument comes **BEFORE** second argument |
| `0` | Both elements are considered **EQUAL** in ordering |
| `positive (> 0)` | First argument comes **AFTER** second argument |

---

## 13. ListIterator

A `ListIterator` extends `Iterator` and allows **bidirectional traversal**, modification, and insertion at the current position.

| Method | Return | Description |
|--------|--------|-------------|
| `hasNext()` | `boolean` | `true` if forward traversal has more elements |
| `next()` | `E` | Returns next element, moves cursor forward |
| `hasPrevious()` | `boolean` | `true` if backward traversal has more elements |
| `previous()` | `E` | Returns previous element, moves cursor backward |
| `nextIndex()` | `int` | Index of element that `next()` would return |
| `previousIndex()` | `int` | Index of element that `previous()` would return |
| `add(E e)` | `void` | Inserts element **before** the element `next()` would return |
| `set(E e)` | `void` | Replaces last element returned by `next()` or `previous()` |
| `remove()` | `void` | Removes last element returned by `next()` or `previous()` |

```java
ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
ListIterator<Integer> lit = list.listIterator();

// Forward pass — double each element
while (lit.hasNext()) {
    int val = lit.next();
    lit.set(val * 2);
}
// list is now [2, 4, 6, 8, 10]

// Backward pass
while (lit.hasPrevious()) {
    System.out.print(lit.previous() + " ");
}
// Output: 10 8 6 4 2

// Start at a specific index
ListIterator<Integer> lit2 = list.listIterator(3);  // starts at index 3
```

---

## 14. Time Complexity of ArrayList

| Operation | Complexity | Reason |
|-----------|------------|--------|
| `get(index)` | **O(1)** | Direct array index access |
| `set(index, e)` | **O(1)** | Direct array index write |
| `add(e)` — at end | **O(1) amortized** | Array write; rare O(n) resize |
| `add(index, e)` | **O(n)** | Must shift elements right |
| `remove(index)` | **O(n)** | Must shift elements left |
| `remove(object)` | **O(n)** | Linear search + shift |
| `contains(o)` | **O(n)** | Linear scan |
| `indexOf(o)` | **O(n)** | Linear scan |
| `size()` | **O(1)** | Stored as a field |
| `clear()` | **O(n)** | Nulls out all element refs (for GC) |
| `sort()` | **O(n log n)** | TimSort algorithm |
| iterator traversal | **O(n)** | Visit every element once |

---

## 15. LinkedList & its Functions

`LinkedList` is a doubly-linked list implementing both `List` and `Deque`. Each node holds data + prev/next pointers.

**Characteristics:** Doubly Linked | Implements List + Deque | Not Thread-Safe | No Random Access (O(n))

```java
LinkedList<String> ll = new LinkedList<>();

// ── ADD ──────────────────────────────────────────────────
ll.add("B");           // ["B"]
ll.add("C");           // ["B","C"]
ll.addFirst("A");      // ["A","B","C"] — O(1)
ll.addLast("D");       // ["A","B","C","D"] — O(1)
ll.add(1, "A+");       // ["A","A+","B","C","D"]
ll.offer("E");         // adds to tail (Queue method) — O(1)
ll.offerFirst("Z");    // adds to head (Deque method) — O(1)
ll.push("TOP");        // pushes onto stack (head) — O(1)

// ── GET ──────────────────────────────────────────────────
ll.getFirst();         // head element — throws NoSuchElementException if empty
ll.getLast();          // tail element
ll.peek();             // head element — returns null if empty (safer)
ll.peekFirst();        // same as peek()
ll.peekLast();         // tail element — returns null if empty
ll.element();          // same as getFirst()
ll.get(2);             // O(n) — must traverse the list!

// ── REMOVE ───────────────────────────────────────────────
ll.removeFirst();      // removes head — throws if empty
ll.removeLast();       // removes tail — throws if empty
ll.poll();             // removes head — returns null if empty
ll.pollFirst();        // same as poll()
ll.pollLast();         // removes tail — returns null if empty
ll.pop();              // same as removeFirst() — stack method
ll.remove("B");        // removes by value
ll.remove(0);          // removes by index
```

### Time Complexity of LinkedList

| Operation | Complexity | Reason |
|-----------|------------|--------|
| `addFirst()` / `addLast()` | **O(1)** | Only pointer updates at head/tail |
| `removeFirst()` / `removeLast()` | **O(1)** | Only pointer updates at head/tail |
| `get(index)` | **O(n)** | Must traverse from head or tail |
| `add(index, e)` | **O(n)** | Traverse to position + pointer update |
| `contains(o)` | **O(n)** | Linear scan |
| `size()` | **O(1)** | Stored as a field |

---

## 16. ArrayList vs LinkedList

### When to Use Which

| Use ArrayList when... | Use LinkedList when... |
|----------------------|----------------------|
| Frequent random access by index | Frequent insertions/deletions at head or tail |
| More reads than writes | Implementing a Queue or Deque |
| Adding/removing mostly at the end | Implementing a Stack |
| Memory efficiency matters | You don't need random access |
| Better cache performance needed | Size varies widely (no wasted capacity) |

### Head-to-Head Comparison

| Feature | ArrayList | LinkedList |
|---------|-----------|------------|
| Internal Structure | Dynamic `Object[]` array | Doubly-linked nodes |
| `get(index)` | **O(1)** | **O(n)** |
| `add` at end | **O(1)** amortized | **O(1)** |
| `add` at beginning | **O(n)** | **O(1)** |
| `add` at middle | **O(n)** | **O(n)** |
| `remove` at end | **O(1)** | **O(1)** |
| Memory per element | ~4 bytes (ref only) | ~32 bytes (data + 2 refs + object header) |
| Cache friendly | ✅ Yes (contiguous memory) | ❌ No (scattered in heap) |
| Implements Deque | ❌ No | ✅ Yes |
| Null elements | ✅ Yes | ✅ Yes |

> ⚠️ **In Practice:** `ArrayList` outperforms `LinkedList` in almost all real-world scenarios due to CPU cache friendliness. Prefer `ArrayList` unless you have a specific deque/queue use case.

---

## 17. Vector

`Vector` is a legacy, **synchronized** version of `ArrayList`. It has been part of Java since version 1.0.

> ⚠️ **Legacy Warning:** `Vector` is considered obsolete. Use `ArrayList` for non-concurrent code, or `Collections.synchronizedList(new ArrayList<>())` / `CopyOnWriteArrayList` for thread safety.

```java
Vector<String> v  = new Vector<>();       // default capacity 10, doubles on growth
Vector<String> v2 = new Vector<>(5, 3);   // initial capacity 5, grows by 3

v.add("A");
v.addElement("B");    // legacy method (same as add)
v.elementAt(0);       // legacy = get(0)
v.firstElement();     // like getFirst()
v.lastElement();      // like getLast()
v.capacity();         // backing array capacity (NOT size)

// Key difference: all methods are synchronized (thread-safe but slow)
// Growth: Vector DOUBLES (10→20→40), ArrayList grows by 50%
```

---

## 18. Stack & its Functions

`Stack` extends `Vector` and models a **LIFO (Last In, First Out)** data structure.

> **Modern Alternative:** Use `Deque` (specifically `ArrayDeque`) as a stack. Java docs themselves recommend it for better performance.

```java
Stack<Integer> stack = new Stack<>();

// ── PUSH (add to top) ────────────────────────────────────
stack.push(10);   // [10]
stack.push(20);   // [10, 20]
stack.push(30);   // [10, 20, 30]

// ── PEEK (view top without removing) ────────────────────
int top = stack.peek();    // 30 — stack unchanged

// ── POP (remove and return top) ─────────────────────────
int popped = stack.pop();  // returns 30, stack: [10, 20]

// ── EMPTY CHECK ──────────────────────────────────────────
stack.empty();     // false  (Stack's own method)
stack.isEmpty();   // false  (inherited from Vector)

// ── SEARCH (1-based position from top) ──────────────────
stack.push(20); stack.push(40);
// Stack: [10, 20, 20, 40]
int pos = stack.search(20);  // 2 (40 is 1st from top, 20 is 2nd)
                              // Returns -1 if not found

// ── Using ArrayDeque as Stack (PREFERRED) ───────────────
Deque<Integer> stack2 = new ArrayDeque<>();
stack2.push(10);   // addFirst
stack2.push(20);
stack2.peek();     // view top (head)
stack2.pop();      // remove top (removeFirst)
```

### Time Complexity of Stack

| Operation | Complexity |
|-----------|------------|
| `push()` | **O(1) amortized** |
| `pop()` | **O(1)** |
| `peek()` | **O(1)** |
| `empty()` | **O(1)** |
| `search()` | **O(n)** |

---

## 19. Queue Interface & its Functions

The `Queue` interface models a **FIFO (First In, First Out)** structure. Elements are inserted at the tail and removed from the head.

| Operation | Throws Exception | Returns null/false (safe version) |
|-----------|-----------------|----------------------------------|
| Insert at tail | `add(e)` | `offer(e)` |
| Remove from head | `remove()` | `poll()` |
| Examine head | `element()` | `peek()` |

> ✅ **Best Practice:** Prefer `offer()`, `poll()`, and `peek()` — they return `null`/`false` instead of throwing exceptions on empty queues.

---

## 20. Queue using LinkedList

```java
Queue<String> queue = new LinkedList<>();

// ── ENQUEUE (add to tail) ────────────────────────────────
queue.offer("First");    // ["First"]
queue.offer("Second");   // ["First","Second"]
queue.offer("Third");    // ["First","Second","Third"]
queue.add("Fourth");     // same as offer for LinkedList

// ── PEEK (view front without removing) ──────────────────
String front  = queue.peek();     // "First" — queue unchanged
String front2 = queue.element();  // "First" — throws if empty

// ── DEQUEUE (remove from front) ─────────────────────────
String removed  = queue.poll();    // "First" — ["Second","Third","Fourth"]
String removed2 = queue.remove();  // "Second" — throws if empty

// ── SIZE AND CHECK ────────────────────────────────────────
queue.size();               // 2
queue.isEmpty();            // false
queue.contains("Third");    // true

// ── ITERATE (FIFO order) ─────────────────────────────────
for (String s : queue) {
    System.out.print(s + " ");  // Third Fourth
}
```

---

## 21. Queue using ArrayDeque

`ArrayDeque` is a resizable-array implementation of `Deque`. It is **faster than LinkedList** for both queue and stack operations.

```java
Queue<Integer> queue = new ArrayDeque<>();

queue.offer(10);   // [10]
queue.offer(20);   // [10, 20]
queue.offer(30);   // [10, 20, 30]

queue.peek();      // 10 (head)
queue.poll();      // returns 10, queue: [20, 30]
queue.size();      // 2

// ⚠ ArrayDeque does NOT allow null elements!
// queue.offer(null); → NullPointerException
```

> **ArrayDeque vs LinkedList as Queue:** `ArrayDeque` is typically faster due to CPU cache friendliness (circular array). `LinkedList` creates a new `Node` object per element, causing GC pressure.

---

## 22. Deque Interface using ArrayDeque & LinkedList

A `Deque` (Double-Ended Queue, pronounced "deck") allows insertion and removal from **both ends**.

| Operation | Head — Throws | Head — Safe | Tail — Throws | Tail — Safe |
|-----------|--------------|-------------|--------------|-------------|
| Insert | `addFirst(e)` | `offerFirst(e)` | `addLast(e)` | `offerLast(e)` |
| Remove | `removeFirst()` | `pollFirst()` | `removeLast()` | `pollLast()` |
| Examine | `getFirst()` | `peekFirst()` | `getLast()` | `peekLast()` |

```java
Deque<String> deque = new ArrayDeque<>();

// Add to both ends
deque.offerLast("B");    // [B]
deque.offerLast("C");    // [B, C]
deque.offerFirst("A");   // [A, B, C]
deque.offerFirst("Z");   // [Z, A, B, C]

// Peek at both ends
deque.peekFirst();  // "Z"
deque.peekLast();   // "C"

// Remove from both ends
deque.pollFirst();  // "Z" → [A, B, C]
deque.pollLast();   // "C" → [A, B]

// ── Using as STACK ────────────────────────────────────────
Deque<Integer> stack = new ArrayDeque<>();
stack.push(1);   // addFirst — [1]
stack.push(2);   // addFirst — [2, 1]
stack.push(3);   // addFirst — [3, 2, 1]
stack.peek();    // 3 (top)
stack.pop();     // 3 → [2, 1]

// ── Using as QUEUE ────────────────────────────────────────
Deque<Integer> q = new ArrayDeque<>();
q.offer(1);   // addLast
q.offer(2);
q.poll();     // removeFirst → 1

// ── PALINDROME CHECK using Deque ─────────────────────────
String word = "racecar";
Deque<Character> dq = new ArrayDeque<>();
for (char c : word.toCharArray()) dq.offer(c);
boolean isPalindrome = true;
while (dq.size() > 1) {
    if (!dq.pollFirst().equals(dq.pollLast())) {
        isPalindrome = false;
        break;
    }
}
// isPalindrome = true
```

---

## 23. PriorityQueue

A `PriorityQueue` is a **heap-based** implementation of `Queue`. The head is always the element with the **highest priority** (smallest value by default — min-heap).

**Characteristics:** Min-Heap by default | `peek`/`poll` = O(log n) | No null elements | Not Thread-Safe

```java
// ── MIN HEAP (default: smallest at head) ────────────────
PriorityQueue<Integer> minPQ = new PriorityQueue<>();
minPQ.offer(30);
minPQ.offer(10);
minPQ.offer(20);

minPQ.peek();    // 10 (minimum — NOT in sorted order internally!)
minPQ.poll();    // removes and returns 10
minPQ.poll();    // removes and returns 20
minPQ.poll();    // removes and returns 30

// ── MAX HEAP (largest at head) ───────────────────────────
PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
maxPQ.offer(30); maxPQ.offer(10); maxPQ.offer(20);
maxPQ.peek();    // 30 (maximum)

// ── CUSTOM OBJECT PRIORITY ───────────────────────────────
class Task {
    String name;
    int priority;
    Task(String n, int p) { name = n; priority = p; }
}

PriorityQueue<Task> taskQueue = new PriorityQueue<>(
    (t1, t2) -> t1.priority - t2.priority  // min priority first (1 = most urgent)
);
taskQueue.offer(new Task("Low",    3));
taskQueue.offer(new Task("High",   1));
taskQueue.offer(new Task("Medium", 2));

taskQueue.poll().name;  // "High"   (priority 1)
taskQueue.poll().name;  // "Medium" (priority 2)
taskQueue.poll().name;  // "Low"    (priority 3)

// ── COMMON PQ OPERATIONS ─────────────────────────────────
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(5); pq.offer(1); pq.offer(3);

pq.contains(3);   // true — O(n) linear scan
pq.size();        // 3
pq.remove(3);     // removes specific element — O(n) search + O(log n) heapify
pq.toArray();     // returns array — NOT in sorted order!

// ⚠ Iterating a PriorityQueue does NOT give elements in priority order!
// Use poll() repeatedly to get elements in order:
while (!pq.isEmpty()) {
    System.out.print(pq.poll() + " ");  // 1 5  (sorted order via poll)
}
```

### Time Complexity of PriorityQueue

| Operation | Complexity | Reason |
|-----------|------------|--------|
| `offer()` / `add()` | **O(log n)** | Sift-up to maintain heap property |
| `poll()` / `remove()` | **O(log n)** | Sift-down after removing root |
| `peek()` / `element()` | **O(1)** | Root element is always at index 0 |
| `contains()` | **O(n)** | Linear scan (no index structure) |
| `remove(Object)` | **O(n)** | Linear scan + O(log n) heapify |
| `size()` | **O(1)** | Stored as a field |

---

## 24. Map Interface

The `Map` interface maps **unique keys** to values. Does **NOT** extend `Collection`. One key maps to exactly one value.

**Characteristics:** Unique Keys ✅ | Values can repeat ✅ | Null keys (HashMap only) | Not ordered (unless LinkedHashMap/TreeMap)

| Method | Return Type | Description |
|--------|-------------|-------------|
| `put(K key, V value)` | `V` | Inserts/updates mapping. Returns previous value (or null). |
| `get(Object key)` | `V` | Returns value for key, or `null` if not present. |
| `getOrDefault(key, defaultVal)` | `V` | Returns value or `defaultVal` if key absent. (Java 8+) |
| `remove(Object key)` | `V` | Removes mapping; returns removed value. |
| `containsKey(Object key)` | `boolean` | `true` if map contains the key. |
| `containsValue(Object value)` | `boolean` | `true` if map contains the value. O(n). |
| `size()` | `int` | Number of key-value pairs. |
| `isEmpty()` | `boolean` | `true` if no entries. |
| `clear()` | `void` | Removes all mappings. |
| `keySet()` | `Set<K>` | Returns `Set` of all keys. |
| `values()` | `Collection<V>` | Returns `Collection` of all values (may contain duplicates). |
| `entrySet()` | `Set<Map.Entry<K,V>>` | Returns Set of all key-value pairs as `Entry` objects. |
| `putIfAbsent(K, V)` | `V` | Puts only if key not already mapped. (Java 8+) |
| `putAll(Map m)` | `void` | Copies all mappings from another map. |
| `replace(K key, V value)` | `V` | Replaces value if key exists. (Java 8+) |
| `merge(K, V, BiFunction)` | `V` | Merges value using function if key exists. (Java 8+) |
| `compute(K, BiFunction)` | `V` | Computes new value from key + old value. (Java 8+) |
| `forEach(BiConsumer)` | `void` | Iterates all (k, v) pairs. (Java 8+) |

---

## 25. Hashing Concept

Hashing converts an object into an integer (**hash code**) used to determine its storage location in a hash table.

```java
// hashCode() is defined in Object — every Java object has one
String s = "Hello";
int code = s.hashCode();  // 69609650 (deterministic for same string)

// Index in bucket array:
// index = (n-1) & hash  where n is always a power of 2
```

| Term | Definition |
|------|-----------|
| **Hash Function** | Maps input of any size → fixed integer |
| **Bucket** | A slot in the internal array. Multiple keys can map to the same bucket. |
| **Collision** | Two different keys produce the same bucket index |
| **Chaining** | Each bucket holds a linked list (Java 7) or tree (Java 8+) of entries |
| **Load Factor** | Ratio of entries to buckets. Default = **0.75**. Triggers rehash when exceeded. |
| **Rehashing** | When load factor exceeded, array doubles in size and all entries are re-placed |

> ⚠️ **`hashCode()` + `equals()` Contract:** If two objects are `.equals()`, they MUST have the same `hashCode()`. **Always override both together** when using objects as map keys or set elements.

---

## 26. How Map Uses Hashing

```java
// Simplified internal HashMap logic for put("name", "Alice"):

// Step 1: hash = "name".hashCode()              → some integer
// Step 2: Spread: hash = hash ^ (hash >>> 16)   → reduces collisions
// Step 3: index = (n-1) & hash                  → n = array size (power of 2)
// Step 4: Place Entry{key, value, hash, next} at table[index]
// Step 5: If collision → chain (linked list in Java 7, tree in Java 8+)

// Treeification (Java 8+):
// When a bucket has ≥ 8 entries  → converts LinkedList to Red-Black Tree
// When a bucket shrinks to ≤ 6  → converts back to LinkedList
// This ensures worst-case O(log n) instead of O(n) per bucket
```

| Scenario | `get()` / `put()` Complexity |
|----------|------------------------------|
| No collisions (ideal) | **O(1)** |
| With collisions — linked list | **O(n)** worst case |
| With treeified bucket (Java 8+) | **O(log n)** worst case |
| Overall amortized | **O(1) amortized** |

---

## 27. HashMap & its Functions

`HashMap` is the most used `Map` implementation. Allows **one null key** and multiple null values. No ordering guarantee.

**Characteristics:** O(1) avg get/put | 1 null key allowed | Not ordered | Not Thread-Safe | Default capacity: 16, load factor: 0.75

```java
HashMap<String, Integer> scores = new HashMap<>();

// ── PUT ──────────────────────────────────────────────────
scores.put("Alice", 95);
scores.put("Bob",   87);
scores.put("Carol", 92);
scores.put("Alice", 98);   // Updates existing key → value becomes 98
scores.put(null, 0);        // null key allowed in HashMap

// ── GET ──────────────────────────────────────────────────
scores.get("Alice");              // 98
scores.get("Unknown");            // null (key not found)
scores.getOrDefault("Dave", 0);   // 0 (default when key absent)

// ── CONTAINS ─────────────────────────────────────────────
scores.containsKey("Bob");     // true
scores.containsValue(87);      // true (O(n) scan)

// ── SIZE / EMPTY ─────────────────────────────────────────
scores.size();       // 4
scores.isEmpty();    // false

// ── REMOVE ───────────────────────────────────────────────
scores.remove("Carol");        // removes "Carol" → returns 92
scores.remove("Bob", 87);      // removes ONLY if value matches exactly 87

// ── JAVA 8 METHODS ───────────────────────────────────────
scores.putIfAbsent("Dave", 75);   // only puts if "Dave" not already a key
scores.replace("Alice", 100);     // replaces value if key exists
scores.replace("Alice", 98, 100); // conditional replace: only if old value == 98

// merge: if key absent → put value; if key present → apply function to old+new
scores.merge("Alice", 5, Integer::sum);  // Alice: 100 + 5 = 105
scores.merge("Eve",  80, Integer::sum);  // Eve: new → 80

// compute: always compute new value (returning null removes the entry)
scores.compute("Bob", (k, v) -> v == null ? 0 : v + 10);

// computeIfAbsent: put result only if key absent
scores.computeIfAbsent("Frank", k -> k.length() * 10);  // "Frank".length()*10 = 50

// computeIfPresent: update only if key currently present
scores.computeIfPresent("Alice", (k, v) -> v * 2);

// ── ITERATE (three common ways) ──────────────────────────

// 1. keySet() — simple, but requires extra get() lookup
for (String key : scores.keySet()) {
    System.out.println(key + " → " + scores.get(key));
}

// 2. values() — when you only need values
for (int val : scores.values()) {
    System.out.println(val);
}

// 3. entrySet() — MOST EFFICIENT (single lookup per entry)
for (Map.Entry<String, Integer> entry : scores.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}

// 4. forEach with lambda (Java 8+) — cleanest
scores.forEach((k, v) -> System.out.println(k + ": " + v));
```

### Frequency Count Pattern (Very Common in Interviews & Projects)

```java
String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple"};
HashMap<String, Integer> freq = new HashMap<>();

// Method 1: getOrDefault
for (String w : words) {
    freq.put(w, freq.getOrDefault(w, 0) + 1);
}
// {apple=3, banana=2, cherry=1}

// Method 2: merge (cleaner)
for (String w : words) {
    freq.merge(w, 1, Integer::sum);
}
```

---

## 28. Traversing a Map using Map.Entry

`Map.Entry<K,V>` represents a single key-value pair. Using `entrySet()` is the **most efficient** way to iterate a map — it avoids an extra `get(key)` lookup per entry.

| Method | Return | Description |
|--------|--------|-------------|
| `getKey()` | `K` | Returns the key of this entry |
| `getValue()` | `V` | Returns the value of this entry |
| `setValue(V value)` | `V` | Sets value; returns old value. Modifies the backing map. |
| `equals(Object o)` | `boolean` | Compares by key and value equality |

```java
Map<String, Integer> inventory = new HashMap<>();
inventory.put("Apples",   50);
inventory.put("Bananas",  30);
inventory.put("Cherries", 100);

// Iterate and modify values in-place
for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
    String item  = entry.getKey();
    int    count = entry.getValue();
    System.out.println(item + ": " + count);
    if (count < 40) {
        entry.setValue(count + 20);  // modify value directly
    }
}

// Find entry with maximum value using Streams
Map.Entry<String, Integer> max = inventory.entrySet().stream()
    .max(Map.Entry.comparingByValue())
    .orElseThrow();
System.out.println("Most stocked: " + max.getKey());  // Cherries

// Sort map entries by value (ascending)
inventory.entrySet().stream()
    .sorted(Map.Entry.comparingByValue())
    .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

// Sort map entries by key
inventory.entrySet().stream()
    .sorted(Map.Entry.comparingByKey())
    .forEach(e -> System.out.println(e.getKey()));
```

---

## 29. LinkedHashMap

`LinkedHashMap` extends `HashMap` and maintains **insertion order** using a doubly-linked list running through all entries.

**Characteristics:** Insertion-order maintained | Same API as HashMap | Slightly more memory | Access-order mode available

```java
// Default: insertion-order
LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
lhm.put("Zebra", 1);
lhm.put("Apple", 2);
lhm.put("Mango", 3);
for (String k : lhm.keySet())
    System.out.print(k + " ");
// Output: Zebra Apple Mango  ← insertion order preserved!

// Access-order mode (last recently accessed moves to end)
// Constructor: (initialCapacity, loadFactor, accessOrder)
LinkedHashMap<String, Integer> lru = new LinkedHashMap<>(16, 0.75f, true);
lru.put("A", 1); lru.put("B", 2); lru.put("C", 3);
lru.get("A");   // access A → moves A to end
// Iteration order now: B, C, A

// ── LRU Cache using LinkedHashMap ────────────────────────
class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    LRUCache(int cap) {
        super(cap, 0.75f, true);  // accessOrder = true
        this.capacity = cap;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;  // auto-evict least recently used when full
    }
}

LRUCache<Integer, String> cache = new LRUCache<>(3);
cache.put(1, "one");
cache.put(2, "two");
cache.put(3, "three");
cache.get(1);           // access 1 → moves to end
cache.put(4, "four");   // evicts 2 (least recently used)
```

---

## 30. BST, Red-Black Tree & TreeMap

### Binary Search Tree (BST)

A BST is a binary tree where for every node: **left subtree values < node < right subtree values**.

| Operation | Average | Worst (skewed/sorted input) |
|-----------|---------|----------------------------|
| Search / Insert / Delete | **O(log n)** | **O(n)** |

> ⚠️ **Problem with plain BST:** If elements are inserted in sorted order (1, 2, 3, 4, 5...), the tree degenerates into a linked list — all operations become O(n). **Solution: Self-Balancing Trees.**

### Red-Black Tree (Self-Balancing BST)

A Red-Black tree guarantees balance via these properties:
1. Every node is either **RED** or **BLACK**
2. Root is always **BLACK**
3. No two adjacent RED nodes (a RED node's parent and children must be BLACK)
4. All paths from root to `null` leaves have the **same number of BLACK nodes**
5. These rules ensure tree height is always `O(log n)` → **all operations guaranteed O(log n)**

Java's `TreeMap` and `TreeSet` are both backed by a **Red-Black Tree**.

### TreeMap

`TreeMap` implements `NavigableMap` and sorts keys in their **natural order** (or custom `Comparator`).

**Characteristics:** Keys always sorted | NavigableMap methods | O(log n) all operations | No null keys

```java
TreeMap<String, Integer> tm = new TreeMap<>();
tm.put("Mango",  3);
tm.put("Apple",  1);
tm.put("Cherry", 2);
tm.put("Banana", 4);
// Keys ALWAYS in sorted order: [Apple, Banana, Cherry, Mango]

// ── NAVIGABLE METHODS ────────────────────────────────────
tm.firstKey();                  // "Apple"  (smallest key)
tm.lastKey();                   // "Mango"  (largest key)
tm.firstEntry();                // Apple=1  (Entry object)
tm.lastEntry();                 // Mango=3

tm.floorKey("Cat");             // "Cherry" (greatest key ≤ "Cat")
tm.ceilingKey("Cat");           // "Cherry" (smallest key ≥ "Cat")
tm.lowerKey("Cherry");          // "Banana" (strictly less than "Cherry")
tm.higherKey("Cherry");         // "Mango"  (strictly greater than "Cherry")

tm.floorEntry("Cat");           // Entry Cherry=2
tm.ceilingEntry("Cat");         // Entry Cherry=2

// ── RANGE VIEWS ──────────────────────────────────────────
tm.headMap("Cherry");           // {Apple=1, Banana=4}       — exclusive end
tm.tailMap("Cherry");           // {Cherry=2, Mango=3}       — inclusive start
tm.subMap("Apple", "Mango");    // {Apple=1, Banana=4, Cherry=2} — [from, to)
tm.subMap("Apple", true, "Mango", true);  // inclusive both ends

// ── DESCENDING ───────────────────────────────────────────
tm.descendingKeySet();          // [Mango, Cherry, Banana, Apple]
tm.descendingMap();             // entire map in reverse key order

// ── POLL (remove and return) ─────────────────────────────
tm.pollFirstEntry();            // removes & returns Apple=1
tm.pollLastEntry();             // removes & returns Mango=3

// ── CUSTOM ORDER ─────────────────────────────────────────
TreeMap<String, Integer> reversed = new TreeMap<>(Comparator.reverseOrder());
reversed.put("Apple", 1);
reversed.put("Mango", 2);
reversed.firstKey();  // "Mango" (largest, because order is reversed)
```

### TreeMap Time Complexity

| Operation | Complexity |
|-----------|------------|
| `get` / `put` / `remove` / `containsKey` | **O(log n)** |
| `firstKey` / `lastKey` | **O(log n)** |
| `floorKey` / `ceilingKey` / `lowerKey` / `higherKey` | **O(log n)** |
| `headMap` / `tailMap` / `subMap` | **O(log n)** |
| `size()` | **O(1)** |

---

## 31. Set Interface

A `Set` is a collection that contains **no duplicate elements**. It models the mathematical set abstraction.

**Characteristics:** No Duplicates ✅ | At most one null | No index-based access | Models mathematical sets

```java
// Mathematical Set Operations
Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4));
Set<Integer> b = new HashSet<>(Arrays.asList(3, 4, 5, 6));

// Union: a ∪ b
Set<Integer> union = new HashSet<>(a);
union.addAll(b);       // {1, 2, 3, 4, 5, 6}

// Intersection: a ∩ b
Set<Integer> inter = new HashSet<>(a);
inter.retainAll(b);    // {3, 4}

// Difference: a - b
Set<Integer> diff = new HashSet<>(a);
diff.removeAll(b);     // {1, 2}

// Subset check: is b a subset of a?
a.containsAll(b);      // false (b has 5, 6 not in a)
```

---

## 32. HashSet

`HashSet` is backed internally by a `HashMap` where your elements are the **keys** and a shared dummy `PRESENT` object is the value.

**Characteristics:** No Duplicates | O(1) avg add/remove/contains | No ordering guarantee | One null allowed

```java
HashSet<String> set = new HashSet<>();

// ── ADD ──────────────────────────────────────────────────
set.add("Apple");    // true  — added
set.add("Banana");   // true
set.add("Apple");    // false — duplicate! NOT added
set.add(null);       // true  — one null allowed
set.addAll(Arrays.asList("Cherry", "Date"));

// ── CONTAINS ─────────────────────────────────────────────
set.contains("Apple");   // true  — O(1)
set.contains("Fig");     // false — O(1)

// ── REMOVE ───────────────────────────────────────────────
set.remove("Banana");    // true
set.remove("Fig");       // false (not present)

// ── SIZE / EMPTY ─────────────────────────────────────────
set.size();      // 4 (Apple, null, Cherry, Date)
set.isEmpty();   // false

// ── ITERATE (order NOT guaranteed) ───────────────────────
for (String s : set) System.out.println(s);
set.forEach(System.out::println);

// ── REMOVE DUPLICATES FROM A LIST ────────────────────────
List<Integer> withDups  = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
Set<Integer>  noDups    = new HashSet<>(withDups);
// noDups = {1, 2, 3, 4} (order not guaranteed)

// Convert back to List
List<Integer> uniqueList = new ArrayList<>(noDups);
```

### How HashSet Works Internally

```java
// HashSet is literally just a thin wrapper around HashMap:
class HashSet<E> {
    private HashMap<E, Object> map;
    private static final Object PRESENT = new Object();  // shared dummy value

    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
        // put() returns null if key was absent → means new element added → return true
        // put() returns PRESENT if key existed → duplicate → return false
    }

    public boolean contains(Object o) { return map.containsKey(o); }
    public boolean remove(Object o)   { return map.remove(o) == PRESENT; }
}
// Duplicate detection uses hashCode() for bucket + equals() for exact match
```

---

## 33. LinkedHashSet

`LinkedHashSet` extends `HashSet` and maintains **insertion order** through a linked list. Backed by `LinkedHashMap`.

**Characteristics:** No Duplicates | Insertion order maintained | O(1) avg operations | Slightly more memory than HashSet

```java
LinkedHashSet<String> lhs = new LinkedHashSet<>();
lhs.add("Zebra");
lhs.add("Apple");
lhs.add("Mango");
lhs.add("Apple");  // duplicate — silently ignored

for (String s : lhs) System.out.print(s + " ");
// Output: Zebra Apple Mango  ← insertion order!

// ── Primary use case: remove duplicates while preserving order ──
List<String> list   = Arrays.asList("b", "a", "b", "c", "a");
Set<String>  unique = new LinkedHashSet<>(list);
// unique = [b, a, c]  ← original insertion order preserved!

List<String> result = new ArrayList<>(unique);
// result = ["b", "a", "c"]
```

---

## 34. TreeSet

`TreeSet` implements `NavigableSet` and stores elements in **sorted order** using a Red-Black Tree.

**Characteristics:** Always sorted | O(log n) operations | No null elements | NavigableSet methods

```java
TreeSet<Integer> ts = new TreeSet<>();
ts.add(5); ts.add(1); ts.add(8); ts.add(3); ts.add(5);
// Stored: [1, 3, 5, 8]  ← sorted, duplicate 5 ignored

// ── NAVIGABLE METHODS ────────────────────────────────────
ts.first();              // 1  (minimum)
ts.last();               // 8  (maximum)
ts.floor(4);             // 3  (greatest element ≤ 4)
ts.ceiling(4);           // 5  (smallest element ≥ 4)
ts.lower(5);             // 3  (strictly less than 5)
ts.higher(5);            // 8  (strictly greater than 5)

// ── RANGE VIEWS ──────────────────────────────────────────
ts.headSet(5);            // [1, 3]     — exclusive end
ts.headSet(5, true);      // [1, 3, 5]  — inclusive end
ts.tailSet(5);            // [5, 8]     — inclusive start
ts.tailSet(5, false);     // [8]        — exclusive start
ts.subSet(1, 5);          // [1, 3]     — [from, to)
ts.subSet(1, true, 5, true); // [1, 3, 5]

// ── POLL (remove and return) ─────────────────────────────
ts.pollFirst();           // removes & returns 1
ts.pollLast();            // removes & returns 8
// Remaining: [3, 5]

// ── DESCENDING ───────────────────────────────────────────
ts.descendingSet();       // [5, 3] — view in descending order
ts.descendingIterator();  // iterate in reverse order

// ── CUSTOM COMPARATOR ─────────────────────────────────────
TreeSet<String> byLength = new TreeSet<>(Comparator.comparingInt(String::length));
byLength.add("Banana");
byLength.add("Fig");
byLength.add("Apple");
// [Fig, Apple, Banana]  ← sorted by string length

// ⚠ Safe comparator (tiebreak alphabetically to prevent treating same-length as duplicates)
TreeSet<String> safe = new TreeSet<>(
    Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder())
);
safe.add("Apple");
safe.add("Mango");   // both length 5 — treated as DIFFERENT (tiebroken alphabetically)
// [Apple, Mango]
```

### Set Implementation Comparison

| Feature | HashSet | LinkedHashSet | TreeSet |
|---------|---------|---------------|---------|
| Ordering | None | Insertion order | Natural / custom sort |
| `add` / `contains` / `remove` | **O(1)** avg | **O(1)** avg | **O(log n)** |
| Null elements | 1 allowed | 1 allowed | ❌ Not allowed (natural order) |
| Backed by | `HashMap` | `LinkedHashMap` | Red-Black Tree |
| NavigableSet methods | ❌ No | ❌ No | ✅ Yes |
| Best use case | Fast lookup, no order needed | Fast lookup + preserve insertion order | Sorted data, range queries |

---

## ★ Quick Reference Cheatsheet

### When to Use Which Collection

| Use Case | Best Choice | Why |
|----------|-------------|-----|
| General ordered list, mostly reads | `ArrayList` | O(1) random access |
| Frequent insert/delete at ends | `ArrayDeque` | O(1) both ends |
| LIFO stack | `ArrayDeque` (as stack) | Faster than `Stack` class |
| FIFO queue | `ArrayDeque` (as queue) | Faster than `LinkedList` |
| Double-ended operations | `ArrayDeque` | O(1) both ends |
| Priority / heap ordering | `PriorityQueue` | O(log n) insert, O(1) peek |
| Key-value, fast lookup | `HashMap` | O(1) avg |
| Key-value, insertion-ordered | `LinkedHashMap` | Ordered iteration |
| Key-value, sorted keys | `TreeMap` | O(log n), range queries |
| Unique elements, fast lookup | `HashSet` | O(1) avg |
| Unique + insertion order | `LinkedHashSet` | Ordered + no duplicates |
| Unique + sorted elements | `TreeSet` | O(log n), sorted order |
| Thread-safe list | `CopyOnWriteArrayList` | `java.util.concurrent` |
| Thread-safe map | `ConcurrentHashMap` | `java.util.concurrent` |

### Big-O Summary Table

| Collection | Access | Insert (end) | Insert (middle) | Delete | Search |
|------------|--------|--------------|-----------------|--------|--------|
| `ArrayList` | O(1) | O(1) amort. | O(n) | O(n) | O(n) |
| `LinkedList` | O(n) | O(1) | O(n) | O(1)* | O(n) |
| `ArrayDeque` | O(1)† | O(1) amort. | O(n) | O(1)† | O(n) |
| `PriorityQueue` | O(1)‡ | O(log n) | — | O(log n) | O(n) |
| `HashMap` | O(1) avg | O(1) avg | — | O(1) avg | O(1) avg |
| `LinkedHashMap` | O(1) avg | O(1) avg | — | O(1) avg | O(1) avg |
| `TreeMap` | O(log n) | O(log n) | — | O(log n) | O(log n) |
| `HashSet` | — | O(1) avg | — | O(1) avg | O(1) avg |
| `LinkedHashSet` | — | O(1) avg | — | O(1) avg | O(1) avg |
| `TreeSet` | — | O(log n) | — | O(log n) | O(log n) |

> \* O(1) only when you already have a reference to the node (via iterator)
> † Head/tail only
> ‡ Only the minimum/maximum element (the head)

---

*Java Collections Framework Complete Reference — `java.util` — Java 8+*
