package workshop3;

public class Palindrome extends PalindromeLogic {
    private String text;

    // constructor
    public Palindrome(String text) {
        super(text);
    }

    public void printResult() {
        this.text = super.getText();
        if (super.checkPalindrome()) {
            System.out.println(text + " is a palindrome");
        } else {
            System.out.println(text + " is not a palindrome");
        }

    }
}
