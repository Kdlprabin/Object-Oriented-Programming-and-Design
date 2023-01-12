package Banking_System;

import java.util.Scanner;


public class BankingTransaction {
    int command;
    public BankingTransaction(){
        Banking banking = new Banking("My Bank");
        Scanner scanner = new Scanner(System.in);
        System.out.println("These are the commands for this system.");

        for(int i = 0; i <5; i++){
            System.out.println(i+1 + "- "+ banking.choices.get(i));
        }
        while(command != 5){
            System.out.println("Enter the command number: ");
            command = scanner.nextInt()-1;
            banking.switchCase(banking.choices.get(command));
        }

    }
    public static void main(String[] args) {
            BankingTransaction bank = new BankingTransaction();
    }
}
