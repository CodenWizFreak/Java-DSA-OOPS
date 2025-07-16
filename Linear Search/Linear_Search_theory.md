# 🔍 Linear Search

Linear Search is one of the simplest searching algorithms in Data Structures and Algorithms (DSA). It's a foundational technique that's easy to understand and implement, making it a great starting point for beginners in programming and algorithm design.

---

## 📘 What is Linear Search?

Linear Search, also known as **sequential search**, is a method to find a specific value in a list or array by checking each element one by one from the beginning to the end until the target is found or the list ends.

---

## ✅ When to Use

- When the dataset is **unsorted**
- When the dataset is **small**
- When you're **learning the basics** of searching
- When code **simplicity** is more important than performance

---

## 🧠 How It Works

1. Start from the first element.
2. Compare the target element with the current element.
3. If it matches, return the index (or indicate it's found).
4. If it doesn't, move to the next element.
5. Repeat until the end of the list.
6. If no match is found, return -1 or indicate not found.

---

## ⏱️ Time Complexity

| Case        | Time Complexity |
|-------------|-----------------|
| Best Case   | O(1)            |
| Average Case| O(n)            |
| Worst Case  | O(n)            |

- **Best Case**: The target is at the first index.
- **Worst Case**: The target is at the end or not present at all.

---

## 💾 Space Complexity

- O(1) → Constant space, as no extra memory is used regardless of input size.

---

## ⚠️ Limitations

- **Inefficient** for large datasets.
- **Slow** compared to binary search on sorted data.
- Doesn't take advantage of any structure in the data.

---

## 📍 Applications

- Useful in small or unsorted datasets.
- Basic building block for more advanced algorithms.
- Used when simplicity is more important than speed.

---

## 📌 Summary

Linear Search is an essential starting point in your DSA journey. While not optimal for large datasets, it teaches key concepts like iteration, conditionals, and basic problem-solving patterns.

> Mastering Linear Search builds the foundation for understanding more efficient algorithms like Binary Search and Hashing.

---

### 📁 You can find the implementation and sample problems in this folder.
