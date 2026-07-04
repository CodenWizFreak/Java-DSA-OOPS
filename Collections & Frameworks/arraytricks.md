# Java Arrays Tricks 

```java
import java.util.*;
```

---

# 1. Filling Arrays

## Arrays.fill()

Fill an entire array with one value.

```java
int[] arr = new int[5];
Arrays.fill(arr, -1);

System.out.println(Arrays.toString(arr));
// [-1, -1, -1, -1, -1]
```

Time Complexity: **O(n)**

---

## Arrays.fill() (Range)

```java
int[] arr = {1,2,3,4,5};

Arrays.fill(arr, 1, 4, 0);

System.out.println(Arrays.toString(arr));
// [1,0,0,0,5]
```

Range:
- fromIndex → inclusive
- toIndex → exclusive

---

## Arrays.parallelFill()

Uses multiple CPU cores for huge arrays.

```java
int[] arr = new int[1_000_000];
Arrays.parallelFill(arr, 5);
```

Mostly useful for very large arrays.

---

# 2. Searching

## Arrays.binarySearch()

Array **must already be sorted.**

```java
int[] arr = {2,4,6,8,10};

int idx = Arrays.binarySearch(arr, 8);

System.out.println(idx);
// 3
```

If not found:

```java
Arrays.binarySearch(arr,7);
// returns -4
```

Meaning:

```
-(insertionPoint)-1
```

Time Complexity:

```
O(log n)
```

---

## Binary Search in Range

```java
int[] arr = {1,3,5,7,9,11};

int idx = Arrays.binarySearch(arr,1,5,7);

System.out.println(idx);
//3
```

Searches only between

```
[1,5)
```

---

# 3. Copying Arrays

## Arrays.copyOf()

```java
int[] arr = {1,2,3};

int[] copy = Arrays.copyOf(arr,5);

System.out.println(Arrays.toString(copy));
// [1,2,3,0,0]
```

If new length is larger,
remaining values become default values.

---

## Arrays.copyOfRange()

```java
int[] arr = {10,20,30,40,50};

int[] part = Arrays.copyOfRange(arr,1,4);

System.out.println(Arrays.toString(part));
// [20,30,40]
```

Range:

```
[from,to)
```

---

## System.arraycopy()

Fastest way to copy arrays.

```java
int[] src = {1,2,3,4,5};
int[] dest = new int[5];

System.arraycopy(src,0,dest,0,5);

System.out.println(Arrays.toString(dest));
// [1,2,3,4,5]
```

Useful in Merge Sort.

---

# 4. Sorting

## Arrays.sort()

```java
int[] arr = {5,2,4,1};

Arrays.sort(arr);

System.out.println(Arrays.toString(arr));
// [1,2,4,5]
```

Time:

```
O(n log n)
```

---

## Sort Only a Range

```java
int[] arr = {5,4,3,2,1};

Arrays.sort(arr,1,4);

System.out.println(Arrays.toString(arr));
// [5,2,3,4,1]
```

---

## Sort Descending (Objects Only)

Primitive arrays cannot use Comparator.

```java
Integer[] arr = {5,2,7,1};

Arrays.sort(arr, Collections.reverseOrder());

System.out.println(Arrays.toString(arr));
// [7,5,2,1]
```

---

## Custom Comparator

Sort intervals by first element.

```java
int[][] intervals = {
    {5,7},
    {1,4},
    {2,6}
};

Arrays.sort(intervals,
    (a,b) -> Integer.compare(a[0], b[0]));

System.out.println(Arrays.deepToString(intervals));
// [[1,4],[2,6],[5,7]]
```

Sort by second element.

```java
Arrays.sort(intervals,
    (a,b) -> Integer.compare(a[1], b[1]));
```

---

# 5. Comparing Arrays

## Arrays.equals()

```java
int[] a = {1,2,3};
int[] b = {1,2,3};

System.out.println(Arrays.equals(a,b));
// true
```

---

## Arrays.deepEquals()

```java
int[][] a = {{1,2},{3,4}};
int[][] b = {{1,2},{3,4}};

System.out.println(Arrays.deepEquals(a,b));
// true
```

---

# 6. Printing Arrays

## Arrays.toString()

```java
int[] arr = {1,2,3};

System.out.println(Arrays.toString(arr));
// [1, 2, 3]
```

Perfect for debugging.

---

## Arrays.deepToString()

```java
int[][] mat = {
    {1,2},
    {3,4}
};

System.out.println(Arrays.deepToString(mat));
// [[1, 2], [3, 4]]
```

---

# 7. Streams

## Sum

```java
int[] arr = {1,2,3,4};

int sum = Arrays.stream(arr).sum();

System.out.println(sum);
//10
```

---

## Maximum

```java
int max = Arrays.stream(arr)
                .max()
                .getAsInt();
```

---

## Minimum

```java
int min = Arrays.stream(arr)
                .min()
                .getAsInt();
```

---

## Distinct Elements

```java
int[] arr = {1,2,2,3,1};

int[] unique =
Arrays.stream(arr)
      .distinct()
      .toArray();

System.out.println(Arrays.toString(unique));
// [1,2,3]
```

---

# 8. Initializing Arrays

```java
int[] arr = {1,2,3,4};

int[][] mat = {
    {1,2},
    {3,4}
};
```

---

# 9. Arrays.setAll()

Initialize using a formula.

```java
int[] arr = new int[5];

Arrays.setAll(arr, i -> i*i);

System.out.println(Arrays.toString(arr));
// [0,1,4,9,16]
```

---

# 10. Arrays.mismatch() (Java 9+)

Returns first different index.

```java
int[] a = {1,2,3,4};
int[] b = {1,2,7,4};

System.out.println(Arrays.mismatch(a,b));
//2
```

---

# 11. Matrix Traversal

## Traverse Matrix

```java
for(int i=0;i<mat.length;i++){

    for(int j=0;j<mat[0].length;j++){

        System.out.print(mat[i][j]+" ");

    }

    System.out.println();
}
```

---

## Traverse Direction Arrays (Grid Problems)

```java
int[] dr = {-1,1,0,0};
int[] dc = {0,0,-1,1};

for(int k=0;k<4;k++){

    int nr = r + dr[k];
    int nc = c + dc[k];

}
```

Used in:

- BFS
- DFS
- Flood Fill
- Number of Islands
- Shortest Path

---

# 12. Frequently Used Math

```java
Math.max(a,b);

Math.min(a,b);

Math.abs(x);
```

Used constantly in array problems.

---

# 13. Complexity Summary

| Method | Complexity |
|---------|------------|
| fill() | O(n) |
| parallelFill() | O(n) |
| binarySearch() | O(log n) |
| sort() | O(n log n) |
| copyOf() | O(n) |
| copyOfRange() | O(n) |
| arraycopy() | O(n) |
| equals() | O(n) |
| deepEquals() | O(n) |
| stream().sum() | O(n) |
| stream().max() | O(n) |
| distinct() | O(n) average |
| setAll() | O(n) |
| mismatch() | O(n) |
