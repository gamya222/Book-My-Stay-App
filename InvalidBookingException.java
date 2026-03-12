/**
 * ============================================================
 * CLASS - InvalidBookingException
 * ============================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * Description:
 * This custom exception represents
 * invalid booking scenarios in the system.
 *
 * Using a domain-specific exception
 * makes error handling clearer and safer.
 *
 * @version 9.0
 */

public class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}