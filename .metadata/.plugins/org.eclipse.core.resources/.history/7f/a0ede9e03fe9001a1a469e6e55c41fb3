
public class Pizza {

	private int diameter;
	private double price;
	private double area;

	public void setDiameterAndPrice(int diameter, double price) {
		this.diameter = diameter;
		this.price = price;
	}

	public int getDiameter() {
		return this.diameter;
	}

	public double getPrice() {
		return this.price;
	}

	public double getArea() {
		this.calculateArea();
		return this.area;
	}

	private void calculateArea() {
		this.area = Math.pow(this.diameter / 2, 2) * Math.PI;
	}
}