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
        head = null;
        //TODO
      }

    // devuelve una ref al nodo que se encuentra en la posición pos de la cadena
    // PRE: 0 <= pos <= size()-1
    private Node<E> getNodeIn(int pos) throws IndexOutOfBoundsException {		
        //TODO       	

        return null;
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
        // TODO Auto-generated method stub
        
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
        return false;
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
        
        return false;
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
