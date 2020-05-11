package items;

public class Water extends cropTools{
	/**
	 * Sets parameter values for item Water
	 */
	public Water() {
		setImpact(1);
		setItemName("Water");
		setItemPrice(0);
		setItemUse("speed up the crop growth process");
	}
	
	public static void main(String[] args) {
		Water r = new Water();
		System.out.println(r);
	}

}
