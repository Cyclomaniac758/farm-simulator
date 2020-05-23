package game;

import farm.*;
import farmer.*;
import exceptions.*;
import generalStore.*;
import items.*;
import money.*;
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
	private GameGUI game;
		
	
		
	public Farm getFarm() {
		return farm;
	}
	
	public void setFarm(Farm farm) {
		this.farm = farm;
	}
	
	public Farmer getFarmer() {
		return farmer;
	}
	
	public void setFarmer() {
		this.farmer = farmer;
	}
	
	
	public void createStore() {
		this.store = new GeneralStore(farm);
	}
	
	public GeneralStore getStore() {
		return store;
	}
	
	public void createFarm() {
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Enter your farm name");
		String name = scan1.next();
		System.out.println("Choose your farm type by entering the respective number.\n1. Family Farm\n2. Commercial Farm\n"
				+ "3. Livestock Farm\n4. Crop Farm");
		
		
		boolean found = false;
		while (found == false) {
			int num = scan1.nextInt();
			if (num == 1) {
				farm = new FamilyFarm(name);
				found = true;
			} else if (num == 2) {
				farm = new CommercialFarm(name);
				found = true;
			} else if (num == 3) {
				farm = new LivestockFarm(name);
				found = true;
			} else if (num == 4) {
				farm = new CropFarm(name);
				found = true;
			} else {
				System.out.println("Enter a valid number");
			}
		}
	}
	
	public void createFarmer(Farmer farmer) {
		this.farmer = farmer;
		
	}
	
	public void setGameLength(int length) {
		numDays = length;
		this.setCurrentDay(1);
	}
	
	public void setGameLength() {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many days should the game last? "
				+ "(must be between 5 an 10)");
		int length = scan.nextInt();
		boolean valid = false;
		if (length >= 5 && length <= 10) {
		    valid = true;
		}
		while (valid != true) {
			System.out.println("Invalid input, enter an integer between 5 and 10");
			length = scan.nextInt();
			if (length >= 5 && length <= 10) {
			    valid = true;
			}
		}
		numDays = length;
		this.setCurrentDay(1);
	}
	
	public int getCurrentDay() {
		return currentDay;
		
	}
	public void setCurrentDay(int num) {
		currentDay = num;
	}
	
	public void playGame() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nEnter action number to complete the action"
				+ "\n1. Proceed to next day\n2. View farm status\n3. Visit general store"
				+ "\n4. Tend crops\n5. Feed animals\n6. Play with animals\n7. Harvest crops"
				+ "\n8. Tend land");
		int num = scan.nextInt();
		switch (num) {
		case 1: 
			nextDay();
			break;
		case 2: 
			viewFarmStatus();
			break;
		case 3: 
			visitStore();
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			playWithAnimals();
			break;
		case 7:
			break;
		case 8:
			tendLand();
			break;
		}
	}


	public void nextDay() {
		if (currentDay < numDays) {
			currentDay += 1;
			farmer.restoreActions();
			farm.progressGrowth();
			farm.addAnimalEarnings();
			farm.deductAnimalHealthiness();
			farm.deductAnimalHappiness();
			
		} else {
			endGame();
		}
	}
	
	public String viewFarmStatus() {
		return ("You have $" + farm.getFarmMoney().getMoneyAmount() + "\n" + 
		farm.printCropList() +
		farm.printItemList() + 
		farm.printAnimalList());
	}
	
	public int getActionsRemaining() {
		return farmer.getNumActions();
	}
	
	public void visitStore() {
	}
	
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
	
	public void feedAnimals(Food item, Animals animal) {
		farmer.useFood(item, animal);
	}
	
	public boolean containsFood() {
		int index = farm.getItemList().size()-1;
		boolean hasFood = false;
		while (index>=0 && hasFood == false) {
			if (farm.getItemList().get(index) instanceof Food) {
				hasFood = true;
			} else {
				index += -1;
			}
		}
		return hasFood;
	}
	
	public void playWithAnimals() {
		farmer.playWithAnimals();
	}
	
	public void harvestCrops(Crops crop) {
		farmer.harvestCrop(crop);
	}
	
	public void tendLand() {
		farmer.tendLand();
	}
	public void endGame() {
		window.getFrame().dispose();
		GameOverWindow window = new GameOverWindow(game);
		window.getFrame().setVisible(true);
	}
	
	public void setHomeWindow(HomeWindow window) {
		this.window = window;
		window.getFrame().setVisible(true);
	}
	public void showHomeWindow() {
		window.getFrame().setVisible(true);
	}
	
	public void setGame(GameGUI game) {
		game.game = game;
		
	}
	
	
	public void restart() {
		game = new GameGUI();
		game.setCurrentDay(9);
		game.setHomeWindow(new HomeWindow(game));
	}
	
	public static void main(String[] args) {
		GameGUI game = new GameGUI();
		StartWindow1 window = new StartWindow1(game);
		window.getFrame().setVisible(true);
	}

	
}
