package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import farmer.*;
import farm.*;
import animals.*;
import crops.*;
import items.*;

class FarmerTest {

	@Test
	public void getNameTest() {
		CropFarm testCropFarm = new CropFarm("My Crop Farm");
		Farmer testFarmer = new Farmer("Michael", 19, testCropFarm);
		assertEquals("Michael", testFarmer.getName());
	}
	
	@Test
	public void setNameTest() {
		CropFarm testCropFarm = new CropFarm("My Crop Farm");
		Farmer testFarmer = new Farmer("Michael", 19, testCropFarm);
		testFarmer.setName("Ronan");
		assertEquals("Ronan", testFarmer.getName());
	}
	
	@Test
	public void getnumActionsTest() {
		CropFarm testCropFarm = new CropFarm("My Crop Farm");
		Farmer testFarmer = new Farmer("Michael", 19, testCropFarm);
		assertEquals(2, testFarmer.getNumActions());
	}
	
	@Test
	public void deductActionsTest() {
		CropFarm testCropFarm = new CropFarm("My Crop Farm");
		Farmer testFarmer = new Farmer("Michael", 19, testCropFarm);
		testFarmer.deductAction();
		assertEquals(1, testFarmer.getNumActions());
		
		testFarmer.deductAction();
		assertEquals(0, testFarmer.getNumActions());
	}
	
	@Test
	public void restoreActionsTest() {
		CropFarm testCropFarm = new CropFarm("My Crop Farm");
		Farmer testFarmer = new Farmer("Michael", 19, testCropFarm);
		testFarmer.deductAction();
		testFarmer.deductAction();
		assertEquals(0, testFarmer.getNumActions());

		testFarmer.restoreActions();
		assertEquals(2, testFarmer.getNumActions());
		testFarmer.deductAction();
		assertEquals(1, testFarmer.getNumActions());
	}
	
	@Test
	public void playWithAnimalsNoneTest() {
		CropFarm testCropFarm = new CropFarm("My Crop Farm");
		Farmer testFarmer = new Farmer("Michael", 19, testCropFarm);
		testFarmer.playWithAnimals();
		assertEquals(2, testFarmer.getNumActions());
	}
	
	@Test
	public void playWithAnimalsTest() {
		CropFarm testCropFarm = new CropFarm("My Crop Farm");
		Farmer testFarmer = new Farmer("Michael", 19, testCropFarm);
		testCropFarm.addAnimal(new Pig());
		testCropFarm.getAnimalList().get(0).setHappinessLevel(0.5);
		
		testFarmer.playWithAnimals();
		assertEquals(1, testFarmer.getNumActions());
		assertEquals(0.55, testCropFarm.getAnimalList().get(0).getHappinessLevel());
		
		testFarmer.playWithAnimals();
		assertEquals(0, testFarmer.getNumActions());
		assertEquals(0.55*1.1, testCropFarm.getAnimalList().get(0).getHappinessLevel());
	}
	
	@Test
	public void maxAnimalHappinessTest() {
		CropFarm testCropFarm = new CropFarm("My Crop Farm");
		Farmer testFarmer = new Farmer("Michael", 19, testCropFarm);
		testCropFarm.addAnimal(new Pig());
		testCropFarm.getAnimalList().get(0).setHappinessLevel(0.5);
		
		assertEquals(1, testCropFarm.getAnimalList().get(0).getHappinessLevel());
	}
	
	@Test
	public void tendLandTest() {
		CropFarm testCropFarm = new CropFarm("My Crop Farm");
		Farmer testFarmer = new Farmer("Michael", 19, testCropFarm);
		testCropFarm.addAnimal(new Pig());
		
		testFarmer.tendLand();
		
		assertEquals(31, testCropFarm.getMaxCropCapacity());
		assertEquals(.9, testCropFarm.getDeductHappinessRate());
	}
	
	@Test
	public void useFoodTest() {
		CropFarm testCropFarm = new CropFarm("My Crop Farm");
		Farmer testFarmer = new Farmer("Michael", 19, testCropFarm);
		testCropFarm.addAnimal(new Pig());
		testCropFarm.addItem(new Grain());
		
		assertEquals(1830.0, testCropFarm.getFarmMoney().getMoneyAmount());
		assertEquals(1, testCropFarm.getAnimalList().size());
		assertEquals(1, testCropFarm.getFoodList().size());
		
		testCropFarm.getAnimalList().get(0).setHealthiness(0.5);
		testFarmer.useFood(testCropFarm.getFoodList().get(0), testCropFarm.getAnimalList().get(0));
		
		assertEquals(0.7, testCropFarm.getAnimalList().get(0).getHealthiness());
		assertEquals(true, testCropFarm.getFoodList().isEmpty());
		assertEquals(1, testFarmer.getNumActions());
	}
	
	@Test
	public void harvestCropTest() {
		CropFarm testCropFarm = new CropFarm("My Crop Farm");
		Farmer testFarmer = new Farmer("Michael", 19, testCropFarm);
		testCropFarm.addCrop(new Wheat());
		assertEquals(1980.0, testCropFarm.getFarmMoney().getMoneyAmount());
		
		testCropFarm.getCropList().get(0).setGrowTime(0);
		testFarmer.harvestCrop(testCropFarm.getCropList().get(0));
		assertEquals(0, testCropFarm.getCropList().size());
		assertEquals(1, testFarmer.getNumActions());
		assertEquals(2005.0, testCropFarm.getFarmMoney().getMoneyAmount());
	}
	
	@Test 
	public void useCropToolLargerImpactThanGrowTimeTest() {
		CropFarm testCropFarm = new CropFarm("My Crop Farm");
		Farmer testFarmer = new Farmer("Michael", 19, testCropFarm);
		testCropFarm.addCrop(new Wheat());
		testCropFarm.addItem(new Fertilizer());
		
		assertEquals(1880.0, testCropFarm.getFarmMoney().getMoneyAmount());
		assertEquals(1, testCropFarm.getCropList().size());
		assertEquals(1, testCropFarm.getCropToolList().size());
		assertEquals(2, testCropFarm.getCropList().get(0).getGrowTime());
		
		testFarmer.useCropTool(testCropFarm.getCropToolList().get(0), testCropFarm.getCropList().get(0));
		
		assertEquals(0, testCropFarm.getCropList().get(0).getGrowTime());
		assertEquals(true, testCropFarm.getCropToolList().isEmpty());
		assertEquals(1, testFarmer.getNumActions());
	}
	
	@Test
	public void useCropToolSmallerImpactThanGrowTimeTest() {
		CropFarm testCropFarm = new CropFarm("My Crop Farm");
		Farmer testFarmer = new Farmer("Michael", 19, testCropFarm);
		testCropFarm.addCrop(new AppleTree());
		testCropFarm.addItem(new Fertilizer());
		
		assertEquals(1700.0, testCropFarm.getFarmMoney().getMoneyAmount());
		assertEquals(1, testCropFarm.getCropList().size());
		assertEquals(1, testCropFarm.getCropToolList().size());
		assertEquals(4, testCropFarm.getCropList().get(0).getGrowTime());
		
		testFarmer.useCropTool(testCropFarm.getCropToolList().get(0), testCropFarm.getCropList().get(0));
		
		assertEquals(1, testCropFarm.getCropList().get(0).getGrowTime());
		assertEquals(true, testCropFarm.getCropToolList().isEmpty());
		assertEquals(1, testFarmer.getNumActions());
	}

}
