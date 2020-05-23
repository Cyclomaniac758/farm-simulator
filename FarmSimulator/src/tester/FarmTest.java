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
	
	public void getAnimalListTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.addAnimal(new Pig());
		testFamilyFarm.addAnimal(new Pig());
		
	}
	
	public void getCropToolListTest() {
		FamilyFarm testFamilyFarm = new FamilyFarm("Pakarikari");
		testFamilyFarm.addItem(new Incubator());
		testFamilyFarm.addItem(new Fertilizer());
		
	}
	
}