
public class Segmento {
	private Punto a, b;
	
	public Segmento(Punto a, Punto b) {
		this.a = a;
		this.b = b;
	}
	
	public String toString() {
		return a.toString() + "--" + b.toString();
	}
}
