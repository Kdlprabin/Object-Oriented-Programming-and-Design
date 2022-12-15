public class Samsung extends Mobile{
    private int modelNumber;
    final String ringToneString;
    public Samsung(String nameString, String brandString, int modelNumber, String ringToneString){
        super(nameString, brandString);
        this.modelNumber = modelNumber;
        this.ringToneString = ringToneString;
    }
    
    //getter methods
    public int getModelNumber() {
        return modelNumber;
    }

    //setter methods
    public void setModelNumber(int modelNumber){
        this.modelNumber = modelNumber;
    }

    @override
    public void vibrates(){
        System.out.println("//////The mobile vibrates with Samsung ringtone//////");
    }
}
