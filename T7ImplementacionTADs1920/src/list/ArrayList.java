package list;

import java.util.Arrays;

/**
 * Implementación de un TAD Lista
 * basada en un vector re-dimensionable
 * 
 * @author jramirez
 *
 */
public class ArrayList<E> implements IList<E> {

    /**
     * Esta constante indica la capacidad inicial. 
     */
    private static final int INITIAL_CAPACITY = 3;
    /**
     * Esta constante indica el incremento/decremento del tamaño del
     * arraylist cada vez que se llena o se dejan suficientes posiciones libres. 
     */
    private static final int GROW_SHRINK_INCREMENT = 10;

    // --Instance variables
    private E[] data; // Use an array data structure to store elements 
    private int nElems; // The number of elements (not the capacity)

    
/*    
 * 
 * Otra forma de crear un vector genérico sin usar un vector de Object
 * 
 * @SuppressWarnings("unchecked")
    public ArrayList(String cName) throws IllegalArgumentException {
        Class<E> cl;
        try {
            cl = (Class<E>) Class.forName(cName);
            data = (E[]) Array.newInstance(cl, INITIAL_CAPACITY);
            nElems = 0;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            throw new IllegalArgumentException("Nombre de clase inexistente:" 
                    + cName);
        }		
    }
  */  
    /**
     * Construye una lista vacía de objetos
     * 
     * <br><B>PRE:</B> Cierto
     * <br><B>POST:</B> crea una lista vacía.
     * 
     */
    @SuppressWarnings("unchecked")
    public ArrayList() {                 
        data = (E[]) new Object[INITIAL_CAPACITY];
        nElems = 0;   
    }

    /**
     * Constructor de copia
     * 
     * <br><B>PRE:</B> Cierto
     * <br><B>POST:</B> crea una lista igual a org (shallow copy).
     * 
     */
    public ArrayList(ArrayList<E> org){
        this.nElems = org.nElems;		
        this.data = Arrays.copyOf(org.data, nElems);		
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
    public void add(int insertIndex, E element) throws IndexOutOfBoundsException { // Throw exception if insertIndex is not in range
        if (insertIndex < 0 || insertIndex > size())
            throw new IndexOutOfBoundsException("" + insertIndex);

        // Increase the array capacity if necessary
        if (size() == data.length){
            // Change data to have the same elements in indexes 0..n - 1
            // and have the same number of new array locations to store new elements.
            this.data = Arrays.copyOf(this.data, nElems + GROW_SHRINK_INCREMENT);
            //System.out.println(data.length);
        }

        // Slide all elements right to make a hole at insertIndex
        for (int index = size(); index > insertIndex; index--) 
            data[index] = data[index - 1];
        // Insert element into the "hole" and increment n.
        data[insertIndex] = element;
        nElems++; 
    }


    /**
     * Lectura indexada de una posición del arraylist
     * 
     * <br><B>PRE:</B> insertIndex EN {0..size()-1}
     * <br><B>POST:</B> devuelve una ref al elemento que está en la pos index.
     * 
     * @throws IndexOutOfBoundsException 
     */
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("" + index);
        return (E) data[index]; 
    }

    /**
     * No. de elementos en el arraylist
     * 
     * <br><B>PRE:</B> cierto
     * <br><B>POST:</B> devuelve el no. de elems que hay en el arraylist.
     */
    public int size() {
        return nElems; 
    }

    /**
     * Escritura indexada en una posición del arraylist
     * 
     * <br><B>PRE:</B> insertIndex EN {0..size()-1}
     * <br><B>POST:</B> coloca element en la posición insertIndex de la lista destruyendo 
     * el elemento que había en esa posición.
     * 
     * @throws IndexOutOfBoundsException 
     */
    @Override
    public void set(int insertIndex, E element) throws IndexOutOfBoundsException {
        if (insertIndex < 0 || insertIndex >= size())
            throw new IndexOutOfBoundsException("" + insertIndex);
        data[insertIndex] = element;
    }

    /**
     * Posición de un elemento dentro del arraylist
     * 
     * <br><B>PRE:</B> Cierto
     * <br><B>POST:</B> devuelve una ref al primer elemento del arraylist
     * que es igual a search (equals), o -1 si no existe ningún elemento igual a search.
     * 
     */
    public int indexOf(E search) {
        // Get index of first element that equals target 
        int index;
        for (index = 0; index < nElems && !data[index].equals(search); index++);

        if (index < nElems) 
            return index;
        else
            return -1; // Did not find target in this list 
    }

    /**
     * Extracción de un elemento del arraylist dada su posición
     * 
     * <br><B>PRE:</B> removalIndex EN {0..size()-1}
     * <br><B>POST:</B> extrae el elemento que está en la pos removalIndex.
     * 
     * @throws IndexOutOfBoundsException 
     */
    @Override
    public void removeElementAt(int removalIndex) throws IndexOutOfBoundsException {
        if (removalIndex < 0 || removalIndex >= size())
            throw new IndexOutOfBoundsException("" + removalIndex);
        nElems--;
        for(int i = removalIndex; i<nElems; i++)
            data[i] = data[i+1];

        // check whether is necessary to shrink the array
        // because there exist free GROW_SHRINK_INCREMENT*2 locations
        if (data.length - nElems >= GROW_SHRINK_INCREMENT*2){
            // Change data to have the same elements in indexes 0..n - 1
            // and have the same number of new array locations to store new elements.
            this.data = Arrays.copyOf(this.data, nElems + GROW_SHRINK_INCREMENT);
            //System.out.println(data.length);
        }
    }

    /**
     * Extracción de un elemento del arraylist dado un elemento igual (equals)
     * 
     * <br><B>PRE:</B> cierto
     * <br><B>POST:</B> extrae el primer elemento que sea igual a element (equals) y devuelve cierto, 
     * si existe. Y si no existe, devuelve falso.
     * 
     */
    @Override
    public boolean remove(E element) {
        int pos = indexOf(element);
        if (pos == -1)
            return false;
        else {
            this.removeElementAt(pos);
            return true;
        }
    }

    /**
     * Igualdad de arraylists
     * 
     * <br><B>PRE:</B> Cierto
     * <br><B>POST:</B> indica si obj es igual a this. Dos listas son iguales
     * si las secuencias de objetos almacenados en ellas son iguales. Cada par de objetos
     * son comparados con el método equals de la clase a la que pertenecen estos objetos.
     * 
     */
    public boolean equals(Object obj){
        if (!(obj instanceof ArrayList<?>))
            return false;

        ArrayList<?> arr = (ArrayList<?>) obj;

        if (this.nElems != arr.nElems)
            return false;
        else {
            if (this.nElems == 0) // both are empty
                return true;
            Object elem = ((ArrayList<?>) obj).data[0];
            if (!(this.data[0].getClass().equals(elem.getClass())))
                return false;

            int i;
            for(i=0; i<nElems && this.data[i].equals(arr.data[i]); i++);
            return i==nElems;		
        }
    }

    /**
     * Devuelve un string con los elementos de la lista
     * 
     * <br><B>PRE:</B> Cierto
     * <br><B>POST:</B> devuelve un string con los elementos de la lista separados
     * por comas y saltos de línea.
     */
    public String toString(){
        if (this.nElems == 0)
            return "[]";
        else {
            String result = "[";
            for(int i=0; i<nElems-1; i++) result += data[i] + ",\n";
            return result + data[nElems-1] + "]";
        }
    }


}
