
public class Segmento {
	private Punto a, b;
	
	public Segmento(Punto a, Punto b) {
		this.a = a;
		this.b = b;
	}
	
	public Segmento(Segmento obj) {
		a = new Punto(obj.a);
		b = new Punto(obj.b);
	}
	
	public String toString() {
		return a.toString() + "--" + b.toString();
	}
	
	public void desplazar(double dx, double dy) {
		a.setX(a.getX()+dx);
		a.setY(a.getY()+dy);
		b.setX(b.getX()+dx);
		b.setY(b.getY()+dy);		
	}
	
	public Punto puntoMedio() {
		Punto PuntoMedio;
		PuntoMedio = new Punto (0,0);
		PuntoMedio.setX((a.getX()+b.getX())/2);
		PuntoMedio.setY((a.getY()+b.getY())/2);
		return PuntoMedio;
	}
	
	public boolean esIgual(Segmento seg) { // segmento
		return a.esIgual(seg.a) && b.esIgual(seg.b) ||
		a.esIgual(seg.b) && b.esIgual(seg.a) ;
	}
	
	public double longitud() {
		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + 
				   					Math.pow(a.getY() - b.getY(), 2));
	}
	
	
}





