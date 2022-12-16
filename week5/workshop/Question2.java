import java.util.Scanner;

public class Question2 {

    public static int getDivision(int num1, int num2) {
        try {
            int result = num1 / num2;
            return result;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number : ");
        int num1 = scanner.nextInt();
        System.out.println("Please enter another number : ");
        int num2 = scanner.nextInt();
        getDivision(num1, num2);
    }
}
