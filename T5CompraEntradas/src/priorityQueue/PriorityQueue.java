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
 private int totalEsperano = 0;
 
 public PriorityQueue(int prioridades){
	 colaEspera = new ArrayList<>();
	 for (int i = 0; i < prioridades;i++) {
		 colaEspera.add(i, new CircularQueue<T>());
	 }
 }
 
 /**
  * Este método sirve para introducir un elemento en la 
  * cola de prioridad dada.
  * PRE: prioridad debe estar entre 1 y N
  * @param prioridad cola en la que se va a insertar. 1 Corresponde a la priordad más baja y N a la más alta
  * @param dato que se inserta
  */
 public void add (int prioridad, T dato) throws IncorrectPriority{
	if(prioridad < 1 || prioridad > this.colaEspera.size()) {
		throw new IncorrectPriority("La prioridad: "+ prioridad +
				" no está dentro del rango permitido: 1 a " + this.colaEspera.size());
	}
	this.colaEspera.get(prioridad-1).add(dato);
	this.totalEsperano ++;
 }
 
 //Gets
 public int getTotalEsperando(){
	 //TODO
	 return this.totalEsperano; //Dummy
 }
 
 public boolean isEmpty(){
	 //TODO
	 return this.totalEsperano == 0;
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
	 if (this.isEmpty()) {
		 throw new EmptyQueueException("No hay datos en la cola");
	 }
	 T dato = null;
	 for (int i = this.colaEspera.size() - 1; i >=0 && dato == null; i --) {
		 if (!this.colaEspera.get(i).isEmpty()) {
			 dato = this.colaEspera.get(i).poll();
		 }
	 }
	 this.totalEsperano --;
	 return dato;
 }

 //Vamos a permitir acceso a las colas, pero sólo para los hijos de esta clase
 //Implementación de los métodos protegidos requeridos para implementar la clase hija
 /**
  * 
  * @param prioridad >=0 y < N <- Las priroidades en este caso siguen el criterio de índices del ArrayList
  * @return
 * @throws IncorrectPriority 
  */
 protected boolean esColaPrioridadVacia(int prioridad) throws IncorrectPriority {
	 if (prioridad < 0 || prioridad >= this.colaEspera.size()) {
			throw new IncorrectPriority("Revisa la implementación por que me estás pasando una prioriodad fuera de rango de 0 a "
		+ (this.colaEspera.size()-1));
		}
	 return this.colaEspera.get(prioridad).isEmpty();
 }
 
 /**
  * 
  * @param prioridad >=0 y < N <- Las priroidades en este caso siguen el criterio de índices del ArrayList
  * @return
 * @throws EmptyQueueException 
 * @throws IndexOutOfBoundsException 
  */
 protected T getDatoPrioridad(int prioridad) throws IncorrectPriority, EmptyQueueException {
	if (prioridad < 0 || prioridad >= this.colaEspera.size()) {
		throw new IncorrectPriority("Revisa la implementación por que me estás pasando una prioriodad fuera de rango de 0 a "
	+ (this.colaEspera.size()-1));
	}
	if (this.colaEspera.get(prioridad).isEmpty()) {
		throw new EmptyQueueException("La cola está vacía revise su implementación");
	}
	
	T dato = this.colaEspera.get(prioridad).poll();
	this.totalEsperano --;
	return dato;
 }
}
