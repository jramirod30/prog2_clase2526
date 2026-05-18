/**
 * 
 */
package priorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import list.ArrayList;
import priorityQueue.exception.IncorrectPriority;
import queues.CircularQueue;
import queues.IQueue;
import queues.exceptions.EmptyQueueException;
/**
 * Esta clase permite la implementación de una cola con prioridad
 * El cirterio que implementa para dar al siguiente que está esperando
 * es mirar primero en la cola de mayor prioridad, si no hay nadie
 * pasa a la de anterior prioridad.
 * La cola de mayor prioridad es la que tiene el ID más alto.
 * Los IDs de las colas van de 1 a N siendo N la de mayor priroidad
 * El número de prioridades se indican al consturilo
 * @author agonzalez
 *
 */
public class PriorityQueue <T>{
 private ArrayList<IQueue<T>> colaEspera;
 //TODO Deina los atributos necesariso
 
 public PriorityQueue(int prioridades){
	//TODO
 }
 
 /**
  * Este método sirve para introducir un elemento en la 
  * cola de prioridad dada.
  * PRE: prioridad debe estar entre 1 y N
  * @param prioridad cola en la que se va a insertar. 1 Corresponde a la priordad más baja y N a la más alta
  * @param dato que se inserta
  */
 public void add (int prioridad, T dato) throws IncorrectPriority{
	 //TODO
 }
 
 //Gets
 public int getTotalEsperando(){
	 //TODO
	 return -1; //Dummy
 }
 
 public boolean isEmpty(){
	 //TODO
	 return false;
 }
 /**
  * PRE: La cola no está vacía
  * Este método retorna al siguiente elemento siguiendo el siguiente
  * criterio: Si hay alguien de la cola con mayor prioridad este será
  * el elegido. En el caso de que no lo haya se pasará la prioridad anterior.
  * Y así hasta encontrar alguno
  * @return retorna el siguiente elemento que debe ser atendido
 * @throws EmptyQueueException 
  */
 public T getNext() throws EmptyQueueException{
	 //TODO
	 return null;
 }

 //Vamos a permitir acceso a las colas, pero sólo para los hijos de esta clase
 //Implementación de los métodos protegidos requeridos para implementar la clase hija
 
}
