package items;

public class Fertilizer extends CropTools {
	/**
	 * set the parameter values of the item Fertilizer
	 */
	public Fertilizer() {
		/**
		 * Set parameter values of item Fertilizer
		 */
		setImpact(3);
		setItemName("Fertilizer");
		setItemPrice(100);
		setItemUse("Speed up the crop growth process by " + getImpact() + " days.");
	}	
}
