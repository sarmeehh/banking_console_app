import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Ask for user's name
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        //Create a bank account
        BankAccount bankAccount = new BankAccount(name);
        bankAccount.showMenu();

        scanner.close();
    }

}