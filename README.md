# Java Generics (Generic-class Branch)

Welcome to the **Generic-class** branch of the Programming-in-JAVA repository! This branch focuses on understanding how to use Java Generics to create reusable, type-safe classes, interfaces, and methods.

## 🧬 What are Generics?
Generics allow you to abstract over types. They enable you to write a single class, interface, or method that can safely work with different data types (like Integers, Strings, or custom objects) while providing strict compile-time type checking.

## 📂 Core Concepts Covered
* **Generic Classes & Interfaces** – Defining classes with type parameters (e.g., `Class<T>`).
* **Generic Methods** – Writing standalone methods that accept generic type inputs.
* **Bounded Type Parameters** – Restricting the types that can be passed using the `extends` keyword (e.g., `<T extends Number>`).
* **Wildcards (`?`)** – Understanding Upper Bounded (`? extends T`), Lower Bounded (`? super T`), and Unbounded wildcards.
* **Type Erasure** – How the Java compiler removes generic type information during compilation for backward compatibility.

## ❓ Frequently Asked Q&As

### Q1: What is the primary benefit of using Generics?
The biggest benefit is **compile-time type safety**. Before Generics, you had to use the `Object` class and manually cast types, which frequently caused runtime `ClassCastException` errors. Generics catch these type mismatches while you are writing code.

### Q2: Can we use primitive types (like `int`, `char`, `double`) as type parameters?
No. Generics do not support primitive data types directly because type parameters must be reference types. You must use their respective Wrapper classes instead (e.g., `Integer`, `Character`, `Double`).

### Q3: What is the naming convention for generic type parameters?
By convention, type parameters are single, uppercase letters:
* `T` – Type
* `E` – Element (heavily used by the Java Collections Framework)
* `K` – Key
* `V` – Value
* `N` – Number

## 🚀 How to Run Code in This Branch
1. Ensure you have switched to this branch locally:
   ```bash
   git checkout Generic-class
   ```
2. Open, compile, and run the generic programming examples found in this directory.
