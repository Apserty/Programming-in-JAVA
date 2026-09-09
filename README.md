# Java File Handling (File-Handling Branch)

Welcome to the **File-Handling** branch of the Programming-in-JAVA repository! This branch focuses on understanding how to perform input and output (I/O) operations on files using Java's built-in libraries.

## 📁 What is File Handling?
File handling allows a Java program to read from, write to, create, delete, and manage files on your local machine. Java treats these file sources or destinations as streams of data flowing into or out of your application code.

## 📂 Core Concepts Covered
* **The `File` Class** – Creating, checking existence, deleting, and fetching file properties or directory structures.
* **Character Streams** – Reading and writing text files using `FileReader`, `FileWriter`, `BufferedReader`, and `BufferedWriter`.
* **Byte Streams** – Reading and writing raw binary data (like images or audio files) using `FileInputStream` and `FileOutputStream`.
* **The Java NIO package (`java.nio.file`)** – Exploring modern, non-blocking I/O file utilities like `Files` and `Paths`.
* **Exception Management** – Handling checked operations securely using `IOException` catch blocks.

## ❓ Frequently Asked Q&As

### Q1: What is the main difference between Character Streams and Byte Streams?
* **Character Streams:** Specifically designed for handling 16-bit Unicode text data. They handle character encoding automatically, making them ideal for text files.
* **Byte Streams:** Process data as raw 8-bit bytes without any encoding translation. They are used for binary files like images, zip archives, or compiled audio.

### Q2: Why is `BufferedReader` preferred over a raw `FileReader`?
Using a raw `FileReader` triggers a system read request for every single character, which is resource-heavy and degrades performance. `BufferedReader` reads a large chunk of characters at once into an internal memory buffer, serving subsequent read actions instantly from memory.

### Q3: What is the difference between writing to a file in overwrite mode vs append mode?
* **Overwrite Mode (Default):** Passing only a file path to `FileWriter("file.txt")` replaces everything currently in the file with your new text content.
* **Append Mode:** Passing a boolean flag `FileWriter("file.txt", true)` tells Java to keep the old data intact and attach new text directly to the end of the file.

## 🚀 How to Run Code in This Branch
1. Ensure you have switched to this branch locally:
   ```bash
   git checkout File-Handling
   ```
2. Run the provided examples. Take note of whether the programs expect target text files to exist beforehand or if they generate them dynamically.
