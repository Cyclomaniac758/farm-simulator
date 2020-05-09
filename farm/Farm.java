package farm;

import java.util.ArrayList;
import crops.*;
import animals.*;
import money.*;

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
	private int cropGrowingSpeed;
	/**
	 * The happiness of animals on the farm
	 */
	private float animalHappiness;
	/**
	 * The farmer this will replaced with the actual farmer class
	 */
	private String farmer;
	/**
	 * ArrayList where the current crops on the farm are stored
	 */
	private ArrayList<Crops> cropList;
	/**
	 * ArrayList where the current animals on the farm are stored
	 */
	private ArrayList<Animals> animalList;

	

    /**
	 * Gets farm Name
     * @return String farm name
     */
    public String getFarmName(){
    	return farmName;
    }
    /**
     * Gets type of farm
     * @return The farms type
     */
    public String getFarmType(){
    	return farmType;
    }
    /**
     * Gets the current amount of money the farm has
     * @return The amount of money on the farm
     */
    public Money getFarmMoney(){
    	return farmMoney;
    }	
    /**
     * Gets the growing speed of the crops
     * @return the number of days it takes for a crop to grow
     */
    public int getGrowingSpeed(){
    	return cropGrowingSpeed;
    }
    /**
     * Gets the animal happiness level
     * @return The happiness level of the animal
     */
    public float getAnimalHappiness(){
    	return animalHappiness;
    }
    /**
     * Gets the farmer
     * @return farmer
     */
    public String getFarmer(){
    	return farmer;
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
	public void setGrowingSpeed(int growingSpeed) {
		cropGrowingSpeed = growingSpeed;
	}
	/**
	 * Sets the modifier for the happiness of animals on the farm
	 * @param happiness
	 */
	public void setAnimalHappiness(float happiness) {
		animalHappiness = happiness;
	}
	/**
	 * Sets the farmer at the start of the game
	 * @param newFarmer
	 */
	public void setFarmer(String newFarmer) {
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
	 * Called when a crop is bought, adds new crop to the farms cropList
	 * @param crop
	 */
	public void addCrop(Crops crop) {
		crop.setGrowTime(cropGrowingSpeed + crop.getGrowTime());
		cropList.add(crop);
		farmMoney.minusMoney(crop.getBuyPrice());
		System.out.println(String.format("Bought %s for $%s", crop.getCropName(), crop.getBuyPrice()));
	}
	/**
	 * Called when a crop is sold, removes sold crop to the farms cropList
	 * @param crop
	 */
	public void minusCrop(Crops crop) {
		if (crop.getGrowTime() <= 0) {
			cropList.remove(crop);
			farmMoney.addMoney(crop.getSellPrice());
			System.out.println(String.format("Sold %s for $%s", crop.getCropName(), crop.getSellPrice()));
		}
	}
	/**
	 * Called when a animal is bought, adds new animal to the farms animalList
	 * @param animal
	 */
	public void addAnimal(Animals animal) {
		animalList.add(animal);
		farmMoney.minusMoney(animal.getBuyPrice());
		System.out.println(String.format("Bought %s for $%s", animal.getAnimalName(), animal.getBuyPrice()));
		
	}
	/**
	 * Called at the end of everyday, 
	 * iterates through animalList and adds the animals daily earning to the farms money
	 */
	public void addAnimalEarnings() {
		for (Animals animal : animalList) {
			float earnings = animalHappiness * animal.GethappinessLevel() * animal.getDailyEarnings();
			farmMoney.addMoney(earnings);
			System.out.println(String.format("Your %s earned $%s today", animal.getAnimalName(), earnings));
		}
	}
	/**
	 * Prints out the crops currently on the farm
	 */
	public void printCropList() {
		for (Crops crop : cropList) {
			System.out.println(crop.getCropName());
		}
	}
	/**
	 * prints out the animals currently on the farm
	 */
	public void printAnimalList() {
		for (Animals animal : animalList) {
			System.out.println(animal.getAnimalName());
		}
	}
	/**
	 * String representation of the farm
	 */
	public String toString() {
		return String.format("the name of the farm is %s\nthe farmer is %s\nmoney count = %s", getFarmName(), getFarmer(), getFarmMoney());
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
