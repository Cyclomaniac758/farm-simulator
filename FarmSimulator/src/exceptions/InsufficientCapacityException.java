package exceptions;

/**
 * 
 * @author Icarus
 *
 */
public class InsufficientCapacityException extends IllegalStateException {
	public InsufficientCapacityException() {}
	
	public InsufficientCapacityException(String s) {
		super(s);
	}
}
