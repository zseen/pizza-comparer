public class Pizza {

	private double diameter;
	private double price;

	public void setDiameter(double diameter) {
		this.diameter = diameter;
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
		return this.price / this.getArea();
	}

}