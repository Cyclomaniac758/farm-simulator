package farm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import crops.*;
import animals.*;
import money.*;
import farmer.*;
import items.*;

/**
 * Farms are where the farmer does their tasks
 * @author Michael Peters
 *
 */
public class Farm {

	/**
	 * The name of the farm
	 */
	private String farmName;
	/**
     * The amount of money the farm starts with
     */
	private Money farmMoney;
    /**
	 * The type of farm
     */
    private String farmType;
	/**
	 *The number of days it takes for a crop to grow on the farm
	 **/
	private int cropGrowingSpeedModifier;
	/**
	 * The happiness of animals on the farm
	 */
	private double animalHappinessModifier;
	/**
	 * The healthiness of animals on the farm
	 */
	private double animalHealthinessModifier;
	/**
	 * The farmer this will replaced with the actual farmer class
	 */
	private Farmer farmer;
	/**
	 * ArrayList where the current crops on the farm are stored
	 */
	private ArrayList<Crops> cropList;
	/**
	 * ArrayList where the current animals on the farm are stored
	 */
	private ArrayList<Animals> animalList;
	/**
	 * ArrayList storing the owned items
	 */
	private ArrayList<Item> itemList;
	/**
	 * ArrayList storing the owned food items
	 */
	private ArrayList<Food> foodList;
	/**
	 * ArrayList storing the owned crop tool items
	 */
	private ArrayList<CropTools> cropToolList;
	/**
	 * The max crop capacity of the farm
	 */
	private int maxCropCapacity;
	/**
	 * The max animal capacity of the farm
	 */
	private int maxAnimalCapacity;
	

    /**
	 * Gets farm Name
     * @return String farm name
     */
    public String getFarmName() {
    	return farmName;
    }
    /**
     * Gets type of farm
     * @return The farms type
     */
    public String getFarmType() {
    	return farmType;
    }
    /**
     * Gets the current amount of money the farm has
     * @return The amount of money on the farm
     */
    public Money getFarmMoney() {
    	return farmMoney;
    }	
    /**
     * Gets the growing speed of the crops
     * @return the number of days it takes for a crop to grow
     */
    public int getGrowingSpeedModifier() {
    	return cropGrowingSpeedModifier;
    }
    /**
     * Gets the animal happiness modifier level
     * @return The happiness level of the animal
     */
    public double getAnimalHappinessModifier() {
    	return animalHappinessModifier;
    }
    /**
     * Gets the animal healthiness modifier level
     * @return the healthiness modifier for the animal
     */
    public double getAnimalHealthinessModifier() {
    	return animalHealthinessModifier;
    }
    /**
     * Gets the farmer
     * @return farmer
     */
    public Farmer getFarmer() {
    	return farmer;
    }
    /**
     * Gets the Crop list
     * @return
     */
    public ArrayList<Crops> getCropList() {
    	return cropList;
    }
    /**
     * Gets the Animal list
     * @return
     */
    public ArrayList<Animals> getAnimalList() {
    	return  animalList;
    }
    /**
     * Gets the item list
     * @return ArrayList<item>
     */
    public ArrayList<Item> getItemList(){
    	return itemList;
    }
    /**
     * Returns the items in itemList of type cropTools
     * @return ArrayList<cropTools>
     */
    public ArrayList<CropTools> getCropToolList(){
    	cropToolList = new ArrayList<CropTools>();
    	for (Item item: itemList) {
    		if (item instanceof CropTools) {
    			cropToolList.add((CropTools) item);
    		}
    	}
    	return cropToolList;
    }
    
