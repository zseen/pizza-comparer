import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class AmountComparerTest {

	@Test
	void test_createPizzaAndSetDiameterAndPrice_pizzaIsCreatedWithDiameterAndPrice() {
		Pizza pizza = new Pizza();
		assertTrue(pizza != null);

		pizza.setDiameter(10);
		pizza.setPrice(13.99);

		assertEquals(pizza.getDiameter(), 10);
		assertEquals(pizza.getPrice(), 13.99);
	}

	@Test
	void test_comparePizzas_sameDiameterAndDifferentPrice_cheaperIsReturned() {
		Pizza firstPizza = new Pizza();
		firstPizza.setDiameter(10);
		firstPizza.setPrice(11.99);

		Pizza secondPizza = new Pizza();
		secondPizza.setDiameter(10);
		secondPizza.setPrice(8.99);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.SECOND_IS_BETTER);
	}

	@Test
	void test_comparePizzas_differentDiameterAndSamePrice_biggerIsReturned() {
		Pizza firstPizza = new Pizza();
		firstPizza.setDiameter(15);
		firstPizza.setPrice(10.00);

		Pizza secondPizza = new Pizza();
		secondPizza.setDiameter(10);
		secondPizza.setPrice(10.00);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.FIRST_IS_BETTER);
	}

	@Test
	void test_comparePizzas_sameDiameterAndSamePrice_equalValue() {
		Pizza firstPizza = new Pizza();
		firstPizza.setDiameter(15);
		firstPizza.setPrice(10.00);

		Pizza secondPizza = new Pizza();
		secondPizza.setDiameter(15);
		secondPizza.setPrice(10.00);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.EQUAL_VALUES);

	}

	@Test
	void test_comparePizzas_differentDiameterAndDifferentPrice_betterValueIsReturned() {
		Pizza firstPizza = new Pizza();
		firstPizza.setDiameter(10);
		firstPizza.setPrice(20);

		Pizza secondPizza = new Pizza();
		secondPizza.setDiameter(15);
		secondPizza.setPrice(21);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.SECOND_IS_BETTER);

	}

	@Test
	void test_comparePizzas_differentDiameterAndDifferentPrice_equalValue() {
		Pizza firstPizza = new Pizza();
		firstPizza.setDiameter(2);
		firstPizza.setPrice(2 * Math.PI);

		Pizza secondPizza = new Pizza();
		secondPizza.setDiameter(4);
		secondPizza.setPrice(8 * Math.PI);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.EQUAL_VALUES);

	}
}