package exceptions;

/**
 * When the user tries to complete an action and they have used all daily actions this class is used to handle it
 * @author Icarus
 *
 */
public class NoMoreActionsException extends IllegalStateException {
	public NoMoreActionsException() {}
	
	public NoMoreActionsException(String s) {
		super(s);
	}
	
}
