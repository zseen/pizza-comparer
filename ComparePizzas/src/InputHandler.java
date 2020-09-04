import java.util.Scanner;

public class InputHandler {
	public Scanner sc = new Scanner(System.in);

	public Pizza createPizzaFromUserInput(String pizzaSequenceNum) {
		Pizza pizza = new Pizza();
		double pizzaDiameter = getPizzaAttributeFromUser(pizzaSequenceNum, "diameter");
		while (pizzaDiameter < 0) {
			System.out.printf("The diameter of a pizza cannot be smaller than 0! ");
			pizzaDiameter = getPizzaAttributeFromUser(pizzaSequenceNum, "diameter");
		}

		double pizzaPrice = getPizzaAttributeFromUser(pizzaSequenceNum, "price");
		while (pizzaPrice < 0) {
			System.out.printf("The price of a pizza cannot be less than 0! ");
			pizzaPrice = getPizzaAttributeFromUser(pizzaSequenceNum, "price");
		}

		pizza.setDiameter(pizzaDiameter);
		pizza.setPrice(pizzaPrice);
		return pizza;

	}

	private double getPizzaAttributeFromUser(String pizzaSequence, String attributeName) {
		System.out.printf("Enter the %s of the %s pizza please!: ", attributeName, pizzaSequence);

		while (!sc.hasNextDouble()) {
			System.out.printf("The %s should be a number! Enter the %s of the %s pizza please!: ", attributeName, attributeName, pizzaSequence);
			sc.next();
		}

		double attribute = sc.nextDouble();
		return attribute;

	}

}
