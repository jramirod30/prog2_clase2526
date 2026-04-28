/*
 * PruebaColas.java
 *
 * Created on 9 de agosto de 2005, 11:26
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author agonzalez
 */

//import ED1.TADS.colas.*;

import queues.SimpleQueue;


public class PruebaColas {//PruebaCola
	//private final static int n = 1000000; //Constante que indica el número de
	private final static int sacar =5;
	private final static int n = 1000; //Constante que indica el número de
	//iteraciones
	/** Creates a new instance of PruebaCola */
	public PruebaColas() {

	}
	//Dado que Cola*<Integer> es un tipo distinto de Cola*<Float>, 
	//Cola*<String> si se desea realizar un servicio (fuera de Cola*) 
	// es necesario recurrir a utilizar
	//caracteres comodines. El siguiente servicio recibe una cola saca los
	//n primeros elementos de la cola y los retorna en un Array 
	public static Object [] convertirArray (SimpleQueue <?> Cola, int Cuantos)
	//	public static Object [] convertirArray (ColaPrimeroUltimo <?> Cola, int Cuantos)
	//	public static Object [] convertirArray (ColaCircular <?> Cola, int Cuantos)
	{//convertirArray
		Object [] resultado = new Object[Cuantos];
		int Contador=0;
		while (! Cola.isEmpty() && Contador<Cuantos)
		{//W
			try
			{//try
				resultado[Contador] = Cola.poll();
				Contador++;
			}//try
			catch (queues.exceptions.EmptyQueueException e)
			{//catch
				System.out.println (e.getMessage());
			}//catch           
		}//W
		return resultado;
	}//convertirArray

	public static void main (String [] args)
	{//main
		//Al trabajar con la interface definida lo único que varía
		//de utilizar una implementación u otra es la llamada a new
		// iColas <Integer> Cola_Enteros= new Colas <Integer>();
		SimpleQueue <Integer> colaEnteros= new SimpleQueue <Integer>();
		//ColaPrimeroUltimo <Integer> colaEnteros= new ColaPrimeroUltimo <Integer>();
		// ColaCircular <Integer> colaEnteros= new ColaCircular <Integer>();
		Integer aux;
		int contador=0;
		try {//try
			for (int i=0; i < n;i++)
			{//FOR
				colaEnteros.add(i);
				aux=colaEnteros.peek();
				assert aux == 0 : "Primero falla después de insertar";
				assert !colaEnteros.isEmpty() : "Esta_Vacia falla despues de insertar";
			}//FOR

			Object [] array = convertirArray(colaEnteros, sacar);

			for (int i=0; i<array.length;i++)
			{
				assert i==(Integer)array[i] : "No se almacenan bien los valores";
			}

			while (contador < n - sacar)
			{//W
				assert !colaEnteros.isEmpty(): "Cola Vacía antes de sacar";
				aux=colaEnteros.poll();
				assert aux == (contador+sacar) : "No se almacenan bien los valores";
				contador++;
			}//W
			assert colaEnteros.isEmpty(): "La cola no está vacía";
			System.out.println("Todo ha funcionado correctamente");
		}//try
		catch (queues.exceptions.EmptyQueueException e)
		{//catch
			System.out.println (e.getMessage());
		}//catch

	}//main
}//PruebaColas
