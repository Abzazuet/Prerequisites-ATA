# Sort

- Makes problem more efficient
- Easier to analyze

## Selection Sort

- Find the smallest item of the array, add it to another array and delete from the current array.

## Sort in place

- Sort the input without generating a different array
- Swap places with index
- Reorders the input array

## Efficency

- Bubble and selection have same general shape, slow (n^2)
- Collections.sort is faster
- The interfaces allow us to call the defined functions with our own classes
- Comparable and comparator
- `Collections.sort` should always be used to sort

## Collections.sort

- Way faster than the bubble sort and the selection sort.

# Comparing objects

- WE cannot use <>, we should use object.compareTo(object).

## Sort at scale

```java
public interface Comparable <T>{
    public int compareTo(T o);
}
```

- Promises one method: compareTo
- Defines natural ordering for type
- T specifies to compare to
- For `<QuakeEntry>`: `comparable <QuakeEntry>`

```java
public interface Comparable <QuakeEntry>{
    public int compareTo(QuakeEntry o);
}
```

- `<T> `Built-in part of java
- String implements `Comparable<String>`
- Lexicographical for ordering letters
- A negative return number means "less than"
- A zero is equal
- A positive number means more than
- The method to compare double is `(Double.compare(d1, d2))`

## Comparator

```java
public interface Comparator <T>{
    public int compare(T o1, T o2);
}
```

- Defines orderings for another type
- Difference between comparable and comparator is that comparator is a third object that compares two sets of data
- The `Collections.sort` method can take a comparator as its second parameter

```java
Collections.sort(list, new MagnitudeComparator());
```

-
