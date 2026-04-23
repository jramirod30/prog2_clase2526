/**
 * 
 */
package banco;

import banco.exception.CantidadIncorrecta;
import banco.exception.SaldoInicialInsuficiente;
import banco.exception.SaldoInsuficiente;

/**
 * @author angel
 *
 */
public class CuentaCorriente {
	private String cliente;
	private double saldo;
	private static double gastosApertura = 10;
	
	/**
	 * Contruye una cuanta bancaria
	 * PRE: saldoInical >= gastosApertura
	 */
	public CuentaCorriente(String cliente, double saldoInicial){
		//TODO
		
	}
	
	/**
	 * Retira dinero de la cuenta
	 * PRE: cantidad > 0 y cantidad < = saldo
	 * @param cantidad
	 * @throws CantidadIncorrecta 
	 * @throws SaldoInsuficiente 
	 */
	public void sacarDinero (double cantidad){
		//TODO
		
	}
	
	/**
	 * Ingresa dinero en la cuenta
	 * PRE: cantidad > 0
	 * @param cantidad
	 * @throws CantidadIncorrecta 
	 */
	public void ingresarDinero (double cantidad) {
		//TODO
		
		
	}
	
	/**
	 * Establece los gastos de apertura de la cuenta
	 * PRE: gastos  > = 0
	 * @param gastos
	 * @throws CantidadIncorrecta 
	 */
	public static void setGastosApertura (double gastos){
		//TODO

	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public String getCliente() {
		return cliente;
	}

	public static double getGastosApertura() {
		return gastosApertura;
	}
}
