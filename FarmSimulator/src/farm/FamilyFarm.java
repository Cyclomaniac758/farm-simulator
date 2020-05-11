package farm;

import java.util.ArrayList;
import java.util.Arrays;

import animals.*;
import crops.*;
import money.*;

/**
 * Class FamilyFarm extends Farm
 * @author Michael Peters
 *
 */
public class FamilyFarm extends Farm {
	/**
	 * Constructor of FamilyFarm Class
	 * @param name
	 */
	public FamilyFarm(String name) {
		setFarmName(name);
		setFarmMoney(new Money(1500));
		setFarmType("Family");
		setGrowingSpeed(2);
		setAnimalHappiness(1.5f);
		setCropList(new ArrayList<Crops>());
		setAnimalList(new ArrayList<Animals>());
	}

}