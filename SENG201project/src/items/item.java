package items;

/**
 * Class item, abstract class for game items to extend
 * @author Icarus
 *
 */
public abstract class item {
	
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
	
	public void setItemUse(String use) {
		itemUse = use;
	}
	
	public String toString() {
		char firstChar = itemName.charAt(0);
		if ("aeiouAEIOU".indexOf(firstChar) != -1) {
			return String.format("This item is %s.\nIt is used to %s.", itemName, itemUse);
		} else {
			return String.format("This item is %s.\nIt is used to %s.", itemName, itemUse);
		}
		
	}
}