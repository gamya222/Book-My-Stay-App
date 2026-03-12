/**
 * ============================================================
 * CLASS - CancellationService
 * ============================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * This class is responsible for handling
 * booking cancellations.
 *
 * It ensures that:
 * - Cancelled room IDs are tracked
 * - Inventory is restored correctly
 * - Invalid cancellations are prevented
 *
 * A stack is used to model rollback behavior.
 *
 * @version 10.0
 */

import java.util.*;

public class CancellationService {
    private Stack<String> releasedRoomIds;
    private Map<String, String> reservationRoomTypeMap;
    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }
    public void registerBooking(String reservationId, String roomType) {

        reservationRoomTypeMap.put(reservationId, roomType);
    }
    public void cancelBooking(String reservationId, RoomInventory inventory) {

        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Invalid cancellation request.");
            return;
        }

        String roomType = reservationRoomTypeMap.get(reservationId);

        Map<String, Integer> availability = inventory.getRoomAvailability();

        inventory.updateAvailability(roomType, availability.get(roomType) + 1);

        releasedRoomIds.push(reservationId);

        reservationRoomTypeMap.remove(reservationId);

        System.out.println(
                "Booking cancelled successfully. Inventory restored for room type: "
                        + roomType
        );
    }
    public void showRollbackHistory() {

        System.out.println("\nRollback History (Most Recent First):");

        while (!releasedRoomIds.isEmpty()) {

            System.out.println("Released Reservation ID: " + releasedRoomIds.pop());
        }
    }
}