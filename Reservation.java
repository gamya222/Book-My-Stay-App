/**
 * ============================================================
 * CLASS - Reservation
 * ============================================================
 *
 * Use Case 5: Booking Request (FIFO)
 *
 * Description:
 * This class represents a booking request
 * made by a guest.
 *
 * At this stage, a reservation only captures
 * intent, not confirmation or room allocation.
 *
 * @version 5.0
 */

public class Reservation {
    private String guestName;
    private String roomType;
    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
    public String getGuestName() {
        return guestName;
    }
    public String getRoomType() {
        return roomType;
    }
}