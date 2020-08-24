package com.myApps;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount("My Account", 0.00);
        printOptions();

        int choice = 0;
        boolean appOpen = true;

        while (appOpen) {
            Scanner scanner = new Scanner(System.in);
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Enter valid number");
                printOptions();
                continue;
            }

            switch (choice) {
                case 1:
                    account.showBalance();
                    break;
                case 2:
                    try {
                        System.out.println("\tEnter deposit amount:");
                        double depositAmount = scanner.nextDouble();
                     account.depositFunds(depositAmount);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input entered");
                        printOptions();
                    }
                    break;
                case 3:
                    try {
                        System.out.println("\tEnter withdrawal amount:");
                        double withdrawalAmount = scanner.nextDouble();
                        account.withdrawFunds(withdrawalAmount);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input entered");
                        printOptions();
                    }
                    break;
                case 4:
                    account.showLastTransaction();
                    break;
                case 5:
                    account.listTransactions();
                    break;
                case 6:
                    System.out.println("Closing App");
                    appOpen = false;
                    break;
                default:
                    System.out.println("Please enter a valid number between 1 - 6:\n");
                    printOptions();
                    break;
            }
        }

    }

    public static void printOptions() {
        System.out.println("\nSelect an option from the menu below:");
        System.out.println("\t1. Show account balance" +
                "\n\t2. Make deposit" +
                "\n\t3. Withdraw funds" +
                "\n\t4. Show last transaction" +
                "\n\t5. Show full transaction history" +
                "\n\t6. Quit Application");
    }
}
