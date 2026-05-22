package priorityQueue;

import java.util.logging.Level;
import java.util.logging.Logger;

import priorityQueue.exception.IncorrectPriority;
import queues.exceptions.EmptyQueueException;

public class PriorityQueueVIP<T> extends PriorityQueue<T>{

	private final static int CEDER_TURNO_TRAS = 5;
	private int [] atendidos;
	
	public PriorityQueueVIP(int prioridades) {
		super(prioridades);
		atendidos = new int [prioridades];
		
	}
	
	
	/**
	  * PRE: La cola no está vacía
	  * Este método retorna al siguiente elemento siguiendo el siguiente
	  * criterio:
	  * a.	Si de una cola se han atendido a cinco o más clientes, 
	  * se seleccionará a un cliente de inferior prioridad, 
	  * si lo hubiera. El contador de la cola de mayor prioridad
	  * que ha cedido el turno se pondrá a cero.
	  * b.	Si a una cola le corresponde ceder el turno, pero no hay
	  * elementos esperando en las prioridades inferiores, 
	  * el contador de solicitudes atendidas en esta prioridad
	  * se pone a cero y se atiende al individuo que lleve más tiempo
	  * esperando en la cola de la prioridad que le correspondía
	  * ceder el turno.
	  * c.	Si cuando una prioridad cede el turno, y la siguiente
	  * prioridad que tiene solicitudes pendientes está en situación
	  * de ceder el turno esta se cederá a la de siguiente prioridad
	  * disponible. En el caso de no haber nadie esperando en las
	  * prioridades inferiores se aplica lo estipulado en 
	  * el apartado b.

	  * @return retorna el siguiente elemento que debe ser atendido
	  * @throws EmptyQueueException 
	  */
	@Override
	 public T getNext() throws EmptyQueueException{
		if (this.isEmpty()){ //Nada que hader está vacía
			throw new EmptyQueueException ("No hay nadie esperando!!!");
		}
		int colaSeleccionada = -1; //Tendremos la prioridad de la cola selaccionada según el criterio de selección
		/*
		 * Para evitar tener que hacer un segundo recorrido en el 
		 * caso de que se tenga que ceder turno y no haya
		 * prioridad a la que cederlo, vamos a recordar
		 * la cola de mayor prioridad que cede el turno. Si
		 * finalmente este cesión no se puede dar será esta
		 * la cola que se usará.
		 */
		int colaMayorPrioridadNoVacia = -1;
		for (int i = this.atendidos.length -1; i > 0 && 
				colaSeleccionada == -1; i --){//FOR
			try {
				if (this.esColaPrioridadVacia(i) &&
						this.atendidos[i]  < CEDER_TURNO_TRAS ){//IF
					colaSeleccionada = i; //trabajamos en este método con índices de 0 a N-1
				}
				else if (this.atendidos[i] >= CEDER_TURNO_TRAS ){//Cede turno
					this.atendidos[i] = 0;
					//Si es la primera que cede el turno y hay esperando la vamos a recordar
					if (colaMayorPrioridadNoVacia == -1 && this.esColaPrioridadVacia(i)){
						colaMayorPrioridadNoVacia = i; //trabajamos en este método con índices de 0 a N-1
					}
				}//Cesión de turno
			} catch (IncorrectPriority e) {
				System.err.println("Esto no debería pasar si todo está bien implementado");
				e.printStackTrace();
			}//IF
		}//FOR
		
		//Ya se debe tener una cola seleccionada ahora hay que ver si es preciso
		//usar una cola que tenía que ceder el turno pero no pudo
		if (colaSeleccionada == -1){//No se seleccionó cola
			//Se coge la que cedió el turno
			colaSeleccionada = colaMayorPrioridadNoVacia;
		}
		
		this.atendidos[colaSeleccionada]++; 
		try {
			return this.getDatoPrioridad(colaSeleccionada);
		} catch (IncorrectPriority e) {
			Logger.getGlobal().log(Level.SEVERE,"Esto no debería haber pasado!!!", e);
			return null;
		}
	 }//getNext
}

