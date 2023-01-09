package Banking_System;

import java.util.Scanner;


public class BankingTransaction {
    int command;
    public BankingTransaction(){
        Banking banking = new Banking("My Bank");
        Scanner scanner = new Scanner(System.in);
        command = scanner.nextInt();
        while(command != ){
            banking.switchCase(command) 
        }

    }
    public static void main(String[] args) {
            BankingTransaction bank = new BankingTransaction();
    }
}
