
public class TestCuenta1 {

	public static void main(String[] args) {
		Persona cliente1 = new Persona("4783784X", "Pepe", 43);
		Cuenta cuenta1 = new Cuenta(1000, cliente1);
		
		System.out.println(cuenta1);
		
		Persona cliente2 = new Persona("4783784X", "Pepe", 43);
		Cuenta cuenta2 = new Cuenta(1000, cliente2);
		
		System.out.println(cuenta1.esIgual(cuenta2));//true
		System.out.println(cuenta1==cuenta2);//false
		

	}

}
