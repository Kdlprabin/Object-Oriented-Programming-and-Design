package Exception;
public class TenantBillNotFoundException extends RuntimeException {
    public TenantBillNotFoundException(){
        super("Currently, there are no bills available.");
    }
}
