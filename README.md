# Java Exception Handling (Exceptions Branch)

Welcome to the **Exceptions** branch of the Programming-in-JAVA repository! This branch focuses on understanding how to intercept runtime anomalies, prevent application crashes, and manage clean code pathways when things go wrong.

## ⚠️ What is Exception Handling?
An exception is an unwanted or unexpected event that occurs during the execution of a program (at runtime) and disrupts the normal flow of instructions. Exception handling is a mechanism that intercepts these events so the application can resolve them or shut down gracefully without crashing.

## 📂 Core Concepts Covered
* **The `Throwable` Hierarchy** – Understanding the relationship between `Throwable`, `Error`, and `Exception`.
* **Checked vs. Unchecked Exceptions** – Differentiating between compile-time required checks and runtime errors.
* **The Keywords Quintet** – Masterfully utilizing `try`, `catch`, `finally`, `throw`, and `throws`.
* **Custom Exceptions** – Extending `Exception` or `RuntimeException` to build tailored business-logic errors.
* **Try-with-Resources** – Managing auto-closeable system dependencies smoothly.

## ❓ Frequently Asked Q&As

### Q1: What is the difference between Checked and Unchecked Exceptions?
* **Checked Exceptions:** Evaluated at compile-time. The compiler forces you to handle them using a try-catch block or declare them with `throws` (e.g., `IOException`, `SQLException`).
* **Unchecked Exceptions:** Occur at runtime and extend `RuntimeException`. The compiler does not force you to handle them explicitly; they are typically caused by programming logical bugs (e.g., `NullPointerException`, `ArrayIndexOutOfBoundsException`).

### Q2: What is the purpose of the `finally` block?
The `finally` block always executes regardless of whether an exception was thrown or caught. It is strictly used to place cleanup code—such as closing file streams, network sockets, or database connections—to prevent resource leaks.

### Q3: What is the difference between `throw` and `throws`?
* **`throw`:** A keyword used to explicitly raise a single, specific exception object instance in the middle of a code block (e.g., `throw new IllegalArgumentException();`).
* **`throws`:** A keyword used in a method signature declaration to warn callers that this specific method might hand off one or more exceptions up the execution stack.

## 🚀 How to Run Code in This Branch
1. Ensure you have switched to this branch locally:
   ```bash
   git checkout Exceptions
   ```
2. Compile and run the provided error-handling scenarios to observe how execution flows through various catch segments.
