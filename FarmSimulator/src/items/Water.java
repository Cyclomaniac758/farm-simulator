package items;

/**
 * Class Water, sets the parameter values for the crop tool item
 * @author Icarus
 *
 */
public class Water extends CropTools{
	/**
	 * Sets parameter values for item Water
	 */
	public Water() {
		setImpact(1);
		setItemName("Water");
		setItemPrice(0);
		setItemUse("Speed up the crop growth process by " + getImpact() + " day.");
	}

}
