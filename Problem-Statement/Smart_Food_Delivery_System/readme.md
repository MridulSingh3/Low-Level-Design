# Smart Food Delivery System

## 📌 Overview

This project demonstrates the implementation of four popular Design Patterns in a single real-world application:

- Factory Design Pattern
- Strategy Design Pattern
- Observer Design Pattern
- Singleton Design Pattern

The application simulates a Food Delivery System where:

- Food items are created using a Factory.
- Payment methods are selected using Strategy.
- Users receive order status notifications using Observer.
- A single Logger instance is used throughout the application using Singleton.

---

## 🏗️ Design Patterns Used

### 1. Factory Pattern

Responsible for creating food objects.

#### Food Types

- VegBurger
- Pizza
- GarlicBread

Factory:

```java
FoodDeliveryFactory factory =
        new FoodDeliveryFactory();

FoodDelivery food =
        factory.getFood("VEGBURGER");
```

---

### 2. Strategy Pattern

Responsible for handling different payment methods.

#### Payment Methods

- Gpay
- Paytm

Example:

```java
Payment payment =
        new Payment(new Gpay());

payment.payment();
```

Runtime payment strategy can be changed without modifying existing code.

---

### 3. Observer Pattern

Responsible for sending order status notifications.

#### Observers

- MobileUser
- EmailUser

Subject:

```java
Notification
```

Example:

```java
notification.setNotification(
        "Order Out For Delivery");
```

All registered users receive notifications automatically.

---

### 4. Singleton Pattern

Responsible for centralized logging.

Example:

```java
Logger logger =
        Logger.getInstance();
```

Only one Logger object exists throughout the application.

---

## 📊 UML Diagram

<img width="1536" height="1024" alt="ChatGPT Image Jun 8, 2026, 09_08_34 PM" src="https://github.com/user-attachments/assets/b9ce8de9-9b1a-493b-aa2c-ffbf3e861125" />

## 💻 Implementation

```java
FoodDeliveryFactory factory =
        new FoodDeliveryFactory();

FoodDelivery food =
        factory.getFood("VEGBURGER");

food.Order("Veg Burger");

Payment payment =
        new Payment(new Gpay());

payment.payment();

Logger logger =
        Logger.getInstance();

logger.log("Food Ordered");

Notification notification =
        new Notification();

Observer mobile =
        new MobileUser();

Observer email =
        new EmailUser();

notification.addObserver(mobile);
notification.addObserver(email);

notification.setNotification(
        "Order Out For Delivery");
```

---

## ▶️ Output

```text
I Ordered Veg Burger

Payment method: GPAY

Food Ordered

Mobile Notification: Order Out For Delivery

Email Notification: Order Out For Delivery
```

---

## 🔄 Execution Flow

```text
User Places Order
        │
        ▼
FoodDeliveryFactory
Creates Food Object
        │
        ▼
Food Ordered
        │
        ▼
Payment Strategy Selected
(Gpay / Paytm)
        │
        ▼
Payment Processed
        │
        ▼
Logger Logs Activity
        │
        ▼
Order Status Updated
        │
        ▼
Notification Subject
        │
        ▼
Observers Notified
(MobileUser, EmailUser)
```

---

## 🎯 Design Pattern Mapping

| Pattern | Class |
|----------|--------|
| Factory | FoodDeliveryFactory |
| Product Interface | FoodDelivery |
| Concrete Products | VegBurger, Pizza, GarlicBread |
| Strategy | PaymentStrategy |
| Concrete Strategies | Gpay, Paytm |
| Context | Payment |
| Observer | Observer |
| Concrete Observers | MobileUser, EmailUser |
| Subject | Notification |
| Singleton | Logger |

---

## ✅ Advantages

### Factory Pattern

- Encapsulates object creation.
- Reduces coupling.

### Strategy Pattern

- Runtime behavior can change.
- Eliminates large if-else statements.

### Observer Pattern

- Supports one-to-many relationships.
- Automatic notifications.

### Singleton Pattern

- Ensures a single Logger instance.
- Saves memory.

---

## 🎤 Interview Explanation

This project combines Factory, Strategy, Observer, and Singleton Design Patterns in a Food Delivery System.

- Factory Pattern creates food items.
- Strategy Pattern handles different payment methods.
- Observer Pattern notifies subscribed users when order status changes.
- Singleton Pattern provides a centralized logger used throughout the application.

This demonstrates how multiple design patterns can work together in a real-world application while keeping the system flexible, maintainable, and loosely coupled.
