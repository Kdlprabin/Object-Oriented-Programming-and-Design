import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex{
    //constructor
    String word = "Herald@gmail.com";
    String stringPattern = "[A-Z]";
    public Regex(){
    }
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("hello", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("helloworld");
        System.out.println(matcher.find());
    }
}