import java.util.Scanner;

// Base class
abstract class BankAccount {
    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    abstract void calculateInterest();
}

// Saving Account
class SavingAccount extends BankAccount {

    SavingAccount(double balance) {
        super(balance);
    }

    void calculateInterest() {
        double interest = balance * 0.04; // 4% interest
        System.out.println("Saving Account Interest: " + interest);
    }
}

// Current Account
class CurrentAccount extends BankAccount {

    CurrentAccount(double balance) {
        super(balance);
    }

    void calculateInterest() {
        double interest = balance * 0.02; // 2% interest
        System.out.println("Current Account Interest: " + interest);
    }
}

// Main class
public class BankingSystem {
    public static void main(String[] args) {

        BankAccount acc1 = new SavingAccount(5000);
        BankAccount acc2 = new CurrentAccount(8000);

        acc1.deposit(1000);
        acc1.calculateInterest();

        System.out.println();

        acc2.withdraw(2000);
        acc2.calculateInterest();
    }
}
