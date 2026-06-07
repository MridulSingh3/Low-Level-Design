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
        if (accountType.equalsIgnoreCase("CHECKING")) {
            return new CheckingAccount();
        } else if (accountType.equalsIgnoreCase("SAVINGS")) {
            return new SavingsAccount();
        } else if (accountType.equalsIgnoreCase("MONEY")) {
            return new MoneyMarketAccount();
        } else if (accountType.equalsIgnoreCase("CERTIFICATE")) {
            return new CertificateDepositAccount();
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        AccountFactory factory = new AccountFactory();
        BankAccount b1 = factory.getAccount("SAVINGS");
        System.out.println(b1.withdraw());
        System.out.println(b1.deposit());
    }
}