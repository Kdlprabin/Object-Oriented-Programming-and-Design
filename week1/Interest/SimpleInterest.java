package Interest;

public class SimpleInterest {
    private int principle, time;
    private double rate, simpleInterest;

    public SimpleInterest(int principle, int time, double rate) {
        System.out.println("////// Welcome to the Simple Interest Calculator ///////");
        this.principle = principle;
        this.time = time;
        this.rate = rate;
    }

    public double getSimpleInterest() {
        simpleInterest = (this.principle * this.time * this.rate) / 100;
        return simpleInterest;
    }

    public double amountToGet(){
        return simpleInterest + this.principle;
    }

    public static void main(String[] args) {
        SimpleInterest interest = new SimpleInterest(100000, 5, 2.937034);
        System.out.println("The simple interest is : \n" + interest.getSimpleInterest());
        System.out.println("The Total amount to recieve is : \n" + interest.amountToGet());
    }
}
