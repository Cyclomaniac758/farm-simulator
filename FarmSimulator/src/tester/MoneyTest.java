package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import money.*;

class MoneyTest {

	@Test
	public void getMoneyAmountTest() {
		Money testMoney = new Money(200);
		assertEquals(200.0, testMoney.getMoneyAmount());
	}
	
	@Test
	public void setMoneyAmountTest() {
		Money testMoney = new Money(200);
		testMoney.setMoneyAmount(5700);
		assertEquals(5700, testMoney.getMoneyAmount());
	}
	
	@Test
	public void minusMoneyTest() {
		Money testMoney = new Money(200);
		testMoney.minusMoney(50);
		assertEquals(150.0, testMoney.getMoneyAmount());
	}
	
	@Test
	public void addMoneyTest() {
		Money testMoney = new Money(200);
		testMoney.addMoney(75.0);
		assertEquals(275.0, testMoney.getMoneyAmount());
	}
	
	@Test
	public void toStringTest() {
		Money testMoney = new Money(200);
		assertEquals("$200.0", testMoney.toString());
	}
}
