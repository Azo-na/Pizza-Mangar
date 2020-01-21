package shapes;

public class Square extends Shape implements Cloneable {

	private int sideLength = getX();

	@Override
	public double getArea() {
		return this.sideLength*this.sideLength;
	}

	public int getSideLength(){
		return this.sideLength;
	}

	public void setSideLength(int length) {
		this.sideLength = length;
	}

	public Square(int x, int y) {
		setX(x);
		setY(y);
	}

	@Override
	public Object clone() {
		return new Square(getX(),getY());
	}


	@Override
	public String toString() {
		return "Square";
	}
	
}
