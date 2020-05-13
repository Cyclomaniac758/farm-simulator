package items;

public class cropTools extends item{
	
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
	 * Returns the items impact level
	 * @return
	 */
	public int getImpact() {
		return impact;
	}		
}