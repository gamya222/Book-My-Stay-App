/**
 * ============================================================
 * MAIN CLASS - UseCase5BookingRequestQueue
 * ============================================================
 *
 * Use Case 5: Booking Request (First-Come-First-Served)
 *
 * Description:
 * This class demonstrates how booking
 * requests are accepted and queued
 * in a fair and predictable order.
 *
 * No room allocation or inventory
 * update is performed here.
 *
 * @version 5.0
 */

public class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Booking Request Queue");

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);
        while (bookingQueue.hasPendingRequests()) {

            Reservation next = bookingQueue.getNextRequest();

            System.out.println(
                    "Processing booking for Guest: "
                            + next.getGuestName()
                            + ", Room Type: "
                            + next.getRoomType()
            );
        }
    }
}