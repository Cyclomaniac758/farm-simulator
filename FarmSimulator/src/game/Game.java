package game;

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
	private GeneralStore generalStore;
	
	public void startGame() {
		setGameLength();
		createFarm();
		System.out.println("done");
		createFarmer();
		//playGame(); //remember to change
		System.out.println("Time to start farming. *RULES*"
				+ "\n");
		System.out.println("Day" + currentDay + ".\nDo activities");
		
	}
	
	public void createFarm() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose your farm type by entering the respective number./n1. Family Farm\n2. Commercial Farm\n"
				+ "3. Livestock Farm\n4. Crop Farm");
		int num = scan.nextInt();
		System.out.println("Enter your farm name");
		String name = scan.nextLine();
		if (num == 1) {
			farm = new FamilyFarm(name);
		} else if (num == 2) {
			farm = new CommercialFarm(name);
		} else if (num == 3) {
			farm = new LivestockFarm(name);
		} else {
			farm = new OrchardFarm(name);
		}
		scan.close();
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
		
		System.out.println("Enter farmer age");
		int userAge = scan.nextInt();
		farmer = new Farmer(userName, userAge, farm);
		scan.close();
	}
	
	public void setGameLength() {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many days should the game last?");
		int length = scan.nextInt();
		numDays = length;
		this.setCurrentDay(1);
		scan.close();
	}
	
	public void setCurrentDay(int num) {
		currentDay = num;
	}
	
//	public void playGame() {
		//while (currentDay < numDays+1) {
		//	System.out.println("Day" + currentDay + ".\nDo activities");
	//		doStuff();
//		}
//		endGame();
//	}

	public void nextDay() {
		if (currentDay < numDays) {
			currentDay += 1;
			farmer.restoreActions();
			System.out.println("Day" + currentDay + ".\nDo activities");
			
		} else {
			endGame();
		}
	}
	
	public void endGame() {
		double earnedValue = farm.getFarmMoney().getMoneyAmount();
		System.out.println("Game completed\nTotal money earned: " + earnedValue);
	}
	
	
	public static void main(String[] args) {
		Game game = new Game();
		game.startGame();
	}
}
