package items;

/**
 * Seed incubator object used to increase plant growth speed
 * @author Icarus
 *
 */
public class Incubator extends CropTools {
	/**
	 * Initialize the object parameters
	 */
	public Incubator() {
		setImpact(2);
		setItemName("Incubator");
		setItemPrice(150);
		setItemUse("<html>Speed up the crop growth process by " + getImpact() + " days<br>(this item can be used multiple times).<html>");
	}
}
