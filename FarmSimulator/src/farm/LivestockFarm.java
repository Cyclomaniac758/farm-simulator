package farm;

import java.util.ArrayList;

import crops.*;
import animals.*;
import money.*;
import items.*;

/**
 * Class LivestockFarm extends Farm
 * @author Michael Peters
 *
 */
public class LivestockFarm extends Farm {
	/**
	 * Constructor of LivestockFarm Class
	 * @param name Name of the farm
	 */
	public LivestockFarm(String name) {
		setFarmName(name);
    	setFarmMoney(new Money(1500));
    	setFarmType("Livestock");
    	setGrowingSpeedModifier(2);
    	setAnimalHappinessModifier(1.0);
    	setAnimalHealthinessModifier(1.0);
    	setCropList(new ArrayList<Crops>());
    	setAnimalList(new ArrayList<Animals>());
    	setItemList(new ArrayList<Item>());
    	setMaxCropCapacity(3);
    	setMaxAnimalCapacity(15);
    	setDeductHappinessRate(.8);
    	setDeductHealthinessRate(.8);
	}

}
