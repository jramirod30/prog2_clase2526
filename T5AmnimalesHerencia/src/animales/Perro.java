/**
 * 
 */
package animales;

/**
 * 
 */
public class Perro extends Animal {
	private String duenio;

	/**
	 * @param sonido
	 */
	public Perro(String duenio, String nombre, int edad) {
		super(nombre, edad,"Gua Gua");
		this.duenio = duenio;
		// TODO Auto-generated constructor stub
	}
	
	public void comerHueso() {
		System.out.println("El perro está comiendo un hueso.");
	}

}
