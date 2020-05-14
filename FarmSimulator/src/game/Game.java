package game;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.*;
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
		System.out.println("done");
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
		System.out.println("Choose your farm type by entering the respective number.\n1. Family Farm\n2. Commercial Farm\n"
				+ "3. Livestock Farm\n4. Crop Farm");
		int num = scan1.nextInt();
		System.out.println("Enter your farm name");
		String name = scan1.next();
		if (num == 1) {
			farm = new FamilyFarm(name);
		} else if (num == 2) {
			farm = new CommercialFarm(name);
		} else if (num == 3) {
			farm = new LivestockFarm(name);
		} else {
			farm = new OrchardFarm(name);
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
			System.out.println("Day" + currentDay + ".\nDo activities");
			
		} else {
			currentDay += 1;
		}
	}
	
	public void viewFarmStatus() {
		farm.printAnimalList();
		farm.printCropList();
		farm.printItemList();
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
					num = scan.nextInt();
					break;
			case 2: System.out.println(store.viewAnimals());
					num = scan.nextInt();
					break;
			case 3: System.out.println(store.viewItems());
					num = scan.nextInt();
					break;
			case 4: buyCrops();
					num = scan.nextInt();
					break;
			case 5: buyAnimals();
					num = scan.nextInt();
					break;
			case 6: buyItems();
					num = scan.nextInt();
					break;
			case 7: viewFarmStatus();
					num = scan.nextInt();
					break;
			}
		}
	}
	
	public void buyCrops() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number to buy crop\n1. Carrots\n2. Wheat\n"
				+ "3. Tomatoes\n4. Corn\n5. Lemon Tree\n6. Apple Tree");
		int num = scan.nextInt();
		System.out.println("Enter crop quantity");
		int num2 = scan.nextInt();
		switch (num) {
		case 1: try {
					store.buyCarrots(num2);
				} catch (InsufficientFundsException|InsufficientCapacityException e) {
					System.out.println(e.getMessage());
				}
				break;
		case 2: store.buyWheat(num2);
				break;
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
