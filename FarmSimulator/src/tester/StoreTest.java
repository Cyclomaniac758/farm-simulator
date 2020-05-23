package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import farm.*;
import generalStore.*;
import crops.*;
import animals.*;
import items.*;

class StoreTest {
	private GeneralStore store;
	private Farm farm;
	
	@BeforeEach
	void makeStore() {
		farm = new FamilyFarm("Name");
		store = new GeneralStore(farm);
	}
	
	@Test
	void buyCarrotsTest() {
		store.buyCarrots(2);
		assertEquals(2, farm.getCropList().size());
		assertEquals(1470, farm.getFarmMoney().getMoneyAmount());
		assertTrue(farm.getCropList().get(0) instanceof Carrots);
	}
	
	@Test
	void buyPigsTest() {
		store.buyPig(2);
		assertEquals(2, farm.getAnimalList().size());
		assertEquals(1200, farm.getFarmMoney().getMoneyAmount());
		assertTrue(farm.getAnimalList().get(0) instanceof Pig);
	}
	
	@Test
	void buyGrainTest() {
		store.buyGrain(2);
		assertEquals(2, farm.getItemList().size());
		assertEquals(1460, farm.getFarmMoney().getMoneyAmount());
		assertTrue(farm.getItemList().get(0) instanceof Grain);
	}

}
