import java.util.Scanner;

public class InputHandler {
	public enum UnitOfMeasurement {
		CM("cm"),
		INCH("inch");

		private final String measurement;

		UnitOfMeasurement(String measurement) {
			this.measurement = measurement;
		}

		public String geUnitOfMeasurementName() {
			return this.measurement;
		}

	}

	public Scanner sc = new Scanner(System.in);

	public Pizza createPizzaFromUserInput(String pizzaSequenceNum) {
		Pizza pizza = new Pizza();
		double pizzaDiameter = getPizzaAttributeFromUser(pizzaSequenceNum, "diameter");
		
		String diameterUnitOfMeasurement = getDiameterUnitOfMeasurementFromUser();
		//System.out.printf("MEASUREMENT: %s", diameterUnitOfMeasurement);

		double pizzaPrice = getPizzaAttributeFromUser(pizzaSequenceNum, "price");
		

		pizza.setDiameter(pizzaDiameter);
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
	
	private String getDiameterUnitOfMeasurementFromUser() {
		//System.out.printf("in getDiameterUnit() ");
	
		
		String unitOfMeasurement = null;
		//System.out.printf("so it got here");
		
		while (unitOfMeasurement == null) {
			//System.out.printf("uom: %s", unitOfMeasurement);
			System.out.printf("What unit of measurement is your pizza? Inch `inch` or `cm`?: ");
			unitOfMeasurement = sc.next();
			
		}
		
		//System.out.printf("In `getDiameterUnitOfMeasurementFromUser`, unitOFMeasurement: %s \n", unitOfMeasurement);
		//System.out.printf("enum value cm: %s \n", UnitOfMeasurement.CM.measurement);
		//System.out.print(UnitOfMeasurement.CM.measurement.equals(unitOfMeasurement) );
		
		
		while (!unitOfMeasurement.equals(UnitOfMeasurement.CM.measurement) && !unitOfMeasurement.equals(UnitOfMeasurement.INCH.measurement)) {
			//System.out.printf("In while loop, unitOFMeasurement: %s \n", unitOfMeasurement);
			//System.out.printf("The diameter should be `cm` or `inch`!: ");
			sc.next();

			
		}
		return unitOfMeasurement;
		
		
	}

}
