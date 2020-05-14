package generalStore;

import farm.*;
import exceptions.*;
import items.*;

import java.util.ArrayList;

import animals.*;
import crops.*;

/**
 * Store object, where items, animals and crops can be bought
 * @author Icarus
 *
 */
public class GeneralStore {
	/**
	 * Farm parameter passed into the constructor class
	 */
	private Farm farm;
	
	/**
	 * Constructor method, setting the farm parameter
	 */
	public GeneralStore(Farm userFarm) {
		farm = userFarm;
	}
	
	/**
	 * Return string representation of the available crops
	 * @return String Table of crop variables
	 */
	public String viewCrops() {
		AppleTree apple = new AppleTree();
		Carrots carrot = new Carrots();
		Corn corn = new Corn();
		LemonTree lemon = new LemonTree();
		Tomatoes tomatoe = new Tomatoes();
		Wheat wheat = new Wheat();
		return String.format("%10s%10s%10s%10s\n%s\n%s\n%s\n%s\n%s\n%s\n", 
				"Crop", "Buy", "Sell", "Time", carrot.toString(),
				wheat.toString(), tomatoe.toString(), corn.toString(), 
				lemon.toString(), apple.toString());
		
	}
	
	/**
	 * Method returning a string representation of the animal attributes
	 * @return String Table of animal values
	 */
	public String viewAnimals() {
		Chicken chicken = new Chicken();
		Cow cow = new Cow();
		Pig pig = new Pig();
		return String.format("%15s%15s%15s\n%s\n%s\n%s\n", "Animal", "Price", 
				"Daily profit", chicken.toString(), pig.toString(), cow.toString());
	}
	
	/**
	 * Display the items available
	 * @return String string representation of items
	 */
	public String viewItems() {
		Water water = new Water();
		Hoe hoe = new Hoe();
		Fertilizer fert = new Fertilizer();
		Incubator incub = new Incubator();
		//initialize cropTool items
		WaterFood waterFood = new WaterFood();
		Grain grain = new Grain();
		GrowthHormone growth = new GrowthHormone();
		//initialize food items
		return String.format("Tools to speed up crop growth:\n%15s%15s\n"
				+ "%s\n%s\n%s\n%s\n\nFood to increase animal healthiness:\n"
				+ "%15s%15s\n%s\n%s\n%s\n", "Name", "Price",  
				water.toString(), hoe.toString(), fert.toString(), incub.toString(), 
				"Name", "Price", 
				waterFood.toString(), grain.toString(), growth.toString());
	}
	
	/**
	 * Buy water method
	 */
	public void buyWater(int num) {
		Water water = new Water();
		if (farm.getFarmMoney().getMoneyAmount() >= water.getItemPrice()*num) {
			for (int i=0; i < num; i++) {
				Water water1 = new Water();
				farm.addItem(water1);
			}
			
			// add to inventory
		} else {
			throw new InsufficientFundsException("You can't afford this"); 
		}
	}
	
	
	public void buyHoe(int num) {
		Hoe hoe = new Hoe();
		if (farm.getFarmMoney().getMoneyAmount() >= hoe.getItemPrice()*num) {
			for (int i=0; i < num; i++) {
				Hoe hoe1 = new Hoe();
				farm.addItem(hoe1);
			}
			// add to inventory
		} else {
			throw new InsufficientFundsException("You can't afford this"); 
		}
	}
	
	
	public void buyFertilizer(int num) {
		Fertilizer fert = new Fertilizer();
		if (farm.getFarmMoney().getMoneyAmount() >= fert.getItemPrice()*num) {
			for (int i=0; i < num; i++) {
				Fertilizer fert1 = new Fertilizer();
				farm.addItem(fert1);
			}
		} else {
			throw new InsufficientFundsException("You can't afford this"); 
		}
	}
	
	
	public void buyIncubator(int num) {
		Incubator incubator = new Incubator();
		if (farm.getFarmMoney().getMoneyAmount() >= incubator.getItemPrice()*num) {
			for (int i=0; i < num; i++) {
				Incubator incubator1 = new Incubator();
				farm.addItem(incubator1);
			}
		} else {
			throw new InsufficientFundsException("You can't afford this"); 
		}
	}
	
	public void buyWaterFood(int num) {
		WaterFood water = new WaterFood();
		if (farm.getFarmMoney().getMoneyAmount() >= water.getItemPrice()*num) {
			for (int i=0; i < num; i++) {
				WaterFood water1 = new WaterFood();
				farm.addItem(water1);
			}
		} else {
			throw new InsufficientFundsException("You can't afford this"); 
		}
	}
	
	
	public void buyGrain(int num) {
		Grain grain = new Grain();
		if (farm.getFarmMoney().getMoneyAmount() >= grain.getItemPrice()*num) {
			for (int i=0; i < num; i++) {
				Grain grain1 = new Grain();
				farm.addItem(grain1);
			}
		} else {
			throw new InsufficientFundsException("You can't afford this"); 
		}
	}
	
	public void buyGrowthHormone(int num) {
		GrowthHormone growth_hormone = new GrowthHormone();
		if (farm.getFarmMoney().getMoneyAmount() >= growth_hormone.getItemPrice()*num) {
			for (int i=0; i < num; i++) {
				GrowthHormone growth_hormone1 = new GrowthHormone();
				farm.addItem(growth_hormone1);
			}
		} else {
			throw new InsufficientFundsException("You can't afford this"); 
		}
	}
	
	public void buyCarrots(int num) {
		Carrots carrot = new Carrots();
		if (farm.getFarmMoney().getMoneyAmount() >= carrot.getBuyPrice()*num) {
			int capacity = farm.getCropList().size() + num;
			if (capacity < farm.getMaxCropCapacity()) {
				for (int i=0; i < num; i++) {
					Carrots carrot1 = new Carrots();
					farm.addCrop(carrot1);
				}
				System.out.println("Bought " + num + " carrots for $" + num*carrot.getBuyPrice());
			} else {
				throw new InsufficientCapacityException("Not enough capacity");
			}
		} else {
			throw new InsufficientFundsException("You can't afford this");
		}
		
	}
	
	public void buyWheat(int num) {
		
	}
	/**
	 * Buy a cow method
	 */
	public void buyCow(int num) {
		Cow cow = new Cow();
		if (farm.getFarmMoney().getMoneyAmount() >= cow.getBuyPrice()*num) {
			for (int i=0; i < num; i++) {
				Cow cow1 = new Cow();
				farm.addAnimal(cow1);
			}
		} else {
			throw new InsufficientFundsException("You can't afford this");
		}
		
	}
	
	
	public void buyPig() {
		
	}
}
