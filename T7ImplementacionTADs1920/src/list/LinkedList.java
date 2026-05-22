package list;

import node.Node;
import java.util.function.*;

/**
 * Implementación de un TAD Lista
 * basada en una cadena simplemente enlazada
 * 
 * @author jramirez
 *
 */
public class LinkedList<E> implements IList<E> {

    private Node<E> head;
    private int nElems;

    /**
     * Construye una lista vacía
     * 
     * <br><B>PRE:</B> Cierto
     * <br><B>POST:</B> crea una lista vacía.
     * 
     */
    public LinkedList(){
        head = null;
        nElems = 0;
    }

    /**
     * Constructor de copia
     * 
     * <br><B>PRE:</B> Cierto
     * <br><B>POST:</B> crea una lista igual a org (shallow copy).
     * 
     */
    public LinkedList(LinkedList<E> org){
    	if (org.size() == 0)
    		return;
    	
    	Node<E> actual = org.head.next();
    	this.head = new Node<>(org.head.getElem());
    	Node<E> insertar = this.head;
    	while (actual != null) {
    		insertar.setNext(new Node<>(actual.getElem()));
    		insertar = insertar.next();
    		actual = actual.next();
    	}	    	
    	this.nElems = org.nElems;
      }

    // devuelve una ref al nodo que se encuentra en la posición pos de la cadena
    // PRE: 0 <= pos <= size()-1
    private Node<E> getNodeIn(int pos) throws IndexOutOfBoundsException {		
        if (pos < 0 || pos >= this.size()) {
			throw new IndexOutOfBoundsException ("El índice debe estar entre 0 y "+(this.nElems-1));
		}
        int contador = 0;
        Node<E> resultado = this.head;
        while (contador < pos) {
        	resultado = resultado.next();
        	contador ++;
        }
        return resultado;
    }

    /**
     * Coloca un nuevo elemento en la posición insertIndex
     *
     * <br><B>PRE:</B> insertIndex EN {0..size()}
     * <br><B>POST:</B> devuelve la lista this con element en la pos insertIndex
     * y los elementos que antes estaban en pos &gt;=insertIndex, ahora en pos+1.
     * 
     * @throws IndexOutOfBoundsException 
     */
    @Override
    public void add(int insertIndex, E element) throws IndexOutOfBoundsException {
        // TODO 
    	if (insertIndex < 0 || insertIndex > this.nElems) {
    		throw new IndexOutOfBoundsException ("El índice debe estar entre 0 y "+this.nElems);
    	}
    	Node<E> nuevo = new Node<>(element);
    	if (insertIndex == 0) {
    		nuevo.setNext(this.head);
    		this.head = nuevo; 
    	}else {
    		Node<E>puntoInsercion = this.getNodeIn(insertIndex-1);
    		nuevo.setNext(puntoInsercion.next());
    		puntoInsercion.setNext(nuevo);
    	}
    	this.nElems++;
    }

    /**
     * Lectura indexada de una posición de la lista
     * 
     * <br><B>PRE:</B> insertIndex EN {0..size()-1}
     * <br><B>POST:</B> devuelve una ref al elemento que está en la pos index.
     * 
     * @throws IndexOutOfBoundsException 
     */
    @Override
    public E get(int getIndex) throws IndexOutOfBoundsException {
        return getNodeIn(getIndex).element();
    }

    /**
     * No. de elementos en la lista
     * 
     * <br><B>PRE:</B> cierto
     * <br><B>POST:</B> devuelve el no. de elems que hay en la lista.
     */
    @Override
    public int size() {
          return nElems;
    }

    /**
     * Escritura indexada en una posición de la lista
     * 
     * <br><B>PRE:</B> insertIndex EN {0..size()-1}
     * <br><B>POST:</B> coloca element en la posición insertIndex de la lista destruyendo 
     * el elemento que había en esa posición.
     * 
     * @throws IndexOutOfBoundsException 
     */
    @Override
    public void set(int insertIndex, E element) throws IndexOutOfBoundsException {
        Node<E> ref = this.getNodeIn(insertIndex);
        ref.setElem(element);
    }

    /**
     * Posición de un elemento dentro de la lista
     * 
     * <br><B>PRE:</B> Cierto
     * <br><B>POST:</B> devuelve una ref al primer elemento de la lista
     * que es igual a search (equals), o -1 si no existe ningún elemento igual a search.
     * 
     */
    @Override
    public int indexOf(E search) {
        // TODO Auto-generated method stub
        return -1;
    }

