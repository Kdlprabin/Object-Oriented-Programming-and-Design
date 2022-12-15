package Question3;

import java.util.Scanner;

@SuppressWarnings("unused")
public class ExceptionHandling {
    //instance variable
    private int number;
    
    //constructor
    public ExceptionHandling() {

        //scanner class to take input from the user
        Scanner scanner = new Scanner(System.in);

        //try block that tries a certain block code
        try{
            number = scanner.nextInt();
            //if the code gets error than it throws an exception
            //which can be caught using catch and a certain action
            //can be taken if the exception is found. This whole process 
            //is exception handling
        }catch(Exception e){
            System.out.println("The input number is not int.\nPlease enter a integer.");
        }
    }
    public static void main(String[] args) {
        ExceptionHandling exceptionHandeling = new ExceptionHandling();
    }
}
