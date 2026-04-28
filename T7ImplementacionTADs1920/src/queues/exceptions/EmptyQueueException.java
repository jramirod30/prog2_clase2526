/*
 * Excepcion_Cola_Vacia.java
 *
 * Created on 11 de agosto de 2005, 11:52
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author agonzalez
 */
package queues.exceptions;
public class EmptyQueueException extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Creates a new instance of Excepcion_Cola_Vacia */
    public EmptyQueueException() {
        super ("Intenta obtener información de una cola vacía");
    }
    public EmptyQueueException(String msg){
    	super(msg);
    }
    
}
