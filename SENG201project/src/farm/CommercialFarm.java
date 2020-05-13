package farm;

import java.util.ArrayList;

import animals.*;
import crops.*;
import money.*;

/**
 * Class CommercialFarm extends Farm
 * @author Michael Peters
 *
 */
public class CommercialFarm extends Farm {
	
	/**
	 * Constructor of CommercialFarm class
	 * @param name
	 */
	public CommercialFarm(String name) {
		setFarmName(name);
		setFarmMoney(new Money(3000));
		setFarmType("Commercial");
    	setGrowingSpeedModifier(1);
    	setAnimalHappinessModifier(0.75f);
    	setAnimalHealthinessModifier(0.9f);
    	setCropList(new ArrayList<Crops>());
    	setAnimalList(new ArrayList<Animals>());
    	setMaxCropCapacity(20);
    	setMaxAnimalCapacity(10);
	}

}
