package stacks;


import node.Node;
import stacks.exceptions.EmptyStackException;


/**
 * Implementación de un TAD Pila
 * basada en una cadena simplemente enlazada
 * 
 * @author jramirez
 *
 */
public class Stack <E>
{
	private Node<E> head;


	public Stack() {
		head = null;    
	} 

	
	private void remove() throws EmptyStackException 
	{
		//TO-DO
	}

	/**
	 * Indica si la pila está vacía
	 * <br><B>PRE:</B> Cierto
	 * <br><B>POST:</B> cierto si no quedan elementos en la pila
	 * 
	 */
	
	public boolean isEmpty ()
	{//Esta_Vacia
		//TO-DO
		return false;
	}

	/**
	 * Apila un elemento en la pila; el elemento apilado se coloca como 
	 * nueva cima
	 * <br><B>PRE:</B> Cierto
	 * <br><B>POST:</B>Pila de entrada con el elemento dado como nueva cima
	 * @param  elemento Referencia a la información que se va a guardar en la pila. <B> No se saca copia de la información referenciada</B>
	 */
	
	public void push (E elemento)
	{        
		//TO-DO       
	}

	/**
	 * Retorna el elemento cima de la pila, sin alterar la pila
	 * <br><B>PRE:</B> la pila no es vacía
	 * <br><B>POST:</B>Retorna referencia al elemento que ocupa la cima de 
	 * la pila
	 * @return retorna el elemento cima de la cola. 
	 * @throws EmptyStackException excepción que se genera si se viola la 
	 * precondición
	 */
	
	public E peek () throws EmptyStackException
	{
		//TO-DO
		return null;
	}

	/**
	 * Vacía el contenido de una pila; Se deja de referenciar a los 
	 * elementos contenidos en la pila
	 * <br><B>PRE:</B> Cierto
	 * <br><B>POST:</B> la pila está vacía
	 */
	public void makeEmpty()
	{//Vaciar
		this.head=null; //En java basta con dejar sin referencia un bloque de memoria
		//para que Ã©ste pueda ser recuperado por el sistema
		//Si se desea forzar la recuperación de forma inmediata de la memoria
		//asignada basta con forzar la entrada del garbage collection:
		System.gc(); /* Esta llamada puede consumir mucha CPU.
		 * lo normal es dejar a la máquina virtual Java
		 * que la realice cuando lo considere oportuno.
		 */
	}

	/**
	 * Saca el primer elemento de la pila
	 * <br><B>PRE:</B> la pila no está vacía
	 * <br><B>POST:</B> Se retorna la referencia al elemento cima de la pila y 
	 * se extrae esta referencia de la pila
	 * @return saca el elemento cima de la pila y lo retorna. 
	 * @throws EmptyStackException excepción que se genera si se viola la precondición
	 */
	
	public E pop() throws EmptyStackException
	{
		//TO-DO
		return null;
	}

}