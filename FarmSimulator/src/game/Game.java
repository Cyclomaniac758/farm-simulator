package game;


import java.util.Scanner;
import farm.*;
import farmer.*;
import exceptions.*;
import generalStore.*;
import items.*;
import money.*;


public class Game {
	private Farm farm;
	private Farmer farmer;
	private int numDays;
	private int currentDay;
	private GeneralStore store;
	
	public void startGame() {
		setGameLength();
		createFarm();
		createFarmer();
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
	
	public void createFarmer() {
		Scanner scan = new Scanner(System.in);
		boolean tracker = false;
		String userName = new String();
		while (tracker == false) {
			System.out.println("Enter farmer name");
			userName = scan.next();
			int len = userName.length();
			if (userName.matches("^[a-zA-Z]*$") && len > 3 && len < 15) {
				tracker = true;
			} else {
				System.out.println("Invalid name");
			}
		} 
		farmer = new Farmer(userName, farm);
		farm.setFarmer(farmer);
		
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
	
	public void setCurrentDay(int num) {
		currentDay = num;
	}
	
	public void playGame() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nEnter action number to complete the action"
				+ "\n1. Proceed to next day\n2.View farm status\n3.Visit general store"
				+ "\n4.Tend crops\n5. Feed animals\n6. Play with animals\n7. Harvest crops"
				+ "\n8. Tend land");
		int num = scan.nextInt();
		if (num == 1) {
			nextDay();
		} else if (num == 2) {
			viewFarmStatus();
		} else if (num == 3) {
			visitStore();
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
	
	public void viewFarmStatus() {
		farm.printAnimalList();
		farm.printCropList();
		farm.printItemList();
		System.out.println("You have $" + farm.getFarmMoney().getMoneyAmount());
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
		System.out.println("Enter number to buy crop\n1. Carrots\n2. Wheat\n"
				+ "3. Tomatoes\n4. Corn\n5. Lemon Tree\n6. Apple Tree\n7. Exit");
		int num = scan.nextInt();
		
		switch (num) {
		case 1: try {
					System.out.println("Enter crop quantity");
					int num2 = scan.nextInt();
					store.buyCarrots(num2);
				} catch (IllegalStateException e) {
					System.out.println(e.getMessage());
				}
				break;
		case 2: System.out.println("Enter crop quantity");
				int num2 = scan.nextInt();
				store.buyWheat(num2);
				break;
		case 7: break;
		}
	}
	
	public void buyAnimals() {
		
	}
	
	public void buyItems() {
		
	}
	
	public void endGame() {
		Scanner scan = new Scanner(System.in);
		double earnedValue = farm.getFarmMoney().getMoneyAmount();
		System.out.println("Game completed\nTotal money earned: " + earnedValue);
		System.out.println("1. Restart\n2. Exit game");
		int num = scan.nextInt();
		if (num == 1) {
			startGame();
		} else if (num == 2) {
			System.out.println("Till next time!");
		} else {
			System.out.println("Enter a valid option");
		}
	}
	
	
	public static void main(String[] args) {
		Game game = new Game();
		game.startGame();
	}
}
