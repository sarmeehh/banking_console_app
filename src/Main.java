import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        BankAccount bankAccount = new BankAccount(name);
        bankAccount.showMenu();

        scanner.close();
    }

}