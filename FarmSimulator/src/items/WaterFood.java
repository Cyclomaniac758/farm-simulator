package items;

/**
 * Object WaterFood extending food. Can be used to feed animals
 * @author Icarus
 *
 */
public class WaterFood extends Food {
	/**
	 * Set the parameters of the object WaterFood
	 */
	public WaterFood() {
		setHealthiness((float) 1.10);
		setItemName("WaterFood");
		setItemPrice(0);
		setItemUse("increase an animals healthiness");
	}
}
