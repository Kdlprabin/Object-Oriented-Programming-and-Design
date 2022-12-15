public class Hello {
    String[] names = {"prabin","kandel"};

    void printLength(){
        System.out.println("\nStarting");
        try{
            System.out.println(names[2]);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.printLength();
    }
}
