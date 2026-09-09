# Java Collections Framework (Collections Branch)

Welcome to the **Collections** branch of the Programming-in-JAVA repository! This branch focuses on mastering the Java Collections Framework (JCF), which provides an architecture to store and manipulate a group of objects efficiently.

## 🗃️ What is the Collections Framework?
The Java Collections Framework is a unified architecture representing and manipulating collections. It reduces programming effort by providing data structures (like lists, sets, and maps) and algorithms (like sorting and searching) out of the box, optimizing speed and memory usage.

## 📂 Core Concepts Covered
* **The `Collection` Hierarchy** – Understanding the core interfaces: `List`, `Set`, and `Queue`.
* **The `Map` Interface** – Storing data as Key-Value pairs using implementations like `HashMap` and `TreeMap`.
* **Lists vs. Sets** – Exploring index-based sequential ordering (`ArrayList`, `LinkedList`) vs. unique-element collections (`HashSet`, `TreeSet`).
* **Iterating Collections** – Navigating data sets smoothly via `Iterator`, `ListIterator`, and the enhanced for-each loop.
* **Sorting & Ordering** – Implementing custom ordering logic using the `Comparable` and `Comparator` interfaces.

## ❓ Frequently Asked Q&As

### Q1: What is the main difference between `ArrayList` and `LinkedList`?
* **`ArrayList`:** Backed by a dynamic resizable array. It provides fast $O(1)$ constant-time access via indexes, but shifting elements makes insertions and deletions slow ($O(n)$) when operating in the middle of the list.
* **`LinkedList`:** Backed by a doubly-linked list structure. Element lookups require linear traversal ($O(n)$), but insertions and deletions are highly efficient ($O(1)$) because only node pointers need to change.

### Q2: How does a `HashMap` handle duplicate keys?
A `HashMap` relies on unique keys. If you attempt to insert a key-value pair with a key that already exists inside the map, the framework will overwrite the old value associated with that key with your newly provided value.

### Q3: What is the difference between `Comparable` and `Comparator`?
* **`Comparable`:** Used to define the *natural sorting order* for a class. The class must implement `Comparable` and override the `compareTo()` method directly within itself.
* **`Comparator`:** Used to define *custom sorting orders* (e.g., sorting by age, then by name). It is created as a separate class or anonymous lambda that overrides the `compare()` method, leaving the original target class untouched.

## 🚀 How to Run Code in This Branch
1. Ensure you have switched to this branch locally:
   ```bash
   git checkout Collections
   ```
2. Open, compile, and run the collection implementations to see different time complexities and data sorting mechanisms in action.
