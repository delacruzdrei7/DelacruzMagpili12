
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        BankAccount account = new BankAccount(
            "ACC-1001",
            "Alex Cruz",
            500.00
        );

        System.out.println("=== BANK ACCOUNT EXCEPTION GATEKEEPER ===");

        System.out.println("Account Created: " +
            account.getAccountNumber() +
            " (Holder: " + account.getAccountHolder() + ")");

        System.out.printf("Balance: $%.2f%n", account.getBalance());

        try {

            // Withdrawal
            System.out.print("Enter withdrawal amount: ");
            double withdrawal = input.nextDouble();

            try {
                account.withdraw(withdrawal);
            } catch (InsufficientFundsException e) {
                System.out.println("[EXCEPTION CAUGHT]: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("[EXCEPTION CAUGHT]: " + e.getMessage());
            }

            // Deposit
            System.out.print("Enter deposit amount: ");
            double deposit = input.nextDouble();

            try {
                account.deposit(deposit);
            } catch (IllegalArgumentException e) {
                System.out.println("[EXCEPTION CAUGHT]: " + e.getMessage());
            }

        } catch (java.util.InputMismatchException e) {

            System.out.println("[INPUT ERROR]: Please enter a valid number.");

        } finally {

            System.out.println("[SESSION COMPLETE]: Transaction log updated.");

            System.out.printf("Current Balance: $%.2f%n",
                account.getBalance());

            input.close();
        }
    }
}
