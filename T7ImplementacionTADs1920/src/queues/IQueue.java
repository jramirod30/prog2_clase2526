package queues;

import queues.exceptions.EmptyQueueException;

public interface IQueue<E> {

    /**
     * Indica si la cola está vacía
     * <br><B>PRE:</B> Cierto
     * <br><B>POST:</B> cierto si no quedan elementos en la cola
     *
     * 
     */
    boolean isEmpty();

    /**
     * Inserta un elemento en la cola; El elemento insertado se coloca el último de la colección
     * <br><B>PRE:</B> Cierto
     * <br><B>POST:</B>Cola de entrada con un elemento al final
     *
     * @param  elemento Referencia a la información que se va a guardar en la cola. <B> No se saca copia de la información referenciada</B>
     **/
    void add(E elemento);//Insertar

    /**
     * Retorna el primer elemento de la cola, sin alterar la cola
     * <br><B>PRE:</B> la cola no es vacía
     * <br><B>POST:</B>Retorna referencia al elemento que ocupa la primera posición de la cola
     *
     * @return Si la cola no está vacía retorna el primer elemento de la cola. 
     * Si la cola está vacía se levanta una excepción
     * @throws EmptyQueueException excepción que se genera si se viola la precondición
     */
    E peek() throws EmptyQueueException;//Primero

    /**
     * Saca el primer elemento de la cola
     * <br><B>PRE:</B> la cola no está vacía
     * <br><B>POST:</B> Se retorna la referencia al primer elemento de la cola y se extrae esta referencia de la cola
     *
     * @throws EmptyQueueException excepción que se genera si se viola la precondición
     */
    E poll() throws EmptyQueueException;//Sacar_Primero

}