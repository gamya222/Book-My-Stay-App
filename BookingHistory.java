/**
 * ============================================================
 * CLASS - BookingHistory
 * ============================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * Description:
 * This class maintains a record of
 * confirmed reservations.
 *
 * It provides ordered storage for
 * historical and reporting purposes.
 *
 * @version 8.0
 */

import java.util.*;

public class BookingHistory {
    private List<Reservation> confirmedReservations;
    public BookingHistory() {
        confirmedReservations = new ArrayList<>();
    }
    public void addReservation(Reservation reservation) {
        confirmedReservations.add(reservation);
    }
    public List<Reservation> getConfirmedReservations() {
        return confirmedReservations;
    }
}