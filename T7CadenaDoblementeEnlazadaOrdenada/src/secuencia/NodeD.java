/**
 * 
 */
package secuencia;

/**
 * @author angel
 * Clase auxiliar que represente al nodo dobe 
 */
class NodeD <T>{
	/**
	 * Dato que contiene el nodo
	 */
	private T dato;
	/**
	 * Nodo previo a este
	 */
	private NodeD<T>  prev = null;
	/**
	 * Nodo siguiente a este
	 */
	private NodeD<T> next = null;

	/**
	 * PRE: Cierto
	 * Este método construye un nodo sin predesro ni suscesor
	 * @param dato: Información que contendrá el nodo doble
	 */
	NodeD(T dato) {
		this.dato = dato;
	}
	
	/**
	 * PRE: Cierto
	 * Este método construye un nodo con predecesor y sucesor
	 * @param dato Informacón o dato que contendrá el nodo
	 * @param prev Nodo doble predecesor a este
	 * @param next Nodo doble siguiente a este
	 */
	NodeD (T dato, NodeD<T> prev, NodeD<T> next){
		this (dato);
		this.prev = prev;
		this.next = next;
	}

	//Gets y sets
	/**
	 * PRE: Cierto
	 * Retorna referencia al nodo predecesor
	 * @return the prev
	 */
	NodeD<T> getPrev() {
		return prev;
	}

	/**
	 * Pre: Cierto
	 * Fija el nodo predecesor a este
	 * @param prev the prev to set
	 */
	void setPrev(NodeD<T> prev) {
		this.prev = prev;
	}

	/**
	 * PRE: Cierto
	 * Retorna el nodo siguiente a este
	 * @return the next
	 */
	NodeD<T> getNext() {
		return next;
	}

	/**
	 * PRE: Cierto
	 * Establece el nodo siguiente a este
	 * @param next the next to set
	 */
	void setNext(NodeD<T> next) {
		this.next = next;
	}

	/**
	 * PRE: Cierto
	 * Retorna el dato correspondiente a este nodo
	 * @return the dato
	 */
	T getDato() {
		return dato;
	}
	
	/**
	 * PRE: Cierto
	 * Establece el dato para este nodo
	 * @param dato nuevo dato
	 */
	void setDato(T dato){
		this.dato = dato;
	}
	

}
