public class Pizza {

	private double diameter;
	public UnitOfMeasurement diameterUnitOfMeasurement;
	private double INCH = 2.54;
	private double price;

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

	public Pizza(double diameter, double price, UnitOfMeasurement diameterUnitOfMeasurement) {
		this.diameter = diameter;
		this.price = price;
		this.diameterUnitOfMeasurement = diameterUnitOfMeasurement;

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

		if (this.diameterUnitOfMeasurement.equals(UnitOfMeasurement.CM)) {
			return pricePerUnitForCM;
		}

		else if (this.diameterUnitOfMeasurement.equals(UnitOfMeasurement.INCH)) {
			return pricePerUnitForCM / (this.INCH * this.INCH);
		}

		else {
			throw new RuntimeException("Problem with unit of measurement.");
		}

	}
}