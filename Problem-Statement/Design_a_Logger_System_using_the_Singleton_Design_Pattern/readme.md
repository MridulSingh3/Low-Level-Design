# Singleton Design Pattern - Logger System

## 📌 Problem Statement

Design a Logger System using the Singleton Design Pattern.

### Requirements

- Only one Logger object should exist throughout the application.
- All classes should use the same Logger instance.
- Logger should provide a method to log messages.

---

## 📊 UML Diagram

```text
+----------------------------------+
|            Logger                |
+----------------------------------+
| - instance : Logger              |
+----------------------------------+
| - Logger()                       |
| + getInstance() : Logger         |
| + log(message : String) : void   |
+----------------------------------+
```

---

## 🏗️ Design Explanation

### Private Constructor

```java
private Logger(){}
```

Prevents object creation using:

```java
new Logger();
```

Only the class itself can create an object.

### Static Instance Variable

```java
private static Logger instance;
```

Stores the single instance of Logger.

### getInstance() Method

```java
public static synchronized Logger getInstance()
```

- Creates the object only once.
- Returns the same object every time.
- `synchronized` makes it thread-safe.

---

## 💻 Implementation

```java
class Logger {

    private static Logger instance;

    private Logger() {}

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println(message);
    }
}

public class Main {

    public static void main(String[] args) {

        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();

        l1.log("Application Started");
        l2.log("User Logged In");

        System.out.println(l1 == l2);
    }
}
```

---

## ▶️ Output

```text
Application Started
User Logged In
true
```

---

## 🔍 How It Works

### First Call

```java
Logger l1 = Logger.getInstance();
```

Since `instance == null`, a new Logger object is created.

### Second Call

```java
Logger l2 = Logger.getInstance();
```

Since the object already exists, the same object is returned.

Therefore:

```java
l1 == l2
```

returns:

```text
true
```

---

## 🎯 Why Singleton?

Singleton is useful when only one object should exist in the entire application.

Examples:

- Logger
- Database Connection Manager
- Configuration Manager
- Cache Manager
- Printer Spooler

---

## ✅ Advantages

- Saves memory
- Provides global access point
- Avoids unnecessary object creation
- Ensures consistent application state

---

## ❌ Disadvantages

- Difficult to unit test
- Can introduce global state issues
- Requires extra care in multithreaded environments

---

## 🎤 Interview Answer

**What is Singleton Design Pattern?**

Singleton is a Creational Design Pattern that ensures a class has only one instance and provides a global point of access to that instance throughout the application.

---

## 📚 Key Learning

- `private constructor` → Prevents object creation from outside.
- `static instance` → Stores the single object.
- `getInstance()` → Returns the same object every time.
- `synchronized` → Makes the implementation thread-safe.

⭐ This is one of the most frequently asked Design Pattern questions in Java and LLD interviews.
