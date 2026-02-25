

public class Cancion {
	private String titulo;	
	// indica cuántas veces se ha reproducido la canción
	private int noReproducciones; 
	// en segundos
	private double duracion;
	
	public Cancion(String titulo, double duracion) {		
		this.titulo = titulo;	
		this.noReproducciones = 0;
		this.duracion = duracion;
	}
	
	public Cancion(Cancion cancion){
		this.titulo = cancion.titulo;		
		this.noReproducciones = cancion.noReproducciones;
		this.duracion = cancion.duracion;
	}
	
	public void reproducirCancion(){
		System.out.println("Reproduciendo... " + titulo);
		try {
			Thread.sleep((int) duracion*1000);
			this.noReproducciones++;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean esIgual(Cancion cancion){
		return titulo.equals(cancion.titulo) 
				&& this.duracion == cancion.duracion;
	}

	public int getNoReproducciones() {
		return noReproducciones;
	}

	void setNoReproducciones(int noReproducciones) {
		this.noReproducciones = noReproducciones;
	}

	public String toString(){
		return "(" + titulo + ", " + duracion + ", "+ noReproducciones + ")";
	}

	public String getTitulo() {
		return titulo;
	}

	public double getDuracion() {
		return duracion;
	}	
	
}
