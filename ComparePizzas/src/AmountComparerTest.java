import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AmountComparerTest {

	@Test
	void test_createPizzaAndSetDiameterAndPrice_pizzaIsCreatedWithDiameterAndPrice() {
		Pizza pizza = new Pizza();
		assertTrue(pizza != null);

		pizza.setDiameterAndPrice(10, 13.99);

		int pizzaDiameter = pizza.getDiameter();
		double pizzaPrice = pizza.getPrice();

		assertEquals(pizzaDiameter, 10);
		assertEquals(pizzaPrice, 13.99);
	}

	@Test
	void test_comparePizzas_sameDiameterAndDifferentPrice_cheaperIsReturned() {
		Pizza firstPizza = new Pizza();
		firstPizza.setDiameterAndPrice(10, 11.99);

		Pizza secondPizza = new Pizza();
		secondPizza.setDiameterAndPrice(10, 8.99);

		int result = AmountComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, 1); // 1 means that the second pizza is better value
	}

	@Test
	void test_comparePizzas_differentDiameterAndSamePrice_biggerIsReturned() {
		Pizza firstPizza = new Pizza();
		firstPizza.setDiameterAndPrice(15, 10.00);

		Pizza secondPizza = new Pizza();
		secondPizza.setDiameterAndPrice(10, 10.00);

		int result = AmountComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, -1); // -1 means that the first pizza is better value
	}

	@Test
	void test_comparePizzas_sameDiameterAndSamePrice_equalValue() {
		Pizza firstPizza = new Pizza();
		firstPizza.setDiameterAndPrice(15, 10.00);

		Pizza secondPizza = new Pizza();
		secondPizza.setDiameterAndPrice(15, 10.00);

		int result = AmountComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, 0); // 0 means that they are of equal value

	}
}