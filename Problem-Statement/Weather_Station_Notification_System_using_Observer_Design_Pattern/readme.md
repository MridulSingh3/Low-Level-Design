# Weather Station Notification System using Observer Design Pattern

## 📌 Problem Statement

Design a Weather Station Notification System using the Observer Design Pattern.

### Requirements

- Multiple devices can subscribe to the Weather Station.
- The Weather Station maintains temperature data.
- Whenever the temperature changes, all subscribed devices should be notified automatically.
- New devices can be added or removed dynamically.

---

## 📊 UML Diagram

```text
+----------------------+
|      Observer        |
+----------------------+
| + update(temp)       |
+----------------------+
           ^
           |
------------------------------
|                            |
|                            |
+----------------+  +----------------+
| PhoneDisplay   |  | TVDisplay      |
+----------------+  +----------------+
| + update()     |  | + update()     |
+----------------+  +----------------+

           ^
           |
+----------------------+
|       Subject        |
+----------------------+
| + addObserver()      |
| + removeObserver()   |
| + notifyObservers()  |
+----------------------+
           ^
           |
+----------------------+
|    WeatherStation    |
+----------------------+
| - temperature        |
| - observers          |
+----------------------+
| + setTemperature()   |
+----------------------+
```

---

## 🎯 Objective

Notify all subscribed devices automatically whenever the temperature changes.

---

## 🏗️ Design Components

### Observer Interface

```java
interface Observer
```

Defines the update method that all observers must implement.

```java
void update(int temperature);
```

---

### Concrete Observers

#### PhoneDisplay

```java
class PhoneDisplay implements Observer
```

Receives weather updates and displays them on a phone.

#### TVDisplay

```java
class TVDisplay implements Observer
```

Receives weather updates and displays them on a TV.

---

### Subject Interface

```java
interface Subject
```

Defines methods to manage observers.

```java
addObserver()
removeObserver()
notifyObservers()
```

---

### Concrete Subject

```java
class WeatherStation implements Subject
```

Stores temperature data and notifies all registered observers when the temperature changes.

---

### Client

```java
class Main
```

Creates the Weather Station and registers observers.

---

## 💻 Implementation

```java
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(int temperature);
}

class PhoneDisplay implements Observer {

    @Override
    public void update(int temperature) {
        System.out.println(
                "Phone Display: Temperature = "
                + temperature);
    }
}

class TVDisplay implements Observer {

    @Override
    public void update(int temperature) {
        System.out.println(
                "TV Display: Temperature = "
                + temperature);
    }
}

interface Subject {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

class WeatherStation implements Subject {

    private List<Observer> observers =
            new ArrayList<>();

    private int temperature;

    @Override
    public void addObserver(
            Observer observer) {

        observers.add(observer);
    }

    @Override
    public void removeObserver(
            Observer observer) {

        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(
            int temperature) {

        this.temperature = temperature;

        notifyObservers();
    }
}

public class Main {

    public static void main(String[] args) {

        WeatherStation station =
                new WeatherStation();

        Observer phone =
                new PhoneDisplay();

        Observer tv =
                new TVDisplay();

        station.addObserver(phone);
        station.addObserver(tv);

        station.setTemperature(35);
    }
}
```

---

## ▶️ Output

```text
Phone Display: Temperature = 35
TV Display: Temperature = 35
```

---

## 🔄 Execution Flow

```text
WeatherStation
      ↓
setTemperature(35)
      ↓
notifyObservers()
      ↓
PhoneDisplay.update()
TVDisplay.update()
```

---

## 🧠 How Observer Pattern Works

1. Observers subscribe to the Subject.
2. Subject maintains a list of observers.
3. When the Subject's state changes, it calls `notifyObservers()`.
4. Every observer receives the update automatically.

---

## ✅ Advantages

- Loose coupling between Subject and Observers
- Easy to add new observers
- Supports one-to-many relationships
- Automatic event notification
- Follows Open/Closed Principle

---

## ❌ Disadvantages

- Too many observers may affect performance
- Notifications can become difficult to track in large systems

---

## 🌍 Real-World Applications

- YouTube Notifications
- Instagram Followers Updates
- Stock Market Monitoring
- Weather Applications
- Newsletter Subscription Systems
- Event Listeners in GUI Applications

---

## 🎤 Interview Answer

### What is Observer Design Pattern?

Observer Pattern is a Behavioral Design Pattern that establishes a one-to-many relationship between objects. When the state of a Subject changes, all registered Observers are automatically notified and updated.

### How is it used in this project?

The Weather Station acts as the Subject and PhoneDisplay and TVDisplay act as Observers. Whenever the temperature changes, the Weather Station automatically notifies all subscribed devices.

---

## 📚 Key Learning

- `Observer` → Observer Interface
- `PhoneDisplay`, `TVDisplay` → Concrete Observers
- `Subject` → Subject Interface
- `WeatherStation` → Concrete Subject
- `Main` → Client

The Observer Pattern is used when one object's state change should automatically notify multiple dependent objects.
