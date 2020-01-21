package shapes;

import java.awt.Graphics;

public abstract class Shape implements Cloneable {
	private int x=0,y=0;
		
	@Override
	public abstract Object clone();
	
	public Shape(){}
	public Shape(Shape other) {
		setX(other.x);
		setY(other.y);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	//public abstract void draw(Graphics g);
	public abstract double getArea();
	
}
