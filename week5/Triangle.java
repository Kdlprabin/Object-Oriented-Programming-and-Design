public class Triangle implements Shape2D {
    private int sideA;
    private int sideB;
    private int sideC;
    private int perimeter;
    private double area;

    public Triangle(int sideA, int sideB, int sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    @Override
    public void perimeter() {
        perimeter = (sideA + sideB + sideC);
        System.out.println("Perimeter : " + perimeter);
    }
    
    @Override
    public void area(){
        float s = (perimeter/2);
        area = Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
        System.out.println("Area : " + area);
    }
}
