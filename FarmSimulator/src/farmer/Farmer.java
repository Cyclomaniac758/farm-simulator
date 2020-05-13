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
	 * The age of the farmer
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
	 * @param userName
	 * @param userAge
	 * @param userFarm
	 */
	public Farmer(String userName, int userAge, Farm userFarm) {
		numActions = 2;
		name = userName;
		age = userAge;
		farm = userFarm;
	}
	
	/**
	 * Sets the name of the farmer
	 * @param name
	 */
	public void setName(String userName) {
		name = userName;
	}
	
	/**
	 * Sets the age of the farmer
	 * @param userAge
	 */
	public void setAge(int userAge) {
		age = userAge;
	}
	
	/**
	 * Returns farmer name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns farmer age
	 * @return age
	 */
	public int getAge() {
		return age;
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
	
	
	public void useCropTool(cropTools item, Crops crop) {
		try {
			this.deductAction();
		} catch (NoMoreActionsException e) {
			System.out.println(e.getMessage());
		}
		int currentTime = crop.getGrowTime();
		int newTime = currentTime - item.getImpact();
		crop.setGrowTime(newTime);
		if (crop.getGrowTime() < 0) {
			crop.setGrowTime(0);
		}
	}
	
	
	public void useFood(Food item, Animals animal) {
		try {
			this.deductAction();
		} catch (NoMoreActionsException e) {
			System.out.println(e.getMessage());
		}
		float currentHealthiness = animal.getHealthiness();
		float newHealthiness = currentHealthiness * item.getHealthiness();
		animal.setHealthiness(newHealthiness);
		if (animal.getHealthiness() > 100) {
			animal.setHealthiness(100);
		}
	}
	
	public void playWithAnimals() {
		try {
			this.deductAction();
		} catch (NoMoreActionsException e) {
			System.out.println(e.getMessage());
		}
		for (Animals animal: farm.getAnimalList()) {
			float currentHappiness = animal.getHappinessLevel();
			float newHappiness = (float) (currentHappiness * 1.4);
			animal.setHappinessLevel(newHappiness);
		}
	}
	
	public void harvestCrop(Crops crop) {
		try {
			this.deductAction();
		} catch (NoMoreActionsException e) {
			System.out.println(e.getMessage());
		}
		farm.minusCrop(crop);
	}
	
	public void tendLand() {
		try {
			this.deductAction();
		} catch (NoMoreActionsException e) {
			System.out.println(e.getMessage());
		}
		int currentCapacity = farm.getMaxCropCapacity();
		farm.setMaxCropCapacity(currentCapacity + 1);
		float currentHappiness = farm.getAnimalHappinessModifier();
		farm.setAnimalHappinessModifier((float) (currentHappiness*1.2));
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}