package vajilla;

import vajilla.exception.ExcepcionCantidadExcesiva;
import vajilla.exception.ExcepcionPrepararDesayuo;
import vajilla.exception.ExcepcionVasoNoCabe;

/**
 * Esta clase define un vaso el cual notifica con expciones las situaciones anómalas
 * @author angel
 *
 */
public class Vaso{
	
	private double capacidadMax;
	private double contenido = 0.0;
	
	public Vaso (double capacidadMax){
		this.capacidadMax = capacidadMax;
	}
	
	/**
	 * Este método mete una cantidad en ml en el vaso
	 * PRE: cantidad + contenido <= capacidadMaxima
	 * @param cantidad
	 * @throws ExcepcionVasoNoCabe
	 */
	public void llenar (double cantidad) throws ExcepcionVasoNoCabe{
		if (this.contenido + cantidad > capacidadMax){
			throw new ExcepcionVasoNoCabe("No cabe cantidad");
		}
		//No se necesita rama else por que el throw corta la ejecución de este método
		this.contenido+= cantidad;
	}
	
	/**
	 * Este método saca una cantidad del vaso
	 * PRE: cantidad <= contenido
	 * @param cantidad
	 * @throws ExcepcionCantidadExcesiva
	 */
	public void vaciar(double cantidad) throws ExcepcionCantidadExcesiva {
		if (this.contenido < cantidad) {
			throw new ExcepcionCantidadExcesiva("No hay suficiente contenido en el vaso ha intentado extrear:" + cantidad + 
					"cuando solo hay: "+ this.contenido);
		}
		this.contenido -= cantidad;
	}
	
	/**
	 * Método que retorna cuentoas ml tiene actualmente el vaso
	 * PRE: Cierto
	 * POS: No altera ningún valor de la clase
	 * @return
	 */
	public double getContenido() {
		return this.contenido;
	}
	
	/**
	 * Método que retorna la capacidad máxima del vaso
	 * PRE: Cierto
	 * POS: No altera ningúin atributo de la clase
	 * @return
	 */
	public double getCapacidadMaxima() {
		return this.capacidadMax;
	}
	
	//TO-DO
	/*
	 * Métodos para perparar el desayuno
	 * Se van a implementar varias versiones:
	 * versión 1: prepararDesayuno1 llama a llenar de vaso y no hace nada con las expceiones, simplemente deja que se propague (el llamante es consciente del problema)
	 * versión 2: prepararDesayuno2 captura la excepciónn muestra un mensaje de error y la consume (el llamante no se entera del error)
	 * versión3: prepararDesayuno3 caputra la excepción y lanza una nueva ExcepcionPrepararDesayuo para que el llamante se entere. También deja el vaso en el estado que estaba al empezar el método
	 */
	
	// version 1
	/**
	 * Introduce los ingredientes en el vaso y no captura la excepción (la propaga)
	 * @param leche
	 * @param azucar
	 * @param cacao
	 * @throws ExcepcionVasoNoCabe
	 */
	public void prepararDesayuno1 (double leche, double azucar, double cacao) throws ExcepcionVasoNoCabe{
		llenar(leche);
		llenar(azucar);
		llenar(cacao);
	}
	

	// version 2
	/**
	 * captura la excepciónn muestra un mensaje de error y la consume
	 * @param leche
	 * @param azucar
	 * @param cacao
	 */
	public void prepararDesayuno2 (double leche, double azucar, double cacao){
		try {
			llenar(leche);
			llenar(azucar);
			llenar(cacao);
		} catch (ExcepcionVasoNoCabe e) {
			System.err.println("Se excede la capacidad del vaso");
		}
	}

	/**
	 * caputra la excepción y lanza una nueva ExcepcionPrepararDesayuo para que el llamante se entere. También deja el vaso en el estado que estaba al empezar el método
	 * @param leche
	 * @param azucar
	 * @param cacao
	 * @throws ExcepcionPrepararDesayuo
	 */
	// version 3
	public void prepararDesayuno3 (double leche, double azucar, double cacao) throws ExcepcionPrepararDesayuo{
		double contenidoInicial = this.getContenido();
		try {
			llenar(leche);
			llenar(azucar);
			llenar(cacao);
		} catch (ExcepcionVasoNoCabe e) {
			this.contenido = contenidoInicial;
			throw new ExcepcionPrepararDesayuo("No se puede preparar el vaso del desayuno, el vaso se ha restaurado a su situación inicial");
		}
	}

}
