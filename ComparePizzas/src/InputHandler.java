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

	public String unitOfMeasure = null;
	public Double diam = null;
	public boolean isComplete = false;

	public void getDiameterAndUnitOfMeasurementFromUser(String pizzaSequenceNum) {
		this.diam = null;
		this.unitOfMeasure = null;
		this.isComplete = false;

		while (!this.isComplete) {

			System.out.printf("Enter the diameter of the %s pizza please:  ", pizzaSequenceNum);
			String word = sc.next();

			while (this.diam == null) {
				try {
					this.diam = Double.parseDouble(word);
				} catch (Exception e) {
					System.out.println("Enter the diameter properly please:  ");
					word = sc.next();
				}
			}

			System.out.printf("Enter the UoMof the %s pizza please:  ", pizzaSequenceNum);
			String otherWord = sc.next();
			this.unitOfMeasure = otherWord;

			while (!this.unitOfMeasure.equals(UnitOfMeasurement.CM.measurement)
					&& !this.unitOfMeasure.equals(UnitOfMeasurement.INCH.measurement)) {
				System.out.println("Enter the uom properly please:  ");
				this.unitOfMeasure = sc.next();
			}

			if (this.diam != null && this.unitOfMeasure != null) {
				this.isComplete = true;
			}
		}
	}

	public Pizza createPizzaFromUserInput(String pizzaSequenceNum) {
		Pizza pizza = new Pizza();
		this.getDiameterAndUnitOfMeasurementFromUser(pizzaSequenceNum);
		double pizzaDiameter = this.diam;
		
		double pizzaPrice = getPizzaAttributeFromUser(pizzaSequenceNum, "price");
		
		pizza.setDiameter(pizzaDiameter);
		pizza.setDiameterUnitOfMeasurement(this.unitOfMeasure);
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
