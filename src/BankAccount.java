import java.util.Random;
import java.util.Scanner;

public class BankAccount {
    public double balance;
    public double previousTransaction;
    public String customerName;
    public String customerId;

    public BankAccount(String customerName) {
        this.customerName = customerName;
        this.customerId = generateCustomerId();
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("===================================");
            System.out.println("Enter an option");
            System.out.println("===================================");

            option = Character.toUpperCase(scanner.next().charAt(0));

            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("-------------------------------");
                    System.out.println("Balance = $" + balance);
                    System.out.println("-------------------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    handleDeposit(scanner);
                    break;

                case 'C':
                    handleWithdrawal(scanner);
                    break;

                case 'D':
                    System.out.println("-------------------------------");
                    getPreviousTransaction();
                    System.out.println("-------------------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("*******************************");
                    break;

                default:
                    System.out.println("Invalid option; please enter again");
                    break;
            }
        } while (option != 'E');
        System.out.println("Thank you for using our services");
        scanner.close();
    }

    private String generateCustomerId() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000));
    }

    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            previousTransaction = amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    private void handleDeposit(Scanner scanner) {
        System.out.println("-------------------------------");
        System.out.println("Enter an amount to deposit: ");
        System.out.println("-------------------------------");

        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();
            deposit(amount);
        } else {
            System.out.println("Invalid input! Please enter a number.");
            scanner.next();
        }
        System.out.println();
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds! Your balance is: $" + balance);
            return;
        }

        balance -= amount;
        previousTransaction = -amount;
        System.out.println("Withdrawal successful! You withdrew: $" + amount);
    }

    private void handleWithdrawal(Scanner scanner) {
        if (this.balance == 0) {
            System.out.println("Your balance is 0.");
            return;
        }
        System.out.print("\nEnter withdrawal amount: $");
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();
            scanner.nextLine();
            withdraw(amount);
        } else {
            System.out.println("Invalid input! Please enter a number.");
            scanner.nextLine();
        }
        System.out.println();
    }

    private void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

}
