package pilas;

import pilas.excepciones.EmptyStackException;
import pilas.excepciones.FullStackException;

public class BoundedStack<E> {
	private E[] datos;
	private int elems;
	
	@SuppressWarnings("unchecked")
	public BoundedStack(int capacidad) {
		datos = (E[]) new Object[capacidad]; //No es la forma adecuado de hacerlo, pero para esta asignatura se asumirá como correcta
		elems = 0;
	}
	
	//PRE: la pila no está llena
	public void push(E elem) throws FullStackException {
		if (elems>=datos.length){
			throw new FullStackException("La pila de capacidad "+
									datos.length+" está llena al"
								+ "intentar apilar el elem " + elem);
		}
		datos[elems++]=elem;		
	}
	
	//PRE: la pila no está vacía
	public E pop() throws EmptyStackException {
		if(elems == 0) {
			throw new EmptyStackException("La pila está vacía");
		}else {
			return datos[--elems];
		}
	}
	
	public E peek() throws EmptyStackException {
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