package workshop3;

public class PrimeLogic {
    private int number;

    //constructor 
    public PrimeLogic(int number){
        this.number = number;
    }

    //getter method
    public int getNumber(){
        return number;
    }

    //setter methods
    public void setNumber(int number){
        this.number = number;
    }

    public boolean checkPrime(){
        int range = number/2;
        for(int i = 2; i < range; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
