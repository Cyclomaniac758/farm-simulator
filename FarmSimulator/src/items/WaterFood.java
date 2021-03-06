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
		setHealthiness(1.10000);
		
		setItemName("WaterFood");
		setItemPrice(0);
		setItemUse("Increase an animals healthiness by " + getHealthiness() + " times." );
	}
}
