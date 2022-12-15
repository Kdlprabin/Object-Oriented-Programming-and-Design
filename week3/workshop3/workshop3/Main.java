package workshop3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // object of the Dog class which extends Animal class
        Dog dog = new Dog("Black", "Rocky", "Mammal");
        dog.getColor();//gets the color of the dog

        // scanner class to take user input
        System.out.println("\nPlease enter a word/number to check Palindrome: ");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();

        // Palindrome words
        Palindrome palindrome = new Palindrome(word);
        palindrome.printResult();

        //check number
        System.out.println("\nPlease enter any number");
        int number = scanner.nextInt();

        Prime prime = new Prime(number);
        prime.printPrimeOrNot();
        scanner.close();
    }
}