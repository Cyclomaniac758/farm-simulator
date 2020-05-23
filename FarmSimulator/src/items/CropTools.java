package items;

/**
 * Crop Tools parent class, extends from the item class
 * @author Icarus
 *
 */
public class CropTools extends Item{
	
	/**
	 * Represents the decrease in number of days required to grow a crop after using the item
	 */
	private int impact;
	
	/**
	 * Sets the impact of the item
	 * @param num
	 */
	public void setImpact(int num) {
		impact = num;
	}
	
	/**
	 * Returns the items impact level on the crops growth time
	 * @return the items impact level
	 */
	public int getImpact() {
		return impact;
	}		
}
