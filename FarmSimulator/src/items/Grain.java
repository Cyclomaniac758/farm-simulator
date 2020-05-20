package items;

/**
 * Class Grain, sets the parameter values for the item
 * @author Icarus
 *
 */
public class Grain extends Food{
	/**
	 * Set the item values
	 */
	public Grain() {
		setHealthiness(1.40000);
		setItemName("Grain");
		setItemPrice(20);
		setItemUse("Increase an animals healthiness by " + getHealthiness() + " times.");
	}
}
