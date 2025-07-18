## 🔍 Binary Search

### 📌 What is Binary Search?

Binary Search is an efficient algorithm for finding an element’s position in a **sorted array or list**. It works by repeatedly dividing the search interval in half, comparing the middle element to the target, and narrowing down the search space.

Unlike linear search which checks every element one by one, binary search skips half of the elements in each step, making it significantly faster for large datasets.

---

### ⏳ When to Use Binary Search?

Use Binary Search when:

- The data is **sorted** (ascending or descending order).
- You need to **quickly find** an element or a condition that satisfies a requirement.
- You're solving problems involving **monotonic functions** or **decision-based searches**.

---

### ⚙️ How to Use Binary Search?

1. Start with two pointers: `low` at the beginning and `high` at the end of the array.
2. Find the `mid` index: `(low + high) / 2`. (Better option is to do `mid = low + (high-low)/2`)
3. Compare the target value with the element at `mid`.
   - If equal, you've found the target.
   - If the target is smaller, repeat the search in the **left half**.
   - If the target is larger, repeat the search in the **right half**.
4. Repeat until the element is found or the range becomes empty.

Binary search can be implemented in both **iterative** and **recursive** ways.

---

### 📈 Time Complexity

- **Best Case:** O(1) – when the middle element is the target.
- **Average & Worst Case:** O(log n) – each step halves the size of the search space.

---

### 🧮 Space Complexity

- **Iterative implementation:** O(1)
- **Recursive implementation:** O(log n) due to function call stack

---

### 🚫 Limitations

- Requires the input data to be **sorted**.
- Not suitable for **unsorted** or **linked lists** (unless transformed into a sorted array).
- Recursive approach may cause **stack overflow** for very large inputs.

---

### ✅ Use Cases

- Searching in sorted arrays
- Finding first or last occurrences of a value
- Lower bound / Upper bound problems
- Solving competitive programming problems with monotonic behavior
- Binary search on the answer in optimization problems

---
