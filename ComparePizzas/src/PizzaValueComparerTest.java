import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class PizzaValueComparerTest {

	Pizza firstPizza;
	Pizza secondPizza;

	private Pizza.UnitOfMeasurement cm = Pizza.UnitOfMeasurement.CM;
	private Pizza.UnitOfMeasurement inch = Pizza.UnitOfMeasurement.INCH;

	@Test
	void test_createPizzaAndSetDiameterAndPrice_pizzaIsCreatedWithDiameterAndPrice() {
		Pizza pizza = new Pizza(10, 13.99, Pizza.UnitOfMeasurement.CM);
		assertTrue(pizza != null);

		assertEquals(pizza.getDiameter(), 10);
		assertEquals(pizza.getPrice(), 13.99);
	}

	@Test
	void test_comparePizzas_sameDiameterAndDifferentPrice_cheaperIsReturned() throws RuntimeException {
		Pizza firstPizza = new Pizza(10, 11.99, cm);
		Pizza secondPizza = new Pizza(10, 8.99, cm);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.SECOND_IS_BETTER);
	}

	@Test
	void test_comparePizzas_differentDiameterAndSamePrice_biggerIsReturned() throws RuntimeException {
		Pizza firstPizza = new Pizza(15, 10.00, cm);
		Pizza secondPizza = new Pizza(10, 10.00, cm);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.FIRST_IS_BETTER);
	}

	@Test
	void test_comparePizzas_sameDiameterAndSamePrice_equalValue() throws Exception {
		Pizza firstPizza = new Pizza(15, 10.00, cm);
		Pizza secondPizza = new Pizza(15, 10.00, cm);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.EQUAL_VALUES);

	}

	@Test
	void test_comparePizzas_differentDiameterAndDifferentPrice_betterValueIsReturned() throws RuntimeException {
		Pizza firstPizza = new Pizza(10, 20.00, cm);
		Pizza secondPizza = new Pizza(15, 21.00, cm);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.SECOND_IS_BETTER);

	}

	@Test
	void test_comparePizzas_differentDiameterAndDifferentPrice_equalValue() throws RuntimeException {
		Pizza firstPizza = new Pizza(2, 2 * Math.PI, cm);
		Pizza secondPizza = new Pizza(4, 8 * Math.PI, cm);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.EQUAL_VALUES);

	}

	@Test
	void test_comparePizzas_sameDiameterAndPrice_differentUnitOfMeasurement_inchIsBetterValue() throws RuntimeException {
		Pizza firstPizza = new Pizza(3, 3, cm);
		Pizza secondPizza = new Pizza(3, 3, inch);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.SECOND_IS_BETTER);
	}

	@Test
	void test_comparePizzas_sameDiameterAndDifferentPrice_differentUnitOfMeasurement_equalValue() throws RuntimeException {
		Pizza firstPizza = new Pizza(4, 3, cm);
		Pizza secondPizza = new Pizza(4, 3 * 2.54 * 2.54, inch);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.EQUAL_VALUES);
	}

}