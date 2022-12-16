import java.util.Scanner;

public class Question5 extends Exception {

    public Question5() {
        super("The number is negative.");
    }

    public static void main(String[] args) throws Question5 {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number : ");
        int number = scanner.nextInt();
        if (number < 0) {
            throw new Question5();
        } else {
            System.out.println("The input number is : " + number);
        }
    }
}
