/**
 * ============================================================
 * CLASS - BookingReportService
 * ============================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * Description:
 * This class generates reports
 * from booking history data.
 *
 * Reporting logic is separated
 * from data storage.
 *
 * @version 8.0
 */
public class BookingReportService {
    public void generateReport(BookingHistory history) {

        System.out.println("Booking History Report\n");

        for (Reservation r : history.getConfirmedReservations()) {

            System.out.println(
                    "Guest: " + r.getGuestName()
                            + ", Room Type: "
                            + r.getRoomType()
            );
        }
    }
}