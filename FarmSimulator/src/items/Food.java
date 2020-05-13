package items;

public class Food extends item {
	
	/**
	 * Float representing the proportional increase in healthiness associated with using the item
	 */
	private float healthiness;
	
	/**
	 * Set the items healthiness level
	 * @param health
	 */
	public void setHealthiness(float health) {
		healthiness = health;
	}
	
	
	/**
	 * Return the associated items healthiness contribution
	 * @return
	 */
	public float getHealthiness() {
		return healthiness;
	}
}
