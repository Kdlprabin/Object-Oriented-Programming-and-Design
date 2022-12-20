public class LandlordNotFoundException extends RuntimeException {
    public LandlordNotFoundException(){
        super("Currently, there are no landlords!");
    }
}
