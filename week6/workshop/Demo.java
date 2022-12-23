public class Demo{
    void demo(int num){
        while ( num >= 1){ // n/2 +1
            System.out.println(num); // 1 operation
            System.out.println("=========");// 1 operation
            num = num/ 2; // 2 operation
        }
    }
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.demo(2);
    }
}