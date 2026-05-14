/**
 * 
 */
package secuencia;

import java.util.Comparator;

import secuencia.exception.ErrorBeginningOfList;
import secuencia.exception.ErrorCursor;
import secuencia.exception.ErrorEmptyList;
import secuencia.exception.ErrorEndOfList;

/**
 * @author angel
 * Esta claase implementa un secuenca ordenada doblemente enlazada que permite iterar
 * se usan nodos centinelas en first y last para facilitar la implementación.
 * Esta clase en lugar de imponer que el tipo que se gestione implemente la interfaz Comparable, lo que impone 
 * es que aparte de pasarle el tipo del dato que se contiene se le pase un función que implemente
 *  la interfaz Comparator
 */
public class SortedDoubleLinkedList <T, Comparador extends Comparator<T>>{
	private NodeD<T> first;
	private NodeD<T> last;
	private NodeD<T> cursor = null;
	private Comparador compare;
	private int nElements = 0;
	
	/**
	 * PRE: Cierto
	 * Constructor que recibe la función de comparación a usar.
	 * Se debe comportar como el compareTo de la interfaz Comparable 
	 */
	public SortedDoubleLinkedList(Comparador compare) {
		this.compare = compare;
		this.first = new NodeD<>(null); //Los centinelas no tienen información
		this.last = new NodeD<>(null, first, null);
		this.first.setNext(last);
	}
	

	
	/**
	 * PRE: No está vacía
	 * Lleva la lista al principio <B>primer dato de la secuencia</B>
	 * @throws ErrorEmptyList Se genera esta excepción cuando la secuencia está vacía
	 */
	public void goFirst() throws ErrorEmptyList {
		//TODO
	}
	
	/**
	 * PRE: No está vacía
	 * Lleva la lista al final de la secuencia <B>último dato de la secuencia</B>
	 * @throws ErrorEmptyList Se genera esta excepción cuando la secuencia está vacía
	 */
	public void goEnd() throws ErrorEmptyList {
		//TODO
	}
	
	/**
	 * PRE:  No ha llegado al final y se está en un recorrido válido (cursor != null)
	 * Método que mueve el cursor al siguiente elemento de la lista
	 * @throws ErrorEndOfList se lanza caundo el cursor está al final de la secuencia
	 * @throws  ErrorCursor se generá si el cursor no es válido
	 */
	public void goNext() throws ErrorEndOfList, ErrorCursor{
		//TODO
	}
	
	/**
	 * PRE: No se está al principio y se está en un recorrido válido (cursor != null)
	 * Retrocede el cursor una posición en la cadena
	 * @throws ErrorBeginningOfList se lanza cuando el cursor estás al principio de la secuencia
	 * @throws ErrorCursor  se levanta cuando el cursor no es válido
	 */
	public void goPrev() throws ErrorBeginningOfList, ErrorCursor{
		//TODO
	}
	
	/**
	 * PRE: Cierto
	 * @return cierto si el cursor apunta al principio de la secuencia <B>(primer nodo con dato)</B>
	 */
	public boolean isStart() {
		//TODO
		return false; //Dummy
	}
	/**
	 * PRE: Cierto
	 * @return retorna si está o no vacía
	 */
	public boolean isEmpty () {
		return this.nElements == 0;
	}
	
	/**
	 * PRE: Cierto
	 * @return cierto si el cursor apunta al último nodo de la cadena <B>(último nodo con dato)</B>
	 */
	public boolean isEnd() {
		//TODO
		return false;
	}
	
	/**
	 * PRE: Se está en un recorrido válido (cursor != null)
	 * @return Retorna la información asociada al nodo en el que se encuentra el cursor
	 * @throws ErrorCursor Se lanza cuando el cursor no es válido
	 */
	public T getCurrent() throws ErrorCursor {
		//TODO
		return null; //Dummy
	}
	
	/**
	 * PRE: La secuencia no está vacía
	 * @return Retorna la información asociada al primer nodo de la secuencia
	 * @throws ErrorEmptyList Se lanza cuando la secuencia está vacía 
	 */
	public T getFirst() throws ErrorEmptyList {
		//TODO
		return null; //Dummy
	}
	
	/**
	 * PRE: La secuencia no está vacía
	 * @return Retorna la información asociada al primer nodo de la secuencia
	 * @throws ErrorEmptyList Se lanza si la secuencia está vacía 
	 */
	public T getLast() throws ErrorEmptyList {
		//TODO
		return null; //Dummy
	}
	
	/**
	 * PR: Cierto
	 * @return el número de elementos en la secuencia
	 */
	public int size() {
		return this.nElements;
	}
	
	/**
	 * Inserta el dato donde corresponda siguendo el orden menor a mayor indicado
	 * por compare. En el caso de que exista un dato igual al que se inserta, 
	 * <B>se insertará dalente de este</B>
	 * POST: se acualiza cursor para que apunte al dato que se acaba de insertar
	 * @param data: Dato que se va a insertar
	 */
	public void add (T data) {
		//TODO
	}

	/**
	 * PRE: Cierto
	 * Método que elimina la primera ocurrencia del dato en la secuencia
	 * En el caso de que cursor esté apuntando a la posición que se va a borrar y esta <B>no</B> sea la última,
	 * cursor pasará a apuntar la siguiente posición.
	 * En el caso de que cursor esté apuntando a la posición que se va a borrar y 
	 * esta sea la última cursor apuntara a la posición anterior
	 * Si es el último elemento de la cadena cursor pasará a valer null
	 * En otro caso cursor queda inalterado
	 * @param data: Dato que se busca y que se desea borrar
	 * @return Cierto si el dato se encuentra y se elimnia de la lista
	 */
	public boolean delete (T data) {
	//TODO
		return false; //Dummy
	}
	
	/**
	 * PRE: Cierto
	 * Se retorna la primera instancia de data que se encuentre y acutaliza cursor a esa posición.
	 * Si no se encuentra se retorna null y no se toca cursor
	 * @param data
	 * @return  Se retorna la primera instancia de data que se encuentre
	 */
	public T search (T data) {
		//TODO
		return null; //Dummy
	}
	
	/**
	 *PRE: Cierto
	 * @param data para el que se busca la posición en la lista
	 * @return Retorna el nodo anterior al que se produce el cambio de orden.
	 */
	private NodeD<T> cambioOrden (T data){
		//TODO
		return null; //Dummy
	}
}
