
public class Cuenta {
	/**
	 * Los gastos de apertura son comunes para todas las cuentas 
	 * abiertas en el banco
	 */
	private static double gastosApertura = 10; 
	private double saldo;

	public Cuenta (double saldoInicial){
		saldo=saldoInicial - gastosApertura;
	}
	public void setSaldo (double saldo){
		this.saldo=saldo;
	}	
	public static void setGastosApertura (double gastosA){
		Cuenta.gastosApertura = gastosA;
	}
	public static double getGastosApertura (){
		return Cuenta.gastosApertura;
	}
	public String toString(){
		return gastosApertura + " " + saldo;
	}

}
