/**
 * 
 */

import animales.*;

/**
 * 
 */
public class PruebaAnimales {
	
	
	public static void main(String[] args) {
		Perro perro = new Perro("Perro1", 3);
		Gato gato = new Gato("Gato1", 2);
		Oveja oveja = new Oveja("Oveja1", 4);
		Animal animal = new Animal("Animal1",5,"Sonido genérico");
		
		perro.emitirSonido();
		perro.comerHueso();
		
		gato.emitirSonido();
		gato.jugarConBola();
		
		ovjea.emitirSonido();
		oveja.pastar();
	}

}
