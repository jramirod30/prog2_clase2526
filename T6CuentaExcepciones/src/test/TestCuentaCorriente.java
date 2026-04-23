/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import banco.CuentaCorriente;
import banco.exception.CantidadIncorrecta;
import banco.exception.SaldoInicialInsuficiente;
import banco.exception.SaldoInsuficiente;

/**
 * @author angel
 *
 */
public class TestCuentaCorriente {
	private CuentaCorriente cuentaTest;
	private final static double SALDO_INICIAL = 100;
	@Before
	public void setUp() throws Exception {
		cuentaTest = new CuentaCorriente("Cliente 1", SALDO_INICIAL);
	}

	/**
	 * Prueba la construcción de una cuenta corriente cuando se cumplen todas las pres
	 */
	@Test
	public void testCuentaCorriente() {
		try {
			CuentaCorriente cuenta = new CuentaCorriente ("Cliente 1", 21);
			assertTrue ("Error en el saldo tras crear la cuenta con un saldo de 21",
					cuenta.getSaldo() == (21 - CuentaCorriente.getGastosApertura()));
			assertEquals ("No se ha incializado bien el cliente", 
					"Cliente 1",cuenta.getCliente());
			cuenta = new CuentaCorriente ("Cliente 1", CuentaCorriente.getGastosApertura());
			assertTrue ("Error en el saldo tras crear la cuenta con un saldo incial igual a los gastos de apertura",
					cuenta.getSaldo() == 0 );
		} catch (SaldoInicialInsuficiente e) {
			assertTrue ("Error se ha producido una excepción inesperada: "+e.getMessage(), false); 
		}
	}
	
	/**
	 * Prueba la construcción de una cuenta corriente con saldo insuficiente
	 * @throws SaldoInicialInsuficiente 
	 */
	@SuppressWarnings("unused")
	@Test (expected = SaldoInicialInsuficiente.class )
	public void testCuentaCorriente2() throws SaldoInicialInsuficiente  {
			CuentaCorriente cuenta = new CuentaCorriente ("Cliente 1", 9);
	}
	
	/**
	 * Test que comprueba sacar dinero cuando se cumplen las precondiciones 
	 */
	@Test
	public void testSacarDinero() {
		try {
			cuentaTest.sacarDinero(20);
			assertTrue ("Error en el saldo tras sacar 20 ",
					cuentaTest.getSaldo() == (SALDO_INICIAL - 20 - CuentaCorriente.getGastosApertura()));
			cuentaTest.sacarDinero(cuentaTest.getSaldo());
			assertTrue ("Error en el saldo tras sacar todo el saldo que queda ",
					cuentaTest.getSaldo() == 0);
		} catch (CantidadIncorrecta e) {
			// TODO Auto-generated catch block
			assertTrue ("Error se ha producido una excepción inesperada: "+e.getMessage(), false);
		} catch (SaldoInsuficiente e) {
			assertTrue ("Error se ha producido una excepción inesperada: "+e.getMessage(), false);
		}
	}

	/**
	 * Test que comprueba sacar dinero con una cantidad negativa 
	 * @throws SaldoInsuficiente 
	 * @throws CantidadIncorrecta 
	 */
	@Test (expected = CantidadIncorrecta.class)
	public void testSacarDinero2() throws CantidadIncorrecta, SaldoInsuficiente {
		cuentaTest.sacarDinero(0);
	}
	
	/**
	 * Test que comprueba sacar dinero con una cantidad negativa 
	 * @throws SaldoInsuficiente 
	 * @throws CantidadIncorrecta 
	 */
	@Test (expected = CantidadIncorrecta.class)
	public void testSacarDinero3() throws CantidadIncorrecta, SaldoInsuficiente {
		cuentaTest.sacarDinero(-2);
	} 
	
	/**
	 * Test que comprueba ingresar dinero cuando se cumple la precondición
	 * @throws CantidadIncorrecta 
	 */
	@Test
	public void testIngresarDinero() throws CantidadIncorrecta {
		cuentaTest.ingresarDinero(12);
		assertTrue ("El saldo no es correcto tras ingresar 12",
				cuentaTest.getSaldo() == (SALDO_INICIAL + 12 - CuentaCorriente.getGastosApertura()));
		
	}
	
	/**
	 * Test que comprueba ingresar dinero cuando no se cumple la precondición
	 * @throws CantidadIncorrecta 
	 */
	@Test (expected = CantidadIncorrecta.class)
	public void testIngresarDinero2() throws CantidadIncorrecta {
		cuentaTest.ingresarDinero(0);
		
		
	}

	/**
	 * Test que comprueba ingresar dinero cuando no se cumple la precondición
	 * @throws CantidadIncorrecta 
	 */
	@Test (expected = CantidadIncorrecta.class)
	public void testIngresarDinero3() throws CantidadIncorrecta {
		cuentaTest.ingresarDinero(-5);
		
		
	}
	
	/**
	 * Comprueba que se establecen bien los gastos de apertura
	 * @throws CantidadIncorrecta 
	 */
	@Test
	public void testSetGastosApertura() throws CantidadIncorrecta {
		CuentaCorriente.setGastosApertura(35);
		assertTrue("No se han actualizado los gastos de apertura", 
				CuentaCorriente.getGastosApertura() == 35);
	}
	
	/**
	 * Comprueba a establecer gastos de apartura incorrectos
	 * @throws CantidadIncorrecta 
	 */
	@Test (expected = CantidadIncorrecta.class)
	public void testSetGastosApertura2() throws CantidadIncorrecta {
		CuentaCorriente.setGastosApertura( -5);
	}
	

}
