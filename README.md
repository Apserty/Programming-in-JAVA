# Java Serialization (Sterlization Branch)

Welcome to the **Sterlization** branch of the Programming-in-JAVA repository! This branch focuses on understanding how Java objects can be converted into platform-independent byte streams and reconstructed back into objects.

## 🔄 What is Serialization?
* **Serialization** is the mechanism of converting the state of a Java object into a byte stream so it can be saved to a file, database, or transmitted across a network.
* **Deserialization** is the reverse process, where the byte stream is used to recreate the actual Java object in memory, restoring its saved state.

## 📂 Core Concepts Covered
* **`Serializable` Interface** – Implementing this marker interface to make a class eligible for serialization.
* **`ObjectOutputStream` & `ObjectInputStream`** – Utilizing the standard classes and their `writeObject()` and `readObject()` methods to handle the streams.
* **`serialVersionUID`** – Understanding this unique version identifier to maintain compatibility between the serialized object data and the class blueprint.
* **The `transient` Keyword** – Marking specific variables (like passwords or temporary tokens) to skip them from being persisted during serialization.

## ❓ Frequently Asked Q&As

### Q1: What is a marker interface, and how does it apply here?
An interface with no fields or methods is a marker interface. `java.io.Serializable` is a marker interface used to "flag" a class to the Java Virtual Machine (JVM) that its objects are safe to serialize.

### Q2: What happens if a class does not define a `serialVersionUID`?
If you do not explicitly define it, the JVM will automatically compute one at runtime based on the class structure. However, if you modify the class later (e.g., adding a field), the generated ID changes, causing an `InvalidClassException` during deserialization.

### Q3: Are static variables serialized?
No. Static variables belong to the class blueprint rather than an individual instance object, so they are not saved as part of the object's serialized state.

## 🚀 How to Run Code in This Branch
1. Ensure you have switched to this branch locally:
   ```bash
   git checkout Sterlization
   ```
2. Compile and execute your serialization code. Note that serialized objects are conventionally saved with a `.ser` file extension.
