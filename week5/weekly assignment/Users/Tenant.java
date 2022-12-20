package Users;

public abstract class Tenant extends SystemUser implements TenantRights {
    private String name;
    private int age;
    private int mobileNumber;
    private int identityProof;
    private String address;
    private String dateOfBirth;
    public abstract void viewLandlord();
    public abstract void selectLandlord();
}
