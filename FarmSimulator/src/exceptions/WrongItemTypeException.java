package exceptions;
/**
 * When the user tries to use a food item on a crop or use a crop tool item on an animal this class is used to handle it
 * @author Icarus
 *
 */
public class WrongItemTypeException extends IllegalStateException {
	public WrongItemTypeException() {}
	
	public WrongItemTypeException(String s) {
		super(s);
	}
}
