package farm;

import java.util.ArrayList;
import java.util.Arrays;

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
	    setAnimalHappinessModifier(1f);
	    setCropList(new ArrayList<Crops>(Arrays.asList(new AppleTree(), new Carrots(), new Corn(), new LemonTree(), new Tomatoes(), new Wheat())));
	    setAnimalList(new ArrayList<Animals>(Arrays.asList(new Chicken(), new Cow(), new Pig())));
	}


}