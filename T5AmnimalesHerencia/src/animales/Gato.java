/**
 * 
 */
package animales;

/**
 * 
 */
public class Gato extends Animal {


	/**
	 * @param sonido
	 */
	public Gato(String pastor, String nombre, int edad) {
		super(nombre, edad,"Miau Miau");
		
	}
	
	public void jugarConBola() {
		System.out.println("El gato está jugando con una bola.");
	}

}
