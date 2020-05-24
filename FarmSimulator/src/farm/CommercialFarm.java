package farm;

import java.util.ArrayList;

import animals.*;
import crops.*;
import money.*;
import items.*;

/**
 * Class CommercialFarm extends Farm
 * @author Michael Peters
 *
 */
public class CommercialFarm extends Farm {
	
	/**
	 * Constructor of CommercialFarm class
	 * @param name Name of the farm
	 */
	public CommercialFarm(String name) {
		setFarmName(name);
		setFarmMoney(new Money(1500));
		setFarmType("Commercial");
    	setGrowingSpeedModifier(1);
    	setAnimalHappinessModifier(0.75);
    	setAnimalHealthinessModifier(0.9);
    	setCropList(new ArrayList<Crops>());
    	setAnimalList(new ArrayList<Animals>());
    	setItemList(new ArrayList<Item>());
    	setMaxCropCapacity(5);
    	setMaxAnimalCapacity(10);
    	setDeductHappinessRate(.8);
    	setDeductHealthinessRate(.8);
	}

}


