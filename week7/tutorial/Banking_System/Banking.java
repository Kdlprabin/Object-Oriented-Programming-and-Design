package Banking_System;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Banking {
    private String name;
    private float amount;
    private boolean choice;
    ArrayList<String> choices = new ArrayList<>();
    private HashMap<String, Float> data = new HashMap<String, Float>();

    public Banking(String name) {
        //welcome message and command choices
        System.out.println("\nWelcome to " + name + "!!!\n");
        choices.add("createAccount");
        choices.add("depositAmount");
        choices.add("withdrawAmount");
        choices.add("checkBalance");
        choices.add("quit");
    }

    void createAccount(String name, float amount) {
        if (data.containsKey(name)) {
            System.out.println("You already have an account in this bank.");
            return;
        }
            this.data.put(name, amount);
    }

    private boolean checkAccount(String name) {
        if (data.containsKey(name)) {
            return true;
        }
        return false;
    }

    void depositAmount(String name, float amount) {
        if (amount < 0) {
            System.out.println("Please enter a valid amount.");
            return;
        }
        if (!checkAccount(name)) {
            System.out.println("User not exist.");
            return;
        }
            float newAmount = data.get(name) + amount;
            data.replace(name, newAmount);
    }

    void withdrawAmount(String name, float amount) {
        if (!checkAccount(name)) {
            System.out.println("User not exist.");
            return;
        }
        if (data.get(name) < amount) {
            System.out.println("Insufficient amount in the account.");
            return;
        }
            float newAmount = data.get(name) - amount;
            data.replace(name, newAmount);
    }

    float checkBalance(String name) {
        if (!checkAccount(name)) {
            System.out.println("User not exist.");
            return 0;
        }
            System.out.println("The amount available is : " + data.get(name));
            return data.get(name);
    }

    private void quitProgram() {
        System.out.println("Logging out.....\n");
    }

    void switchCase(String command) {
        Scanner scanner = new Scanner(System.in);
        switch (command) {
            case "createAccount":
                System.out.println("Enter the name: ");
                this.name = scanner.next();
                System.out.println("Enter the amount: ");
                this.amount = scanner.nextFloat();
                createAccount(name, amount);
                break;
            case "depositAmount":
                System.out.println("Enter the name: ");
                String holderName = scanner.next();
                System.out.println("Enter the amount: ");
                float depositAmount = scanner.nextFloat();
                depositAmount(holderName, depositAmount);
                break;
            case "withdrawAmount":
                System.out.println("Enter the name: ");
                String withdrawName = scanner.next();
                System.out.println("Enter the amount: ");
                float withdrawAmount = scanner.nextFloat();
                withdrawAmount(withdrawName, withdrawAmount);
                break;
            case "checkBalance":
                System.out.println("Enter the name: ");
                checkBalance(scanner.next());
                break;
            case "quit":
                quitProgram();
                break;
            default:
                break;
        }
    }

}
