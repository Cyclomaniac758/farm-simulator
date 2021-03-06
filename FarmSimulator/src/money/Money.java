package money;
/**
 * Class money
 * @author Michael
 *
 */
public class Money {
	/**
	 * The amount of money
	 */
	private double moneyAmount;
	/**
	 * The farms starting amount of money
	 */
	private double startingMoney;
	/**
	 * Constructor of Money class
	 * @param money The money value to start with
	 */
	public Money(double money) {
		moneyAmount = money;
		startingMoney = money;
	}
	/**
	 * Sets the moneyAmount value
	 * @param amount The amount of money in the farm
	 */
	public void setMoneyAmount(int amount) {
		moneyAmount = amount;
	}
	/**
	 * Get the amount of money the farm started with
	 * @return The starting amount of money
	 */
	public double getStartingMoney() {
		return startingMoney;
	}
	/**
	 * Gets the moneyAmount value
	 * @return The current amount of money
	 */
	public double getMoneyAmount() {
		return moneyAmount;
	}
	/**
	 * Adds amount value to current moneyAmount
	 * @param amount The amount to be added
	 */
	public void addMoney(double amount) {
		moneyAmount += amount;
	}
	/**
	 * Minuses amount value to current moneyAmount
	 * @param amount The amount to be subtracted
	 */
	public void minusMoney(int amount) {
		moneyAmount -= amount;
	}
	/**
	 * Returns String value of money in format '$moneyAmount'
	 */
	public String toString() {
		return String.format("$%s", moneyAmount);
	}
	

}