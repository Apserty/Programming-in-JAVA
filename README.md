# Java Multithreading (Multithreading Branch)

Welcome to the **Multithreading** branch of the Programming-in-JAVA repository! This branch focuses on understanding how to execute multiple threads simultaneously to maximize CPU utilization and build high-performance applications.

## 🧵 What is Multithreading?
Multithreading is a Java feature that allows concurrent execution of two or more parts of a program for maximum utilization of the CPU. Each part of such a program is called a thread. Threads are lightweight processes within a process.

## 📂 Core Concepts Covered
* **Thread Creation** – Inheriting from the `Thread` class vs. implementing the `Runnable` interface.
* **Thread Lifecycle** – Navigating states like New, Runnable, Blocked, Waiting, Timed Waiting, and Terminated.
* **Synchronization** – Preventing thread interference and data corruption using `synchronized` blocks and methods.
* **Inter-Thread Communication** – Utilizing `wait()`, `notify()`, and `notifyAll()` to coordinate tasks between active threads.
* **Thread Pools** – Managing a collection of worker threads using the `ExecutorService` framework.

## ❓ Frequently Asked Q&As

### Q1: What is the difference between extending `Thread` and implementing `Runnable`?
* **Extending `Thread`:** Your class cannot extend any other class because Java does not support multiple inheritance.
* **Implementing `Runnable`:** Your class can still extend another base class, making it a more flexible design choice widely preferred in production code.

### Q2: What is the difference between `start()` and `run()` methods?
* Calling `start()` creates a brand new thread and allocates the necessary system resources before executing the `run()` method within that new context.
* Calling `run()` directly does not create a new thread; it simply executes the code sequentially like a regular method inside the current calling thread.

### Q3: Why is thread synchronization necessary?
When multiple threads try to access and modify a shared mutable resource at the same time, it leads to data inconsistency (Race Condition). Synchronization ensures that only one thread can access the critical section of code at a single time.

## 🚀 How to Run Code in This Branch
1. Ensure you have switched to this branch locally:
   ```bash
   git checkout Multithreading
   ```
2. Compile and run the concurrent examples found in this folder directory.
