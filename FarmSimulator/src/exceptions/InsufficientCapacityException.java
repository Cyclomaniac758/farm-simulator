package exceptions;

/**
 * When user does not have enough capacity this class is used to handle it
 * @author Icarus
 *
 */
public class InsufficientCapacityException extends IllegalStateException {
	public InsufficientCapacityException() {}
	
	public InsufficientCapacityException(String s) {
		super(s);
	}
}
