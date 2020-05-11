package farm;

import java.util.ArrayList;
import java.util.Arrays;

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
	 * Constructor of LivestockFarmClass
	 * @param name
	 */
	public LivestockFarm(String name) {
		setFarmName(name);
    	setFarmMoney(new Money(2500));
    	setFarmType("Livestock");
    	setGrowingSpeed(2);
    	setAnimalHappiness(1.0f);
    	setCropList(new ArrayList<Crops>());
    	setAnimalList(new ArrayList<Animals>());
	}

}