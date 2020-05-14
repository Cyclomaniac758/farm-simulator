package exceptions;

public class InsufficientCapacityException extends IllegalStateException {
	public InsufficientCapacityException() {}
	
	public InsufficientCapacityException(String s) {
		super(s);
	}
}
