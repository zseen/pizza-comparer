import java.util.Scanner;

public class InputHandler {
	public static Pizza createPizzaFromUserInput(String pizzaSequenceNum) {
		Pizza pizza = new Pizza();
		double pizzaDiameter = getPizzaDiameterFromUser(pizzaSequenceNum);
		while (pizzaDiameter < 0) {
			System.out.printf("The diameter of a pizza cannot be smaller than 0! ");
			pizzaDiameter = getPizzaDiameterFromUser(pizzaSequenceNum);
		}

		double pizzaPrice = getPizzaPriceFromUser(pizzaSequenceNum);
		while (pizzaPrice < 0) {
			System.out.printf("The price of a pizza cannot be less than 0! ");
			pizzaPrice = getPizzaPriceFromUser(pizzaSequenceNum);
		}

		pizza.setDiameter(pizzaDiameter);
		pizza.setPrice(pizzaPrice);
		return pizza;

	}

	private static double getPizzaDiameterFromUser(String pizzaSequence) {
		System.out.printf("Enter the diameter of the %s pizza please!: ", pizzaSequence);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		if (sc.hasNextDouble()) {
			double diameter = sc.nextDouble();
			return diameter;
		} else {
			return getPizzaDiameterFromUser(pizzaSequence);
		}

	}

	private static double getPizzaPriceFromUser(String pizzaSequence) {
		System.out.printf("Enter the price of the %s pizza please!: ", pizzaSequence);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		if (sc.hasNextDouble()) {
			double price = sc.nextDouble();
			return price;
		} else {
			return getPizzaPriceFromUser(pizzaSequence);
		}
	}

}
