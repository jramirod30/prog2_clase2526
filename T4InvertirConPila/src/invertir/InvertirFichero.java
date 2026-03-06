package invertir;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import stacks.exceptions.EmptyStackException;
import stacks.Stack;

public class InvertirFichero {

	/* Este programa lee las líneas de un fichero de texto, y
	 * las escribe en la consola en orden inverso.
	 * El nombre del fichero se pasa como argumento al invocar al
	 * programa (main). Si no se pasa ningún nombre o no existe un
	 * fichero con el nombre dado, se leen las líneas por el teclado.
	 */
	public static void main(String[] args) throws EmptyStackException {
		BufferedReader in = null;
		String s;
		Stack<String> pilaStrings = new Stack<String>();		
		Reader file;
		
		// si no se pasa como argumento un string, se usa el teclado
		// para leer las líneas
		if (args.length == 0)
			file = new InputStreamReader(System.in); // teclado
		else
			try {
				file = new FileReader(args[0]);
			} catch (FileNotFoundException e1) {
				System.out.println("El file " + args[0] + " no existe, se leerán las líneas por el teclado");
				file = new InputStreamReader(System.in); // teclado
			}
									
		in = new BufferedReader(file);
					
		try {
			// se leen las líneas y se guardan en la Stack
			while((s = in.readLine())!= null) 
			   	pilaStrings.push(s);
			
			in.close();
			
			// se vacía la pila y se escriben las líneas en orden
			// inverso en la consola
			while (!pilaStrings.isEmpty()){
				
					s = pilaStrings.pop();
					System.out.println(s);
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR al leer el fichero, no se podrá invertir.");
			e.printStackTrace();
		} 
				
		
	}

}
