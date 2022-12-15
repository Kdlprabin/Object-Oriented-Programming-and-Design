package week2;

public class Assignment {
    int obtainedMarks = 90;
    String name;
    Assignment(String name) {
        this.name = name;
    }

    void getMarks() {
        System.out.println(name);
        System.out.println(obtainedMarks);
    }
}
