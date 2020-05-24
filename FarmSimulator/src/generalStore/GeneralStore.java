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
	 * @param userFarm The farm
	 */
	public GeneralStore(Farm userFarm) {
		farm = userFarm;
	}
	/**
	 * Method returning a string representation of the animal attributes
	 * @return String Table of animal values
	 */
	public String viewAnimals() {
		Chicken chicken = new Chicken();
		Cow cow = new Cow();
		Pig pig = new Pig();
		return String.format("%15s%15s%15s\n1. %s\n2. %s\n3. %s\n", "Animal", "Price", 
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
		return String.format("Tools to speed up crop growth:\n%18s%15s\n"
				+ "1. %s\n2. %s\n3. %s\n4. %s\n\nFood to increase animal healthiness:\n"
				+ "%18s%15s\n5. %s\n6. %s\n7. %s\n", "Name", "Price",  
				water.toString(), hoe.toString(), fert.toString(), incub.toString(), 
				"Name", "Price", 
				waterFood.toString(), grain.toString(), growth.toString());
	}
	
	/**
	 * Buy water method
	 * @param num Quantity of water that is to be bought
	 */
	public void buyWater(int num) {
		Water water = new Water();
		if (farm.getFarmMoney().getMoneyAmount() >= water.getItemPrice()*num) {
			for (int i=0; i < num; i++) {
				Water water1 = new Water();
				farm.addItem(water1);
			}
		} else {
			throw new InsufficientFundsException("You can't afford this"); 
		}
	}
	
	/**
	 * Buy Hoe method
	 * @param num Quantity of hoes to be bought
	 */
	public void buyHoe(int num) {
		Hoe hoe = new Hoe();
		if (farm.getFarmMoney().getMoneyAmount() >= hoe.getItemPrice()*num) {
			for (int i=0; i < num; i++) {
				Hoe hoe1 = new Hoe();
				farm.addItem(hoe1);
			}
		} else {
			throw new InsufficientFundsException("You can't afford this"); 
		}
	}
	
	/**
	 * Buy Fertilizer method
	 * @param num Quantity of fertilizer that is to be bought
	 */
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
	
	/**
	 * Buy Incubator method
	 * @param num Quantity of incubators that is to be bought
	 */
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
	/**
	 * Buy WaterFood method
	 * @param num Quantity of water that is to be bought
	 */
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
	
	/**
	 * Buy Grain method
	 * @param num Quantity of grain that is to be bought
	 */
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
	/**
	 * Buy Growth Hormone method
	 * @param num Quantity of growth hormone that is to be bought
	 */
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
	/**
	 * Buy carrots method
	 * @param num Quantity of carrots that is to be bought
	 */
	public void buyCarrots(int num) {
		Carrots carrot = new Carrots();
		if (farm.getFarmMoney().getMoneyAmount() >= carrot.getBuyPrice()*num) {
			int capacity = farm.getCropList().size() + num;
			if (capacity <= farm.getMaxCropCapacity()) {
				for (int i=0; i < num; i++) {
					Carrots carrot1 = new Carrots();
					farm.addCrop(carrot1);
				}
			} else {
				throw new InsufficientCapacityException("Not enough capacity");
			}
		} else {
			throw new InsufficientFundsException("You can't afford this");
		}
		
	}
	/**
	 * Buy wheat method
	 * @param num Quantity of wheat that is to be bought
	 */
	public void buyWheat(int num) {
		Wheat wheat = new Wheat();
		if (farm.getFarmMoney().getMoneyAmount() >= wheat.getBuyPrice()*num) {
			int capacity = farm.getCropList().size() + num;
			if (capacity <= farm.getMaxCropCapacity()) {
				for (int i=0; i < num; i++) {
					Wheat wheat1 = new Wheat();
					farm.addCrop(wheat1);
				}
			} else {
				throw new InsufficientCapacityException("Not enough capacity");
			}
		} else {
			throw new InsufficientFundsException("You can't afford this");
		}
	}
	/**
	 * Buy tomatoes method
	 * @param num Quantity of tomatoes that is to be bought
	 */
	public void buyTomatoes(int num) {
		Tomatoes tomatoe = new Tomatoes();
		if (farm.getFarmMoney().getMoneyAmount() >= tomatoe.getBuyPrice()*num) {
			int capacity = farm.getCropList().size() + num;
			if (capacity <= farm.getMaxCropCapacity()) {
				for (int i=0; i < num; i++) {
					Tomatoes tomatoe1 = new Tomatoes();
					farm.addCrop(tomatoe1);
				}
			} else {
				throw new InsufficientCapacityException("Not enough capacity");
			}
		} else {
			throw new InsufficientFundsException("You can't afford this");
		}
	}
	/**
	 * Buy corn method
	 * @param num Quantity of corn that is to be bought
	 */
	public void buyCorn(int num) {
		Corn corn = new Corn();
		if (farm.getFarmMoney().getMoneyAmount() >= corn.getBuyPrice()*num) {
			int capacity = farm.getCropList().size() + num;
			if (capacity <= farm.getMaxCropCapacity()) {
				for (int i=0; i < num; i++) {
					Corn corn1 = new Corn();
					farm.addCrop(corn1);
				}
			} else {
				throw new InsufficientCapacityException("Not enough capacity");
			}
		} else {
			throw new InsufficientFundsException("You can't afford this");
		}
	}
	/**
	 * Buy lemon tree method
	 * @param num Quantity of lemon trees that is to be bought
	 */
	public void buyLemonTree(int num) {
		LemonTree lemonTree = new LemonTree();
		if (farm.getFarmMoney().getMoneyAmount() >= lemonTree.getBuyPrice()*num) {
			int capacity = farm.getCropList().size() + num;
			if (capacity <= farm.getMaxCropCapacity()) {
				for (int i=0; i < num; i++) {
					LemonTree lemonTree1 = new LemonTree();
					farm.addCrop(lemonTree1);
				}
			} else {
				throw new InsufficientCapacityException("Not enough capacity");
			}
		} else {
			throw new InsufficientFundsException("You can't afford this");
		}
	}
	/**
	 * Buy apple tree method
	 * @param num Quantity of apple trees that is to be bought
	 */
	public void buyAppleTree(int num) {
		AppleTree appleTree = new AppleTree();
		if (farm.getFarmMoney().getMoneyAmount() >= appleTree.getBuyPrice()*num) {
			int capacity = farm.getCropList().size() + num;
			if (capacity <= farm.getMaxCropCapacity()) {
				for (int i=0; i < num; i++) {
					AppleTree appleTree1 = new AppleTree();
					farm.addCrop(appleTree1);
				}
			} else {
				throw new InsufficientCapacityException("Not enough capacity");
			}
		} else {
			throw new InsufficientFundsException("You can't afford this");
		}
	}
	/**
	 * Buy chickens method
	 * @param num Quantity of chickens that is to be bought
	 */
	public void buyChicken(int num) {
		Chicken chicken = new Chicken();
		if (farm.getFarmMoney().getMoneyAmount() >= chicken.getBuyPrice()*num) {
			int capacity = farm.getAnimalList().size() + num;
			if (capacity <= farm.getMaxAnimalCapacity()) {
				for (int i=0; i < num; i++) {
					Chicken chicken1 = new Chicken();
					farm.addAnimal(chicken1);
				}
				
			} else {
				throw new InsufficientCapacityException("Not enough capacity");
			}
		} else {
			throw new InsufficientFundsException("You can't afford this");
		}
	}
	/**
	 * Buys pigs method
	 * @param num Quantity of pigs that is to be bought
	 */
	public void buyPig(int num) {
		Pig pig = new Pig();
		if (farm.getFarmMoney().getMoneyAmount() >= pig.getBuyPrice()*num) {
			int capacity = farm.getAnimalList().size() + num;
			if (capacity <= farm.getMaxAnimalCapacity()) {
				for (int i=0; i < num; i++) {
					Pig pig1 = new Pig();
					farm.addAnimal(pig1);
				}
				
			} else {
				throw new InsufficientCapacityException("Not enough capacity");
			}
		} else {
			throw new InsufficientFundsException("You can't afford this");
		}
	}
	/**
	 * Buy cows method
	 * @param num Quantity of cows that is to be bought
	 */
	public void buyCow(int num) {
		Cow cow = new Cow();
		if (farm.getFarmMoney().getMoneyAmount() >= cow.getBuyPrice()*num) {
			int capacity = farm.getAnimalList().size() + num;
			if (capacity <= farm.getMaxAnimalCapacity()) {
				for (int i=0; i < num; i++) {
				Cow cow1 = new Cow();
				farm.addAnimal(cow1);
				}
			} else {
				throw new InsufficientCapacityException("Not enough capacity");
			}
		} else {
			throw new InsufficientFundsException("You can't afford this");
		}
		
	}
}
