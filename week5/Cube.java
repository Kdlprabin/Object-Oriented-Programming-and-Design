public class Cube implements Shape2D, Shape3D {
    private int l;

    public Cube(int l){
        this.l = l;
    }

    @Override
    public void volume() {
        System.out.println("The volume is "+(l*l*l));
    }

    @Override
    public void perimeter() {
        System.out.println("The perimeter of cube is " + 12*l);
    }

    @Override
    public void area() {
        System.out.println("The area is "+(6*l*l));
    }
    
}
