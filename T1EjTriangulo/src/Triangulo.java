
public class Triangulo {
	private double base, altura;
	
	public Triangulo(double base1, double altura1) {
		base = base1;
		altura = altura1;
	}
	
	public Triangulo(Triangulo obj) {
		base = obj.base;
		altura = obj.altura;
	}
	
	public boolean esIgual(Triangulo obj) {
		return base == obj.base && altura == obj.altura;
	}
	
	public double getBase(){
		return base;
	}
	
	public double getAltura(){
		return altura;
	}
	
	public void setBase(double nBase) {
		base=nBase;
	}
	
	public void setAltura(double nAltura) {
		altura=nAltura;
	}
	
	public double area() {
		return base*altura/2;
	}
	
	public String toString() {
		return "base: " + base + " altura: " + altura;
	}
}
