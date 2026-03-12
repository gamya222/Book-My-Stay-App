/**
 * ============================================================
 * CLASS - BookingRequestQueue
 * ============================================================
 *
 * Use Case 5: Booking Request (FIFO)
 *
 * Description:
 * This class manages booking requests
 * using a queue to ensure fair allocation.
 *
 * Requests are processed strictly
 * in the order they are received.
 *
 * @version 5.0
 */

import java.util.LinkedList;
import java.util.Queue;

public class BookingRequestQueue {
    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }
    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}