abstract class NonWithdrawable {
    abstract void deposit(double amount);
}

abstract class Withdrawable extends NonWithdrawable {
    abstract void withdraw(double amount);
}

class SavingAccount extends Withdrawable {
    private double balance = 0;

    @Override
    void deposit(double amount) {
        balance += amount;
        System.out.println("Saving Account Deposit: " + amount);
    }

    @Override
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
            System.out.println("Saving Account Withdraw: " + amount);
        }
    }
}

class CurrentAccount extends Withdrawable {
    private double balance = 0;

    @Override
    void deposit(double amount) {
        balance += amount;
        System.out.println("Current Account Deposit: " + amount);
    }

    @Override
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
            System.out.println("Current Account Withdraw: " + amount);
        }
    }
}

class FixedDeposit extends NonWithdrawable {
    private double balance = 0;

    @Override
    void deposit(double amount) {
        balance += amount;
        System.out.println("FD Deposit: " + amount);
    }
}

public class Main {
    public static void main(String[] args) {
        SavingAccount saving = new SavingAccount();
        saving.deposit(5000);
        saving.withdraw(2000);
        System.out.println();

        CurrentAccount current = new CurrentAccount();
        current.deposit(10000);
        current.withdraw(3000);
        System.out.println();

        FixedDeposit fd = new FixedDeposit();
        fd.deposit(50000);
    }
}