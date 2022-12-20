package Users;
public interface TenantRights {
    void leaveRentedRoom();

    void requestEmergencyPayment();

    void reviewLandlordBehavior();

    void reviewRentalProperty();

    default void requestMaintenance() {
    }

    static void requestExtension() {
    }
}