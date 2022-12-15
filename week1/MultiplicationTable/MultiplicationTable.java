package MultiplicationTable;

import java.util.Scanner;

public class MultiplicationTable {

    // variables declaration
    private int multi, upto;

    // assigning the values to the instance variables
    public MultiplicationTable(int multi, int upto) {
        this.multi = multi;
        this.upto = upto;
    }

    //getter methods
    public int getMulti() {
        return this.multi;
    }

    public int getUpto() {
        return this.upto;
    }


    //setter methods
    public void setMulti(int multi) {
        this.multi = multi;
    }
    public void setUpto(int upto) {
        this.upto = upto;
    }

    public void getMultiplicationTable() {
        // looping the multiplication statement for the number of range provided
        for (int i = 1; i <= this.upto; i++) {
            System.out.println(multi + " x " + i + " = " + multi * i);
        }
        System.out.println("#Thank You  :)");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // taking the first number to get the multiplication of
            System.out.println("Please enter the number: ");
            int multi = scanner.nextInt();

            // the range of the multiplication table
            System.out.println("Please enter the range: ");
            int upto = scanner.nextInt();

            // Creating the multiplication table object of multiplication table class
            MultiplicationTable multiplicationTable = new MultiplicationTable(multi, upto);

            // getting the multiplication table
            multiplicationTable.getMultiplicationTable();
        }
    }

}
