package Banking_System;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Banking {
    private String name;
    private float amount;
    private boolean choice;
    private ArrayList<String> choices = new ArrayList<>();
    private HashMap<String, Float> data = new HashMap<>();

    public Banking(String name) {
        System.out.println(name);
    }

    void createAccount(String name, float amount) {
        if (data.containsKey(name)) {
            System.out.println("You already have an account in this bank.");
            return;
        }
        data.put(name, amount);
    }

    private boolean checkAccount(String name) {
        if (data.containsKey(name)) {
            return true;
        }
        return false;
    }

    void depositAmount(String name, float amount) {
        if (amount > 0) {
            System.out.println("Please enter a valid amount.");
            return;
        }
        if (checkAccount(name)) {
            System.out.println("User not exist.");
            return;
        }

        float newAmount = data.get(name) + amount;
        data.replace(name, newAmount);
    }

    void withdrawAmount(String name, float amount) {
        if (checkAccount(name)) {
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
        if (checkAccount(name)) {
            System.out.println("User not exist.");
            return 0;
        }
        return data.get(name);
    }

    void quitProgram() {
        System.out.println("Exiting.....");
    }

    void switchCase(String command) {
        Scanner scanner = new Scanner(System.in);
        switch (command) {
            case "createAccount":
                createAccount(scanner.next(), scanner.nextFloat());
                break;
        }
    }

}
