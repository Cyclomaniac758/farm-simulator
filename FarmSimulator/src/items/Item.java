package items;

/**
 * Class item, abstract class for game items to extend
 * @author Icarus
 *
 */
public abstract class Item {
	
	/**
	 * Name of item
	 */
	private String itemName;
	
	/**
	 * Price of the item
	 */
	private int price;
	
	/**
	 * What the item is used for
	 */
	private String itemUse;
	
	/**
	 * Set the name of the item
	 * @param name
	 */
	public void setItemName(String name) {
		itemName = name;
	}
	
	/**
	 * Set the price of the item
	 * @param num
	 */
	public void setItemPrice(int num) {
		price = num;
	}
	
	/**
	 * Returns the name of the item
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * Returns the price of the item
	 * @return price
	 */
	public int getItemPrice() {
		return price;
	}
	/**
	 * Sets the string when for when an item is used
	 * @param use
	 */
	public void setItemUse(String use) {
		itemUse = use;
	}
	/**
	 * Gets the string for when the item is used
	 * @return
	 */
	public String getItemUse() {
		return itemUse;
	}
	/**
	 * The string representation of the item
	 */
	public String toString() {
		return String.format("%s", itemName);
	}
}
