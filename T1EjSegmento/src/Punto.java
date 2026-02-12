public class Punto {
	private double x, y;
	public Punto(double xo, double yo) {
		x = xo;
		y = yo;
	}
	
	public Punto(Punto obj) {
		x = obj.x;
		y = obj.y;
	}

	public String toString() {
		return "(" + x + "," + y + ")" ;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public boolean esIgual(Punto obj) {
		return this.x == obj.x && this.y == obj.y;
	}
	
}
