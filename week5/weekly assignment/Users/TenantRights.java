package Users;

public interface TenantRights {
    void leaveRentedRoom();

    void requestEmergencyPayment();

    void reviewLandlordBehavior();

    void reviewRentalProperty();

    default void requestMaintenance() {
        System.out.println("I request a maintenance.");
    }

    static void requestExtension() {
        System.out.println("I request landlord to provide extension for bills.");
    }
}