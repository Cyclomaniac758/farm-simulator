package farm;

import java.util.ArrayList;

import crops.*;
import animals.*;
import money.*;

/**
 * Class OrchardFarm extends Farm
 * @author Michael Peters
 *
 */
public class OrchardFarm extends Farm {
	/**
	 * Constructor of OrchardFarm class
	 * @param name
	 */
	public OrchardFarm(String name) {
		setFarmName(name);
	    setFarmMoney(new Money(2000));
	    setFarmType("Orchard");
	    setGrowingSpeedModifier(1);
	    setAnimalHappinessModifier(1.2f);
	    setAnimalHealthinessModifier(1.0f);
	    setCropList(new ArrayList<Crops>());
	    setAnimalList(new ArrayList<Animals>());
    	setMaxCropCapacity(30);
    	setMaxAnimalCapacity(5);
	}


}
