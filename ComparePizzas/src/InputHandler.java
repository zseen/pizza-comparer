import java.util.Scanner;

public class InputHandler {

	public Scanner sc = new Scanner(System.in);
	public Pizza.UnitOfMeasurement unitOfMeasurement = null;
	public Double diameter = null;

	public void getDiameterDataFromUser(String pizzaSequenceNumWord) {
		this.diameter = null;
		this.unitOfMeasurement = null;

		while (this.diameter == null || this.diameter <= 0) {
			try {
				System.out.printf("Enter the diameter of the %s pizza please:  ", pizzaSequenceNumWord);
				String word = sc.next();
				this.diameter = Double.parseDouble(word);
				if (this.diameter <= 0) {
					System.out.println("The diameter should be greater than 0!");
				}
			} catch (NumberFormatException e) {
				System.out.printf("The diameter should be a number!");
			}
		}

		String potentialUnitOfMeasurement = null;
		while (!isUnitOfMeasurementValid(potentialUnitOfMeasurement)) {
			System.out.printf("Enter the unit of measurement (cm or inch) for the %s pizza please:  ",
					pizzaSequenceNumWord);
			potentialUnitOfMeasurement = sc.next();

		}

		this.unitOfMeasurement = convertUnitOfMeasurementStringToEnum(potentialUnitOfMeasurement);

	}

	public Pizza createPizzaFromUserInput(String pizzaSequenceNum) {
		this.getDiameterDataFromUser(pizzaSequenceNum);
		double pizzaPrice = getPizzaAttributeFromUser(pizzaSequenceNum, "price");

		Pizza pizza = new Pizza(this.diameter, pizzaPrice, this.unitOfMeasurement);
		return pizza;

	}

	private double getPizzaAttributeFromUser(String pizzaSequence, String attributeName) {
		while (true) {
			System.out.printf("Enter the %s of the %s pizza please!: ", attributeName, pizzaSequence);

			if (!sc.hasNextDouble()) {
				System.out.printf("The %s should be a number!\n", attributeName);
				sc.next();
				continue;
			}

			double attribute = sc.nextDouble();
			if (attribute < 0) {
				System.out.printf("The %s should be a number greater than 0!\n", attributeName);
			} else {
				return attribute;
			}
		}
	}

	private static boolean isUnitOfMeasurementValid(String unitOfMeasurement) {
		if (unitOfMeasurement == null) {
			return false;
		}

		if (unitOfMeasurement.equals(Pizza.UnitOfMeasurement.CM.measurement)
				|| unitOfMeasurement.equals(Pizza.UnitOfMeasurement.INCH.measurement)) {
			return true;
		}

		return false;

	}

	private static Pizza.UnitOfMeasurement convertUnitOfMeasurementStringToEnum(String unitOfMeasurement)
			throws RuntimeException {
		if (unitOfMeasurement.equals(Pizza.UnitOfMeasurement.CM.measurement)) {
			return Pizza.UnitOfMeasurement.CM;
		} else if (unitOfMeasurement.equals(Pizza.UnitOfMeasurement.INCH.measurement)) {
			return Pizza.UnitOfMeasurement.INCH;
		}
		throw new RuntimeException("Problem with unit of measurement.");
	}
}
