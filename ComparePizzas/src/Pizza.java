
public class Pizza {

	private double diameter;
	private double price;
	private String diameterUnitOfMeasurement;

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public void setDiameterUnitOfMeasurement(String unitOfMeasurement) {
		this.diameterUnitOfMeasurement = unitOfMeasurement;
	}

	public void setPrice(double price) {
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

	public double getPricePerUnit() {
		if (this.diameterUnitOfMeasurement.equals(InputHandler.UnitOfMeasurement.CM.measurement)) {
			System.out.println(this.price / this.getArea());
			return this.price / this.getArea();
		}

		else {
			System.out.println(this.price / this.getArea() / (2.54 * 2.54));
			return this.price / this.getArea() / (2.54 * 2.54);
		}
	}
}