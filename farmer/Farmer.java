package farmer;


import items.item;
import farm.Farm;

/**
 * A farmer character
 * @author Icarus
 */
public class Farmer {
	/**
	 * The farmer's name
	 */
	private String name;
	
	/**
	 * The age of the farmer
	 */
	private int age;
	
	/**
	 * The number of actions remaining for the day
	 */
	private int numActions;
	
	/**
	 * The farm that the farmer tends to
	 */
	private Farm farm;
	
	/**
	 * Constructor method for the farmer class
	 * @param userName
	 * @param userAge
	 * @param userFarm
	 */
	public Farmer(String userName, int userAge, Farm userFarm) {
		numActions = 2;
		name = userName;
		age = userAge;
		farm = userFarm;
	}
	
	/**
	 * Returns farmer name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns farmer age
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * returns the number of actions remaining for the day
	 * @return numActions
	 */
	public int getNumActions() {
		return numActions;
	}
	
	/**
	 * Reduce the number of actions remaining by one
	 */
	public void deductAction() {
		numActions += -1;
	}
	
	/**
	 * Starting a new day, restore the number of actions remaining
	 */
	public void restoreActions() {
		numActions = 2;
	}
	
	
	public void tendCrops(item item) {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
