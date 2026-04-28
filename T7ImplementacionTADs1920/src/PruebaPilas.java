
import stacks.Stack;
import stacks.exceptions.EmptyStackException;

public class PruebaPilas {
	//private final static int n = 1000000; //Constante que indica el número de
	private final static int SACAR =1;
	private final static int N = 1000; //Constante que indica el número de
	//iteraciones

	public PruebaPilas() {

	}
	//Dado que Pila<Integer> es un tipo distinto de Pila <Float>, 
	//Pila<String> si se desea realizar un servicio (fuera de Pila 
	//o de alguna implementación de Pila) es necesario recurrir a utilizar
	//caracteres comodines. El siguiente servicio recibe una pila saca los
	//n primeros elementos de la pila y los retorna en un Array 
	public static Object [] convertirArray (Stack<?> pila, int Cuantos)
	{//convertirArray
		Object [] resultado = new Object[Cuantos];
		int Contador=0;
		while (! pila.isEmpty() && Contador<Cuantos)
		{//W
			try
			{//try
				resultado[Contador] = pila.peek();
				Contador++;
			}//try
			catch (EmptyStackException e)
			{//catch
				System.out.println (e.getMessage());
			}//catch           
		}//W
		return resultado;
	}//convertirArray

	public static void main (String [] args)
	{//main

		Stack<Integer> pilaEnteros= new Stack <Integer>();

		Integer Aux;
		int contador=N-SACAR-1;
		try {//try
			for (int i=0; i < N;i++)
			{//FOR
				pilaEnteros.push(i);
				Aux=pilaEnteros.peek();
				assert Aux == i : "Cima falla después de apilar";
				assert !pilaEnteros.isEmpty() : "Esta Vacia falla despues de apilar";
			}//FOR

			@SuppressWarnings("unused")
			Object [] Array = convertirArray(pilaEnteros, SACAR);

			while (contador >= 0)
			{//W
				assert !pilaEnteros.isEmpty(): "Pila Vacía antes de sacar";
				Aux=pilaEnteros.pop();
				assert Aux == contador : "No se almacenan bien los valores " + Aux + " " + contador;
				contador--;
			}//W
			assert pilaEnteros.isEmpty(): "La pila no está vacía";
			System.out.println("Todo ha funcionado correctamente");
		}//try
		catch (EmptyStackException e)
		{//catch
			System.out.println (e.getMessage());
		}//catch

	}//main
}
