/**
 * ============================================================
 * CLASS - ConcurrentBookingProcessor
 * ============================================================
 *
 * Use Case 11: Concurrent Booking Simulation
 *
 * Description:
 * This class represents a booking processor
 * that can be executed by multiple threads.
 *
 * It demonstrates how shared resources
 * such as booking queues and inventory
 * must be accessed in a thread-safe manner.
 *
 * @version 11.0
 */

public class ConcurrentBookingProcessor implements Runnable {
    private BookingRequestQueue bookingQueue;

    private RoomInventory inventory;

    private RoomAllocationService allocationService;
    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue,
            RoomInventory inventory,
            RoomAllocationService allocationService
    ) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }
    @Override
    public void run() {

        while (true) {

            Reservation reservation;
            synchronized (bookingQueue) {

                if (!bookingQueue.hasPendingRequests()) {
                    break;
                }

                reservation = bookingQueue.getNextRequest();
            }
            synchronized (inventory) {

                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}