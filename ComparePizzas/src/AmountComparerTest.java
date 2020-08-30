import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

		AmountComparer.Values result = AmountComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, AmountComparer.Values.SECOND);
	}

	@Test
	void test_comparePizzas_differentDiameterAndSamePrice_biggerIsReturned() {
		Pizza firstPizza = new Pizza();
		firstPizza.setDiameterAndPrice(15, 10.00);

		Pizza secondPizza = new Pizza();
		secondPizza.setDiameterAndPrice(10, 10.00);

		AmountComparer.Values result = AmountComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, AmountComparer.Values.FIRST);
	}

	@Test
	void test_comparePizzas_sameDiameterAndSamePrice_equalValue() {
		Pizza firstPizza = new Pizza();
		firstPizza.setDiameterAndPrice(15, 10.00);

		Pizza secondPizza = new Pizza();
		secondPizza.setDiameterAndPrice(15, 10.00);

		AmountComparer.Values result = AmountComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, AmountComparer.Values.EQUAL);

	}
}