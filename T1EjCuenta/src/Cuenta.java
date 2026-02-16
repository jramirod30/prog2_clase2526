
public class Cuenta {
	/**
	 * Los gastos de apertura son comunes para todas las cuentas 
	 * abiertas en el banco
	 */
	private static double gastosApertura = 10; 
	private double saldo;
	private Persona cliente;

	public Cuenta (double saldoInicial, Persona cliente){
		saldo=saldoInicial - gastosApertura;
		this.cliente = cliente;
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
		return gastosApertura + " " + saldo + " " + cliente;
	}
	
	public boolean esIgual(Cuenta obj) {
		return this.saldo == obj.saldo && this.cliente.esIgual(obj.cliente); 
		
	}
	
	public Cuenta(Cuenta obj) {
		this.saldo = obj.saldo;
		this.cliente = new Persona(obj.cliente);
		//cliente = obj.cliente si solo queremos tener un objeto de cada cliente
	}

}
