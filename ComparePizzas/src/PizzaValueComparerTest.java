import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class PizzaValueComparerTest {

	Pizza firstPizza;
	Pizza secondPizza;

	@Test
	void test_createPizzaAndSetDiameterAndPrice_pizzaIsCreatedWithDiameterAndPrice() {
		Pizza pizza = new Pizza(10, InputHandler.UnitOfMeasurement.CM, 13.99);
		assertTrue(pizza != null);

		assertEquals(pizza.getDiameter(), 10);
		assertEquals(pizza.getPrice(), 13.99);
	}

	@Test
	void test_comparePizzas_sameDiameterAndDifferentPrice_cheaperIsReturned() throws Exception {
		Pizza firstPizza = new Pizza(10, InputHandler.UnitOfMeasurement.CM, 11.99);
		Pizza secondPizza = new Pizza(10, InputHandler.UnitOfMeasurement.CM, 8.99);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.SECOND_IS_BETTER);
	}

	@Test
	void test_comparePizzas_differentDiameterAndSamePrice_biggerIsReturned() throws Exception {
		Pizza firstPizza = new Pizza(15, InputHandler.UnitOfMeasurement.CM, 10.00);
		Pizza secondPizza = new Pizza(10, InputHandler.UnitOfMeasurement.CM, 10.00);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.FIRST_IS_BETTER);
	}

	@Test
	void test_comparePizzas_sameDiameterAndSamePrice_equalValue() throws Exception {
		Pizza firstPizza = new Pizza(15, InputHandler.UnitOfMeasurement.CM, 10.00);
		Pizza secondPizza = new Pizza(15, InputHandler.UnitOfMeasurement.CM, 10.00);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.EQUAL_VALUES);

	}

	@Test
	void test_comparePizzas_differentDiameterAndDifferentPrice_betterValueIsReturned() throws Exception {
		Pizza firstPizza = new Pizza(10, InputHandler.UnitOfMeasurement.CM, 20.00);
		Pizza secondPizza = new Pizza(15, InputHandler.UnitOfMeasurement.CM, 21.00);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.SECOND_IS_BETTER);

	}

	@Test
	void test_comparePizzas_differentDiameterAndDifferentPrice_equalValue() throws Exception {
		Pizza firstPizza = new Pizza(2, InputHandler.UnitOfMeasurement.CM, 2 * Math.PI);
		Pizza secondPizza = new Pizza(4, InputHandler.UnitOfMeasurement.CM, 8 * Math.PI);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.EQUAL_VALUES);

	}

	@Test
	void test_comparePizzas_sameDiameterAndPrice_differentUnitOfMeasurement_inchIsBetterValue() throws Exception {
		Pizza firstPizza = new Pizza(3, InputHandler.UnitOfMeasurement.CM, 3);
		Pizza secondPizza = new Pizza(3, InputHandler.UnitOfMeasurement.INCH, 3);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.SECOND_IS_BETTER);
	}

	@Test
	void test_comparePizzas_sameDiameterAndDifferentPrice_differentUnitOfMeasurement_equalValue() throws Exception {
		Pizza firstPizza = new Pizza(4, InputHandler.UnitOfMeasurement.CM, 3);
		Pizza secondPizza = new Pizza(4, InputHandler.UnitOfMeasurement.INCH, 3 * 2.54 * 2.54);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.EQUAL_VALUES);
	}

}