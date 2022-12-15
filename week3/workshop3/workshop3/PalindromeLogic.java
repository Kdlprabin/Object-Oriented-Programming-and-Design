package workshop3;

public class PalindromeLogic {
    private String text;

    // constructor
    public PalindromeLogic(String text) {
        this.text = text;
    }

    // getter method
    public String getText() {
        return text;
    }

    // setter Method
    public void setText(String text) {
        this.text = text;
    }

    public boolean checkPalindrome() {
        int last = text.length() - 1;
        String revWord = "";
        for (int i = last; i >= 0; i--) {
            revWord = revWord + text.charAt(i);
        }
        if (revWord.equals(text)) {
            return true;
        } else {
            return false;
        }
    }
}
