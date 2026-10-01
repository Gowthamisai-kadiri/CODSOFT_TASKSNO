package Task3;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double balance = 10000;

        while (true) {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Current Balance: " + balance);
            }

            else if (choice == 2) {
                System.out.print("Enter deposit amount: ");
                double amount = sc.nextDouble();

                balance = balance + amount;

                System.out.println("Amount deposited successfully.");
                System.out.println("Current Balance: " + balance);
            }

            else if (choice == 3) {
                System.out.print("Enter withdrawal amount: ");
                double amount = sc.nextDouble();

                if (amount <= balance) {
                    balance = balance - amount;

                    System.out.println("Please collect your cash.");
                    System.out.println("Current Balance: " + balance);
                } else {
                    System.out.println("Insufficient balance.");
                }
            }

            else if (choice == 4) {
                System.out.println("Thank you for using ATM.");
                break;
            }

            else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
