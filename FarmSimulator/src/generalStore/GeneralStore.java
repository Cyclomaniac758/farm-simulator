package generalStore;

import farm.*;
import exceptions.*;
import items.*;

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
	 * Buy water method
	 */
	public void buyWater() {
		Water water = new Water();
		if (farm.getFarmMoney().getMoneyAmount() >= water.getItemPrice()) {
			farm.getFarmMoney().minusMoney(water.getItemPrice());
			// add to inventory
		} else {
			throw new InsufficientFundsException("You can't afford this"); 
		}
	}
	
	
	public void buyHoe() {
		Hoe hoe = new Hoe();
		if (farm.getFarmMoney().getMoneyAmount() >= hoe.getItemPrice()) {
			farm.getFarmMoney().minusMoney(hoe.getItemPrice());
			// add to inventory
		} else {
			throw new InsufficientFundsException("You can't afford this"); 
		}
	}
	
	
	public void buyFertilizer() {
		Fertilizer fertilizer = new Fertilizer();
		if (farm.getFarmMoney().getMoneyAmount() >= fertilizer.getItemPrice()) {
			farm.getFarmMoney().minusMoney(fertilizer.getItemPrice());
			// add to inventory
		} else {
			throw new InsufficientFundsException("You can't afford this"); 
		}
	}
	
	
	public void buyIncubator() {
		Incubator incubator = new Incubator();
		if (farm.getFarmMoney().getMoneyAmount() >= incubator.getItemPrice()) {
			farm.getFarmMoney().minusMoney(incubator.getItemPrice());
			// add to inventory
		} else {
			throw new InsufficientFundsException("You can't afford this"); 
		}
	}
	
	public void buyWaterFood() {
		WaterFood water = new WaterFood();
		if (farm.getFarmMoney().getMoneyAmount() >= water.getItemPrice()) {
			farm.getFarmMoney().minusMoney(water.getItemPrice());
			// add to inventory
		} else {
			throw new InsufficientFundsException("You can't afford this"); 
		}
	}
	
	
	public void buyGrain() {
		Grain grain = new Grain();
		if (farm.getFarmMoney().getMoneyAmount() >= grain.getItemPrice()) {
			farm.getFarmMoney().minusMoney(grain.getItemPrice());
			// add to inventory
		} else {
			throw new InsufficientFundsException("You can't afford this"); 
		}
	}
	
	public void buyGrowthHormone() {
		GrowthHormone growth_hormone = new GrowthHormone();
		if (farm.getFarmMoney().getMoneyAmount() >= growth_hormone.getItemPrice()) {
			farm.getFarmMoney().minusMoney(growth_hormone.getItemPrice());
			// add to inventory
		} else {
			throw new InsufficientFundsException("You can't afford this"); 
		}
	}
	/**
	 * Buy a cow method
	 */
	public void buyCow() {
		Cow cow = new Cow();
		
	}
}
