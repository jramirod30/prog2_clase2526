
public class Rectangulo {
	private double lado1, lado2;
	
	public Rectangulo(double lado11, double lado22) {
		lado1 = lado11;
		lado2 = lado22;
	}
	
	public double getLado1() {
		return lado1;
	}
	
	public double getLado2() {
		return lado2;
	}
	
	public void setLado1(double nuevoLado1) {
		lado1 = nuevoLado1;
	}
	
	public void setLado2(double nuevoLado2) {
		lado2 = nuevoLado2;
	}
	
	public double area() {
		return lado1*lado2;
	}
	
	public String toString() {
		return "[" + lado1 + "; " + lado2 + "]";
	}

}
