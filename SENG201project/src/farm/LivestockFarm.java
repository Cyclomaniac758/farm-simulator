package farm;

import java.util.ArrayList;

import crops.*;
import animals.*;
import money.*;

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
    	setAnimalHappinessModifier(1.0f);
    	setAnimalHealthinessModifier(1.0f);
    	setCropList(new ArrayList<Crops>());
    	setAnimalList(new ArrayList<Animals>());
    	setMaxCropCapacity(10);
    	setMaxAnimalCapacity(15);
	}

}