/**
 * ============================================================
 * MAIN CLASS - UseCase10BookingCancellation
 * ============================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * This class demonstrates how confirmed
 * bookings can be cancelled safely.
 *
 * Inventory is restored and rollback
 * history is maintained.
 *
 * @version 10.0
 */

public class BookMyStayApp {
    public static void main(String[] args) {

        System.out.println("Booking Cancellation\n");

        RoomInventory inventory = new RoomInventory();

        CancellationService cancellationService = new CancellationService();
        cancellationService.registerBooking("Single-1", "Single");

        cancellationService.cancelBooking("Single-1", inventory);
        cancellationService.showRollbackHistory();

        System.out.println(
                "\nUpdated Single Room Availability: "
                        + inventory.getRoomAvailability().get("Single")
        );
    }
}