import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PizzaValueComparerTest {

	Pizza firstPizza;
	Pizza secondPizza;

	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("Invoked before each test method");
		firstPizza = new Pizza();
		firstPizza.setDiameterUnitOfMeasurement("cm");

		secondPizza = new Pizza();
		secondPizza.setDiameterUnitOfMeasurement("cm");
	}

	
	  @Test void
	  test_createPizzaAndSetDiameterAndPrice_pizzaIsCreatedWithDiameterAndPrice() {
	  Pizza pizza = new Pizza(); assertTrue(pizza != null);
	  
	  pizza.setDiameter(10); pizza.setPrice(13.99);
	  
	  assertEquals(pizza.getDiameter(), 10); assertEquals(pizza.getPrice(), 13.99);
	  }
	 

	@Test
	void test_comparePizzas_sameDiameterAndDifferentPrice_cheaperIsReturned() throws Exception {
		// Pizza firstPizza = new Pizza();
		firstPizza.setDiameter(10);
		firstPizza.setPrice(11.99);
		System.out.println("why");
		System.out.println(firstPizza.diameterUnitOfMeasurement);

		// Pizza secondPizza = new Pizza();
		secondPizza.setDiameter(10);
		secondPizza.setPrice(8.99);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.SECOND_IS_BETTER);
	}

	@Test
	void test_comparePizzas_differentDiameterAndSamePrice_biggerIsReturned() throws Exception {
		//Pizza firstPizza = new Pizza();
		firstPizza.setDiameter(15);
		firstPizza.setPrice(10.00);

		//Pizza secondPizza = new Pizza();
		secondPizza.setDiameter(10);
		secondPizza.setPrice(10.00);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.FIRST_IS_BETTER);
	}

	@Test
	void test_comparePizzas_sameDiameterAndSamePrice_equalValue() throws Exception {
		//Pizza firstPizza = new Pizza();
		firstPizza.setDiameter(15);
		firstPizza.setPrice(10.00);

		//Pizza secondPizza = new Pizza();
		secondPizza.setDiameter(15);
		secondPizza.setPrice(10.00);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.EQUAL_VALUES);

	}

	@Test
	void test_comparePizzas_differentDiameterAndDifferentPrice_betterValueIsReturned() throws Exception {
		//Pizza firstPizza = new Pizza();
		firstPizza.setDiameter(10);
		firstPizza.setPrice(20);

		//Pizza secondPizza = new Pizza();
		secondPizza.setDiameter(15);
		secondPizza.setPrice(21);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.SECOND_IS_BETTER);

	}

	@Test
	void test_comparePizzas_differentDiameterAndDifferentPrice_equalValue() throws Exception {
		//Pizza firstPizza = new Pizza();
		firstPizza.setDiameter(2);
		firstPizza.setPrice(2 * Math.PI);

		//Pizza secondPizza = new Pizza();
		secondPizza.setDiameter(4);
		secondPizza.setPrice(8 * Math.PI);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizza, secondPizza);
		assertEquals(result, PizzaValueComparer.ComparisonResult.EQUAL_VALUES);

	}

	@Test
	void test_comparePizzas_sameDiameterAndPrice_differentUnitOfMeasurement_inchIsBetterValue() throws Exception {
		Pizza firstPizzaNew = new Pizza();
		firstPizzaNew.setDiameter(3);
		firstPizzaNew.setDiameterUnitOfMeasurement("cm");
		firstPizzaNew.setPrice(3);

		Pizza secondPizzaNew = new Pizza();
		secondPizzaNew.setDiameter(3);
		secondPizzaNew.setDiameterUnitOfMeasurement("inch");
		secondPizzaNew.setPrice(3);

		PizzaValueComparer.ComparisonResult result = PizzaValueComparer.comparePizzas(firstPizzaNew, secondPizzaNew);
		assertEquals(result, PizzaValueComparer.ComparisonResult.SECOND_IS_BETTER);
	}

}