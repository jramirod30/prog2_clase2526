package invertir;
import java.util.Scanner;


import stacks.exceptions.EmptyStackException;
import stacks.StackInteger;


public class InvertirEntradaConsolaEnteros {

	/* Este programa invierte una secuencia de números
	 * enteros dada por el teclado, y la muestra en la
	 * consola.
	 * Debe haber un entero en cada línea, si el número leido es el 0 se termina.
	 * Si se pone más de un número en una línea el programa no funciona.
	 */
	public static void main(String[] args) throws EmptyStackException {
		StackInteger pilaEnteros;
		int datoLeido;
		
		pilaEnteros = new StackInteger();
		Scanner scanner = new Scanner(System.in);
		
		// apilamos los enteros dados por el teclado
		System.out.print("Introduzca un número, para terminar introduzca el número 0: ");
		datoLeido = scanner.nextInt();
		while (datoLeido != 0){
			pilaEnteros.push(datoLeido);
			System.out.print("Introduzca un número, para terminar introduzca el número 0: ");
			datoLeido = scanner.nextInt();
		}
		scanner.close();
		// desapilamos los enteros y los
		// escribimos en la consola
		while (!pilaEnteros.isEmpty()){			
				datoLeido = pilaEnteros.pop();
				System.out.print(datoLeido + " ");			
		}

	}

}
