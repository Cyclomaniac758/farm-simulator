package items;

/**
 * Food item Growth Hormone
 * @author Icarus
 *
 */
public class GrowthHormone extends Food {
	/**
	 * Set the attribute values for growth hormone
	 */
	public GrowthHormone() {
		setHealthiness((double) 1.6);
		setItemName("Growth Hormone");
		setItemPrice(30);
		setItemUse("Increase an animals healthiness by " + getHealthiness() + " times.");
	}
}
