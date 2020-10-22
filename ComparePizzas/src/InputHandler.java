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
	public String unitOfMeasurement = null;
	public Double diameter = null;
	public boolean areDiameterDataComplete = false;

	public void getDiameterData(String pizzaSequenceNum) {
		this.diameter = null;
		this.unitOfMeasurement = null;
		this.areDiameterDataComplete = false;

		while (!this.areDiameterDataComplete) {
			System.out.printf("Enter the diameter of the %s pizza please:  ", pizzaSequenceNum);
			String word = sc.next();

			while (this.diameter == null) {
				try {
					this.diameter = Double.parseDouble(word);
				} catch (Exception e) {
					System.out.println("Enter the diameter properly please:  ");
					word = sc.next();
				}
			}

			System.out.printf("Enter the unit of measurement (cm or inch) for the %s pizza please:  ", pizzaSequenceNum);
			String otherWord = sc.next();
			this.unitOfMeasurement = otherWord;

			while (!this.unitOfMeasurement.equals(UnitOfMeasurement.CM.measurement)
					&& !this.unitOfMeasurement.equals(UnitOfMeasurement.INCH.measurement)) {
				System.out.println("Enter the unit of measurement (cm or inch) properly please:  ");
				this.unitOfMeasurement = sc.next();
			}

			if (this.diameter != null && this.unitOfMeasurement != null) {
				this.areDiameterDataComplete = true;
			}
		}
	}

	public Pizza createPizzaFromUserInput(String pizzaSequenceNum) {
		Pizza pizza = new Pizza();
		this.getDiameterData(pizzaSequenceNum);
		double pizzaDiameter = this.diameter;
		
		double pizzaPrice = getPizzaAttributeFromUser(pizzaSequenceNum, "price");
		
		pizza.setDiameter(pizzaDiameter);
		pizza.setDiameterUnitOfMeasurement(this.unitOfMeasurement);
		pizza.setPrice(pizzaPrice);
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
