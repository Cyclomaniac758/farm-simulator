package animals;

/**
 * Animal class
 * @author Michael
 *
 */
public class Animals {
	/**
	 * The name of the animal
	 */
	private String animalName;
	/**
	 * The buy price of the animal
	 */
	private int buyPrice;
	/**
	 * The daily earnings of the animal
	 */
	private int dailyEarnings;
	/**
	 * The happiness level of the animal
	 */
	private double happinessLevel;
	/**
	 * The  healthiness level of the animal
	 */
	private double healthinessLevel;
  
	/**
	 * Sets the animal's name
	 * @param name
	 */
  	public void setAnimalName(String name) {
  		animalName = name;
  	}
  	/**
  	 * Sets the buy price of the animal
  	 * @param buyingPrice
  	 */
  	public void setBuyPrice(int buyingPrice) {
  		buyPrice = buyingPrice;
  	}
  	/**
  	 * Sets the daily earnings of the animal
  	 * @param earnings
  	 */
  	public void setDailyEarnings(int earnings) {
  		dailyEarnings = earnings;
  	}
  	/**
  	 * Sets the happiness level of the animal
  	 * @param happiness
  	 */
  	public void setHappinessLevel(double happiness) {
  		happinessLevel = happiness;
  		if (happinessLevel > 1) {
  			happinessLevel = 1;
  		}
  	}
  	/**
  	 * Sets the healthiness level of the animal
  	 * @param healthiness
  	 */
  	public void setHealthiness(double healthiness) {
  		healthinessLevel = healthiness;
  	}
  	/**
  	 * Gets the animal name
  	 * @return
  	 */
  	public String getAnimalName() {
  		return animalName;
  	}
  	/**
  	 * Gets the buy price of the animal
  	 * @return
  	 */
  	public int getBuyPrice() {
  		return buyPrice;
  	}
  	/**
  	 * Gets the daily earnings of the animal
  	 * @return
  	 */
  	public int getDailyEarnings() {
  		return dailyEarnings;
  	}
  	/**
  	 * Gets the happiness level of the animal
  	 * @return
  	 */
  	public double getHappinessLevel() {
  		return happinessLevel;
  	}
  	/**
  	 * Gets the healthiness level of the animal
  	 * @return
  	 */
  	public double getHealthiness() {
  		return healthinessLevel;
  	}
  	
  	public String toString() {
  		return String.format("%12s%15s%15s", getAnimalName(), getBuyPrice(), getDailyEarnings());
  	}

}