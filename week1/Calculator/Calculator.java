package Calculator;

import java.util.Scanner;

class Calculator {
    private static String alphabets = "abcdefghijklmnopqrstuvwxyz";

    // constructor
    public Calculator() {
        System.out.println("List of operators: add subtract multiply divide alphabetize");
    }

    // addition method
    void add(int one, int two) {
        int result = one + two;
        System.out.println("Answer: " + result);
    }

    // subtraction method
    void subtract(int one, int two) {
        int result = one - two;
        System.out.println("Answer: " + result);
    }

    // multiplication method
    void multiply(double one, double two) {
        double result = one * two;
        System.out.printf("Answer: %.2f", result);
    }

    // division method
    void divide(double one, double two) {
        double result = one / two;
        System.out.printf("Answer : %.2f", result);
    }

    // check the lexicographical order
    void alphabetize(String one, String two) {

        // strings to lower case
        one = one.toLowerCase();
        two = two.toLowerCase();

        // position of the first char of the two strings one and two
        int oneIndex1 = alphabets.indexOf(one.charAt(0));
        int twoIndex1 = alphabets.indexOf(two.charAt(0));
        int result = oneIndex1 - twoIndex1;

        // if both the first chars are same
        if (result == 0) {
            int oneIndex2 = alphabets.indexOf(one.charAt(1));
            int twoIndex2 = alphabets.indexOf(two.charAt(1));
            int result2 = oneIndex2 - twoIndex2;
            // if both the second chars are same
            if (result2 == 0) {
                System.out.println("Answer: Chicken or Egg");
            } else if (result2 > 0) {
                System.out.println("Answer: " + two + " comes before " + one + " alphabetically.");
            } else {
                System.out.println("Answer: " + one + " comes before " + two + " alphabetically.");
            }
        } else if (result > 0) {
            System.out.println("Answer: " + two + " comes before " + one + " alphabetically.");
        } else {
            System.out.println("Answer: " + one + " comes before " + two + " alphabetically.");
        }
    }

    public static void main(String[] args) {
        // taking user input
        try (Scanner scanner = new Scanner(System.in)) {

            // object of calculator class
            Calculator calculator = new Calculator();

            // operation to perform
            System.out.println("Enter an operation: ");
            String operator = scanner.nextLine();

            switch (operator) {
                case "add":
                    System.out.println("Enter two integers: ");
                    try {
                        int oneAdd = scanner.nextInt();
                        int twoAdd = scanner.nextInt();
                        calculator.add(oneAdd, twoAdd);
                    } catch (Exception e) {
                        System.out.println("Invalid Input Entered. Terminating...");
                    }
                    break;
                case "subtract":
                    System.out.println("Enter two integers: ");
                    try {
                        int oneSub = scanner.nextInt();
                        int twoSub = scanner.nextInt();
                        calculator.subtract(oneSub, twoSub);
                    } catch (Exception e) {
                        System.out.println("Invalid Input Entered. Terminating...");
                    }
                    break;
                case "multiply":
                    System.out.println("Enter two doubles: ");
                    try {
                        double oneMul = scanner.nextDouble();
                        double twoMul = scanner.nextDouble();
                        calculator.multiply(oneMul, twoMul);
                    } catch (Exception e) {
                        System.out.println("Invalid Input Entered. Terminating...");
                    }
                    break;
                case "divide":
                    System.out.println("Enter two doubles: ");
                    try {
                        double oneDiv = scanner.nextDouble();
                        double twoDiv = scanner.nextDouble();
                        calculator.divide(oneDiv, twoDiv);
                    } catch (Exception e) {
                        System.out.println("Invalid Input Entered. Terminating...");
                    }
                    break;
                case "alphabetize":
                    System.out.println("Enter two words: ");
                    try {
                        String oneStr = scanner.next();
                        String twoStr = scanner.next();
                        calculator.alphabetize(oneStr, twoStr);
                    } catch (Exception e) {
                        System.out.println("Invalid Input Entered. Terminating...");
                    }
                    break;
                default:
                    System.out.println("Invalid input entered. Terminating...");
            }
        }

    }
}