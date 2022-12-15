package Question1;
public class Samsung extends Mobile{

    //adding the variable
    private int modelNumber;
    public Samsung(String nameString, String brandString, int modelNumber){
        //calling constructor of parent class
        super(nameString, brandString);
        this.modelNumber = modelNumber;
    }
    
    //getter methods
    public int getModelNumber() {
        return modelNumber;
    }

    //setter methods
    public void setModelNumber(int modelNumber){
        this.modelNumber = modelNumber;
    }

    //overriding methods from the parent class mobile
    @Override
    public void vibrates(){
        System.out.println("//////The mobile vibrates with Samsung ringtone//////");
    }
}
