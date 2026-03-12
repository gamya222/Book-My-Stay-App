/**
 * ============================================================
 * MAIN CLASS - UseCase7AddOnServiceSelection
 * ============================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * Description:
 * This class demonstrates how optional
 * services can be attached to a confirmed
 * booking.
 *
 * Services are added after room allocation
 * and do not affect inventory.
 *
 * @version 7.0
 */

public class BookMyStayApp {
    public static void main(String[] args) {

        System.out.println("Add-On Service Selection\n");
        String reservationId = "Single-1";

        AddOnServiceManager manager = new AddOnServiceManager();
        Service breakfast = new Service("Breakfast", 500);
        Service spa = new Service("Spa", 1000);
        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, spa);
        double totalCost = manager.calculateTotalServiceCost(reservationId);

        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}