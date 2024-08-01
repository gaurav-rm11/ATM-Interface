import java.util.Scanner;
import java.util.ArrayList;
import java.lang.String;

/*  File name:   ATM INTERFACE
    Author:      Gaurav Mahadeshwar
    Date:        05-11-2023
    Version:     1.0
    Description: The file contains 4 java files namely Account.java, User.java, Transactions.java(interface) and Main.java
                 This is a console based ATM interface.  */

public class Main {

    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String inputID;
        int inputPin;
        Account a1 = new Account("Gaurav", "gaur11", 1914); // as the ATM can access any bank accounts I opted to make
                                                            // accounts rather than creating other bank.java class and
                                                            // instances.
        Account a2 = new Account("Harsh", "ha182", 1945);
        accounts.add(a1);
        accounts.add(a2);
        System.out.println("Welcome to ATM!!\n");
        System.out.println("Please enter your userID: ");
        inputID = scanner.nextLine();
        System.out.println("Please enter your pin: ");
        inputPin = scanner.nextInt();

        boolean found = false;
        for (int i = 0; i < accounts.size(); i++) {
            if ((inputID).equalsIgnoreCase(accounts.get(i).getUserID()) && (inputPin) == (accounts.get(i).getPin())) {
                found = true;
                {
                    Account a = accounts.get(i);
                    int choice;
                    do {
                        System.out.println("\nWelcome " + a.getUserName());
                        System.out.println(
                                "Choose an option:\n1.Withdraw\n2.Deposit\n3.Check Balance\n4.Transfer\n5.Transaction History\n6.Quit");
                        System.out.println("enter your choice: ");
                        choice = scanner.nextInt();
                        switch (choice) {
                            case 1 -> {
                                int amount;
                                System.out.println("Enter the amount you want to withdraw: ");
                                amount = scanner.nextInt();
                                a.withdraw(amount);
                            }
                            case 2 -> {
                                int amount2;
                                System.out.println("Enter the amount you want to deposit: ");
                                amount2 = scanner.nextInt();
                                a.deposit(amount2);
                            }
                            case 3 -> System.out.println("Your current balance is :" + a.getBalance());
                            case 4 -> {
                                int amount3;
                                String user;
                                Account reciever;
                                System.out.println("Enter the amount: ");
                                amount3 = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Enter the recipient's ID: ");
                                user = scanner.nextLine();
                                boolean recieverfound = false;
                                for (Account account : accounts) {
                                    if (account.getUserID().equals(user)) {
                                        recieverfound = true;
                                        reciever = account;
                                        a.transfer(amount3, reciever);
                                        break;
                                    }
                                }
                                if (!recieverfound) {
                                    System.out.println("No such account exists");
                                }
                            }
                            case 5 -> a.transactionHistory();
                            case 6 -> System.out.println("Thank you for banking with us!");
                            default -> System.out.println("Please enter a valid option");
                        }
                    } while (choice != 6);
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Invalid User ID or Pin, Please try again!");
        }

    }
}
