public class Pizza {

	private double diameter;
	public InputHandler.UnitOfMeasurement diameterUnitOfMeasurement;
	private double price;

	public Pizza(double diameter, InputHandler.UnitOfMeasurement diameterUnitOfMeasurement, double price) {
		this.diameter = diameter;
		this.diameterUnitOfMeasurement = diameterUnitOfMeasurement;
		this.price = price;
	}

	public double getDiameter() {
		return this.diameter;
	}

	public double getPrice() {
		return this.price;
	}

	public double getArea() {
		return (this.diameter / 2) * (this.diameter / 2) * Math.PI;
	}

	public double getPricePerUnit() throws RuntimeException {
		double pricePerUnitForCM = this.price / this.getArea();

		if (this.diameterUnitOfMeasurement.equals(InputHandler.UnitOfMeasurement.CM)) {
			return pricePerUnitForCM;
		}

		else if (this.diameterUnitOfMeasurement.equals(InputHandler.UnitOfMeasurement.INCH)) {
			return pricePerUnitForCM / (2.54 * 2.54);
		}

		else {
			throw new RuntimeException("Problem with unit of measurement.");
		}

	}
}