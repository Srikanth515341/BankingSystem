package bank;

import bank.services.BankService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();

        // Create default government account
        bankService.createAccount("GOVT123456", "Government", 0);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Banking System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    String accName = scanner.nextLine();
                    System.out.print("Enter initial deposit: ");
                    double initialDeposit = scanner.nextDouble();
                    bankService.createAccount(accNum, accName, initialDeposit);
                    System.out.println("Account created successfully.");
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    String depositAccount = scanner.nextLine();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter deposit date (YYYY-MM-DD): ");
                    String depositDate = scanner.nextLine();
                    bankService.deposit(depositAccount, depositAmount, depositDate);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    String withdrawAccount = scanner.nextLine();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter withdrawal date (YYYY-MM-DD): ");
                    String withdrawDate = scanner.nextLine();
                    bankService.withdraw(withdrawAccount, withdrawAmount, withdrawDate);
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    String statementAccount = scanner.nextLine();
                    bankService.generateMiniStatement(statementAccount);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
