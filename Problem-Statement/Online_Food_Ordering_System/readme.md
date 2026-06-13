
# Online Food Ordering System using Command Design Pattern

## 📌 Problem Statement

Design an Online Food Ordering System using the Command Design Pattern.

A customer places food orders through a waiter. The waiter does not know how the food is prepared. The waiter simply executes the order command, and the chef performs the actual cooking.

---

## 🎯 Objective

Demonstrate the Command Design Pattern by decoupling the order requester (Waiter) from the order executor (Chef).

---

## 📊 UML Diagram

```text
+----------------------+
|    OrderCommand      |
+----------------------+
| + execute()          |
+----------------------+
            ^
            |
---------------------------------------
|                 |                   |
|                 |                   |
+-------------+ +-------------+ +-------------+
| PizzaOrder  | | BurgerOrder | | PastaOrder  |
+-------------+ +-------------+ +-------------+
| + execute() | | + execute() | | + execute() |
+-------------+ +-------------+ +-------------+

            |
            ▼

+----------------------+
|        Chef          |
+----------------------+
| + cookPizza()        |
| + cookBurger()       |
| + cookPasta()        |
+----------------------+

            ^

+----------------------+
|       Waiter         |
+----------------------+
| - command            |
+----------------------+
| + takeOrder()        |
| + placeOrder()       |
+----------------------+
```

---

## 🏗️ Design Components

### Command Interface

```java
interface OrderCommand {
    void execute();
}
```

Defines a common contract for all commands.

---

### Receiver

```java
class Chef
```

Performs the actual work.

Methods:

```java
cookPizza()
cookBurger()
cookPasta()
```

---

### Concrete Commands

```java
PizzaOrder
BurgerOrder
PastaOrder
```

Each command delegates the request to the Chef.

---

### Invoker

```java
class Waiter
```

Stores and executes commands.

Methods:

```java
takeOrder()
placeOrder()
```

---

### Client

```java
class Main
```

Creates commands and connects all components.

---

## 💻 Implementation

```java
interface OrderCommand {
    void execute();
}

class Chef {

    public void cookPizza() {
        System.out.println("Chef is preparing Pizza");
    }

    public void cookBurger() {
        System.out.println("Chef is preparing Burger");
    }

    public void cookPasta() {
        System.out.println("Chef is preparing Pasta");
    }
}

class PizzaOrder implements OrderCommand {

    private Chef chef;

    public PizzaOrder(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void execute() {
        chef.cookPizza();
    }
}

class BurgerOrder implements OrderCommand {

    private Chef chef;

    public BurgerOrder(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void execute() {
        chef.cookBurger();
    }
}

class PastaOrder implements OrderCommand {

    private Chef chef;

    public PastaOrder(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void execute() {
        chef.cookPasta();
    }
}

class Waiter {

    private OrderCommand command;

    public void takeOrder(OrderCommand command) {
        this.command = command;
    }

    public void placeOrder() {
        command.execute();
    }
}

public class Main {

    public static void main(String[] args) {

        Chef chef = new Chef();

        OrderCommand pizza =
                new PizzaOrder(chef);

        OrderCommand burger =
                new BurgerOrder(chef);

        OrderCommand pasta =
                new PastaOrder(chef);

        Waiter waiter = new Waiter();

        waiter.takeOrder(pizza);
        waiter.placeOrder();

        waiter.takeOrder(burger);
        waiter.placeOrder();

        waiter.takeOrder(pasta);
        waiter.placeOrder();
    }
}
```

---

## ▶️ Output

```text
Chef is preparing Pizza
Chef is preparing Burger
Chef is preparing Pasta
```

---

## 🔄 Execution Flow

```text
Customer
   ↓
Waiter
   ↓
OrderCommand
   ↓
Chef
   ↓
Food Prepared
```

Example:

```text
PizzaOrder
   ↓
execute()
   ↓
Chef.cookPizza()
   ↓
Chef is preparing Pizza
```

---

## 🎭 Design Pattern Mapping

| Role             | Class                               |
| ---------------- | ----------------------------------- |
| Command          | OrderCommand                        |
| Concrete Command | PizzaOrder, BurgerOrder, PastaOrder |
| Receiver         | Chef                                |
| Invoker          | Waiter                              |
| Client           | Main                                |

---

## ✅ Advantages

* Loose coupling between Invoker and Receiver
* Easy to add new commands
* Supports Undo/Redo functionality
* Commands can be queued and logged
* Follows Open/Closed Principle

---

## 🌍 Real-World Applications

* Restaurant Order Systems
* Remote Controls
* Undo/Redo Operations
* Banking Transactions
* Job Scheduling Systems
* Task Queues

---

## 🎤 Interview Explanation

The Command Design Pattern encapsulates a request as an object. In this project, the Waiter acts as the Invoker, the Chef acts as the Receiver, and food orders such as PizzaOrder, BurgerOrder, and PastaOrder act as Concrete Commands. The Waiter does not know how food is prepared; it simply executes the command, making the system loosely coupled and extensible.

---

## 📚 Key Learning

* Command Pattern converts requests into objects.
* Invoker and Receiver remain loosely coupled.
* New commands can be added without changing existing code.
* Useful for task execution, logging, scheduling, and undo operations.
