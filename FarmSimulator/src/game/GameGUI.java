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
	public void startGame() {
		setGameLength();
		createFarm();
		System.out.println("Time to start farming. *RULES*"
				+ "\n");
		System.out.println("Day" + currentDay + ".\nDo activities");
		while (currentDay < numDays+1) {
			playGame();
		}
		endGame();
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
				farm = new OrchardFarm(name);
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
			tendCrops();
			break;
		case 5:
			feedAnimals();
			break;
		case 6:
			playWithAnimals();
			break;
		case 7:
			harvestCrops();
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
			System.out.println("Day" + currentDay + ".\nDo activities");
			
		} else {
			currentDay += 1;
		}
	}
	
	public String viewFarmStatus() {
		return ("<html>" + farm.printAnimalList() + "<br>" +
		farm.printCropList() + "<br>" +
		farm.printItemList() + "<br>" + 
		"You have $" + farm.getFarmMoney().getMoneyAmount() + "<html>");
	}
	
	public int getActionsRemaining() {
		return farmer.getNumActions();
	}
	
	public void visitStore() {
		Scanner scan = new Scanner(System.in);
		store = new GeneralStore(farm);
		store.viewCrops();
		store.viewAnimals();
		System.out.println("General Store\n1. View crops\n2. View animals"
				+ "\n3. View items\n4. Buy crops\n5. Buy animals"
				+ "\n6. Buy items\n7. Show current inventory\n"
				+ "8. Exit store");
		int num = scan.nextInt();
		while (num != 8) {
			switch (num) {
			case 1: System.out.println(store.viewCrops());
					break;
			case 2: System.out.println(store.viewAnimals());
					break;
			case 3: System.out.println(store.viewItems());
					break;
			case 4: buyCrops();
					break;
			case 5: buyAnimals();
					break;
			case 6: buyItems();
					break;
			case 7: viewFarmStatus();
					break;
			}
			System.out.println("General Store\n1. View crops\n2. View animals"
					+ "\n3. View items\n4. Buy crops\n5. Buy animals"
					+ "\n6. Buy items\n7. Show current inventory\n"
					+ "8. Exit store");
			num = scan.nextInt();
		}
	}
	
	public void buyCrops() {
		Scanner scan = new Scanner(System.in);
		System.out.println(store.viewCrops());
		int num = scan.nextInt();
		System.out.println("Enter crop quantity");
		int num2 = scan.nextInt();
		switch (num) {
		case 1: try {
					store.buyCarrots(num2);
				} catch (IllegalStateException e) {
					System.out.println(e.getMessage());
				}
				break;
		case 2: try {
					store.buyWheat(num2);
				} catch (IllegalStateException e) {
					System.out.println(e.getMessage());
				}
				break;
		case 3: 
			try {
			store.buyTomatoes(num2);
			} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
			}
		break;
		case 4:
			try {
				store.buyCorn(num2);
			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 5:
			try {
				store.buyLemonTree(num2);
			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 6:
			try {
				store.buyAppleTree(num2);
			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 7: break;
		}
	}
	
	public void buyAnimals() {
		Scanner scan = new Scanner(System.in);
		System.out.println(store.viewAnimals());
		int num = scan.nextInt();
		System.out.println("Enter animal quantity");
		int num2 = scan.nextInt();
		switch (num) {
		case 1:
			try {
				store.buyChicken(num2);
			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 2:
			try {
				store.buyPig(num2);
			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 3:
			try {
				store.buyCow(num2);
			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 4:
			break;
		}
	}
	
	public void buyItems() {
		Scanner scan = new Scanner(System.in);
		System.out.println(store.viewItems() + "\n\n Enter tool number");
		int num = scan.nextInt();
		System.out.println("Enter item quantity");
		int num2 = scan.nextInt();
		switch (num) {
		case 1:
			try {
				store.buyWater(num2);
			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 2: 
			try {
				store.buyHoe(num2);
			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 3:
			try {
				store.buyFertilizer(num2);
			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 4:
			try {
				store.buyIncubator(num2);
			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 5:
			try {
				store.buyWaterFood(num2);
			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 6: 
			try {
				store.buyGrain(num2);
			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 7:
			try {
				store.buyGrowthHormone(num2);
			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
	}
	/**
	 * Use crop tool to tend crop
	 */
	public void tendCrops() {
		if (farm.getCropList().size() == 0) {
			farm.printCropList();
		} else if (farm.getItemList().size() == 0) {
			farm.printItemList();
		} else {
			if (containsCropTool() == true) {
				Scanner scan = new Scanner(System.in);
				System.out.println("Choose your crop to tend to");
				farm.printCropList();
				int num = scan.nextInt();
				Crops crop = farm.getCropList().get(num-1);
				boolean validTool = false;
				while (validTool == false) {
					System.out.println("Choose your item to use");
					farm.printItemList();
					int num1 = scan.nextInt();
					if (farm.getItemList().get(num1-1) instanceof cropTools) {
						cropTools item = (cropTools) farm.getItemList().get(num1-1);
						try {
							farmer.useCropTool(item, crop);
						} catch (NoMoreActionsException e) {
							System.out.println(e.getMessage());
						}
						validTool = true;
					} else {
						System.out.println("Select a valid tool");
					}
				} 
			} else {
					System.out.println("You dont own any crop tools");
			}
		}
	}
	/**
	 * itemList contains cropTool
	 * @return boolean Crop tool in items
	 */
	public boolean containsCropTool() {
		int index = farm.getItemList().size()-1;
		boolean hasCropTool = false;
		while (index>=0 && hasCropTool == false) {
			if (farm.getItemList().get(index) instanceof cropTools) {
				hasCropTool = true;
			} else {
				index += -1;
			}
		}
		return hasCropTool;
	}
	
	public void feedAnimals() {
		if (farm.getAnimalList().size() == 0) {
			farm.printAnimalList();
		} else if (farm.getItemList().size() == 0) {
			farm.printItemList();
		} else {
			if (containsFood() == true) {
				Scanner scan = new Scanner(System.in);
				System.out.println("Choose your animal to feed");
				farm.printAnimalList();
				int num = scan.nextInt();
				Animals animal = farm.getAnimalList().get(num-1);
				boolean validTool = false;
				while (validTool == false) {
					System.out.println("Choose your item to use");
					farm.printItemList();
					int num1 = scan.nextInt();
					if (farm.getItemList().get(num1-1) instanceof Food) {
						Food item = (Food) farm.getItemList().get(num1-1);
						try {
							farmer.useFood(item, animal);
						} catch (NoMoreActionsException e) {
							System.out.println(e.getMessage());
						}
						validTool = true;
					} else {
						System.out.println("Select a item");
					}
				} 
			} else {
					System.out.println("You dont own any food");
			}
		}
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
		if (farm.getAnimalList().size() > 0) {
			try {
				farmer.playWithAnimals();
			} catch (NoMoreActionsException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("You own no animals");
		}
	}
	
	public void harvestCrops() {
		Scanner scan = new Scanner(System.in);
		if (farm.getCropList().size() == 0) {
			System.out.println("You have no crops");
		} else {
			System.out.println("Select your crop to harvest");
			farm.printCropList();
			int num = scan.nextInt();
			Crops crop = farm.getCropList().get(num-1);
			if (crop.getGrowTime() > 0) {
				System.out.println("Crop is not ready yet");
			} else {
				try {
					farmer.harvestCrop(crop);
				} catch (NoMoreActionsException e) {
					System.out.println(e.getMessage());
				}
				
			}
		}
	}
	
	public void tendLand() {
		try {
			farmer.tendLand();
		} catch (NoMoreActionsException e) {
			System.out.println(e.getMessage());
		}
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
		FamilyFarm farm = new FamilyFarm("beepboop");
		Farmer farmer = new Farmer("foo", 3, farm);
		game.createFarmer(farmer);
		game.setGame(game);
		game.setFarm(farm);
		game.setCurrentDay(100);
		game.setHomeWindow(new HomeWindow(game));
	}

	
}
