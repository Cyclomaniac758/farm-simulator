package farm;

import java.util.ArrayList;
import animals.*;
import crops.*;
import money.*;
import items.*;

/**
 * Class FamilyFarm extends Farm
 * @author Michael Peters
 *
 */
public class FamilyFarm extends Farm {
	/**
	 * Constructor of FamilyFarm Class
	 * @param name Name of the farm
	 */
	public FamilyFarm(String name) {
		setFarmName(name);
		setFarmMoney(new Money(1500));
		setFarmType("Family");
		setGrowingSpeedModifier(2);
		setAnimalHappinessModifier(1.5);
		setAnimalHealthinessModifier(1.0);
		setCropList(new ArrayList<Crops>());
		setAnimalList(new ArrayList<Animals>());
		setItemList(new ArrayList<Item>());
    	setMaxCropCapacity(2);
    	setMaxAnimalCapacity(6);
    	setDeductHappinessRate(.8);
    	setDeductHealthinessRate(.8);
	}

}

