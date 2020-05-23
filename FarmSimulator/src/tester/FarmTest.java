package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import farm.*;
import crops.*;
import animals.*;
import money.*;
import farmer.*;
import items.*;

class FarmTest {

	@Test
	public void getNameTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		assertEquals("Pakarikari", testFamilyFarm.getFarmName());
	}
	
	@Test
	public void getTypeTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		assertEquals("Family", testFamilyFarm.getFarmType());
	}
	
	@Test
	public void getFarmMoneyTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		assertEquals(1500, testFamilyFarm.getFarmMoney().getMoneyAmount());
	}
	
	@Test
	public void getGrowingSpeedModifierTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		assertEquals(2, testFamilyFarm.getGrowingSpeedModifier());
	}
	
	@Test
	public void getAnimalHappinessModifierTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		assertEquals(1.5, testFamilyFarm.getAnimalHappinessModifier());
	}
	
	@Test
	public void getAnimalHealthinessModifierTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		assertEquals(1.0, testFamilyFarm.getAnimalHealthinessModifier());
	}
	
	@Test
	public void getAndSetFarmerTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		Farmer testFarmer = new Farmer("Michael", 19, testFamilyFarm);
		testFamilyFarm.setFarmer(testFarmer);
		
		assertEquals(testFarmer, testFamilyFarm.getFarmer());	
	}
	
	@Test
	public void getCropListTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.addCrop(new Wheat());
		testFamilyFarm.addCrop(new Wheat());
		
	}
	
	@Test
	public void getAnimalListTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.addAnimal(new Pig());
		testFamilyFarm.addAnimal(new Pig());
		
	}
	
	@Test
	public void getCropToolListTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.addItem(new Incubator());
		testFamilyFarm.addItem(new Fertilizer());
		
	}
	
	@Test
	public void getFoodListTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.addItem(new Grain());
		testFamilyFarm.addItem(new GrowthHormone());
		
	}
	
	@Test
	public void getMaxCropCapacityTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		assertEquals(18, testFamilyFarm.getMaxCropCapacity());
	}
	
	@Test
	public void getMaxAnimalCapacityTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		assertEquals(6, testFamilyFarm.getMaxAnimalCapacity());
	}
	
	@Test
	public void setFarmNameTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.setFarmName("New name");
		
		assertEquals("New name", testFamilyFarm.getFarmName());
	}
	
	@Test
	public void setFarmMoneyTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.setFarmMoney(new Money(500));
		
		assertEquals(500, testFamilyFarm.getFarmMoney().getMoneyAmount());
	}
	
	@Test
	public void setGrowingSpeedModifierSpeed() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.setGrowingSpeedModifier(10);
		
		assertEquals(10, testFamilyFarm.getGrowingSpeedModifier());
	}
	
	@Test
	public void setAnimalHappinessModifierTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.setAnimalHappinessModifier(0.5);
		
		assertEquals(0.5, testFamilyFarm.getAnimalHappinessModifier());
	}
	
	@Test
	public void setAnimalHealthinessModifierTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.setAnimalHealthinessModifier(0.5);
		
		assertEquals(0.5, testFamilyFarm.getAnimalHealthinessModifier());
	}
	
	@Test 
	public void setCropListTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		
		
	}
	
	@Test
	public void setAnimalListTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		
		
	}
	
	@Test
	public void setItemListTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		
		
	}
	
	@Test
	public void setMaxCropCapacityTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.setMaxCropCapacity(20);
		
		assertEquals(20, testFamilyFarm.getMaxCropCapacity());
	}
	
	@Test
	public void setMaxAnimalCapacityTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.setMaxAnimalCapacity(20);
		
		assertEquals(20, testFamilyFarm.getMaxAnimalCapacity());
	}
	
	@Test
	public void addCropTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.addCrop(new Wheat());
		
		assertEquals(1480, testFamilyFarm.getFarmMoney().getMoneyAmount());
		assertEquals(1, testFamilyFarm.getCropList().size());
		assertEquals("Wheat", testFamilyFarm.getCropList().get(0).getCropName());
		assertEquals(3, testFamilyFarm.getCropList().get(0).getGrowTime());
	}
	
	@Test
	public void minusCropTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.addCrop(new Wheat());
		assertEquals(1, testFamilyFarm.getCropList().size());
		
		testFamilyFarm.minusCrop(testFamilyFarm.getCropList().get(0));
		
		assertEquals(1505, testFamilyFarm.getFarmMoney().getMoneyAmount());
		assertEquals(0, testFamilyFarm.getCropList().size());
		
	}
	
	@Test
	public void addAnimalTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.addAnimal(new Cow());
		
		assertEquals(1300, testFamilyFarm.getFarmMoney().getMoneyAmount());
		assertEquals(1, testFamilyFarm.getAnimalList().size());
		assertEquals("Cow", testFamilyFarm.getAnimalList().get(0).getAnimalName());
		assertEquals(120, testFamilyFarm.getAnimalList().get(0).getDailyEarnings());
	}
	
	@Test
	public void addItemTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.addItem(new Fertilizer());
		testFamilyFarm.addItem(new Fertilizer());
		testFamilyFarm.addItem(new Grain());
		
		assertEquals(3, testFamilyFarm.getItemList().size());
		assertEquals(2, testFamilyFarm.getCropToolList().size());
		assertEquals(1, testFamilyFarm.getFoodList().size());
		
		assertEquals(1280, testFamilyFarm.getFarmMoney().getMoneyAmount());
	}
	
	@Test
	public void removeItemTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.addItem(new Incubator());
		testFamilyFarm.addItem(new Fertilizer());
		testFamilyFarm.addItem(new Grain());
		
		assertEquals(3, testFamilyFarm.getItemList().size());
		assertEquals(2, testFamilyFarm.getCropToolList().size());
		assertEquals(1, testFamilyFarm.getFoodList().size());
		
		testFamilyFarm.removeItem(testFamilyFarm.getItemList().get(0));
		
		assertEquals(2, testFamilyFarm.getItemList().size());
		assertEquals(1, testFamilyFarm.getCropToolList().size());
		assertEquals(1, testFamilyFarm.getFoodList().size());
		
		testFamilyFarm.removeItem(testFamilyFarm.getItemList().get(1));
		
		assertEquals(1, testFamilyFarm.getItemList().size());
		assertEquals(1, testFamilyFarm.getCropToolList().size());
		assertEquals(0, testFamilyFarm.getFoodList().size());
		
	}
	
	@Test
	public void addAnimalEarningsTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.addAnimal(new Cow());
		
		assertEquals(1300, testFamilyFarm.getFarmMoney().getMoneyAmount());
		assertEquals(1, testFamilyFarm.getAnimalList().size());
		assertEquals("Cow", testFamilyFarm.getAnimalList().get(0).getAnimalName());
		assertEquals(120, testFamilyFarm.getAnimalList().get(0).getDailyEarnings());
		
		testFamilyFarm.addAnimalEarnings();
		assertEquals(1420, testFamilyFarm.getFarmMoney().getMoneyAmount());
		
	}
	
	@Test
	public void deductAnimalHealthinessTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.addAnimal(new Cow());
		
		assertEquals(1300, testFamilyFarm.getFarmMoney().getMoneyAmount());
		assertEquals(1, testFamilyFarm.getAnimalList().size());
		assertEquals("Cow", testFamilyFarm.getAnimalList().get(0).getAnimalName());
		assertEquals(120, testFamilyFarm.getAnimalList().get(0).getDailyEarnings());
		
		testFamilyFarm.deductAnimalHealthiness();
		
		assertEquals(0.8, testFamilyFarm.getAnimalList().get(0).getHealthiness());
		assertEquals(96, testFamilyFarm.getAnimalList().get(0).getDailyEarnings());
	}
	
	@Test
	public void deductAnimalHappinessTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.addAnimal(new Cow());
		
		assertEquals(1300, testFamilyFarm.getFarmMoney().getMoneyAmount());
		assertEquals(1, testFamilyFarm.getAnimalList().size());
		assertEquals("Cow", testFamilyFarm.getAnimalList().get(0).getAnimalName());
		assertEquals(120, testFamilyFarm.getAnimalList().get(0).getDailyEarnings());
		
		testFamilyFarm.deductAnimalHappiness();
		
		assertEquals(0.9, testFamilyFarm.getAnimalList().get(0).getHappinessLevel());
		assertEquals(108, testFamilyFarm.getAnimalList().get(0).getDailyEarnings());
	}
	
	@Test
	public void progressGrowthTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.addCrop(new Wheat());
		
		assertEquals(3, testFamilyFarm.getCropList().get(0).getGrowTime());
		testFamilyFarm.progressGrowth();
		testFamilyFarm.progressGrowth();
		assertEquals(1, testFamilyFarm.getCropList().get(0).getGrowTime());
		testFamilyFarm.progressGrowth();
		assertEquals(0, testFamilyFarm.getCropList().get(0).getGrowTime());
		testFamilyFarm.progressGrowth();
		assertEquals(0, testFamilyFarm.getCropList().get(0).getGrowTime());
	}
	
	
}