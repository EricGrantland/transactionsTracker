package com.myApps;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class BankAccount {
    private String accountName;
    private double balance;
    private double startingBalance;
    private List<String> transactions;

    public BankAccount(String accountName, String accountNumber, double balance) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        if(balance > 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
        this.startingBalance = this.balance;
        this.transactions = new ArrayList<String>();
        transactions.add("Starting Balance: " + startingBalance);
    }

    public void showBalance() {
        System.out.println("Account Balance: " + this.balance);
    }

    public boolean depositFunds(double depositAmount) {
            if (depositAmount > 0) {
                this.balance += depositAmount;
                System.out.println("$" + depositAmount + " has been deposited into " + accountName + ".\nBalance is now: " + this.balance);
                transactions.add("+$" + depositAmount + " deposit made.\n\tTotal Balance: $" + this.balance);
                return true;
            }
            System.out.println("Can only deposit a positive amount");
            return false;
    }

    public boolean withdrawFunds(double withdrawalAmount) {
            if (withdrawalAmount > 0) {
                this.balance -= withdrawalAmount;
                System.out.println("$" + withdrawalAmount + " has been withdrawn from " + accountName + ".\nBalance is now: " + this.balance);
                transactions.add("-$" + withdrawalAmount + " withdrawal made.\n\tTotal Balance: $" + this.balance);
                return true;
            }

            System.out.println("Can only withdraw a positive amount");
            return false;


    }

    public void listTransactions() {
        System.out.println("Transaction History:");
        for(String transaction : transactions) {
            System.out.println("\t" + transaction);
        }
        System.out.println("Current Balance: " + this.balance);
    }

    public void showLastTransaction() {
        if(transactions.size() > 1) {
            System.out.println("Last transaction:\n\t" + transactions.get(transactions.size() - 1));
        } else {
            System.out.println("No transactions have been made since the initial deposit. \nAccount Balance: " + this.balance);
        }
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

}
