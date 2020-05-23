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
	 * @param name
	 */
	public LivestockFarm(String name) {
		setFarmName(name);
    	setFarmMoney(new Money(2500));
    	setFarmType("Livestock");
    	setGrowingSpeedModifier(2);
    	setAnimalHappinessModifier(1.0);
    	setAnimalHealthinessModifier(1.0);
    	setCropList(new ArrayList<Crops>());
    	setAnimalList(new ArrayList<Animals>());
    	setItemList(new ArrayList<Item>());
    	setMaxCropCapacity(10);
    	setMaxAnimalCapacity(15);
    	setDeductHappinessRate(.8);
    	setDeductHealthinessRate(.8);
	}

}
