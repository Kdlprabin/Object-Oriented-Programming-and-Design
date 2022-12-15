package week2;

public class Graduate extends Student {

    private Assignment assignment = new Assignment(student_name);

    public Graduate(String student_name, int student_age) {
        super(student_name, student_age);
    }

    void printName() {
        super.printName();
    }

    void submitAssignment(){
        if(assignment instanceof Assignment){
            assignment.getMarks();
        }
    }

    public static void main(String[] args) {
        Graduate graduate = new Graduate("prabin", 20);
        graduate.submitAssignment();
    }
}
