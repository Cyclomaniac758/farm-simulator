package items;
/**
 * Food parent class, extends from the Item class
 * @author Icarus
 *
 */
public class Food extends Item {
	
	/**
	 * Float representing the proportional increase in healthiness associated with using the item
	 */
	private double healthiness;
	
	/**
	 * Set the items healthiness level
	 * @param health
	 */
	public void setHealthiness(double health) {
		healthiness = health;
	}
	
	
	/**
	 * Return the associated items healthiness contribution
	 * @return
	 */
	public double getHealthiness() {
		return healthiness;
	}
}
