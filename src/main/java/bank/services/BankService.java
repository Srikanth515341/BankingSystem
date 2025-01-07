package bank.services;

import bank.models.Account;
import bank.models.Transaction;

import java.util.HashMap;

public class BankService {
    private final HashMap<String, Account> accounts = new HashMap<>();

    public Account createAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        Account account = new Account(accountNumber, accountHolderName, initialDeposit);
        accounts.put(accountNumber, account);
        return account;
    }

    public boolean deposit(String accountNumber, double amount, String date) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return false;
        }

        double tax = 0;
        if (amount > 10000 && amount <= 100000) {
            tax = amount * 0.30;
        } else if (amount > 100000) {
            tax = amount * 0.50;
        }

        double netAmount = amount - tax;

        account.deposit(netAmount);

        Account governmentAccount = accounts.get("GOVT123456");
        if (governmentAccount != null) {
            governmentAccount.deposit(tax);
        }

        account.addTransaction(new Transaction("Deposit", netAmount, date, tax));
        System.out.println("Deposit successful. Net credited: " + netAmount + ", Tax deducted: " + tax);
        return true;
    }

    public boolean withdraw(String accountNumber, double amount, String date) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return false;
        }

        if (account.withdraw(amount)) {
            account.addTransaction(new Transaction("Withdraw", amount, date, 0));
            System.out.println("Withdrawal successful.");
            return true;
        } else {
            System.out.println("Insufficient funds.");
            return false;
        }
    }

    public void generateMiniStatement(String accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Transactions for " + account.getAccountHolderName() + " (" + accountNumber + "):");

        for (Transaction transaction : account.getTransactions()) {
            System.out.println(transaction);
        }

        System.out.println("Available Balance: " + account.getBalance());
    }
}
