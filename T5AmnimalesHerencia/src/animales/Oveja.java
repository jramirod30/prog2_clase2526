/**
 * 
 */
package animales;

/**
 * 
 */
public class Oveja extends Animal {

	/**
	 * @param sonido
	 */
	public Oveja(String nombre, int edad) {
		super(nombre, edad,"Bee Bee");
		// TODO Auto-generated constructor stub
	}
	
	public void pastar() {
		System.out.println("La oveja está pastando en el campo.");
	}

}
