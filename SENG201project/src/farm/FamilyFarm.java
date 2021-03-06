package farm;

import java.util.ArrayList;
import animals.*;
import crops.*;
import money.*;

/**
 * Class FamilyFarm extends Farm
 * @author Michael Peters
 *
 */
public class FamilyFarm extends Farm {
	/**
	 * Constructor of FamilyFarm Class
	 * @param name
	 */
	public FamilyFarm(String name) {
		setFarmName(name);
		setFarmMoney(new Money(1500));
		setFarmType("Family");
		setGrowingSpeedModifier(2);
		setAnimalHappinessModifier(1.5f);
		setAnimalHealthinessModifier(1.0f);
		setCropList(new ArrayList<Crops>());
		setAnimalList(new ArrayList<Animals>());
    	setMaxCropCapacity(18);
    	setMaxAnimalCapacity(6);
	}

}
