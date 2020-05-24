package items;
/**
 *  Class Fertilizer, sets the parameter values for the crop tool item
 * @author Icarus
 *
 */
public class Fertilizer extends CropTools {
	/**
	 * set the parameter values of the item Fertilizer
	 */
	public Fertilizer() {
		setImpact(3);
		setItemName("Fertilizer");
		setItemPrice(100);
		setItemUse("Speed up the crop growth process by " + getImpact() + " days.");
	}	
}
