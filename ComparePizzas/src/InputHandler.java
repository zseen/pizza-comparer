import java.util.Scanner;

public class InputHandler {
	public enum UnitOfMeasurement {
		CM("cm"), INCH("inch");

		final String measurement;

		UnitOfMeasurement(String measurement) {
			this.measurement = measurement;
		}

		public String geUnitOfMeasurementName() {
			return this.measurement;
		}
	}

	public Scanner sc = new Scanner(System.in);
	public UnitOfMeasurement unitOfMeasurement = null;
	public Double diameter = null;

	public void getDiameterDataFromUser(String pizzaSequenceNumWord) {
		this.diameter = null;
		this.unitOfMeasurement = null;

		while (this.diameter == null && this.unitOfMeasurement == null) {

			while (this.diameter == null || this.diameter <= 0) {
				try {
					System.out.printf("Enter the diameter of the %s pizza please:  ", pizzaSequenceNumWord);
					String word = sc.next();
					this.diameter = Double.parseDouble(word);
					if (this.diameter <= 0) {
						System.out.println("The diameter should be greater than 0!");
					}
				} catch (NumberFormatException e) {
					System.out.println(e);
				}
			}

			String potentialUoM = null;
			while (potentialUoM == null || !potentialUoM.equals(UnitOfMeasurement.CM.measurement)
					&& !potentialUoM.equals(UnitOfMeasurement.INCH.measurement)) {
				System.out.printf("Enter the unit of measurement (cm or inch) for the %s pizza please:  ",
						pizzaSequenceNumWord);

				potentialUoM = sc.next();

				if (potentialUoM.equals(UnitOfMeasurement.CM.measurement)) {
					this.unitOfMeasurement = UnitOfMeasurement.CM;
				} else if (potentialUoM.equals(UnitOfMeasurement.INCH.measurement)) {
					this.unitOfMeasurement = UnitOfMeasurement.INCH;
				}
			}

		}
	}

	public Pizza createPizzaFromUserInput(String pizzaSequenceNum) {
		this.getDiameterDataFromUser(pizzaSequenceNum);
		double pizzaPrice = getPizzaAttributeFromUser(pizzaSequenceNum, "price");

		Pizza pizza = new Pizza(this.diameter, this.unitOfMeasurement, pizzaPrice);
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
}
