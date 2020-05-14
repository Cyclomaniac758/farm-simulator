package exceptions;

/**
 * 
 * @author Icarus
 *
 */
public class NoMoreActionsException extends IllegalStateException {
	public NoMoreActionsException() {}
	
	public NoMoreActionsException(String s) {
		super(s);
	}
	
}
