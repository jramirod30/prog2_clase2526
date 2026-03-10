package vigilanciaespacial.estrellas;

public class Estrella {
	private String identificador;
	private double campoMagnetico;
	private int indiceColor;
	
	public Estrella(String identificador, double campoMagnetico, int indiceColor) {
		this.campoMagnetico = campoMagnetico;
		this.identificador = identificador;
		this.indiceColor = indiceColor;
	}
	
	public String getIdentificador() {
		return identificador;
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
		return this.identificador.equals(obj.identificador); 
	}
}
