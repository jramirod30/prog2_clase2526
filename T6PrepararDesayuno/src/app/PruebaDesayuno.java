/**
 * 
 */
package app;

import java.util.Scanner;

import vajilla.Vaso;
import vajilla.exception.ExcepcionPrepararDesayuo;

/**
 * @author angel
 *
 */
public class PruebaDesayuno {


	public static double leerNumero(String pregunta) {
		 final Scanner lector = new Scanner (System.in); 
		System.out.print(pregunta);
		return lector.nextDouble();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		double capacidad = leerNumero("Cuantos ml tiene el vaso: ");
		Vaso vaso = new Vaso (capacidad);
		//TODO: leer los datos para perparar el desayuno. Se deben pedir los datos hasta que se puede preparar
		
		//Fin TODO
		System.out.println("Desayuno listo con " + vaso.getContenido() + " ml");
	}

}
