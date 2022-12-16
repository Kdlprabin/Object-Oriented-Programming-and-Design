import java.util.InputMismatchException;
import java.util.Scanner;

import javafx.beans.value.WritableObjectValue;

@SuppressWarnings("unused")
public class Question1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Please enter a number : ");
            int number1 = scanner.nextInt();

            System.out.println("Please enter another number : ");
            int number2 = scanner.nextInt();

            int answer = number1 / number2;
            System.out.println(number1 + " /" + number2 + "=" + answer);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (InputMismatchException e) {
            System.out.println(e);
        } catch (NullPointerException e) {
            System.out.println(e);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
}