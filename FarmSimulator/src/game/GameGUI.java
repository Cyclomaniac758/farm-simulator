package game;

import farm.*;
import farmer.*;
import generalStore.*;
import items.*;
import crops.*;

import java.util.Scanner;

import javax.swing.JFrame;

import animals.*;

/**
 * GUI Game controller class
 * @author Icarus
 *
 */
public class GameGUI {
	private Farm farm;
	private Farmer farmer;
	private int numDays;
	private int currentDay;
	private GeneralStore store;
	private HomeWindow window;
		
	
	/**
	 * Return the farm object
	 * @return farm object
	 */
	public Farm getFarm() {
		return farm;
	}
	/**
	 * Set farm parameter
	 * @param farm
	 */
	public void setFarm(Farm farm) {
		this.farm = farm;
	}
	/**
	 * Return the farmer object
	 * @return
	 */
	public Farmer getFarmer() {
		return farmer;
	}
	/**
	 * Set the farmer parameter
	 * @param farmer
	 */
	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;	
	}
	/**
	 * Create a GeneralStore object and store it in game
	 */
	public void createStore() {
		this.store = new GeneralStore(farm);
	}
	/**
	 * Return the store object
	 * @return store object
	 */
	public GeneralStore getStore() {
		return store;
	}
	/**
	 * Set the game length call setCurrentDay
	 * @param length
	 */
	public void setGameLength(int length) {
		numDays = length;
		this.setCurrentDay(1);
	}
	/**
	 * Return the game length
	 * @return game length
	 */
	public int getGameLenth() {
		return numDays;
	}
	/**
	 * Set the current day
	 * @param num
	 */
	public void setCurrentDay(int num) {
		currentDay = num;
	}
	/**
	 * Return the current day
	 * @return current day
	 */
	public int getCurrentDay() {
		return currentDay;
	}
	/**
	 * Move to the next day
	 */
	public void nextDay() {
		if (currentDay < numDays) {
			currentDay += 1;
			farmer.restoreActions();
			farm.progressGrowth();
			farm.addAnimalEarnings();
			farm.deductAnimalHealthiness();
			farm.deductAnimalHappiness();
		} else {
			currentDay += 1;
			endGame();
		}
	}
	/**
	 * Return the current inventory of the farm
	 * @return farm inventory
	 */
	public String viewFarmInventory() {
		return ("You have $" + farm.getFarmMoney().getMoneyAmount() + "\n" + 
		farm.printCropList() +
		farm.printItemList() + 
		farm.printAnimalList());
	}
	/**
	 * Return number of actions remaining in the day
	 * @return actions remaining
	 */
	public int getActionsRemaining() {
		return farmer.getNumActions();
	}
	/**
	 * Buy a certain number of a crop
	 * @param crop
	 * @param num
	 */
	public void buyCrops(String crop, int num) {
		switch (crop) {
		case "Carrots":
			store.buyCarrots(num);
			break;
		case "Wheat":
			store.buyWheat(num);
			break;
		case "Tomatoes": 
			store.buyTomatoes(num);
			break;
		case "Corn":
			store.buyCorn(num);
			break;
		case "Lemon Tree":
			store.buyLemonTree(num);
			break;
		case "Apple Tree":
			store.buyAppleTree(num);
			break;
		}
	}
	/**
	 * Buy a certain number of an animal
	 * @param animal
	 * @param num
	 */
	public void buyAnimals(String animal, int num) {
		switch (animal) {
		case "Chicken":
			store.buyChicken(num);
			break;
		case "Pig":
			store.buyPig(num);
			break;
		case "Cow":
			store.buyCow(num);
			break;
		}
	}
	/**
	 * Buy a certain number of an item
	 * @param item
	 * @param num
	 */
	public void buyItems(String item, int num) {
		switch (item) {
		case "Water For Crops":
			store.buyWater(num);
			break;
		case "Hoe": 
			store.buyHoe(num);
			break;
		case "Fertilizer":
			store.buyFertilizer(num);
			break;
		case "Incubator":
			store.buyIncubator(num);
			break;
		case "Water For Animals":
			store.buyWaterFood(num);
			break;
		case "Grain": 
			store.buyGrain(num);
			break;
		case "Growth Hormone":
			store.buyGrowthHormone(num);
			break;
		}
	}
	/**
	 * Use crop tool to tend crop
	 */
	public void tendCrops(CropTools item, Crops crop) {
		farmer.useCropTool(item, crop);
	}
	/**
	 * Use food to feed animal
	 * @param item
	 * @param animal
	 */
	public void feedAnimals(Food item, Animals animal) {
		farmer.useFood(item, animal);
	}
	/**
	 * Play with farm animals
	 */
	public void playWithAnimals() {
		farmer.playWithAnimals();
	}
	/**
	 * Harvest a crop
	 * @param crop
	 */
	public void harvestCrops(Crops crop) {
		farmer.harvestCrop(crop);
	}
	/**
	 * Tend the land
	 */
	public void tendLand() {
		farmer.tendLand();
	}
	/**
	 * End the game, opening the game over window
	 */
	public void endGame() {
		window.getFrame().dispose();
		GameOverWindow window = new GameOverWindow(this);
		window.getFrame().setVisible(true);
	}
	/**
	 * Setting the home window parameter
	 * @param window
	 */
	public void setHomeWindow(HomeWindow window) {
		this.window = window;
		window.getFrame().setVisible(true);
	}
	/**
	 * Make the home window visible
	 */
	public void showHomeWindow() {
		window.getFrame().setVisible(true);
	}
	/**
	 * Restart the game
	 */
	public void restart() {
		GameGUI game = new GameGUI();
	}
	/**
	 * Launches first start up window
	 * @param args
	 */
	public static void main(String[] args) {
		GameGUI game = new GameGUI();
		StartWindow1 window = new StartWindow1(game);
		window.getFrame().setVisible(true);
	}

	
}
