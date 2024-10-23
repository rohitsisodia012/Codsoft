

import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance to withdraw $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    // Method to check the current balance
    public double checkBalance() {
        return balance;
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount bankAccount;
    private Scanner scanner = new Scanner(System.in);

    // Constructor to initialize the ATM with a user's bank account
    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    // Method to display the ATM menu and interact with the user
    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleWithdraw();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleCheckBalance();
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        }
    }

    // Method to handle withdrawing money
    private void handleWithdraw() {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        bankAccount.withdraw(amount);
    }

    // Method to handle depositing money
    private void handleDeposit() {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
    }

    // Method to handle checking the balance
    private void handleCheckBalance() {
        double balance = bankAccount.checkBalance();
        System.out.println("Your current balance is: $" + balance);
    }
}
// Main Class
public class ATMMachine {
    public static void main(String[] args) {
        // Creating a bank account with an initial balance of $1000
        BankAccount userAccount = new BankAccount(1000.0);

        // Creating an ATM instance and starting the ATM machine
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