    public ArrayList<Food> getFoodList(){
    	foodList = new ArrayList<Food>();
    	for (Item item: itemList) {
    		if (item instanceof Food) {
    			foodList.add((Food) item);
    		}
    	}
    	return foodList;
    }
    /**
     * Gets the max crop capacity of the farm
     * @return maxCropCapacity
     */
    public int getMaxCropCapacity() {
    	return maxCropCapacity;
    }
    /**
     * Gets the max animal capacity of the farm
     * @return
     */
    public int getMaxAnimalCapacity() {
    	return maxAnimalCapacity;
    }
    /**
     * Sets the farm name at the start of the game
     * @param name
     */
	public void setFarmName(String name) {
		farmName = name;
	}
	/**
	 * Sets the farm type at the start of the game
	 * @param type
	 */
	public void setFarmType(String type) {
		farmType = type;
	}
	/**
	 * Sets the farms money at the start of the game
	 * @param money
	 */
	public void setFarmMoney(Money money) {
		farmMoney = money;
	}
	/**
	 * Sets the modifier for the speed of crops on the farm
	 * @param growingSpeed
	 */
	public void setGrowingSpeedModifier(int growingSpeed) {
		cropGrowingSpeedModifier = growingSpeed;
	}
	/**
	 * Sets the modifier for the happiness of animals on the farm
	 * @param happiness
	 */
	public void setAnimalHappinessModifier(double happiness) {
		animalHappinessModifier = happiness;
	}
	/**
	 * Set the farms healthiness modifier value.
	 * @param healthiness
	 */
	public void setAnimalHealthinessModifier(double healthiness) {
		animalHealthinessModifier = healthiness;
	}
	/**
	 * Sets the farmer at the start of the game
	 * @param newFarmer
	 */
	public void setFarmer(Farmer newFarmer) {
		farmer = newFarmer;
	}
	/**
	 * Sets the cropList of the farm at the start of the game
	 * @param cropsList
	 */
	public void setCropList(ArrayList<Crops> cropsList) {
		cropList = cropsList;
	}
	/**
	 * Sets the animalList of the farm at the start of the game
	 * @param animalsList
	 */
	public void setAnimalList(ArrayList<Animals> animalsList) {
		animalList = animalsList;
	}
	/**
	 * Set the list of owned items
	 * @param itemList
	 */
	public void setItemList(ArrayList<Item> itemsList) {
		itemList = itemsList;
	}
	/**
	 * Sets the max crop capacity of the farm
	 * @param maxCapacity
	 */
	public void setMaxCropCapacity(int maxCapacity) {
		maxCropCapacity = maxCapacity;
	}
	/**
	 * Sets the max animal capacity of the farm
	 * @param maxCapacity
	 */
	public void setMaxAnimalCapacity(int maxCapacity) {
		maxAnimalCapacity = maxCapacity;
	}
	/**
	 * Called when a crop is bought, adds new crop to the farms cropList
	 * @param crop
	 */
	public void addCrop(Crops crop) {
		if (cropList.size() < maxCropCapacity) {
		crop.setGrowTime(cropGrowingSpeedModifier + crop.getGrowTime());
		cropList.add(crop);
		farmMoney.minusMoney(crop.getBuyPrice());
		} else {
			System.out.println("Farm is at max capacity of crops please sell some before purchasing more. :)");
		}
	}
	/**
	 * Called when a crop is sold, removes sold crop to the farms cropList
	 * @param crop
	 */
	public void minusCrop(Crops crop) {
		cropList.remove(crop);
		farmMoney.addMoney(crop.getSellPrice());
		System.out.println(String.format("Sold %s for $%s", crop.getCropName(), crop.getSellPrice()));
	}
	/**
	 * Called when a animal is bought, adds new animal to the farms animalList
	 * @param animal
	 */
	public void addAnimal(Animals animal) {
		if (animalList.size() < maxAnimalCapacity) {
			double earnings = animalHappinessModifier * animal.getHappinessLevel() * animal.getHealthiness() *  animal.getDailyEarnings();
			animal.setDailyEarnings(earnings);
			animalList.add(animal);
			farmMoney.minusMoney(animal.getBuyPrice());
		} else {
			System.out.println("You have reached the maximum animal capacity for your farm. :)");
		}
	}
	/**
	 * Add item to itemList
	 * @param item
	 */
	public void addItem(Item item) {
		itemList.add(item);
		farmMoney.minusMoney(item.getItemPrice());
	}
	/**
	 * Remove item from itemList
	 * @param item
	 */
	public void removeItem(Item item) {
		int index = itemList.indexOf(item);
		itemList.remove(index);
	}
	/**
	 * Called at the end of everyday, 
	 * iterates through animalList and adds the animals daily earning to the farms money
	 */
	public void addAnimalEarnings() {
		for (Animals animal : animalList) {
			farmMoney.addMoney(animal.getDailyEarnings());
			System.out.println(animal.getClass());
			System.out.println(String.format("Your %s earned $%s today", animal.getAnimalName(), animal.getDailyEarnings()));
		}
	}
	/**
	 * Reduce all the animals healthiness levels by 20%.
	 */
	public void deductAnimalHealthiness() {
		for (Animals animal: animalList) {
			animal.setHealthiness(animal.getHealthiness()*.8);
			double newEarnings = animal.getDailyEarnings()* animal.getHealthiness();
			animal.setDailyEarnings(newEarnings);
			
		}
	}
	/**
	 * Reduce all the animals happiness levels by 10%.
	 */
	public void deductAnimalHappiness() {
		for (Animals animal: animalList) {
			animal.setHappinessLevel(animal.getHappinessLevel()*.9);
			double newEarnings = animal.getDailyEarnings()* animal.getHappinessLevel();
			animal.setDailyEarnings(newEarnings);
		}
	}
	/**
	 * Called at the end of every day, lessens the days left for crops to grow if they're days left = 0 sells the crops
	 */
	public void progressGrowth() {
		for (Crops crop : cropList) {
			crop.setGrowTime(crop.getGrowTime() - 1);
			if (crop.getGrowTime() <= 0) {
				crop.setGrowTime(0);
			}
		}
	}
	
	/**
	 * Prints out the crops currently on the farm
	 */
	public String printCropList() {
		if (cropList.size() == 0) {
			return "You own no crops\n";
		} else {
		String result = new String();
		result = result + "Crops:\n";
		int num = 1;
		for (Crops crop : cropList) {
			result = result + num + ": " + crop.getCropName() + ": Days remaining= " + crop.getGrowTime() + "\n";
			num += 1;
		}
		return result;
		}
		
	}
	/**
	 * prints out the animals currently on the farm
	 */
	public String printAnimalList() {
		if (animalList.size() == 0) {
			return "You own no animals\n";
		} else {
			String result = new String();
			result = result.concat("Animals:\n");
			int num = 1;
			for (Animals animal : animalList) {
				result = result.concat(num + ": " + animal.getAnimalName() + "\n");
				num += 1;
			}
			return result;
		}
	}
	/**
	 * Return itemList as string
	 * @return String
	 */
	public String printItemList() {
		if (itemList.size() == 0) {
			return "You own no items\n";
		} else {
			String result = new String();
			result = result.concat("Items:\n");
			int num = 1;
			for (Item item: itemList) {
				result = result.concat(num + ". " + item.getItemName() + "\n");
				num += 1;
			}
			return result;
		
		}
	}
	
	/**
	 * String representation of the farm
	 */
	public String toString() {
		return String.format("<html>Farm: %s<br>Congratulations %s<br>Money Count: %.2f<html>", getFarmName(), getFarmer().getName(), getFarmMoney().getMoneyAmount());
	}
	
}