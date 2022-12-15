package workshop3;

public class Prime extends PrimeLogic {
    //constructor 
    public Prime(int number) {
        super(number);
    }

    public void printPrimeOrNot(){
        int number = super.getNumber();
        if(super.checkPrime()){
            System.out.println("The Given number " + number + " is Prime." );
        }else{
            System.out.println("The Given number " + number + " is Not Prime.");
        }
    }
}
