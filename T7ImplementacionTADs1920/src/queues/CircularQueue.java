package queues;
import node.*;
import queues.exceptions.EmptyQueueException;

/*//Esp formal<br>
 * <b>DOMINIO</b><br>
 * <b>TIPO Cola</b> = CColaVacia  | CCola (Tipo_Elemento x Cola)<br>
 * <b>INVARIANTE</b>: (A) C EN Cola. Es_Estructura (C)<br>
 *
 * <p><b>NOTA</b>: Es_Estructura es un predicado que pretende informar
 *  al usuario de ciertas propiedades de cualquier clase contenedora
 *  implementado con punteros (ver el TipoLista).</p>
 */
/**
 * Implementación de colas utilizando una cadena circular;
 * Con esta implementación se gana eficiencia al insertar y al sacar de la cola.
 */
public class CircularQueue  <E> implements IQueue<E> {
	//El primero de la cola va a ser el siguiente de ultimo
	//ultimo hace referencia al último
	private Node<E> last=null;
	/** 
	 * Constructor de la ColaCircular; Se encarga de los pasos necesarios para inicializar la 
	 * estructura.
	 */
	public CircularQueue() {
	    // sirve la inicialización por defecto de los atributos
	}

	/*//Esp. Formal
	 *  <b>PRE</b>: not Esta_Vacia(C)<br>
	 *  <b> POST/SOL </b>: C^ent = CCola (_,C^Sal)<br>
	 *  <b>COMPLEJIDAD</b>: O (1) <br>
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
		//TODO
	}//Borrar    

	/*//Esp Formal
	 * <b>PRE</b>: Cierto<br>
	 * <b>POST/SOL</b>: Resultado = (C = CColaVacia)<br>
	 * <b>COMPLEJIDAD</b>: O (1)<br>
	 */

	/* (non-Javadoc)
     * @see queues.QueueInterface#isEmpty()
     */
	@Override
    public boolean isEmpty ()
	{//Esta_Vacia
		return this.last==null;
	}

	/*//Esp. Formal
	 *  <b>PRE</b>: Cierto<br>
	 *  <b>POST: C^sal</b> = <br>
	 *    | CCola (Elemento, CColaVacia)<br>
	 *    |   SI C^ent = CColaVacia<br>
	 *    |<br>
	 *    | CCola (Primero,Insertar (Resto,Elemento))<br>
	 *    |   SI C^ent = CCola (Primero,Resto) <br>
	 *  <b>COMPLEJIDAD</b>: O (1)<br>
	 *  <b>EXCEPCIONES</b>: Memoria_Agotada<br>
	 */

	/* (non-Javadoc)
     * @see queues.QueueInterface#add(E)
     */
	@Override
    public void add (E elemento)
	{//Insertar
	//TODO
	}//Insertar

	/*//Esp. Formal
	 * <b>PRE</b>: not Esta_Vacia(C)<br>
	 * <b>POST/SOL</b>: C = CCola (Elemento,_)<br>
	 * <b>COMPLEJIDAD</b>: O (1)<br>
	 * @return Si la cola no está vacía retorna el primer elemento de la cola. 
	 * Si la cola está vacía se levanta una excepción
	 * @throws excepcion.ExcepcionColaVacia <PRE>Se genera esta 
	 * excepción si se intenta obtener el primer elemento en
	 * una cola vacía</PRE>
	 */

	/* (non-Javadoc)
     * @see queues.QueueInterface#peek()
     */
	@Override
    public E peek () throws EmptyQueueException
	{//Primero
		//TODO
		return null;
	}//Primero

	/*//Esp Formal.
	 *<b>PRE</b>: Cierto<br>
	 *<b>POST/SOL</b>: C^sal = CColaVacia<br>
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
	 */
	public void makeEmpty()
	{//Vaciar
		last=null; //En java basta con dejar sin referencia un bloque de memoria
		//para que este pueda ser recuperado por el sistema
		//Si se desea forzar la recuperación de forma inmediata de la memoria
		//asignada basta con forzar la entrada del garbage collection:
		System.gc(); /* Esta llamada puede consumir mucha CPU.
		 * lo normal es dejar a la máquina virtual Java
		 * que la realice cuando lo considere oportuno.
		 */
	}

	/*//Esp. Formal
	 *  <b>PRE</b>: not Esta_Vacia(C)<br>
	 *  <b> POST/SOL </b>: C^ent = CCola (Elemento,C^Sal)<br>
	 *  <b>COMPLEJIDAD</b>: O (1) <br>
	 *  @return Si la cola no está vacía saca el primer elemento de la cola y lo retorna. 
	 *  Si la cola está vacía se levanta una excepción
	 *  @throws excepcion.ExcepcionColaVacia <PRE>Se genera esta 
	 *  excepción si se intenta sacar el primer elemento en
	 *  una cola vacía</PRE>
	 */

	/* (non-Javadoc)
     * @see queues.QueueInterface#poll()
     */
	@Override
    public E poll() throws EmptyQueueException
	{//Sacar_Primero
		//TODO
		return null;
	}//Sacar_Primero


}//ColaCircular

