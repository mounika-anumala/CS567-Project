package com.example.project;

import java.util.HashMap;
import java.util.Map;
import com.example.project.Account;

public class BankingSystem {
    private Map<String, Account> accounts;

    public BankingSystem() {
        this.accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, double initialBalance) {
        if (!accounts.containsKey(accountNumber)) {
            Account account = new Account(accountNumber, initialBalance);
            accounts.put(accountNumber, account);
        } else {
            System.out.println("Account with this account number already exists.");
        }
    }

    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            accounts.get(accountNumber).deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            accounts.get(accountNumber).withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void transfer(String fromAccount, String toAccount, double amount) {
        if (accounts.containsKey(fromAccount) && accounts.containsKey(toAccount)) {
            Account sender = accounts.get(fromAccount);
            Account receiver = accounts.get(toAccount);
            sender.withdraw(amount);
            receiver.deposit(amount);
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    public double checkBalance(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber).getBalance();
        } else {
            System.out.println("Account not found.");
            return 0.0;
        }
    }
}

