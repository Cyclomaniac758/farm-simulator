package farm;

import java.util.ArrayList;

import crops.*;
import animals.*;
import money.*;
import items.*;

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
	    setAnimalHappinessModifier(1.2);
	    setAnimalHealthinessModifier(1.0);
	    setCropList(new ArrayList<Crops>());
	    setAnimalList(new ArrayList<Animals>());
	    setItemList(new ArrayList<item>());
    	setMaxCropCapacity(30);
    	setMaxAnimalCapacity(5);
	}


}