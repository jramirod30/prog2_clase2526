/**
 * 
 */
package animales;

/**
 * 
 */
public class Animal {
	private String sonido;
	private int edad;
	private String nombre;
	
	public Animal(String nombre, int edad, String sonido) {
		this.sonido = sonido;
		this.edad = edad;
		this.nombre = nombre;
	}
	
	public void emitirSonido() {
		System.out.println("El animal emite el sonido: " + sonido);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}

}
