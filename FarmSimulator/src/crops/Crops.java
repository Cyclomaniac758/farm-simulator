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
	 * The number of days it takes for the crop to grow
	 */
	private int growTime;
	/**
	 * Sets the name of the crop
	 * @param name
	 */
	public void setCropName(String name) {
		cropName = name;
	}
	/**
	 * Sets the buy price of  the crop
	 * @param buyingPrice
	 */
	public void setBuyPrice(int buyingPrice) {
		buyPrice = buyingPrice;
	}
	/**
	 * Sets the sell price of the crop
	 * @param sellingPrice
	 */
	public void setSellPrice(int sellingPrice) {
		sellPrice = sellingPrice;
	}
	/**
	 * Sets the grow time of the crop
	 * @param growingTime
	 */
	public void setGrowTime(int growingTime) {
		growTime = growingTime;
	}
	/**
	 * Gets the crop name
	 * @return
	 */
	public String getCropName() {
		return cropName;
	}
	/**
	 * Gets the buy price of the  crop
	 * @return
	 */
	public int getBuyPrice() {
		return buyPrice;
	}
	/**
	 * Gets the sell price of the crop
	 * @return
	 */
	public int getSellPrice() {
		return sellPrice;
	}
	/**
	 * Gets the grow time of the crop
	 * @return
	 */
	public int getGrowTime() {
		return growTime;
	}
}