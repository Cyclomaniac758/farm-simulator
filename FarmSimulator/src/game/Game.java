package game;

import java.util.Scanner;
import farm.*;
import farmer.*;

public class Game {
	
	
	public void startGame() {
		Scanner scan = new Scanner(System.in);
		Farm farm = this.createFarm();
		System.out.println("done");
	}
	
	public Farm createFarm() {
		
		System.out.println("Choose your farm type by entering the respective number./n1. Family Farm\n2. Commercial Farm\n"
				+ "3. Livestock Farm\n4. Crop Farm");
		int num = scan.nextInt();
		System.out.println("Enter your farm name");
		String name = scan.nextLine();
		if (num == 1) {
			FamilyFarm farm = new FamilyFarm(name);
		} else if (num == 2) {
			CommercialFarm farm = new CommercialFarm(name);
		} else if (num == 3) {
			LivestockFarm farm = new LivestockFarm(name);
		} else {
			OrchardFarm farm = new OrchardFarm(name);
		}
		return farm; 
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.startGame();
	}
}
