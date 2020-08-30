import java.util.Scanner;

public class InputHandler {
	public Scanner sc = new Scanner(System.in);

	public Pizza createPizzaFromUserInput(String pizzaSequenceNum) {
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

		pizza.setDiameter(pizzaDiameter);
		pizza.setPrice(pizzaPrice);
		return pizza;

	}

	private int getPizzaDiameterFromUser(String pizzaSequence) {
		System.out.printf("Enter the diameter of the %s pizza please!: ", pizzaSequence);
		if (sc.hasNextInt()) {
			int diameter = sc.nextInt();
			return diameter;
		} else {
			return getPizzaDiameterFromUser(pizzaSequence);
		}
	}

	private double getPizzaPriceFromUser(String pizzaSequence) {
		System.out.printf("Enter the price of the %s pizza please!: ", pizzaSequence);
		if (sc.hasNextDouble()) {
			double price = sc.nextInt();
			return price;
		} else {
			return getPizzaPriceFromUser(pizzaSequence);
		}
	}

}
