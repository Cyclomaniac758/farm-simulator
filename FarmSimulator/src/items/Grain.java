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
		setHealthiness(1.4);
		setItemName("Grain");
		setItemPrice(20);
		setItemUse("increase an animals healthiness");
	}
}
