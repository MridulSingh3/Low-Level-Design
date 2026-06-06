# 🎯 SOLID Principles in Java

<div align="center">

![SOLID](https://img.shields.io/badge/SOLID-Design%20Principles-blue?style=for-the-badge)

**A collection of Java examples demonstrating the five SOLID principles of Object-Oriented Design and Low-Level Design (LLD).**

🚀 Write Clean Code • 🚀 Build Scalable Systems • 🚀 Ace LLD Interviews

</div>

---

## 📖 What are SOLID Principles?

SOLID is a set of five design principles introduced by **Robert C. Martin (Uncle Bob)** to make software systems more maintainable, scalable, and flexible.

These principles help developers write clean, reusable, and loosely coupled code.

---

## 🧩 SOLID Breakdown

| Principle | Description |
|------------|------------|
| 🟢 **S** | Single Responsibility Principle |
| 🔵 **O** | Open Closed Principle |
| 🟡 **L** | Liskov Substitution Principle |
| 🟠 **I** | Interface Segregation Principle |
| 🔴 **D** | Dependency Inversion Principle |

---

# 🟢 Single Responsibility Principle (SRP)

> A class should have only one reason to change.

### ✅ Good Example

```java
UserRepository
EmailService
ReportService
```

Each class handles a single responsibility.

### Benefits

✔ Easier Maintenance  
✔ Better Readability  
✔ Improved Testing  

---

# 🔵 Open Closed Principle (OCP)

> Software entities should be open for extension but closed for modification.

### ❌ Bad

```java
if(type.equals("EMAIL"))
if(type.equals("SMS"))
if(type.equals("WHATSAPP"))
```

Every new feature requires modifying existing code.

### ✅ Good

```java
interface Notification {
    void send();
}
```

```java
class EmailNotification implements Notification {}
class SMSNotification implements Notification {}
class WhatsAppNotification implements Notification {}
```

Add new functionality without modifying existing code.

---

# 🟡 Liskov Substitution Principle (LSP)

> Child classes should be replaceable for their parent classes.

### ❌ Bad

```java
Bird bird = new Penguin();
bird.fly();
```

Penguins cannot fly.

### ✅ Good

```java
interface Flyable {
    void fly();
}
```

```java
class Sparrow implements Flyable {}
class Penguin {}
```

Inheritance should preserve behavior.

---

# 🟠 Interface Segregation Principle (ISP)

> Clients should not be forced to depend on methods they do not use.

### ❌ Bad

```java
interface Worker {
    void work();
    void eat();
    void sleep();
}
```

Robot workers don't eat or sleep.

### ✅ Good

```java
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Sleepable {
    void sleep();
}
```

Create small, focused interfaces.

---

# 🔴 Dependency Inversion Principle (DIP)

> Depend on abstractions, not concrete implementations.

### ❌ Bad

```java
Notification
      |
      V
 EmailService
```

Tight coupling.

### ✅ Good

```java
Notification
      |
      V
MessageService
   /      \
  /        \
Email     SMS
```

Loose coupling through abstractions.

---

## 📂 Project Structure

```text
SOLID-Principles/
│
├── srp.java
├── ocp.java
├── lsp.java
├── isp.java
├── dip.java
│
└── README.md
```

---

## 🎯 Why SOLID?

✨ Improves Code Quality

✨ Reduces Tight Coupling

✨ Makes Systems Scalable

✨ Simplifies Maintenance

✨ Enhances Testability

✨ Encourages Clean Architecture

---

## 🚀 Quick Revision

```text
S → One Responsibility

O → Extend, Don't Modify

L → Child Should Replace Parent

I → Small Specific Interfaces

D → Depend On Abstractions
```

---

## 🛠 Tech Stack

- Java
- OOP
- SOLID Principles
- Low Level Design (LLD)

---

<div align="center">

### ⭐ If you found this repository useful, consider giving it a Star!

🚀 Happy Coding 🚀

</div>
