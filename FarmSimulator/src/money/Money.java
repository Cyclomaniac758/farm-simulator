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
	 * @param amount
	 */
	public Money(double money) {
		moneyAmount = money;
		startingMoney = money;
	}
	/**
	 * Sets the moneyAmount value
	 * @param amount
	 */
	public void setMoneyAmount(int amount) {
		moneyAmount = amount;
	}
	
	public double getStartingMoney() {
		return startingMoney;
	}
	/**
	 * Gets the moneyAmount value
	 * @return
	 */
	public double getMoneyAmount() {
		return moneyAmount;
	}
	/**
	 * Adds amount value to current moneyAmount
	 * @param amount
	 */
	public void addMoney(double amount) {
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