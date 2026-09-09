# Java Database Connectivity (JDBC Branch)

Welcome to the **JDBC** branch of the Programming-in-JAVA repository! This branch focuses on understanding how Java applications connect and interact with relational databases using the standard JDBC API.

## 🗄️ What is JDBC?
Java Database Connectivity (JDBC) is a Java API that manages connecting to a database, executing SQL statements, and processing the retrieved results. It serves as an abstraction layer between your Java code and database engines like MySQL, PostgreSQL, or Oracle.

## 📂 Core Concepts Covered
* **JDBC Drivers** – Understanding driver architectures and registering database-specific drivers.
* **Core API Interfaces** – Working with `Connection`, `Statement`, `PreparedStatement`, and `ResultSet`.
* **CRUD Operations** – Writing Java code to Insert, Read, Update, and Delete database records.
* **SQL Injection Prevention** – Utilizing parameterized queries with `PreparedStatement` to keep transactions secure.
* **Transaction Management** – Handling database commits and rollbacks programmatically using `setAutoCommit(false)`.

## ❓ Frequently Asked Q&As

### Q1: What is the difference between `Statement` and `PreparedStatement`?
* **`Statement`:** Compiles the SQL query every single time it runs. It is vulnerable to SQL injection attacks and is best used for simple, one-time static queries.
* **`PreparedStatement`:** Pre-compiles the SQL query template on the database server. It accepts parameters dynamically, executes much faster over repetitive iterations, and inherently blocks SQL injection threats.

### Q2: Why should we use try-with-resources when dealing with JDBC objects?
Database connections, statements, and result sets are heavy system resources. If left open, they cause memory leaks and exhaust connection pools. Using a try-with-resources block ensures these resources are automatically closed when the block finishes, even if an exception occurs.

### Q3: How do you handle database transactions manually in JDBC?
By default, JDBC commits every individual statement automatically. To group multiple operations into a single transaction, you set `connection.setAutoCommit(false)`. You then invoke `connection.commit()` if all steps succeed, or `connection.rollback()` inside a catch block if any step fails.

## 🚀 How to Run Code in This Branch
1. Ensure you have switched to this branch locally:
   ```bash
   git checkout JDBC
   ```
2. Make sure you have the appropriate database driver JAR file (like MySQL Connector/J) added to your project's build path.
3. Configure your local database credentials inside the sample program before running it.