    /**
     * Extracción de un elemento de la lista dada su posición
     * 
     * <br><B>PRE:</B> removalIndex EN {0..size()-1}
     * <br><B>POST:</B> extrae el elemento que está en la pos removalIndex.
     * 
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void removeElementAt(int removalIndex) throws IndexOutOfBoundsException {
        if(removalIndex < 0 || removalIndex >= this.size()) {
        	throw new IndexOutOfBoundsException("Valor fuera de rango. El índice debe estar entre 0 y"
        			+ " " + (this.nElems-1));
        }
        
        if (removalIndex ==0 ) {
        	this.head = this.head.next();
        }
        else {
        	Node<E> anterior = this.getNodeIn(removalIndex-1);
        	anterior.setNext(anterior.next().next());
        }
        this.nElems --;
    }

    /**
     * Extracción de un elemento de la lista dado un elemento igual (equals)
     * 
     * <br><B>PRE:</B> cierto
    * <br><B>POST:</B> extrae el primer elemento que sea igual a element (equals) y devuelve cierto, 
     * si existe. Y si no existe, devuelve falso.
     * 
     */
    @Override
    public boolean remove(E element) {
        // TODO Auto-generated method stub
    	/*int pos = this.indexOf(element);
    	if (pos == -1)
    		return false;
    	this.removeElementAt(pos);
    	return true;*/
    	if (this.size() == 0)
    		return false;
    	
    	boolean eliminado = false;
    	if(head.getElem().equals(element)) {
    		head = head.next();
    		eliminado = true;
    		nElems--;
    	} else {
    		Node<E> enEstudio = head;
    		while(enEstudio.next() != null &&
    				!enEstudio.next().getElem().equals(element)) {
    			enEstudio = enEstudio.next();
    		}
    		if(enEstudio.next() != null) {
    			enEstudio.setNext(enEstudio.next().next());
        		eliminado = true;
        		nElems--;
    		}
    		
    	}
    	return eliminado;
    }

    // Class-specific methods

    /**
     * Devuelve un string con los elementos de la lista
     * 
     * <br><B>PRE:</B> Cierto
     * <br><B>POST:</B> devuelve un string con los elementos de la lista separados
     * por comas.
     */
    public String toString() {
        //TODO
        return "";
    }

    /**
     * Igualdad de listas
     * 
     * <br><B>PRE:</B> Cierto
     * <br><B>POST:</B> indica si obj es igual a this. Dos listas son iguales
     * si las secuencias de objetos almacenados en ellas son iguales. Cada par de objetos
     * son comparados con el método equals de la clase a la que pertenecen estos objetos.
     * 
     */
   // @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (!(obj instanceof LinkedList<?>))
            return false; // also, list == null

        LinkedList<?> list = (LinkedList<?>) obj;
        //TODO
        if(this.nElems != list.nElems)
        	 return false;
        
        if (this.nElems == 0)
        	return true; //Dos listas vacías siempre son iguales
        if(this.head.element().getClass() != list.head.element().getClass()) {
        	return false;
        }
        Node<E> actualThis = this.head;
        Node<?> actualOther = list.head;
        while(actualThis != null && actualThis.element().equals(actualOther.element())) {
        	actualThis = actualThis.next();
        	actualOther = actualOther.next();
        	}
        
        return actualThis == null;
       }

    /**
     * Se hace una deep copy sí y sólo si si copyData hace una copia compelta del tipo de dato conetenido en la lista 
     * @param copyData
     * @return
     */
    public LinkedList <E> deepCopy (Function<E,E>copyData){
        LinkedList <E> copia = new LinkedList<E>();
        Node<E> headOrg = this.head;
        Node<E> refCopyList = null;
        copia.nElems = this.nElems;
        while (headOrg != null){//W
            Node <E> nodoAux = new Node<E>(copyData.apply(headOrg.element()));
            if (copia.head==null){
                copia.head = nodoAux;
                refCopyList = nodoAux;
            }
            else{
                refCopyList.setNext(nodoAux);
                refCopyList = refCopyList.next();
            }
            headOrg = headOrg.next();
        }//W
        return copia;
    }

   /* public E copy (E dato,Function<E,E>copiar ){
        return copiar.apply(dato);
    }*/
}
