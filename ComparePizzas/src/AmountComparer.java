import java.util.*;

class AmountComparer {
	public static int comparePizzas(Pizza firstPizza, Pizza secondPizza) {
		double firstPizzaPricePerUnit = firstPizza.getPrice() / firstPizza.getArea();
		double secondPizzaPricePerUnit = secondPizza.getPrice() / secondPizza.getArea();

		// result is -1 if the first pizza is better value, 1 if the second pizza is
		// better value, and 0 if they are equal value
		int result = Double.compare(firstPizzaPricePerUnit, secondPizzaPricePerUnit);
		return result;

	}

	public static int getPizzaDiameterFromUser(String pizza) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter the diameter of the %s pizza please!: ", pizza);
		int diameter = sc.nextInt();
		return diameter;
	}

	public static double getPizzaPriceFromUser(String pizza) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter the price of the %s pizza please!: ", pizza);
		double price = sc.nextDouble();
		return price;
	}

	public static Pizza createPizzaFromUserInput(String pizzaSequenceNum) {
		Pizza pizza = new Pizza();
		int pizzaDiameter = getPizzaDiameterFromUser(pizzaSequenceNum);
		while (pizzaDiameter < 0) {
			System.out.printf("The diameter of a pizza cannot be smaller than 0! ");
			pizzaDiameter = getPizzaDiameterFromUser(pizzaSequenceNum);
		}

		double pizzaPrice = getPizzaPriceFromUser(pizzaSequenceNum);
		while (pizzaPrice < 0) {
			System.out.printf("The price of a pizza cannot be less than 0! ");
			pizzaPrice = getPizzaPriceFromUser(pizzaSequenceNum);
		}
		pizza.setDiameterAndPrice(pizzaDiameter, pizzaPrice);
		return pizza;

	}

	public static void main(String[] args) {
		Pizza firstPizza = createPizzaFromUserInput("first");
		Pizza secondPizza = createPizzaFromUserInput("second");

		int result = comparePizzas(firstPizza, secondPizza);
		if (result == -1) {
			System.out.println("The first pizza is better value");
		} else if (result == 1) {
			System.out.println("The second pizza is better value");
		} else {
			System.out.println("They are the same value - choose the one you prefer!");
		}
	}

}