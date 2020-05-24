package crops;

/**
 * Crops class
 * @author Michael
 *
 */
public class Crops {
	/**
	 * The name of the crop
	 */
	private String cropName;
	/**
	 * The buy price of the crop
	 */
	private int buyPrice;
	/**
	 * The sell price of the farm
	 */
	private int sellPrice;
	/**
	 * The number of days remaining until the crop can be harvested
	 */
	private int growTime;
	/**
	 * Total grow time for a crop
	 */
	private int totalGrowTime;
	/**
	 * Sets the name of the crop
	 * @param name The crops name
	 */
	public void setCropName(String name) {
		cropName = name;
	}
	/**
	 * Sets the buy price of  the crop
	 * @param buyingPrice The crops buy price
	 */
	public void setBuyPrice(int buyingPrice) {
		buyPrice = buyingPrice;
	}
	/**
	 * Sets the sell price of the crop
	 * @param sellingPrice The crops sell price
	 */
	public void setSellPrice(int sellingPrice) {
		sellPrice = sellingPrice;
	}
	/**
	 * Sets the grow time of the crop
	 * @param growingTime The crops growing time
	 */
	public void setGrowTime(int growingTime) {
		growTime = growingTime;
	}
	/**
	 * Set the total growing time of the crop
	 * @param growTime The crops growing time
	 */
	public void setTotalGrowTime(int growTime) {
		totalGrowTime = growTime;
		setGrowTime(growTime);
	}
	/**
	 * Gets the crop name
	 * @return The name of the crop
	 */
	public String getCropName() {
		return cropName;
	}
	/**
	 * Gets the buy price of the  crop
	 * @return The crops buy price
	 */
	public int getBuyPrice() {
		return buyPrice;
	}
	/**
	 * Gets the sell price of the crop
	 * @return The crops sell price
	 */
	public int getSellPrice() {
		return sellPrice;
	}
	/**
	 * Gets the grow time of the crop
	 * @return The crops grow time
	 */
	public int getGrowTime() {
		return growTime;
	}
	/**
	 * Get the total grow time for the crop
	 * @return totalGrowTime
	 */
	public int getTotalGrowTime() {
		return totalGrowTime;
	}
	/**
	 * String representation of the crop
	 */
	public String toString() {
		return String.format("%s", getCropName());
	}
}