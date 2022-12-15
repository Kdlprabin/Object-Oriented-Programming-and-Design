package week2;

public class Student {
    String student_name;
    int student_age;

    void printName() {
        System.out.println(student_name);
        System.out.println(student_age);
    }

    // Constructor
    Student(String student_name, int student_age) {
        this.student_name = student_name;
        this.student_age = student_age;
    }

    // main method
    public static void main(String[] args) {
        Student student = new Student("prabin",20);
        student.printName();
    }

    // Student Object
}