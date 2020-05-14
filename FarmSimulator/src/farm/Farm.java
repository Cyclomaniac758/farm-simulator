package farm;

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
	private ArrayList<item> itemList;
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
    public double getAnimallHealthinessModifier() {
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
    public ArrayList<item> getItemList(){
    	return itemList;
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
	public void setItemList(ArrayList<item> itemsList) {
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
		animal.setHappinessLevel(animalHappinessModifier * animal.getHappinessLevel());
		animalList.add(animal);
		farmMoney.minusMoney(animal.getBuyPrice());
		} else {
			System.out.println("You have reached the maximum animal capacity for your farm. :)");
		}
	}
	
	public void addItem(item item) {
		itemList.add(item);
		farmMoney.minusMoney(item.getItemPrice());
	}
	/**
	 * Called at the end of everyday, 
	 * iterates through animalList and adds the animals daily earning to the farms money
	 */
	public void addAnimalEarnings() {
		for (Animals animal : animalList) {
			double earnings = animal.getHealthiness() * animal.getHappinessLevel() * animal.getDailyEarnings();
			farmMoney.addMoney(earnings);
			System.out.println(animal.getClass());
			System.out.println(String.format("Your %s earned $%s today", animal.getAnimalName(), earnings));
		}
	}
	/**
	 * Called at the end of every day, lessens the days left for crops to grow if they're days left = 0 sells the crops
	 */
	public void progressGrowth() {
		for (Crops crop : cropList) {
			crop.setGrowTime(crop.getGrowTime() - 1);
			if (crop.getGrowTime() <= 0) {
				minusCrop(crop);
			}
		}
	}
	/**
	 * Prints out the crops currently on the farm
	 */
	public void printCropList() {
		if (cropList.size() == 0) {
			System.out.println("You own no crops");
		} else {
			for (Crops crop : cropList) {
				System.out.println(crop.getCropName() + ": Days remaining= " + crop.getGrowTime());
			}	
		}
	}
	/**
	 * prints out the animals currently on the farm
	 */
	public void printAnimalList() {
		if (animalList.size() == 0) {
			System.out.println("You own no animals");
		} else {
			for (Animals animal : animalList) {
				System.out.println(animal.getAnimalName());
			}
		
		}
	}
	
	public void printItemList() {
		if (itemList.size() == 0) {
			System.out.println("You own no items");
		} else {
			for (item item: itemList) {
				System.out.println(item.getItemName());
			}
		
		}
	}
	/**
	 * String representation of the farm
	 */
	public String toString() {
		return String.format("the name of the farm is %s\nthe farmer is %s\nmoney count = %s", getFarmName(), getFarmer().getName(), getFarmMoney());
	}


	public static void main(String[] args) {
	
    OrchardFarm myNewFarm = new OrchardFarm("my orchard");
    System.out.println(myNewFarm.toString());
    myNewFarm.printAnimalList();
    myNewFarm.printCropList();
    
    FamilyFarm famtime = new FamilyFarm("Family time");
    System.out.println(famtime.toString());
    famtime.addCrop(new Corn());
    famtime.minusCrop(new Corn());
    famtime.printCropList();
    System.out.println(famtime.getFarmMoney());
    
    LivestockFarm lively = new LivestockFarm("cull season");
    System.out.println(lively.toString());

    CommercialFarm fonterra = new CommercialFarm("The scotts");
    System.out.println(fonterra.toString());
    fonterra.addAnimal(new Cow());
    fonterra.addAnimal(new Pig());
    fonterra.addAnimalEarnings();
    System.out.println(fonterra.getFarmMoney());
    
	}

}