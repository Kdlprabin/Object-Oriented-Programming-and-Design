import java.util.Scanner;

public class Question3 implements InterfaceShape3d, InterfaceShape2d {

    @Override
    public void area(int x, int y) {
        System.out.println("The area is : " + (x * y));
    }

    @Override
    public void volume(int x, int y, int z) {
        System.out.println("The volume is : " + (x * y * z));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length: ");
        int length = scanner.nextInt();
        System.out.println("Enter the breadth : ");
        int breadth = scanner.nextInt();
        System.out.println("Enter the heighth : ");
        int height = scanner.nextInt();

        Question3 question = new Question3();
        question.area(breadth, length);
        question.volume(length, breadth, height);

    }
}
