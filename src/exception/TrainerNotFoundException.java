package exception;

/**
 * Name: Alex Akere, Cam Carter
 * Date: April 20, 2026
 * Description: A specific alarm system for when the database can't find a trainer ID.
 * Instead of letting the program crash with a generic error, this custom exception 
 * provides a clear message to the user that the trainer they requested doesn't exist.
 * It makes the application more user-friendly by handling "missing data" scenarios gracefully.
 */
public class TrainerNotFoundException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TrainerNotFoundException(int id) {
        super("Trainer with ID " + id + " was not found in the system.");
    }

    public TrainerNotFoundException(String message) {
        super(message);
    }
}