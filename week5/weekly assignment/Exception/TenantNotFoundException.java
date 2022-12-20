package Exception;
public class TenantNotFoundException extends RuntimeException {
    public TenantNotFoundException(){
        super("Currently, there are not tenants!");
    }
}
