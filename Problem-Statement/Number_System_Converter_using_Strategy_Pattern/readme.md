# Number System Converter using Strategy Design Pattern

## 📌 Problem Statement

Design a Number System Converter using the Strategy Design Pattern.

The system should be able to convert a decimal number into:

- Binary
- Octal
- Hexadecimal

The conversion algorithm should be selected dynamically at runtime.

---

## 📊 UML Diagram

<img width="1017" height="405" alt="image" src="https://github.com/user-attachments/assets/80deda01-a2b4-46af-9027-ae3456d5f84b" />


## 🎯 Objective

Convert a decimal number into different number systems without modifying existing code.

The conversion strategy can be changed at runtime.

---

## 🏗️ Design Components

### 1. Strategy Interface

```java
interface NumberSystem {
    void convertNumber(int num);
}
```

Defines a common contract for all conversion algorithms.

---

### 2. Concrete Strategies

#### Binary Strategy

```java
class Binary implements NumberSystem
```

Converts decimal numbers to binary format.

---

#### Octal Strategy

```java
class Octal implements NumberSystem
```

Converts decimal numbers to octal format.

---

#### Hexadecimal Strategy

```java
class Hexa implements NumberSystem
```

Converts decimal numbers to hexadecimal format.

---

### 3. Context Class

```java
class Strategy
```

Maintains a reference to the current conversion strategy and delegates execution to that strategy.

---

### 4. Client

```java
class Main
```

Chooses the conversion strategy at runtime.

---

## 💻 Implementation

```java
interface NumberSystem {
    void convertNumber(int num);
}

class Binary implements NumberSystem {

    @Override
    public void convertNumber(int num) {
        System.out.println(
            "Binary: " +
            Integer.toBinaryString(num)
        );
    }
}

class Octal implements NumberSystem {

    @Override
    public void convertNumber(int num) {
        System.out.println(
            "Octal: " +
            Integer.toOctalString(num)
        );
    }
}

class Hexa implements NumberSystem {

    @Override
    public void convertNumber(int num) {
        System.out.println(
            "Hexa: " +
            Integer.toHexString(num).toUpperCase()
        );
    }
}

class Strategy {

    private NumberSystem strategy;

    public void setStrategy(NumberSystem strategy) {
        this.strategy = strategy;
    }

    public void execute(int num) {
        strategy.convertNumber(num);
    }
}

public class Main {

    public static void main(String[] args) {

        Strategy converter = new Strategy();

        converter.setStrategy(new Binary());
        converter.execute(10);

        converter.setStrategy(new Octal());
        converter.execute(10);

        converter.setStrategy(new Hexa());
        converter.execute(10);
    }
}
```

---

## ▶️ Output

```text
Binary: 1010
Octal: 12
Hexa: A
```

---

## 🔄 Execution Flow

### Binary Conversion

```text
Main
 ↓
Strategy
 ↓
Binary
 ↓
convertNumber(10)
 ↓
1010
```

### Octal Conversion

```text
Main
 ↓
Strategy
 ↓
Octal
 ↓
convertNumber(10)
 ↓
12
```

### Hexadecimal Conversion

```text
Main
 ↓
Strategy
 ↓
Hexa
 ↓
convertNumber(10)
 ↓
A
```

---

## ✅ Advantages

- Eliminates large if-else statements
- Easy to add new conversion formats
- Follows Open/Closed Principle
- Runtime behavior can be changed dynamically
- Promotes clean and maintainable code

---

## ❌ Disadvantages

- Increases the number of classes
- Slightly more complex than simple conditional logic

---

## 🎤 Interview Answer

### What is Strategy Design Pattern?

Strategy Pattern is a Behavioral Design Pattern that defines a family of algorithms, encapsulates each algorithm in a separate class, and allows them to be selected dynamically at runtime.

### How is it used in this project?

Binary, Octal, and Hexadecimal conversions are implemented as separate strategies. The Strategy class chooses which conversion algorithm to execute at runtime.

---

## 📚 Key Learning

- Interface → Strategy
- Binary, Octal, Hexa → Concrete Strategies
- Strategy Class → Context
- Main Class → Client

This project demonstrates how Strategy Design Pattern can be used to switch between multiple algorithms dynamically without changing existing code.
