package farm;

import java.util.ArrayList;

import crops.*;
import animals.*;
import money.*;
import items.*;

/**
 * Class CropFarm extends Farm
 * @author Michael Peters
 *
 */
public class CropFarm extends Farm {
	/**
	 * Constructor of OrchardFarm class
	 * @param name Name of the farm
	 */
	public CropFarm(String name) {
		setFarmName(name);
	    setFarmMoney(new Money(1500));
	    setFarmType("Crop");
	    setGrowingSpeedModifier(1);
	    setAnimalHappinessModifier(1.2);
	    setAnimalHealthinessModifier(1.0);
	    setCropList(new ArrayList<Crops>());
	    setAnimalList(new ArrayList<Animals>());
	    setItemList(new ArrayList<Item>());
    	setMaxCropCapacity(10);
    	setMaxAnimalCapacity(5);
    	setDeductHappinessRate(.8);
    	setDeductHealthinessRate(.8);
	}


}