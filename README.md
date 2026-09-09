# Java Packages (Package Branch)

Welcome to the **Package** branch of the Programming-in-JAVA repository! This branch focuses on understanding how packages work in Java to group related classes, interfaces, and sub-packages.

## 📦 What is a Package?
A package in Java is a mechanism used to encapsulate a group of classes, sub-packages, and interfaces. It helps prevent naming conflicts, controls access, and makes code easier to locate and maintain.

## 📂 Core Concepts Covered
* **Built-in Packages** – Utilizing standard Java libraries (e.g., `java.util`, `java.lang`, `java.io`).
* **User-defined Packages** – Creating, structuring, and compiling your own custom packages.
* **The `import` Keyword** – How to import specific classes or entire packages into your files.
* **Access Protection** – Understanding how packages interact with access modifiers (`public`, `protected`, `private`, and default/package-private).

## ❓ Frequently Asked Q&As

### Q1: What is the purpose of the `package` keyword in Java?
The `package` keyword is used to define a namespace for your classes. It must be the very first line of code in your Java source file (excluding comments).

### Q2: What is the difference between `import java.util.*` and `import java.util.Scanner`?
* `import java.util.*` imports all public classes and interfaces within the `util` package, which might slightly affect compilation time but does not impact runtime performance or memory.
* `import java.util.Scanner` explicitly imports only the `Scanner` class, keeping the code explicitly clear about its dependencies.

### Q3: How do you compile a Java file that belongs to a package from the terminal?
Use the `-d` option flag followed by the destination directory (usually `.` for the current directory):
```bash
javac -d . MyClass.java
```
This forces the compiler to automatically generate the required folder structure matching your package name.

## 🚀 How to Run Code in This Branch
1. Ensure you are on the `Package` branch:
   ```bash
   git checkout Package
   ```
2. Navigate to the specific source folder and compile the packaged classes using the `-d` flag.
