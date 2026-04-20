package exception;

/**
 * Name: Alex Akere, Cam Carter
 * Date: April 20, 2026
 * Description: A custom exception class used to handle business logic violations.
 * By extending the standard Exception class, it allows the system to differentiate 
 * between general errors and specific gym-related validation failures, such as age restrictions.
 * This implementation enhances the robustness of the application by ensuring only 
 * valid data models are processed or stored in the database.
 */

public class InvalidMemberException extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Default constructor
    public InvalidMemberException() {
        super("Invalid member data provided.");
    }

    // Constructor with custom message
    public InvalidMemberException(String message) {
        super(message);
    }
}