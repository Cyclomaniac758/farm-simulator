package farmer;


import items.*;
import farm.Farm;
import exceptions.*;
import crops.*;
import animals.*;

/**
 * A farmer character
 * @author Icarus
 */
public class Farmer {
	/**
	 * The farmer's name
	 */
	private String name;
	/**
	 * The farmer's age
	 */
	private int age;
	/**
	 * The number of actions remaining for the day
	 */
	private int numActions;
	
	/**
	 * The farm that the farmer tends to
	 */
	private Farm farm;
	
	/**
	 * Constructor method for the farmer class
	 * @param userName Name of the user
	 * @param userAge Age of the user
	 * @param userFarm Farm
	 */
	public Farmer(String userName, int userAge, Farm userFarm) {
		numActions = 2;
		name = userName;
		age = userAge;
		farm = userFarm;
	}
	/**
	 * Sets the name of the farmer
	 * @param userName Name of the user
	 */
	public void setName(String userName) {
		name = userName;
	}
	/**
	 * Returns farmer name
	 * @return Name of the user
	 */
	public String getName() {
		return name;
	}
	/**
	 * returns the number of actions remaining for the day
	 * @return numActions
	 */
	public int getNumActions() {
		return numActions;
	}
	/**
	 * Reduce the number of actions remaining by one
	 */
	public void deductAction() {
		if (numActions <= 0) {
			throw new NoMoreActionsException("Your farmer is all worked out, proceed to the next day to restore actions");
		} else {
		numActions += -1;
		}
	}
	/**
	 * Starting a new day, restore the number of actions remaining
	 */
	public void restoreActions() {
		numActions = 2;
	}
	/**
	 * Use a crop tool item to reduce the grow time remaining of a crop to a minimum of 0, removes the item used
	 * @param item Item to be used
	 * @param crop Crop to be tended to
	 */
	public void useCropTool(CropTools item, Crops crop) {
		deductAction();
		int currentTime = crop.getGrowTime();
		int newTime = currentTime - item.getImpact();
		crop.setGrowTime(newTime);
		if (crop.getGrowTime() < 0) {
			crop.setGrowTime(0);
		}
		farm.removeItem(item);
	}
	/**
	 * Use a food item to increase the animal healthiness, removes the item used 
	 * @param item Item to be used
	 * @param animal Animal to be fed
	 */
	public void useFood(Food item, Animals animal) {
		deductAction();
		double currentHealthiness = animal.getHealthiness();
		double newHealthiness = currentHealthiness * item.getHealthiness();
		animal.setHealthiness(newHealthiness);
		if (animal.getHealthiness() > 1) {
			animal.setHealthiness(1);
		}
		farm.removeItem(item);
	}
	/**
	 * Play with the animals to increase every animals happiness level, deducts an action
	 */
	public void playWithAnimals() {
		if (farm.getAnimalList().size() > 0) {
			deductAction();
			for (Animals animal: farm.getAnimalList()) {
				double currentHappiness = animal.getHappinessLevel();
				double newHappiness = currentHappiness * 1.1;
				animal.setHappinessLevel(newHappiness);
			}
		}
	}
	/**
	 * Harvests a crop, deducts an action and remove the crop from the farms cropList
	 * @param crop Crop to be harvested
	 */
	public void harvestCrop(Crops crop) {
		deductAction();
		farm.minusCrop(crop);
	}
	/**
	 * Tends the land to increase the max crop capacity by 1 and decrease the amount that animal happiness changes daily
	 */
	public void tendLand() {
		deductAction();
		int currentCapacity = farm.getMaxCropCapacity();
		farm.setMaxCropCapacity(currentCapacity + 1);
		double rate = farm.getDeductHappinessRate();
		rate = rate + .1;
		if (rate > 1) {
			rate = 1;
		}
		farm.setDeductHappinessRate(rate);
	}
}