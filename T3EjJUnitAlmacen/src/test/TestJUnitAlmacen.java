package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tienda.Almacen;

public class TestJUnitAlmacen {

	private Almacen almacen;

	@Before
	public void setUp() {
		almacen = new Almacen(3);
	}
	/**
	 * Test method for {@link
	 * Almacen#test0Constructor()}.
	 */
	@Test
	public void test0Constructor() {
		assertEquals("pos 0 incorrectamente inicializada", 0, almacen.get(0));
		assertEquals("pos 1 incorrectamente inicializada", 0, almacen.get(1));
		assertEquals("pos 2 incorrectamente inicializada", 0, almacen.get(2));
	}
	
	@Test
	public void testRecibirProductos() {
		almacen.recibirProductos(0, 3);
		assertEquals("No se ha actualizado bien tras recibir productos de cod 0", 
				3, almacen.get(0));
		almacen.recibirProductos(1, 5);
		assertEquals("No se ha actualizado bien tras recibir productos de cod 1", 
				5, almacen.get(1));
		almacen.recibirProductos(1, 3);
		assertEquals("No se ha actualizado bien tras recibir productos de cod 1", 
				8, almacen.get(1));
	}
	
	@Test
	public void testToString() {
		assertEquals("El formato del toString no es correcto", "0,0,0", 
				almacen.toString());
		
		almacen.recibirProductos(0, 3);
		almacen.recibirProductos(1, 2);
		almacen.recibirProductos(2, 5);		
		assertEquals("El formato del toString no es correcto", "3,2,5", 
				almacen.toString());
		
	}

}



