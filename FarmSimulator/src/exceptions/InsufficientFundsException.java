package exceptions;

public class InsufficientFundsException extends IllegalStateException {
	
	public InsufficientFundsException() {}
	
	public InsufficientFundsException(String s) {
		super(s);
	}
}
