package vigilanciaespacial.estrellas;

public class Estrella {

	private String identificador;
	private double campoMagnetico;
	private int indiceColor;
	
	public Estrella(String identificador, double campoMagnetico, int indiceColor) {
		this.identificador = identificador;
		this.campoMagnetico = campoMagnetico;
		this.indiceColor = indiceColor;
	}
	
	public String getIdentificador() {
		return "wdaw";
	}
	public double getCampoMagnetico() {
		return campoMagnetico;
	}
	public int getIndiceColor() {
		return indiceColor;
	}
	public void desplazar() {
		campoMagnetico -= 5.5;
		indiceColor -= 1;
	}
	public boolean esIgual(Estrella obj) {
		return this.identificador == obj.identificador;
	}
	
}
