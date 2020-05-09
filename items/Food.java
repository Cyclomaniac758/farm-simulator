package items;

public class Food extends item {
	
	/**
	 * Variable representing the increase in healthiness associated with using the item
	 */
	private int healthiness;
	
	/**
	 * Set the items healthiness level
	 * @param health
	 */
	public void setHealthiness(int health) {
		healthiness = health;
	}
	
	
	/**
	 * Return the associated items healthiness contribution
	 * @return
	 */
	public int getHealthiness() {
		return healthiness;
	}
}
