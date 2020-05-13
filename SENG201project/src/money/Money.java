package money;
/**
 * Class money
 * @author Michael Peters
 *
 */
public class Money {
	/**
	 * The amount of money
	 */
	private float moneyAmount;
	/**
	 * Constructor of Money class
	 * @param amount
	 */
	public Money(float money) {
		moneyAmount = money;
	}
	/**
	 * Sets the moneyAmount value
	 * @param amount
	 */
	public void setMoneyAmount(int amount) {
		moneyAmount = amount;
	}
	/**
	 * Gets the moneyAmount value
	 * @return
	 */
	public float getMoneyAmount() {
		return moneyAmount;
	}
	/**
	 * Adds amount value to current moneyAmount
	 * @param amount
	 */
	public void addMoney(float amount) {
		moneyAmount += amount;
	}
	/**
	 * Minuses amount value to current moneyAmount
	 * @param amount
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
