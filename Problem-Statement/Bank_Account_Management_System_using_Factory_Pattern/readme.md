# Bank Account Factory using Factory Design Pattern

## 📌 Problem Statement

Design a Bank Account Management System using the Factory Design Pattern.

The system should support multiple account types:

- Checking Account
- Savings Account
- Money Market Account
- Certificate Deposit Account

The client should not create account objects directly. The Factory class should be responsible for creating the appropriate account object.

---

## 📊 UML Diagram

<img width="1202" height="476" alt="image" src="https://github.com/user-attachments/assets/fd6c278d-bc13-4953-b715-8c34de11f9ed" />


## 🎯 Objective

Create different types of bank account objects without exposing object creation logic to the client.

---

## 🏗️ Design Components

### Abstract Product

```java
abstract class BankAccount
```

Defines common behavior for all bank accounts.

Methods:

```java
withdraw()
deposit()
```

---

### Concrete Products

#### CheckingAccount

```java
class CheckingAccount extends BankAccount
```

#### SavingsAccount

```java
class SavingsAccount extends BankAccount
```

#### MoneyMarketAccount

```java
class MoneyMarketAccount extends BankAccount
```

#### CertificateDepositAccount

```java
class CertificateDepositAccount extends BankAccount
```

Each account type provides its own implementation of `withdraw()` and `deposit()`.

---

### Factory Class

```java
class AccountFactory
```

Responsible for creating account objects.

```java
BankAccount getAccount(String accountType)
```

Returns the appropriate account object based on the account type.

---

### Client

```java
class Main
```

Requests objects from the factory instead of creating them directly.

---

## 💻 Implementation

```java
abstract class BankAccount {

    String bankName;
    int accountNumber;

    abstract String withdraw();
    abstract String deposit();
}

class CheckingAccount extends BankAccount {

    @Override
    String withdraw() {
        return "Checking account withdraws";
    }

    @Override
    String deposit() {
        return "Checking account deposits";
    }
}

class SavingsAccount extends BankAccount {

    @Override
    String withdraw() {
        return "Saving account withdraws";
    }

    @Override
    String deposit() {
        return "Saving account deposits";
    }
}

class MoneyMarketAccount extends BankAccount {

    @Override
    String withdraw() {
        return "MoneyMarket account withdraws";
    }

    @Override
    String deposit() {
        return "MoneyMarket account deposits";
    }
}

class CertificateDepositAccount extends BankAccount {

    @Override
    String withdraw() {
        return "CertificateDeposit account withdraws";
    }

    @Override
    String deposit() {
        return "CertificateDeposit account deposits";
    }
}

class AccountFactory {

    public BankAccount getAccount(String accountType) {

        if(accountType.equalsIgnoreCase("CHECKING")) {
            return new CheckingAccount();
        }
        else if(accountType.equalsIgnoreCase("SAVINGS")) {
            return new SavingsAccount();
        }
        else if(accountType.equalsIgnoreCase("MONEY")) {
            return new MoneyMarketAccount();
        }
        else if(accountType.equalsIgnoreCase("CERTIFICATE")) {
            return new CertificateDepositAccount();
        }

        return null;
    }
}

public class Main {

    public static void main(String[] args) {

        AccountFactory factory = new AccountFactory();

        BankAccount account =
                factory.getAccount("SAVINGS");

        System.out.println(account.withdraw());
        System.out.println(account.deposit());
    }
}
```

---

## ▶️ Output

```text
Saving account withdraws
Saving account deposits
```

---

## 🔄 Execution Flow

```text
Main
 ↓
AccountFactory
 ↓
getAccount("SAVINGS")
 ↓
SavingsAccount Object
 ↓
withdraw()
 ↓
deposit()
```

---

## ✅ Advantages

- Encapsulates object creation logic
- Reduces coupling between client and objects
- Easy to add new account types
- Follows Open/Closed Principle
- Improves maintainability

---

## ❌ Disadvantages

- Increases the number of classes
- Factory logic can become complex if too many products are added

---

## 🎤 Interview Answer

### What is Factory Design Pattern?

Factory Design Pattern is a Creational Design Pattern that delegates the responsibility of object creation to a Factory class instead of allowing the client to create objects directly.

### How is it used in this project?

The client requests an account from the `AccountFactory`. Based on the account type, the factory creates and returns the appropriate account object such as `SavingsAccount`, `CheckingAccount`, or `MoneyMarketAccount`.

---

## 📚 Key Learning

- `BankAccount` → Abstract Product
- `SavingsAccount`, `CheckingAccount`, `MoneyMarketAccount`, `CertificateDepositAccount` → Concrete Products
- `AccountFactory` → Factory
- `Main` → Client

The Factory Pattern centralizes object creation and keeps the client independent of concrete classes.
