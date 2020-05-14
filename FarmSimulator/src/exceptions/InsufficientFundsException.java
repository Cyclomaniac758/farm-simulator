package exceptions;

/**
 * 
 * @author Icarus
 *
 */
public class InsufficientFundsException extends IllegalStateException {
	
	public InsufficientFundsException() {}
	
	public InsufficientFundsException(String s) {
		super(s);
	}
}
