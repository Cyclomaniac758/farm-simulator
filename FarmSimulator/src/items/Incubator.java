package items;

/**
 * Seed incubator object used to increase plant growth speed
 * @author Icarus
 *
 */
public class Incubator extends cropTools {
	/**
	 * Initialize the object parameters
	 */
	public Incubator() {
		setImpact(2);
		setItemName("seed incubator");
		setItemPrice(150);
		setItemUse("speed up the crop growth process");
	}
}
