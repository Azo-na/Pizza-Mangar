package shapes;

public class Circle extends Shape implements Cloneable {


	private double radius = 10;

	@Override
	public double getArea() {
		return Math.PI * this.radius * this.radius;
	}

	public double getRadius(){
		return this.radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Circle(int x, int y) {
		setX(x);
		setY(y);
	}

	@Override
	public Object clone() {
		return new Circle(getX(),getY());
	}

	@Override
	public String toString() {
		return "Circle";
	}
}
