
public class TestCuenta {
	public static void main(String[] args) {
		// el atributo static existe antes de crear el primer objeto
		System.out.println(Cuenta.getGastosApertura()); // sale 10 
		Cuenta cuenta1, cuenta2;
		cuenta1 = new Cuenta(23);
		cuenta2 = new Cuenta(40);
		System.out.println(cuenta1);

		Cuenta.setGastosApertura(1.5);

		// Los gastos de apertura de cuenta1 son los mismos de 
		// cuenta2 y cuando un objeto los cambia se cambia en los dos 
		System.out.println(cuenta2);
		System.out.println(cuenta1);

		// Cambiamos el valor de los gastos de apertura para todas 
		// las cuentas usando el nombre de la clase
		Cuenta.setGastosApertura(0.75);
		System.out.println(cuenta2);
		System.out.println(cuenta1); 
	}

}
