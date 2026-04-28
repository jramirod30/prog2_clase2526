
package queues;
import node.*;
import queues.exceptions.EmptyQueueException;

/** Implementación de colas sin utilizar los recursos
 * de java.util. basada en una cadena simplemente enlazada
 */
public class SimpleQueue  <E> implements IQueue<E>
{//ColaSimple
	private Node<E> head=null;
	/** Constructor que se encarga de inicializar la cola*/
	public SimpleQueue() {
	}

	/*//Esp. Formal
	 *  <b>PRE</b>: not Esta_Vacia(C)<br>
	 *  <b> POST/SOL </b>: C^ent = CCola (_,C^Sal)<br>
	 *  <b>COMPLEJIDAD</b>: O (1)
	 *  Si la cola no está vacía saca el primer elemento de la cola. 
	 *  Si la cola está vacía se levanta una excepción
	 *  @throws excepcion.ExcepcionColaVacia <PRE>Se genera esta 
	 *  excepción si se intenta borrar el primer elemento en
	 *  una cola vacía</PRE>
	 */

	/**
	 * Elimina el primer elemento de la cola
	 * <br><B>PRE:</B> no es vacía la cola
	 * <br><B>POST:</B> El resultado es la cola de entrada sin el elemento más antiguo
	 *
	 * @throws EmptyQueueException excepción que se genera si se viola la precondición
	 */
	private void remove() throws EmptyQueueException 
	{//Borrar
		// TODO 
		
	}//Borrar

	/*//Esp. Formal
	 * PRE: Cierto
	 * POST/SOL: Resultado = (C = CColaVacia)
	 * COMPLEJIDAD: O (1)
	 */

	/**
	 * Indica si la cola está vacía
	 * <br><B>PRE:</B> Cierto
	 * <br><B>POST:</B> cierto si no quedan elementos en la cola
	 *
	 * 
	 */
	public boolean isEmpty ()
	{//Esta_Vacia
		return this.head==null;
	}

	/*//Esp. Formal
	 *  PRE: Cierto
	 *  POST: C^sal = | CCola (Elemento, CColaVacia)
	 *                |   SI C^ent = CColaVacia
	 *                |
	 *                | CCola (Primero,
	 *                |        Insertar (Resto,Elemento))
	 *                |   SI C^ent = CCola (Primero,Resto)
	 *  COMPLEJIDAD: O (N)
	 *  DONDE: N es el numero de elementos en C^ent
	 *  EXCEPCIONES: Memoria_Agotada
	 */
	/**
	 * Inserta un elemento en la cola; El elemento insertado se coloca el último de la colección
	 * <br><B>PRE:</B> Cierto
	 * <br><B>POST:</B>Cola de entrada con un elemento al final
	 * @param  elemento Referencia a la información que se va a guardar en la cola. <B> No se saca copia de la información referenciada</B>
	 */
	public void add (E elemento)
	{//Insertar
		//TODO
	}//Insertar

	/*//Esp. Formal
	 * PRE: not Esta_Vacia(C)
	 * POST/SOL: C = CCola (Elemento,_)
	 * COMPLEJIDAD: O (1)
	 **/

	/**
	 * Retorna el primer elemento de la cola, sin alterar la cola
	 * <br><B>PRE:</B> la cola no es vacía
	 * <br><B>POST:</B>Retorna referencia al elemento que ocupa la primera posición de la cola
	 *
	 * @return Si la cola no está vacía retorna el primer elemento de la cola. 
	 * Si la cola está vacía se levanta una excepción
	 * @throws EmptyQueueException excepción que se genera si se viola la precondición
	 */
	public E peek () throws EmptyQueueException
	{//Primero
		//TODO
		return null;
	}//Primero

	/*//Esp. Formal
	 *<b>PRE</b>: Cierto<br>
	 *<b>POST/SOL</b>: C^sal = CColaVacia
	 *<p><b>COMPLEJIDAD</b>: O (N) Hay que suponer que el tiempo que consuma gc
	 *depende del número de elementos que hay en la cola. 
	 * Aunque no se haga una llamada explicita al gc la máquina virtual 
	 * acabará haciendo esta llamada.</p>
	 * <b>DONDE N</b> es el número de elementos encolados en C^ent
	 */

	/**
	 * Vacía el contenido de una cola; Se deja de referenciar a los elementos contenidos en la cola
	 * <br><B>PRE:</B> Cierto
	 * <br><B>POST:</B> la cola está vacía
	 *
	 * depende del número de elementos que hay en la cola. 
	 * Aunque no se haga una llamada explicita al gc la máquina virtual 
	 * acabará haciendo esta llamada.
	 * DONDE N es el número de elementos encolados en la cola de entrada<br>
	 */
	public void makeEmpty()
	{//Vaciar
		this.head=null; //En java basta con dejar sin referencia un bloque de memoria
		//para que éste pueda ser recuperado por el sistema
		//Si se desea forzar la recuperación de forma inmediata de la memoria
		//asignada basta con forzar la entrada del garbage collection:
		System.gc(); /* Esta llamada puede consumir mucha CPU.
		 * lo normal es dejar a la máquina virtual Java
		 * que la realice cuando lo considere oportuno.
		 */
	}

	/*//Esp. formal
	 *  <b>PRE</b>: not Esta_Vacia(C)<br>
	 *  <b> POST/SOL </b>: C^ent = CCola (Elemento,C^Sal)<br>
	 *  <b>COMPLEJIDAD</b>: O (1)
	 *  @return Si la cola no está vacía saca el primer elemento de la cola y lo retorna. 
	 *  Si la cola está vacía se levanta una excepción
	 *  @throws excepcion.ExcepcionColaVacia <PRE>Se genera esta 
	 *  excepción si se intenta sacar el primer elemento en
	 *  una cola vacía</PRE>
	 */
	/**
	 * Saca el primer elemento de la cola
	 * <br><B>PRE:</B> la cola no está vacía
	 * <br><B>POST:</B> Se retorna la referencia al primer elemento de la cola y se extrae esta referencia de la cola
	 *
	 * @return Si la cola no está vacía saca el primer elemento de la cola y lo retorna. 
	 * Si la cola está vacía se levanta una excepción
	 * @throws EmptyQueueException excepción que se genera si se viola la precondición
	 */
	public E poll() throws EmptyQueueException
	{//Sacar_Primero
		return null;
	}//Sacar_Primero



}//ColaSimple
