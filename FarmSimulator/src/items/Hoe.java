package items;
/**
 * Class Hoe, sets the parameter values for the crop tool item
 * @author Icarus
 *
 */
public class Hoe extends CropTools {
	/**
	 * Set the parameters of the item Hoe
	 */
	public Hoe() {
		setImpact(2);
		setItemName("Hoe");
		setItemPrice(50);
		setItemUse("Speed up the crop growth process by " + getImpact() + " days.");
	}
}
