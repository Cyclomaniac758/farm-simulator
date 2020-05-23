package exceptions;

/**
 * When user does not have enough funds this class is used to handle it
 * @author Icarus
 *
 */
public class InsufficientFundsException extends IllegalStateException {
	
	public InsufficientFundsException() {}
	
	public InsufficientFundsException(String s) {
		super(s);
	}
}
