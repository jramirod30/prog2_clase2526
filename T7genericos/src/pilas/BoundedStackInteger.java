package pilas;

import pilas.excepciones.EmptyStackException;
import pilas.excepciones.FullStackException;

public class BoundedStackInteger {
	private int[] datos;
	private int elems;
	
	public BoundedStackInteger(int capacidad) {
		datos = new int[capacidad];
		elems = 0;
	}
	
	//PRE: la pila no está llena
	public void push(int elem) throws FullStackException {
		if (elems>=datos.length){
			throw new FullStackException("La pila de capacidad "+
									datos.length+" está llena al"
								+ "intentar apilar el elem " + elem);
		}
		datos[elems++]=elem;		
	}
	
	//PRE: la pila no está vacía
	public int pop() throws EmptyStackException {
		if(elems == 0) {
			throw new EmptyStackException("La pila está vacía");
		}else {
			return datos[--elems];
		}
	}
	
	public int peek() throws EmptyStackException {
		if(elems == 0) {
			throw new EmptyStackException("La pila está vacía");
		}else {
			return datos[elems-1];
		}
	}
	
	public boolean isEmpty() {
		return elems == 0;
	}
	
	public boolean isFull() {
		return elems == datos.length;
	}
	
}