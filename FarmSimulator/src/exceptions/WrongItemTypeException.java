package exceptions;

public class WrongItemTypeException extends IllegalStateException {
	public WrongItemTypeException() {}
	
	public WrongItemTypeException(String s) {
		super(s);
	}
}
