/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;


import secuencia.SortedDoubleLinkedList;
import secuencia.exception.ErrorBeginningOfList;
import secuencia.exception.ErrorCursor;
import secuencia.exception.ErrorEmptyList;
import secuencia.exception.ErrorEndOfList;

/**
 * TODO: Test  Next, Prev, isStart, isEnd
 */

/**
 * @author agonzalez
 *
 */
public class TestSortedDoubleLinkedList {
	private SortedDoubleLinkedList<Contacto, Comparator<Contacto>> agenda;
	private Contacto [] contactosOrdenados;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		agenda = new SortedDoubleLinkedList<>((Contacto c1, Contacto c2) -> c1.compareTo(c2));
		contactosOrdenados = new Contacto[]{
				new Contacto("A1", "Ap1, Ap1.2","", "", 22, 02, 2000),
				new Contacto("A1", "Ap1, Ap2","", "", 23, 02, 2001),
				new Contacto("A1", "Ap1, Ap2","", "", 22, 02, 2000),
				new Contacto("B1", "Ap1, Ap3","", "", 25, 05, 2010)
		};
	}

	/**
	 * Borra el último contacto de la agenda
	 * y el cursor mo está al final
	 * @throws ErrorBeginningOfList 
	 * @throws ErrorEmptyList 
	 * @throws ErrorCursor 
	 */
	@Test
	public void testdDelete2a() throws ErrorBeginningOfList, ErrorEmptyList, ErrorCursor {
		for (Contacto contacto : contactosOrdenados) {
			agenda.add(contacto);
		}
		agenda.goEnd(); //Current apunta al último
		agenda.goPrev(); //Current ya no apunta al último
		Contacto buscado = new Contacto (contactosOrdenados[3]);
		boolean bOK = agenda.delete(buscado);
		assertTrue("Se borra "+buscado, bOK && agenda.search(buscado) == null
				&& (contactosOrdenados.length-1) == agenda.size());
		assertTrue ("La posición del cursor no debía haber variado al haber borrado el último elemento", 
				contactosOrdenados[2] == agenda.getCurrent());
	}
	
	/**
	 * Borra el primer contacto de la agenda
	 * @throws ErrorEmptyList 
	 * @throws ErrorCursor 
	 */
	@Test
	public void testDelete() throws ErrorEmptyList, ErrorCursor {
		for (Contacto contacto : contactosOrdenados) {
			agenda.add(contacto);
		}
		Contacto actual = agenda.getCurrent();
		Contacto buscado = new Contacto (contactosOrdenados[0]);
		boolean bOK = agenda.delete(buscado);
		assertTrue("Se borra "+buscado, bOK && agenda.search(buscado) == null
				&& (contactosOrdenados.length-1) == agenda.size());
		assertTrue ("La posición del cursor no tenía que haber variado", actual == agenda.getCurrent());
	}
	
	/**
	 * Borra el primer contacto de la agenda y el cursor está en la primera posición
	 * @throws ErrorEmptyList 
	 * @throws ErrorEndOfList 
	 * @throws ErrorCursor 
	 */
	@Test
	public void testDelete1a() throws ErrorEmptyList, ErrorEndOfList, ErrorCursor {
		for (Contacto contacto : contactosOrdenados) {
			agenda.add(contacto);
		}
		agenda.goFirst(); //Se lleva al primer elemento de la lista
		Contacto buscado = new Contacto (contactosOrdenados[0]);
		boolean bOK = agenda.delete(buscado);
		assertTrue("Se borra "+buscado, bOK && agenda.search(buscado) == null
				&& (contactosOrdenados.length-1) == agenda.size());
		assertTrue ("La posición del cursor debía haber variado al haber borrado al primer elemento", contactosOrdenados[1] == agenda.getCurrent());
	}

	/**
	 * Borra el último contacto de la agenda
	 * y el cursor está al final
	 * @throws ErrorBeginningOfList 
	 * @throws ErrorEmptyList 
	 * @throws ErrorCursor 
	 */
	@Test
	public void testDelete2() throws ErrorBeginningOfList, ErrorEmptyList, ErrorCursor {
		for (Contacto contacto : contactosOrdenados) {
			agenda.add(contacto);
		}
		agenda.goEnd(); //Current apunta al último
		Contacto buscado = new Contacto (contactosOrdenados[3]);
		boolean bOK = agenda.delete(buscado);
		assertTrue("Se borra "+buscado, bOK && agenda.search(buscado) == null
				&& (contactosOrdenados.length-1) == agenda.size());
		assertTrue ("La posición del cursor debía haber variado al haber borrado el último elemento", 
				contactosOrdenados[2] == agenda.getCurrent());
	}
	
	/**
	 * Borra el un contacto del medio de la agenda
	 * @throws ErrorEmptyList 
	 * @throws ErrorCursor 
	 */
	@Test
	public void testDelete3() throws ErrorEmptyList, ErrorCursor {
		for (Contacto contacto : contactosOrdenados) {
			agenda.add(contacto);
		}
		Contacto actual = agenda.getCurrent();
		Contacto buscado = new Contacto (contactosOrdenados[2]);
		boolean bOK = agenda.delete(buscado);
		assertTrue("Se borra "+buscado, bOK && agenda.search(buscado) == null 
				&& (contactosOrdenados.length-1) == agenda.size());
		assertTrue ("La posición del cursor no tenía que haber variado", actual == agenda.getCurrent());
	}
	
	/**
	 * Prueba que se lance la excepción cuando está vacío y se pide el primer dato
	 * @throws ErrorEmptyList
	 */
	@Test (expected = ErrorEmptyList.class)
	public void testGetFirst() throws ErrorEmptyList {
		agenda.getFirst();
	}
	
	/**
	 * Prueba a pedir el primer dato y verifica que el cursor no se altera
	 * @throws ErrorEmptyList
	 * @throws ErrorCursor
	 */
	public void testGetFirst2() throws ErrorEmptyList, ErrorCursor {
		int i = 0;
		for (; i < contactosOrdenados.length / 2; i++ ) {
			agenda.add(this.contactosOrdenados[i]);
		}	
		agenda.goEnd();
		assertEquals("No es el primero", contactosOrdenados[0], agenda.getFirst());
		assertEquals("se ha movido el cursor", contactosOrdenados[i-1], agenda.getCurrent());
	}
	
	/**
	 * Prueba que se lance la excepción cuando está vacío y se pide el primer dato
	 * @throws ErrorEmptyList
	 */
	@Test (expected = ErrorEmptyList.class)
	public void testGetLast() throws ErrorEmptyList {
		agenda.getLast();
	}
	
	/**
	 * Prueba a pedir el primer dato y verifica que el cursor no se altera
	 * @throws ErrorEmptyList
	 * @throws ErrorCursor
	 */
	public void testGetLast2() throws ErrorEmptyList, ErrorCursor {
		int i = 0;
		for (; i < contactosOrdenados.length / 2; i++ ) {
			agenda.add(this.contactosOrdenados[i]);
		}	
		agenda.goFirst();
		assertEquals("No es el primero", contactosOrdenados[i-1], agenda.getLast());
		assertEquals("se ha movido el cursor", contactosOrdenados[0], agenda.getCurrent());
	}
	
	/**
	 * Prueba que se lance la excepción cuando se pide ir al final de la cadena
	 * y esta está vacía
	 * @throws ErrorEmptyList
	 */
	@Test (expected = ErrorEmptyList.class)
	public void testGoEnd() throws ErrorEmptyList {
		agenda.goEnd();
	}
	
	/**
	 * Prueba a ir al final de la cadena cuando hay datos
	 * @throws ErrorEmptyList
	 * @throws ErrorCursor
	 */
	public void testGoEnd2() throws ErrorEmptyList, ErrorCursor {
		int i = 0;
		for (; i < contactosOrdenados.length / 2; i++ ) {
			agenda.add(this.contactosOrdenados[i]);
		}
		agenda.goEnd();
		assertEquals("No es el primero", contactosOrdenados[i-1], agenda.getCurrent());
	}
	
	/**
	 * Prueba que se lance la excepción cuando está vacío y se pide ir al principio
	 * @throws ErrorEmptyList
	 */
	@Test (expected = ErrorEmptyList.class)
	public void testGoFirst() throws ErrorEmptyList {
		agenda.goFirst();
	}
	
	/**
	 * Prueba que se pueda ir al principio de la cadena
	 * @throws ErrorEmptyList
	 * @throws ErrorCursor
	 */
	public void testGoFirst2() throws ErrorEmptyList, ErrorCursor {
		for (int i= 0; i < contactosOrdenados.length / 2; i++ ) {
			agenda.add(this.contactosOrdenados[i]);
		}
		agenda.goFirst();
		assertEquals("No es el primero", contactosOrdenados[0], agenda.getCurrent());
	}
	
	@Test
	public void testInsertarDesordenado() throws ErrorEmptyList, ErrorEndOfList, ErrorCursor {
		agenda.add(contactosOrdenados[2]);
		assertTrue ("El cursor (current) del itreador no se queda apuntando a la instancia insertada", 
				 contactosOrdenados[2] ==  agenda.getCurrent());
		agenda.add(contactosOrdenados[1]);
		assertTrue ("El cursor (current) del itreador no se queda apuntando a la instancia insertada", 
				 contactosOrdenados[1] ==  agenda.getCurrent());
		agenda.add(contactosOrdenados[3]);
		assertTrue ("El cursor (current) del itreador no se queda apuntando a la instancia insertada", 
				 contactosOrdenados[3] ==  agenda.getCurrent());
		agenda.add(contactosOrdenados[0]);
		assertTrue ("El cursor (current) del itreador no se queda apuntando a la instancia insertada", 
				 contactosOrdenados[0] ==  agenda.getCurrent());
		verificarOrden(" cuando se han insertado los contactos ordenados están desordenados ");
	}

	@Test
	public void testInsertarDuplicado() {
		Contacto duplicado1 = new Contacto(contactosOrdenados[2]);
		Contacto duplicado2 = new Contacto(contactosOrdenados[1]);
		Contacto duplicado3 = new Contacto(contactosOrdenados[3]);
		Contacto duplicado4 = new Contacto(contactosOrdenados[0]);
		agenda.add(duplicado1);
		agenda.add(duplicado2);
		agenda.add(duplicado3);
		agenda.add(duplicado4);
		Contacto busqueda = agenda.search(duplicado1);
		assertTrue("Deberían ser la misma instancia, recuerde cuando se inserta un duplicado este va delante", busqueda == duplicado1);
		busqueda = agenda.search(duplicado2);
		assertTrue("Deberían ser la misma instancia, recuerde cuando se inserta un duplicado este va delante", busqueda == duplicado2);
		busqueda = agenda.search(duplicado3);
		assertTrue("Deberían ser la misma instancia, recuerde cuando se inserta un duplicado este va delante", busqueda == duplicado3);
		busqueda = agenda.search(duplicado4);
		assertTrue("Deberían ser la misma instancia, recuerde cuando se inserta un duplicado este va delante", busqueda == duplicado4);
		//fail ("Falta por verificar que el duplicado se inserta antes del que ya está"); 
	}
	
	@Test
	public void testInsertarOrdenado() throws ErrorEmptyList, ErrorEndOfList, ErrorCursor {
		
		for (int i = 0; i< contactosOrdenados.length; i++) {
			agenda.add(contactosOrdenados[i]);
			assertTrue ("El cursor (current) del itreador no se queda apuntando a la instancia insertada", 
					 contactosOrdenados[i] ==  agenda.getCurrent());
		}
		assertTrue("La ocupación debe ser "+contactosOrdenados.length, contactosOrdenados.length == agenda.size()); 
		verificarOrden(" cuando se han insertado los contactos ordenados ");
	}
	
	@Test
	public void testInsertarOrdenadoInverso() throws ErrorEmptyList, ErrorEndOfList, ErrorCursor {
		for (int i = contactosOrdenados.length-1; i >=0;i--) {
			agenda.add(contactosOrdenados[i]);
		}
		assertTrue("La ocupación debe ser "+contactosOrdenados.length, contactosOrdenados.length == agenda.size());  
		verificarOrden(" cuando se han insertado los contactos ordenados en orden inverso ");
	}
	
	/**
	 * Prueba el método isEmpty y size cuando está vacía la estrucutura
	 */
	@Test
	public void testIsEmptySize() {
		assertTrue("No hay elementos y debería estar vacía ",agenda.isEmpty());
		assertEquals("No hay elementos size debería ser cero ",0,agenda.size());
	}
	
	/**
	 * Prueba el método isEmpty y size cuando no está vacía la estrucutura y
	 * vuelve a estar vacía cuando se extrae el último elemento
	 */
	@Test
	public void testIsEmpty2() {
		agenda.add(contactosOrdenados[2]);
		agenda.add(contactosOrdenados[2]);
		assertFalse("Hay elementos y no debería estar vacía ",agenda.isEmpty());
		assertEquals("Hay elementos size debería ser distinto de cero ",2,agenda.size());
		agenda.delete(contactosOrdenados[2]);
		assertFalse("Hay elementos y no debería estar vacía ",agenda.isEmpty());
		assertEquals("Hay elementos size debería ser distinto de cero ",1,agenda.size());
		agenda.delete(contactosOrdenados[2]);
		assertTrue("No hay elementos y debería estar vacía ",agenda.isEmpty());
		assertEquals("No hay elementos size debería ser cero ",0,agenda.size());
	}
	
	/**
	 * Busca el primer contacto de la agenda
	 * @throws ErrorEmptyList 
	 * @throws ErrorCursor 
	 */
	@Test
	public void testSearch() throws ErrorEmptyList, ErrorCursor {
		for (Contacto contacto : contactosOrdenados) {
			agenda.add(contacto);
		}
		Contacto buscado = new Contacto (contactosOrdenados[0]);
		Contacto encontrado = agenda.search(buscado);
		assertTrue("Se buscaba "+buscado+ " y se ha encontrado "+encontrado, encontrado !=null && buscado.compareTo(encontrado)==0);
		//SE verifica que el cursor se quede apuntando al dato buscado
		assertTrue ("El cursor (current) del itreador no se queda apuntando a la instancia buscada", 
				contactosOrdenados[0] ==  agenda.getCurrent()); 
	}
	
	/**
	 * Busca el último contacto de la agenda
	 * @throws ErrorEmptyList 
	 * @throws ErrorCursor 
	 */
	@Test
	public void testSearch2() throws ErrorEmptyList, ErrorCursor {
		for (Contacto contacto : contactosOrdenados) {
			agenda.add(contacto);
		}
		Contacto buscado = new Contacto (contactosOrdenados[3]);
		Contacto encontrado = agenda.search(buscado);
		assertTrue("Se buscaba "+buscado+ " y se ha encontrado "+encontrado, encontrado !=null && buscado.compareTo(encontrado)==0);
		//SE verifica que el cursor se quede apuntando al dato buscado
		assertTrue ("El cursor (current) del itreador no se queda apuntando a la instancia buscada", 
						contactosOrdenados[3] ==  agenda.getCurrent()); 
	}

	
	/**
	 * Busca un contacto del medio contacto de la agenda
	 * @throws ErrorEmptyList 
	 * @throws ErrorCursor 
	 */
	@Test
	public void testSearch3() throws ErrorEmptyList, ErrorCursor {
		for (Contacto contacto : contactosOrdenados) {
			agenda.add(contacto);
		}
		Contacto buscado = new Contacto (contactosOrdenados[2]);
		Contacto encontrado = agenda.search(buscado);
		assertTrue("Se buscaba "+buscado+ " y se ha encontrado "+encontrado, encontrado !=null && buscado.compareTo(encontrado) == 0);
		//SE verifica que el cursor se quede apuntando al dato buscado
		assertTrue ("El cursor (current) del itreador no se queda apuntando a la instancia buscada", 
		 contactosOrdenados[2] ==  agenda.getCurrent());
	}
	
	/**
	 * Busca un contacto que no está en la agenda
	 * @throws ErrorEmptyList 
	 * @throws ErrorCursor 
	 */
	@Test
	public void testSearch4() throws ErrorEmptyList, ErrorCursor {
		for (Contacto contacto : contactosOrdenados) {
			agenda.add(contacto);
		}
		Contacto actual = agenda.getCurrent();
		Contacto buscado = new Contacto ("No estoy", "No Estoy");
		Contacto encontrado = agenda.search(buscado);
		assertTrue("Error al bucar el contacto: "+buscado+ " que no debería estar "+encontrado, encontrado == null );
		//SE verifica que el cursor se quede apuntando al dato buscado
		assertTrue ("El cursor (current) del itreador no se queda apuntando a la instancia buscada", 
		 actual ==  agenda.getCurrent());
	}
	
	private void verificarOrden(String info) throws ErrorEmptyList, ErrorEndOfList, ErrorCursor {
		//Se procede a verificar
				agenda.goFirst();
				for (int i = 0; i < contactosOrdenados.length; i++) {
					Contacto aux = agenda.getCurrent();
					assertTrue("Verificando el contacto "+(i+1)+info+aux+"!="+ contactosOrdenados[i], 
							aux!=null && aux == contactosOrdenados[i]); //Se verifica que se la misma instancia. Agenda no saca copia ni retorna una copia
					if (!agenda.isEnd()) {
						agenda.goNext();
					}
				}
				assertTrue("Verificando fin tras recorrido", agenda.isEnd());
	}
}
