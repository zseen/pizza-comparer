public class Pizza {

	private int diameter;
	private double price;

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDiameter() {
		return this.diameter;
	}

	public double getPrice() {
		return this.price;
	}

	public double getArea() {
		return this.calculateArea();
	}

	public double getPricePerUnit() {
		return this.price / this.getArea();
	}

	private double calculateArea() {
		return (this.diameter / 2) * (this.diameter / 2) * Math.PI;
	}
}